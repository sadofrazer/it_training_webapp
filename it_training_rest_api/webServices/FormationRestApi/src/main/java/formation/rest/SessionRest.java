package formation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import formation.bll.SessionBLL;
import formation.bo.Session;

@RestController
@RequestMapping("/session")
public class SessionRest {
	
	@Autowired
	private SessionBLL bll;
	
	@GetMapping
	public ResponseEntity<List<Session>> getAllSessions() {
		try {
			return new ResponseEntity<List<Session>>(bll.selectAll(), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<Session>>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Session> findById(@PathVariable("id") int id) {
		
		if (bll.exist(id)) {
			try {
				return new ResponseEntity<Session>(bll.selectById(id), HttpStatus.OK);
			}
			catch (Exception e) {
				return new ResponseEntity<Session>(HttpStatus.CONFLICT);
			}
		} else {
			return new ResponseEntity<Session>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PostMapping
	public ResponseEntity<Session> insert(@RequestBody Session s) {
		
		try {
			if (bll.insert(s)) {
				return new ResponseEntity<Session>(bll.getSessionByCode(s.getCodeSession()), HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Session>(HttpStatus.CONFLICT);
			}
		} 
		catch (Exception e) {
			return new ResponseEntity<Session>(HttpStatus.CONFLICT);
		}
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Session> update(@PathVariable("id") int id, @RequestBody Session s) {
		
		try {
			// Je recupere l'instance telle qu'elle existe en bdd
			Session originalBDD = bll.selectById(id);
			originalBDD = s;
			if(bll.update(originalBDD)) {
				return new ResponseEntity<Session>(bll.selectById(id), HttpStatus.OK);
			}else {
				return new ResponseEntity<Session>(HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			return new ResponseEntity<Session>(HttpStatus.CONFLICT);
		}
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		try {
			if(bll.delete(id)) {
				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			}else {
				return new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
		}
	}
	
	
	@GetMapping(value = "/formation/{id}")
	public ResponseEntity<List<Session>> findByFormation(@PathVariable("id") int id) {
		
		try {
			return new ResponseEntity<List<Session>>(bll.getByFormation(id), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<Session>>(HttpStatus.CONFLICT);
		}
	} 
		
	
	@GetMapping(value="/search")
	@ResponseBody
	public ResponseEntity<Session> getSessionByCode(@RequestParam(name = "code") String code) {
		
		try {
			return new ResponseEntity<Session>(bll.getSessionByCode(code), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Session>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping(value="/exist")
	@ResponseBody
	public ResponseEntity<Boolean> codeSessionExist(@RequestParam(name = "code") String code) {
		
		try {
			return new ResponseEntity<Boolean>(bll.codeSessionExist(code), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Boolean>(HttpStatus.CONFLICT);
		}
	}
	
}

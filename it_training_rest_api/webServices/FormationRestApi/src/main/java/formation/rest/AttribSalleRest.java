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
import org.springframework.web.bind.annotation.RestController;

import formation.bll.AttribSalleBLL;
import formation.bo.AttribSalle;

@RestController
@RequestMapping("/attribSalle")
public class AttribSalleRest {
	
	@Autowired
	private AttribSalleBLL bll;
	
	
	
	@GetMapping
	public ResponseEntity<List<AttribSalle>> getAllAttribSalles() {
		try {
			return new ResponseEntity<List<AttribSalle>>(bll.selectAll(), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<AttribSalle>>(HttpStatus.CONFLICT);
		}
	}
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AttribSalle> findById(@PathVariable("id") int id) {
		
		if (bll.exist(id)) {
			try {
				return new ResponseEntity<AttribSalle>(bll.selectById(id), HttpStatus.OK);
			}
			catch (Exception e) {
				return new ResponseEntity<AttribSalle>(HttpStatus.CONFLICT);
			}
		} else {
			return new ResponseEntity<AttribSalle>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	@PostMapping
	public ResponseEntity<Boolean> insert(@RequestBody AttribSalle s) {
		
		try {
			if (bll.insert(s)) {
				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Boolean>(HttpStatus.CONFLICT);
			}
		} 
		catch (Exception e) {
			return new ResponseEntity<Boolean>(HttpStatus.CONFLICT);
		}
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AttribSalle> update(@PathVariable("id") int id, @RequestBody AttribSalle s) {
		
		try {
			// Je recupere l'instance telle qu'elle existe en bdd
			AttribSalle originalBDD = bll.selectById(id);
			originalBDD = s;
			if(bll.update(originalBDD)) {
				return new ResponseEntity<AttribSalle>(bll.selectById(id), HttpStatus.OK);
			}else {
				return new ResponseEntity<AttribSalle>(HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			return new ResponseEntity<AttribSalle>(HttpStatus.CONFLICT);
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
	
	@GetMapping(value = "/session/{id}")
	public ResponseEntity<List<AttribSalle>> getAllBySessionid(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<List<AttribSalle>>(bll.getBySessionId(id), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<AttribSalle>>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping(value = "/salle/{id}")
	public ResponseEntity<List<AttribSalle>> getAllBySalleid(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<List<AttribSalle>>(bll.getBySalleId(id), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<AttribSalle>>(HttpStatus.CONFLICT);
		}
	}

}

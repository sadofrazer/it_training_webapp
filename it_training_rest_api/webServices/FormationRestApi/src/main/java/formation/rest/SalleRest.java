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

import formation.bll.SalleBLL;
import formation.bo.Salle;

@RestController
@RequestMapping("/salle")
public class SalleRest {
	
	@Autowired
	private SalleBLL bll;

	
	@GetMapping
	public ResponseEntity<List<Salle>> getAllSalles() {
		try {
			return new ResponseEntity<List<Salle>>(bll.selectAll(), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<Salle>>(HttpStatus.CONFLICT);
		}
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Salle> findById(@PathVariable("id") int id) {
		
		if (bll.exist(id)) {
			try {
				return new ResponseEntity<Salle>(bll.selectById(id), HttpStatus.OK);
			}
			catch (Exception e) {
				return new ResponseEntity<Salle>(HttpStatus.CONFLICT);
			}
		} else {
			return new ResponseEntity<Salle>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@PostMapping
	public ResponseEntity<Salle> insert(@RequestBody Salle s) {
		
		try {
			if (bll.insert(s)) {
				return new ResponseEntity<Salle>(bll.getSalleByCode(s.getCodeSalle()), HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Salle>(HttpStatus.CONFLICT);
			}
		} 
		catch (Exception e) {
			return new ResponseEntity<Salle>(HttpStatus.CONFLICT);
		}
		
	}
	
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Salle> update(@PathVariable("id") int id, @RequestBody Salle s) {
		
		try {
			// Je recupere l'instance telle qu'elle existe en bdd
			Salle originalBDD = bll.selectById(id);
			originalBDD = s;
			if(bll.update(originalBDD)) {
				return new ResponseEntity<Salle>(bll.selectById(id), HttpStatus.OK);
			}else {
				return new ResponseEntity<Salle>(HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			return new ResponseEntity<Salle>(HttpStatus.CONFLICT);
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
		
	
	
	
	@GetMapping(value="/search")
	@ResponseBody
	public ResponseEntity<Salle> getSalleByCode(@RequestParam(name = "code") String code) {
		
		try {
			return new ResponseEntity<Salle>(bll.getSalleByCode(code), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Salle>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping(value="/free")
	@ResponseBody
	public ResponseEntity<List<Salle>> getFreeSalles() {
		
		try {
			return new ResponseEntity<List<Salle>>(bll.getFreeSalles(), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<Salle>>(HttpStatus.CONFLICT);
		}
	}
	
	
	@GetMapping(value="/exist")
	@ResponseBody
	public ResponseEntity<Boolean> codeSalleExist(@RequestParam(name = "code") String code) {
		
		try {
			return new ResponseEntity<Boolean>(bll.codeSalleExist(code), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Boolean>(HttpStatus.CONFLICT);
		}
	}
	
}

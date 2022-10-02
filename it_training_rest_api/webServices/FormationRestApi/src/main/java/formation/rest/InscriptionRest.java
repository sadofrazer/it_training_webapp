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

import formation.bll.InscriptionBLL;
import formation.bo.Inscription;

@RestController
@RequestMapping("/inscription")
public class InscriptionRest {

	@Autowired
	private InscriptionBLL bll;
	
	
	
	@GetMapping
	public ResponseEntity<List<Inscription>> getAllInscriptions() {
		try {
			return new ResponseEntity<List<Inscription>>(bll.selectAll(), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<Inscription>>(HttpStatus.CONFLICT);
		}
	}
	
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Inscription> findById(@PathVariable("id") int id) {
		
		if (bll.exist(id)) {
			try {
				return new ResponseEntity<Inscription>(bll.selectById(id), HttpStatus.OK);
			}
			catch (Exception e) {
				return new ResponseEntity<Inscription>(HttpStatus.CONFLICT);
			}
		} else {
			return new ResponseEntity<Inscription>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@PostMapping
	public ResponseEntity<Inscription> insert(@RequestBody Inscription i) {
		
		try {
			if (bll.insert(i)) {
				return new ResponseEntity<Inscription>(bll.getInscriptionByCode(i.getCodeInscription()), HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Inscription>(HttpStatus.CONFLICT);
			}
		} 
		catch (Exception e) {
			return new ResponseEntity<Inscription>(HttpStatus.CONFLICT);
		}
		
	}
	
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Inscription> update(@PathVariable("id") int id, @RequestBody Inscription i) {
		
		try {
			// Je recupere l'instance telle qu'elle existe en bdd
			Inscription originalBDD = bll.selectById(id);
			originalBDD = i;
			if(bll.update(originalBDD)) {
				return new ResponseEntity<Inscription>(bll.selectById(id), HttpStatus.OK);
			}else {
				return new ResponseEntity<Inscription>(HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			return new ResponseEntity<Inscription>(HttpStatus.CONFLICT);
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
	public ResponseEntity<Inscription> getInscriptionByCode(@RequestParam(name = "code") String code) {
		
		try {
			return new ResponseEntity<Inscription>(bll.getInscriptionByCode(code), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Inscription>(HttpStatus.CONFLICT);
		}
	}
	
	
	
	@GetMapping(value="/exist")
	@ResponseBody
	public ResponseEntity<Boolean> codeInscriptionExist(@RequestParam(name = "code") String code) {
		
		try {
			return new ResponseEntity<Boolean>(bll.codeInscriptionExist(code), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Boolean>(HttpStatus.CONFLICT);
		}
	}
	
	
	@GetMapping(value = "/session/{id}")
	public ResponseEntity<List<Inscription>> getAllBySessionId(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<List<Inscription>>(bll.getAllBySessionId(id), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<Inscription>>(HttpStatus.CONFLICT);
		}
	}
	
	
	@GetMapping(value = "/formation/{id}")
	public ResponseEntity<List<Inscription>> getAllByFormationId(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<List<Inscription>>(bll.getAllByFormationId(id), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<Inscription>>(HttpStatus.CONFLICT);
		}
	}
	
	
	@GetMapping(value = "/apprenant/{id}")
	public ResponseEntity<List<Inscription>> getAllByApprenantId(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<List<Inscription>>(bll.getAllByApprenantId(id), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<Inscription>>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping(value = "/order/{statut}")
	public ResponseEntity<List<Inscription>> getAllOrderById(@PathVariable("statut") String statut) {
		try {
			return new ResponseEntity<List<Inscription>>(bll.getAllOrderByCode(statut), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<Inscription>>(HttpStatus.CONFLICT);
		}
	}
	
}

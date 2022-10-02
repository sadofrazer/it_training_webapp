package fr.user.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.user.bll.FormateurBll;
import fr.user.bo.Formateur;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/formateurs")
public class FormateurController {

	@Autowired
	private FormateurBll bll;
	
	@GetMapping
	public ResponseEntity<List<Formateur>> findAll() {
		return new ResponseEntity<List<Formateur>>(bll.selectAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{idFormateur}")
	public ResponseEntity<Formateur> findById(@PathVariable("idFormateur") int id) {
		if (bll.exist(id)) {
			return new ResponseEntity<Formateur>(bll.selectById(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<Formateur>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Formateur> insert(@RequestBody Formateur f) {
		try {
			bll.insert(f);
			return new ResponseEntity<Formateur>(f, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Formateur>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping(value = "/{idFormateur}")
	public ResponseEntity<Formateur> update(
											@PathVariable("idFormateur") int id,
											@RequestBody Formateur f) {
		try {
			
			Formateur originalBDD = bll.selectById(id);
			
			originalBDD.setCodeUser(f.getCodeUser());
			originalBDD.setNom(f.getNom());
			originalBDD.setPrenom(f.getPrenom());
			originalBDD.setTelephone(f.getTelephone());
			originalBDD.setEmail(f.getEmail());
			originalBDD.setDateNaiss(f.getDateNaiss());
			originalBDD.setNumeroSiret(f.getNumeroSiret());
			originalBDD.setLogin(f.getLogin());
			originalBDD.setPassword(f.getPassword());
			originalBDD.setSociete(f.getSociete());
			originalBDD.setStatut(f.getStatut());
			originalBDD.setTypeUser(f.getTypeUser());
			originalBDD.setCertification(f.getCertification());


			bll.update(originalBDD);
			return new ResponseEntity<Formateur>(f, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Formateur>(HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping(value = "/{idFormateur}")
	public ResponseEntity<Void> delete(@PathVariable("idFormateur") int id) {
		try {
			bll.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
}

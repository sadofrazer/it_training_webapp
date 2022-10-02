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

import fr.user.bll.ApprenantBll;
import fr.user.bo.Apprenant;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/apprenants")
public class ApprenantController {


	@Autowired
	private ApprenantBll bll;
	
	@GetMapping
	public ResponseEntity<List<Apprenant>> findAll() {
		return new ResponseEntity<List<Apprenant>>(bll.selectAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{idApprenant}")
	public ResponseEntity<Apprenant> findById(@PathVariable("idApprenant") int id) {
		if (bll.exist(id)) {
			return new ResponseEntity<Apprenant>(bll.selectById(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<Apprenant>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Apprenant> insert(@RequestBody Apprenant a) {
		System.out.println("vous etes ici");
		System.out.println(a);
		try {
			bll.insert(a);
			return new ResponseEntity<Apprenant>(a, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Apprenant>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping(value = "/{idApprenant}")
	public ResponseEntity<Apprenant> update(
											@PathVariable("idApprenant") int id,
											@RequestBody Apprenant a) {
		try {
			
			Apprenant originalBDD = bll.selectById(id);
			
			originalBDD.setCodeUser(a.getCodeUser());
			originalBDD.setNom(a.getNom());
			originalBDD.setPrenom(a.getPrenom());
			originalBDD.setTelephone(a.getTelephone());
			originalBDD.setEmail(a.getEmail());
			originalBDD.setDateNaiss(a.getDateNaiss());
			originalBDD.setNumeroSiret(a.getNumeroSiret());
			originalBDD.setLogin(a.getLogin());
			originalBDD.setPassword(a.getPassword());
			originalBDD.setSociete(a.getSociete());
			originalBDD.setStatut(a.getStatut());
			originalBDD.setTypeUser(a.getTypeUser());
			originalBDD.setDernierDiplome(a.getDernierDiplome());
			

			bll.update(originalBDD);
			return new ResponseEntity<Apprenant>(a, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Apprenant>(HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping(value = "/{idApprenant}")
	public ResponseEntity<Void> delete(@PathVariable("idApprenant") int id) {
		try {
			bll.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
}
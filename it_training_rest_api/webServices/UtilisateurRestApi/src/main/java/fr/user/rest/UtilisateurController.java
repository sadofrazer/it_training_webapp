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

import fr.user.bll.UtilisateurBll;
import fr.user.bo.Utilisateur;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/utilisateurs")
public class UtilisateurController {
	@Autowired
	private UtilisateurBll bll;
	
	@GetMapping
	public ResponseEntity<List<Utilisateur>> findAll() {
		return new ResponseEntity<List<Utilisateur>>(bll.selectAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{idUtilisateur}")
	public ResponseEntity<Utilisateur> findById(@PathVariable("idUtilisateur") int id) {
		if (bll.exist(id)) {
			return new ResponseEntity<Utilisateur>(bll.selectById(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<Utilisateur>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Utilisateur> insert(@RequestBody Utilisateur p) {
		System.out.println("vous etes ici");
		System.out.println(p);
		try {
			bll.insert(p);
			return new ResponseEntity<Utilisateur>(p, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Utilisateur>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping(value = "/{idUtilisateur}")
	public ResponseEntity<Utilisateur> update(
											@PathVariable("idUtilisateur") int id,
											@RequestBody Utilisateur u) {
		try {
			
			Utilisateur originalBDD = bll.selectById(id);
			
			originalBDD.setCodeUser(u.getCodeUser());
			originalBDD.setNom(u.getNom());
			originalBDD.setPrenom(u.getPrenom());
			originalBDD.setTelephone(u.getTelephone());
			originalBDD.setEmail(u.getEmail());
			originalBDD.setDateNaiss(u.getDateNaiss());
			originalBDD.setNumeroSiret(u.getNumeroSiret());
			originalBDD.setLogin(u.getLogin());
			originalBDD.setPassword(u.getPassword());
			originalBDD.setSociete(u.getSociete());
			originalBDD.setStatut(u.getStatut());
			originalBDD.setTypeUser(u.getTypeUser());

			bll.update(originalBDD);
			return new ResponseEntity<Utilisateur>(u, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Utilisateur>(HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping(value = "/{idUtilisateur}")
	public ResponseEntity<Void> delete(@PathVariable("idUtilisateur") int id) {
		try {
			bll.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
}

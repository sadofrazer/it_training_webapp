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

import fr.user.bll.ResponsableBll;
import fr.user.bo.Responsable;

@RestController
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/responsables")
public class ResponsableController {

	

		@Autowired
		private ResponsableBll bll;
		
		@GetMapping
		public ResponseEntity<List<Responsable>> findAll() {
			return new ResponseEntity<List<Responsable>>(bll.selectAll(), HttpStatus.OK);
		}
		
		@GetMapping(value = "/{idResponsable}")
		public ResponseEntity<Responsable> findById(@PathVariable("idResponsable") int id) {
			if (bll.exist(id)) {
				return new ResponseEntity<Responsable>(bll.selectById(id), HttpStatus.OK);
			} else {
				return new ResponseEntity<Responsable>(HttpStatus.NOT_FOUND);
			}
		}
		
		@PostMapping
		public ResponseEntity<Responsable> insert(@RequestBody Responsable r) {
			try {
				bll.insert(r);
				return new ResponseEntity<Responsable>(r, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Responsable>(HttpStatus.CONFLICT);
			}
		}
		
		@PutMapping(value = "/{idResponsable}")
		public ResponseEntity<Responsable> update(
												@PathVariable("idResponsable") int id,
												@RequestBody Responsable r) {
			try {
				
				Responsable originalBDD = bll.selectById(id);
				
				originalBDD.setCodeUser(r.getCodeUser());
				originalBDD.setNom(r.getNom());
				originalBDD.setPrenom(r.getPrenom());
				originalBDD.setTelephone(r.getTelephone());
				originalBDD.setEmail(r.getEmail());
				originalBDD.setDateNaiss(r.getDateNaiss());
				originalBDD.setNumeroSiret(r.getNumeroSiret());
				originalBDD.setLogin(r.getLogin());
				originalBDD.setPassword(r.getPassword());
				originalBDD.setSociete(r.getSociete());
				originalBDD.setStatut(r.getStatut());
				originalBDD.setTypeUser(r.getTypeUser());
				originalBDD.setFonction(r.getFonction());
				

				bll.update(originalBDD);
				return new ResponseEntity<Responsable>(r, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Responsable>(HttpStatus.CONFLICT);
			}
		}
		
		@DeleteMapping(value = "/{idResponsable}")
		public ResponseEntity<Void> delete(@PathVariable("idResponsable") int id) {
			try {
				bll.delete(id);
				return new ResponseEntity<Void>(HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}
		}
	}


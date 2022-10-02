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

import fr.user.bll.TypeUserBll;
import fr.user.bo.TypeUser;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/typeuser")
public class TypeUserController {

	@Autowired
	private TypeUserBll bll;
	
	@GetMapping
	public ResponseEntity<List<TypeUser>> findAll() {
		return new ResponseEntity<List<TypeUser>>(bll.selectAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{idTypeUser}")
	public ResponseEntity<TypeUser> findById(@PathVariable("idTypeUser") int id) {
		if (bll.exist(id)) {
			return new ResponseEntity<TypeUser>(bll.selectById(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<TypeUser>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<TypeUser> insert(@RequestBody TypeUser f) {
		try {
			bll.insert(f);
			return new ResponseEntity<TypeUser>(f, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<TypeUser>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping(value = "/{idTypeUser}")
	public ResponseEntity<TypeUser> update(
											@PathVariable("idTypeUser") int id,
											@RequestBody TypeUser f) {
		try {
			
			TypeUser originalBDD = bll.selectById(id);
			
			originalBDD.setIdType(f.getIdType());
			originalBDD.setDescription(f.getDescription());
			originalBDD.setNom(f.getNom());
			


			bll.update(originalBDD);
			return new ResponseEntity<TypeUser>(f, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<TypeUser>(HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping(value = "/{idTypeUser}")
	public ResponseEntity<Void> delete(@PathVariable("idTypeUser") int id) {
		try {
			bll.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
}

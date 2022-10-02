package formation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import formation.bll.DomaineBLL;
import formation.bo.Domaine;

@RestController
@RequestMapping("/domaine")
public class DomaineRest {

	@Autowired
	private DomaineBLL bll;
	
	@GetMapping
	public ResponseEntity<List<Domaine>> getAllDomaines() {
		try {
			return new ResponseEntity<List<Domaine>>(bll.selectAll(), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<Domaine>>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Domaine> findById(@PathVariable("id") int id) {
		
		if (bll.exist(id)) {
			try {
				return new ResponseEntity<Domaine>(bll.selectById(id), HttpStatus.OK);
			}
			catch (Exception e) {
				return new ResponseEntity<Domaine>(HttpStatus.CONFLICT);
			}
		} else {
			return new ResponseEntity<Domaine>(HttpStatus.NOT_FOUND);
		}
	}
	
}

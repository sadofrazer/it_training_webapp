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

import formation.bll.FormationBLL;
import formation.bo.Formation;


@RestController
@RequestMapping("/formation")
public class FormationRest {
	
	@Autowired
	private FormationBLL bll;
	
	@GetMapping
	public ResponseEntity<List<Formation>> getAllFormations() {
		try {
			return new ResponseEntity<List<Formation>>(bll.selectAll(), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<Formation>>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Formation> findById(@PathVariable("id") int id) {
		
		if (bll.exist(id)) {
			try {
				return new ResponseEntity<Formation>(bll.selectById(id), HttpStatus.OK);
			}
			catch (Exception e) {
				return new ResponseEntity<Formation>(HttpStatus.CONFLICT);
			}
		} else {
			return new ResponseEntity<Formation>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Formation> insert(@RequestBody Formation f) {
		
		try {
			if (bll.insert(f)) {
				return new ResponseEntity<Formation>(bll.selectByCode(f.getCodeFormation()), HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Formation>(HttpStatus.CONFLICT);
			}
		} 
		catch (Exception e) {
			return new ResponseEntity<Formation>(HttpStatus.CONFLICT);
		}
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Formation> update(@PathVariable("id") int id, @RequestBody Formation f) {
		
		try {
			// Je recupere l'instance telle qu'elle existe en bdd
			Formation originalBDD = bll.selectById(id);
			originalBDD = f;
			if(bll.update(originalBDD)) {
				return new ResponseEntity<Formation>(bll.selectById(id), HttpStatus.OK);
			}else {
				return new ResponseEntity<Formation>(HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			return new ResponseEntity<Formation>(HttpStatus.CONFLICT);
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
	
	@GetMapping(value ="/ordonner")
	@ResponseBody
	public ResponseEntity<List<Formation>> sort(@RequestParam(name = "nom") String nom, @RequestParam(name = "code") String code,
			@RequestParam(name = "stheme") String stheme, @RequestParam(name = "sort") String sort) {
		
		try {
			return new ResponseEntity<List<Formation>>(bll.sortForm(nom, code, stheme, sort), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Formation>>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping(value="/search")
	@ResponseBody
	public ResponseEntity<List<Formation>> searchFormations(@RequestParam(name = "word") String word) {
		try {
			return new ResponseEntity<List<Formation>>(bll.searchForm(word), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<Formation>>(HttpStatus.CONFLICT);
		}
	}
	
	//Get formation by domaine
	@GetMapping(value="/domaine/{id}")
	@ResponseBody
	public ResponseEntity<List<Formation>> getByDomaine(@PathVariable("id") int id){
		try {
			return new ResponseEntity<List<Formation>>(bll.getFormByDomaine(id), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<Formation>>(HttpStatus.CONFLICT);
		}
	}
	
	
	//Get formation by theme
	@GetMapping(value="/theme/{id}")
	@ResponseBody
	public ResponseEntity<List<Formation>> getByTheme(@PathVariable("id") int id){
		try {
			return new ResponseEntity<List<Formation>>(bll.getFormByTheme(id), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<Formation>>(HttpStatus.CONFLICT);
		}
	}
	
	//Get formation by stheme
	@GetMapping(value="/stheme/{id}")
	@ResponseBody
	public ResponseEntity<List<Formation>> getByStheme(@PathVariable("id") int id){
		try {
			return new ResponseEntity<List<Formation>>(bll.getFormByStheme(id), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<Formation>>(HttpStatus.CONFLICT);
		}
	}
	

}

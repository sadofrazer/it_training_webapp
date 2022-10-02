package fr.user.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.user.bll.SthemeBLL;
import fr.user.bo.SousTheme;

@RestController
@RequestMapping("/stheme")
public class SthemeRest {
	
	@Autowired
	private SthemeBLL bll;
	
	@GetMapping
	public ResponseEntity<List<SousTheme>> getAllSousThemes() {
		try {
			return new ResponseEntity<List<SousTheme>>(bll.selectAll(), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<SousTheme>>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SousTheme> findById(@PathVariable("id") int id) {
		
		if (bll.exist(id)) {
			try {
				return new ResponseEntity<SousTheme>(bll.selectById(id), HttpStatus.OK);
			}
			catch (Exception e) {
				return new ResponseEntity<SousTheme>(HttpStatus.CONFLICT);
			}
		} else {
			return new ResponseEntity<SousTheme>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping(value = "/theme/{id}")
	public ResponseEntity<List<SousTheme>> findByTheme(@PathVariable("id") int id) {
		
			try {
				return new ResponseEntity<List<SousTheme>>(bll.getByTheme(id), HttpStatus.OK);
			}
			catch (Exception e) {
				return new ResponseEntity<List<SousTheme>>(HttpStatus.CONFLICT);
			}
		
	}
	
	@GetMapping(value="/search")
	@ResponseBody
	public ResponseEntity<SousTheme> getSthemeByCode(@RequestParam(name = "code") String code) {
		
		try {
			return new ResponseEntity<SousTheme>(bll.getSthemeByCode(code), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<SousTheme>(HttpStatus.CONFLICT);
		}
	}
}

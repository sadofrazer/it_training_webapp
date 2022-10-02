package formation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import formation.bll.ThemeBLL;
import formation.bo.Theme;

@RestController
@RequestMapping("/theme")
public class ThemeRest {

	@Autowired
	private ThemeBLL bll;
	
	@GetMapping
	public ResponseEntity<List<Theme>> getAllThemes() {
		try {
			return new ResponseEntity<List<Theme>>(bll.selectAll(), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<Theme>>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Theme> findById(@PathVariable("id") int id) {
		
		if (bll.exist(id)) {
			try {
				return new ResponseEntity<Theme>(bll.selectById(id), HttpStatus.OK);
			}
			catch (Exception e) {
				return new ResponseEntity<Theme>(HttpStatus.CONFLICT);
			}
		} else {
			return new ResponseEntity<Theme>(HttpStatus.NOT_FOUND);
		}
	}
	
}

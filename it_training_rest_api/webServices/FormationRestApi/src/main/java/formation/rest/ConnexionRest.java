package formation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import formation.bll.ConnexionBLL;
import formation.bo.Utilisateur;



@RestController
@RequestMapping("/connexion")
public class ConnexionRest {
	
	@Autowired
	private ConnexionBLL bll;
	
	@GetMapping
	public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
		try {
			return new ResponseEntity<List<Utilisateur>>(bll.selectAll(), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<List<Utilisateur>>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/{login}/{password}")
	public Utilisateur connexion(@PathVariable("login") String login,
									 @PathVariable("password") String password) {
		return bll.connexion(login, password);
	}

}

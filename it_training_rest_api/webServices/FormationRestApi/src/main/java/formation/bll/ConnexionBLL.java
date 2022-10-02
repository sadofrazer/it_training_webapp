package formation.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.bo.Utilisateur;
import formation.dal.UtilisateurDAO;

@Service
public class ConnexionBLL {
	
	@Autowired
	private UtilisateurDAO dao;
	
	public Utilisateur connexion(String login, String password) {
		Utilisateur utilisateur = dao.findByLoginAndPassword(login, password);
		return utilisateur;
		
	}
	
	public List<Utilisateur> selectAll() {
		return dao.findAll();
	}
}

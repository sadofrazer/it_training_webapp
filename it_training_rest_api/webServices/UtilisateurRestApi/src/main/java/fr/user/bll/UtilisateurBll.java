package fr.user.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import fr.user.bo.Utilisateur;
import fr.user.dal.UtilisateurDAO;


@Service
public class UtilisateurBll {
	@Autowired
 private UtilisateurDAO dao;
	
	public List<Utilisateur> selectAll() {
		return dao.findAll();
	}
	
	public Utilisateur selectById(int id) {
		if(exist(id)) {
			return dao.findById(id).get();
		}else {
			return null;
		}

	}
	
	public boolean insert(Utilisateur u) {
		if( u.getNom() != null && u.getPrenom() != null && u.getCodeUser() != null && u.getEmail() != null) {
			dao.save(u);
			return true;
		}else {
			System.err.println("cette utilisateur à deja etait crerr");
			return false;
		}

		
	}
	
	public void update(Utilisateur u) {
		dao.save(u);
	}
	
	public void delete(int id) {
		dao.deleteById(id);
	}
	
	public boolean exist(int id) {
		return dao.existsById(id);
	}
}
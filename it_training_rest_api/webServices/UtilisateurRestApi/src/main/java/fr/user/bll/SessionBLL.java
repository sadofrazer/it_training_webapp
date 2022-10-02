package fr.user.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.user.bo.Session;
import fr.user.dal.SessionDAO;

@Service
public class SessionBLL {
	
	@Autowired
	public SessionDAO dao;
	
	
	public List<Session> selectAll() {
		return dao.findAll();
	}
	
	
	public Session selectById(int id) {
		if(exist(id)) {
			return dao.findById(id).get();
		}else {
			return null;
		}
	}
	
	
public boolean insert(Session s) {
		
		if( s.getCodeSession() != null && (getSessionByCode(s.getCodeSession()) == null) 
				&& s.getNom()!=null && s.getDateDebut()!=null && s.getDateFin()!=null ) {
			dao.save(s);
			return true;
		}else {
			System.err.println("impossible d'ajouter cette session car plusieurs champs sont incorrects");
			return false;
		}
	}
	
	public boolean update(Session s) {
		
		if( s.getCodeSession() != null && s.getNom()!=null && s.getDateDebut()!=null && s.getDateFin()!=null ) {
			
			if( exist(s.getIdSession()) && !(s.getCodeSession().equals(selectById(s.getIdSession()).getCodeSession()))) {
				
				if(getSessionByCode(s.getCodeSession()) != null ) {
					System.err.println("Désolé vous ne pouvez pas modifier une Session en utilisant un code existant déja en Base");
					return false;
				}
			}
			dao.save(s);
			return true;
		}else {
			System.err.println("Le code , ou le nom ou les différentes dates de debut et fin ne peuvent pas etre null");
			return false;
		}
	}
	
	
	public boolean delete(int id) {
		if(exist(id)) {
			dao.deleteById(id);
			return true;
		}else {
			System.err.println("Impossible de supprimer cet ID ( " + id + " ) car il existe pas en Base");
			return false;
		}
	}
	
	
	
	
	public List<Session> getByFormation(int id){
		if(exist(id)) {
			return dao.findByFormationIdFormation(id);
		}else {
			return null;
		}
	}
	
	
	
	public Session getSessionByCode(String code){
		return dao.findByCodeSession(code);
	}
	
	
	
	//if id exist in database return true, else return false
	public boolean exist(int id) {
		return dao.existsById(id);
	}
	
	
	
	public boolean codeSessionExist(String code) {
		Session s = getSessionByCode(code);
		if(s!=null) {
			return dao.existsById(s.getIdSession());
		}else {
			return false;
		}
	}
	
	
	
}

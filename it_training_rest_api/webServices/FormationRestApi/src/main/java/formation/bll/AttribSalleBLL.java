package formation.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.bo.AttribSalle;
import formation.dal.AttribSalleDAO;

@Service
public class AttribSalleBLL {
	
	@Autowired
	private AttribSalleDAO dao;
	
	public List<AttribSalle> selectAll() {
		return dao.findAll();
	}
	
	
	public AttribSalle selectById(int id) {
		if(exist(id)) {
			return dao.findById(id).get();
		}else {
			return null;
		}
	}
	
	
	public boolean insert(AttribSalle a) {
		
		if( a.getDateAttrib() != null && a.getSalle()!=null && a.getSession()!=null) {
			dao.save(a);
			return true;
		}else {
			System.err.println("impossible d'ajouter cette Attributions car plusieurs champs sont incorrects");
			return false;
		}
	}
	
	public boolean update(AttribSalle a) {
		
		if( a.getDateAttrib() != null && a.getSalle()!=null && a.getSession()!=null) {
			dao.save(a);
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
	
	//if id exist in database return true, else return false
	public boolean exist(int id) {
		return dao.existsById(id);
	}
	

	public List<AttribSalle> getBySessionId(int id) {
		
		return dao.findBySessionIdSession(id);
	}
	
	public List<AttribSalle> getBySalleId(int id) {
		
		return dao.findBySalleIdSalle(id);
	}

}

package formation.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.bo.Salle;
import formation.dal.SalleDAO;

@Service
public class SalleBLL {
	
	@Autowired
	private SalleDAO dao;
	
	
	public List<Salle> selectAll() {
		return dao.findAll();
	}
	
	
	public Salle selectById(int id) {
		if(exist(id)) {
			return dao.findById(id).get();
		}else {
			return null;
		}
	}
	
	
	public boolean insert(Salle s) {
		
		if( s.getCodeSalle() != null && (getSalleByCode(s.getCodeSalle()) == null) 
				&& s.getNomSalle()!=null && s.getNbrePlaces()>1 && s.getVille()!=null ) {
			dao.save(s);
			return true;
		}else {
			System.err.println("impossible d'ajouter cette session car plusieurs champs sont incorrects");
			return false;
		}
	}
	
	public boolean update(Salle s) {
		
		if( s.getCodeSalle() != null && s.getNomSalle()!=null && s.getNbrePlaces()>1 && s.getVille()!=null ) {
			
			if( exist(s.getIdSalle()) && !(s.getCodeSalle().equals(selectById(s.getIdSalle()).getCodeSalle()))) {
				
				if(getSalleByCode(s.getCodeSalle()) != null ) {
					System.err.println("Désolé vous ne pouvez pas modifier une Salle en utilisant un code existant déja en Base");
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
	
	
	
	
	public Salle getSalleByCode(String code){
		return dao.findByCodeSalle(code);
	}
	
	
	
	//if id exist in database return true, else return false
	public boolean exist(int id) {
		return dao.existsById(id);
	}
	
	
	
	public boolean codeSalleExist(String code) {
		Salle s = getSalleByCode(code);
		if(s!=null) {
			return dao.existsById(s.getIdSalle());
		}else {
			return false;
		}
	}
	
	public List<Salle> getFreeSalles(){
		return dao.findByStatut("FREE");
	}

}

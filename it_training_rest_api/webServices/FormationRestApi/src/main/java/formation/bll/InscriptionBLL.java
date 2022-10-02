package formation.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.bo.Inscription;
import formation.dal.InscriptionDAO;

@Service
public class InscriptionBLL {

	@Autowired
	private InscriptionDAO dao;
	
	
	public List<Inscription> selectAll() {
		return dao.findAll();
	}
	
	
	public Inscription selectById(int id) {
		if(exist(id)) {
			return dao.findById(id).get();
		}else {
			return null;
		}
	}
	
	
	public boolean insert(Inscription i) {
		
		List<Inscription> all=selectAll();
		int n = all.size();
		int id= all.get(n-1).getIdInscription();
		i.setCodeInscription("INSC000"+(id+1)); 
		
		if( i.getCodeInscription() != null && i.getSession() != null && i.getApprenant()!=null && i.getSession()!=null) {
			dao.save(i);
			return true;
		}else {
			System.err.println("impossible d'ajouter cette Attributions car plusieurs champs sont incorrects");
			return false;
		}
	}
	
public boolean update(Inscription i) {
		
		if(  i.getCodeInscription() != null && i.getSession() != null && i.getApprenant()!=null && i.getSession()!=null ) {
			
			if( exist(i.getIdInscription()) && !(i.getCodeInscription().equals(selectById(i.getIdInscription()).getCodeInscription()))) {
				
				if(getInscriptionByCode(i.getCodeInscription()) != null ) {
					System.err.println("Désolé vous ne pouvez pas modifier une Inscription en utilisant un code existant déja en Base");
					return false;
				}
			}
			dao.save(i);
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
	
	
	public Inscription getInscriptionByCode(String code){
		return dao.findByCodeInscription(code);
	}
	
	
	//if id exist in database return true, else return false
	public boolean exist(int id) {
		return dao.existsById(id);
	}
	
	public boolean codeInscriptionExist(String code) {
		Inscription s = getInscriptionByCode(code);
		if(s!=null) {
			return dao.existsById(s.getIdInscription());
		}else {
			return false;
		}
	}
	
	public List<Inscription> getAllBySessionId(int id) {
		return dao.findBySessionIdSession(id);
	}
	
	public List<Inscription> getAllByFormationId(int id) {
		return dao.findBySessionFormationIdFormation(id);
	}
	
	public List<Inscription> getAllByApprenantId(int id) {
		return dao.findByApprenantIdUtilisateur(id);
	}
	
	public List<Inscription> getAllOrderByCode(String statut) {
		return dao.findByStatutOrderByIdInscription(statut);
	}
}

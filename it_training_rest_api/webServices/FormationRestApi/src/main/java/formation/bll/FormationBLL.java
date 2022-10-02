package formation.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import formation.bo.Formation;
import formation.dal.FormationDAO;

@Service
public class FormationBLL {
	@Autowired
	private FormationDAO dao;
	
	public List<Formation> selectAll() {
		return dao.findAll();
	}
	
	public Formation selectById(int id) {
		if(exist(id)) {
			return dao.findById(id).get();
		}else {
			return null;
		}
	}
	
	public boolean insert(Formation f) {
		
		if( f.getCodeFormation() != null && (selectByCode(f.getCodeFormation()) == null) && f.getNom()!=null && f.getStheme()!=null ) {
			dao.save(f);
			return true;
		}else {
			System.err.println("impossible d'ajouter cette formation car ce code formation existe déja");
			return false;
		}
	}
	
	public boolean update(Formation f) {
		
		if( f.getCodeFormation() != null && f.getNom()!=null && f.getStheme()!=null ) {
			if( exist(f.getIdFormation()) && !(f.getCodeFormation().equals(dao.findById(f.getIdFormation()).get().getCodeFormation()))) {
				if(selectByCode(f.getCodeFormation()) != null ) {
					System.err.println("Désolé vous ne pouvez pas modifier une formation en utilisant un code formation existant déja en Base");
					return false;
				}
			}
			dao.save(f);
			return true;
		}else {
			System.err.println("Le code formation, ou le nom ou le sous thème ne peuvent pas etre null");
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
	
	//if id exist in database return true, else retrun false
	public boolean exist(int id) {
		return dao.existsById(id);
	}
	
	public List<Formation> searchForm(String word){
		return dao.findByNomContainingOrCodeFormationContainingOrSthemeNomContainingOrSthemeThemeNomContaining(word, word, word,word);
	}
	
	public List<Formation> filterForm(String nom, String code, String stheme){
		return dao.findByNomContainingAndCodeFormationContainingAndSthemeNomContaining(nom, code, stheme);
	}
	
	//recherche les formation en fonction du nom, code, et nom du sous theme et les tri selon l'ordre passé en paramètre
	public List<Formation> sortForm(String nom, String code, String stheme, String sort){
		return dao.findByAndSort(("%"+nom+"%"), "%"+code+"%", "%"+stheme+"%", Sort.by(sort));
	}
	
	//retourne la formation correspondante au code passé en paramètre
	public Formation selectByCode(String code) {
		
		if(dao.findByCodeFormation(code).size()>0) {
			return dao.findByCodeFormation(code).get(0);
		}else {
			System.err.println("Aucune formation correspondante au code " + code + " n'a été trouvée en Base");
			return null;
		}
	}
	
	//Liste des fromation par domaine
	public List<Formation> getFormByDomaine(int id){
		return dao.findBySthemeThemeDomaineIdDomaine(id);
	}
	
	//Liste des formations par thème
	public List<Formation> getFormByTheme(int id){
		return dao.findBySthemeThemeIdTheme(id);
	}
	
	//Liste des formations par sous thèmes
	public List<Formation> getFormByStheme(int id){
		return dao.findBySthemeIdStheme(id);
	}
}

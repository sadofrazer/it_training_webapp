package formation.dal;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import formation.bo.Formation;

@Repository
public interface FormationDAO extends JpaRepository<Formation, Integer> {
	
	public List<Formation> findByNomContainingOrCodeFormationContainingOrSthemeNomContainingOrSthemeThemeNomContaining(String nom, String codeFormation, String nomStheme, String nomTheme);
	public List<Formation> findByNomContainingAndCodeFormationContainingAndSthemeNomContaining(String nom, String codeFormation, String nomStheme);
	public List<Formation> findByCodeFormation(String CodeFormation);
	
	// liste des fromation par domaine, theme et sous thème
	public List<Formation> findBySthemeThemeDomaineIdDomaine(int idDomaine);
	public List<Formation> findBySthemeThemeIdTheme(int idTheme);
	public List<Formation> findBySthemeIdStheme(int idStheme);
	
	@Query("select f from Formation f where f.nom like ?1 and f.codeFormation like ?2 and f.stheme.nom like ?3")
	public List<Formation> findByAndSort(String nom, String codeFormation, String nomStheme, Sort sort);

}

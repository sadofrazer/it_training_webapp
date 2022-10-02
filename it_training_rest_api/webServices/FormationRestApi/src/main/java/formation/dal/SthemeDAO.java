package formation.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.bo.SousTheme;

@Repository
public interface SthemeDAO extends JpaRepository<SousTheme, Integer> {
	
	public List<SousTheme> findByThemeIdTheme(int id);
	public SousTheme findByCodeStheme(String codeStheme);
}

package formation.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.bo.Theme;

@Repository
public interface ThemeDAO extends JpaRepository<Theme, Integer> {

}

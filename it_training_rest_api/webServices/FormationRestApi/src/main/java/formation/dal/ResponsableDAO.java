package formation.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.bo.Responsable;

@Repository
public interface ResponsableDAO extends JpaRepository<Responsable, Integer>{

}

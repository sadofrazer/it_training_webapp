package formation.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.bo.Alerte;

@Repository
public interface AlerteDAO extends JpaRepository<Alerte, Integer>{

}

package formation.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.bo.Apprenant;

@Repository
public interface ApprenantDAO extends JpaRepository<Apprenant, Integer>{

}

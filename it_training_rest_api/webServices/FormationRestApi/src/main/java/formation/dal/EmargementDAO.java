package formation.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.bo.Emargement;

@Repository
public interface EmargementDAO extends JpaRepository<Emargement, Integer>{

}

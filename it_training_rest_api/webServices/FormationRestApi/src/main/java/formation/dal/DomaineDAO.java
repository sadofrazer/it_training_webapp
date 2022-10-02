package formation.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.bo.Domaine;


@Repository
public interface DomaineDAO extends JpaRepository<Domaine, Integer> {

}

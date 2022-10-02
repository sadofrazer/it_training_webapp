package formation.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.bo.Formateur;

@Repository
public interface FormateurDAO extends JpaRepository<Formateur, Integer>{

}

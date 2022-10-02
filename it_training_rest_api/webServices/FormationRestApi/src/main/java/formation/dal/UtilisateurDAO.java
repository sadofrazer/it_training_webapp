package formation.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.bo.Utilisateur;

@Repository
public interface UtilisateurDAO extends JpaRepository<Utilisateur, Integer>{

	Utilisateur findByLoginAndPassword(String login, String password);
}

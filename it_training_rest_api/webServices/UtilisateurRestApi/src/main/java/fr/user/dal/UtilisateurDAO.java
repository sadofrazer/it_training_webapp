package fr.user.dal;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.user.bo.Utilisateur;



@Repository
public interface UtilisateurDAO extends JpaRepository<Utilisateur, Integer>{

	

}

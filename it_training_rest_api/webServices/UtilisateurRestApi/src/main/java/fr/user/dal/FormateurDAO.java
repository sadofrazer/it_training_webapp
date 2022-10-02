package fr.user.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.user.bo.Formateur;

@Repository
public interface FormateurDAO extends JpaRepository<Formateur, Integer>{

	

}

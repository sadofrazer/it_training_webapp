package fr.user.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.user.bo.Inscription;


@Repository
public interface InscriptionDAO extends JpaRepository<Inscription, Integer> {

}

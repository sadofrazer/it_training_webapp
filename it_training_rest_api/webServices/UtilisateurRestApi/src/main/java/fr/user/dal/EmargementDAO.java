package fr.user.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.user.bo.Emargement;



@Repository
public interface EmargementDAO extends JpaRepository<Emargement, Integer>{

}

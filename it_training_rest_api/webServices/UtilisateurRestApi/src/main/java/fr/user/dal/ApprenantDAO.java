package fr.user.dal;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.user.bo.Apprenant;



@Repository
public interface ApprenantDAO extends JpaRepository<Apprenant, Integer>{

	

}

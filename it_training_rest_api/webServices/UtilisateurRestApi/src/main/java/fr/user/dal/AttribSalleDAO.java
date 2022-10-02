package fr.user.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.user.bo.AttribSalle;



@Repository
public interface AttribSalleDAO extends JpaRepository<AttribSalle, Integer>{

}

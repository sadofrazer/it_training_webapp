package fr.user.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.user.bo.Alerte;



@Repository
public interface AlerteDAO extends JpaRepository<Alerte, Integer>{

}

package fr.user.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.user.bo.Salle;



public interface SalleDAO extends JpaRepository<Salle, Integer>{

}

package fr.user.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.user.bo.Domaine;



@Repository
public interface DomaineDAO extends JpaRepository<Domaine, Integer> {

}

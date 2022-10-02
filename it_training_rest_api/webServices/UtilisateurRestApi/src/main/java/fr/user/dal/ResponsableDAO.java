package fr.user.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.user.bo.Responsable;

@Repository
public interface ResponsableDAO extends JpaRepository<Responsable, Integer>{

}

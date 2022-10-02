package fr.user.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.user.bo.Operations;



@Repository
public interface OperationsDAO extends JpaRepository<Operations, Integer>{

}

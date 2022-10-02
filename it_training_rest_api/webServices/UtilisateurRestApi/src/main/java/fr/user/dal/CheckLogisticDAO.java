package fr.user.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.user.bo.CheckLogistic;



@Repository
public interface CheckLogisticDAO extends JpaRepository<CheckLogistic, Integer>{

}

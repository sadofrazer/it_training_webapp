package fr.user.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.user.bo.Evaluation;



@Repository
public interface EvaluationDAO extends JpaRepository<Evaluation, Integer>{

}

package formation.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.bo.Evaluation;

@Repository
public interface EvaluationDAO extends JpaRepository<Evaluation, Integer>{

}

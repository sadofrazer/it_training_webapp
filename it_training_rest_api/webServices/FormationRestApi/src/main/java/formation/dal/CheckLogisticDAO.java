package formation.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.bo.CheckLogistic;

@Repository
public interface CheckLogisticDAO extends JpaRepository<CheckLogistic, Integer>{

}

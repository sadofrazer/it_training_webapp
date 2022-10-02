package formation.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.bo.Operations;

@Repository
public interface OperationsDAO extends JpaRepository<Operations, Integer>{

}

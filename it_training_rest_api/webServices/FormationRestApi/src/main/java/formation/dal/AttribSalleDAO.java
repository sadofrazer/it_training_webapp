package formation.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.bo.AttribSalle;

@Repository
public interface AttribSalleDAO extends JpaRepository<AttribSalle, Integer>{
	
	public List<AttribSalle> findBySessionIdSession(int idSession);
	public List<AttribSalle> findBySalleIdSalle(int idSalle);
	
}

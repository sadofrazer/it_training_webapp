package formation.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.bo.Session;

@Repository
public interface SessionDAO extends JpaRepository<Session, Integer> {
	
	public List<Session> findByFormationIdFormation(int idFormation);
	public Session findByCodeSession(String codeSession);

}

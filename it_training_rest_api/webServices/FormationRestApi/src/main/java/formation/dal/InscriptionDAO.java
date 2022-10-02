package formation.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.bo.Inscription;

@Repository
public interface InscriptionDAO extends JpaRepository<Inscription, Integer> {

	public Inscription findByCodeInscription(String codeInscription);
	public List<Inscription> findBySessionFormationIdFormation(int idFormation);
	public List<Inscription> findBySessionIdSession(int idSession);
	public List<Inscription> findByApprenantIdUtilisateur(int idApprenant);
	public List<Inscription> findByStatutOrderByIdInscription(String statut);
	
}

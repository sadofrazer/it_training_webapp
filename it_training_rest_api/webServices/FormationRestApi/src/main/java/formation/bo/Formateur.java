package formation.bo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="FORM")
public class Formateur extends Utilisateur{
	
	private String certifications;
	
	/*@OneToMany(mappedBy = "formateur" )
	private List<Session> sessions;*/
	
	public Formateur() {
		// TODO Auto-generated constructor stub
	}

	public String getCertifications() {
		return certifications;
	}

	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}

	/*public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}*/
	
	
}

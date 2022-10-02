package fr.user.bo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="FORM")
public class Formateur extends Utilisateur {
	

private String certifications;

//@OneToMany(mappedBy = "formateur" )
//private List<Session> sessions;

public Formateur() {}


public String getCertification() {
	return certifications;
}

public void setCertification(String certifications) {
	this.certifications = certifications;
}
/*public List<Session> getSessions() {
	return sessions;
}

public void setSessions(List<Session> sessions) {
	this.sessions = sessions;
}*/
}

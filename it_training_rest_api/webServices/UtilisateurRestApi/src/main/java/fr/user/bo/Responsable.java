package fr.user.bo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="RESP")
public class Responsable extends Utilisateur {
	

private String fonction;

//@OneToMany(mappedBy = "respLog")
//private List<CheckLogistic> checks;

public Responsable() {}
	


public String getFonction() {
	return fonction;
}

public void setFonction(String fonction) {
	this.fonction = fonction;
}



  
  
}

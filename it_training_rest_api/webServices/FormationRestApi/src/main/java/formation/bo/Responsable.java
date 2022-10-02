package formation.bo;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="RESP")
public class Responsable extends Utilisateur{
	private String fonction;
	
	@OneToMany(mappedBy = "respLog")
	private List<CheckLogistic> checks;
	
	
	public Responsable() {
		// TODO Auto-generated constructor stub
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	
	
	
}

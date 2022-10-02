package fr.user.bo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="APP")
public class Apprenant extends Utilisateur {
	
	private String dernierDiplome;
	
	//@OneToMany(mappedBy = "apprenant" )
	//private List<Inscription> inscriptions;

	/*public Apprenant(int id, String nom, String codeUser, String prenom, String adresse, String telephone,
			String societe, LocalDate dateNaiss, String numeroSiret, String statut, String login, String password,
			TypeUser typeUser, String dernierDiplome) {
		super(id, nom, codeUser, prenom, adresse, telephone, societe, dateNaiss, numeroSiret, statut, login, password,
				typeUser);
		this.dernierDiplome = dernierDiplome;
	}*/
	
	public Apprenant() {
		// TODO Auto-generated constructor stub
	}

	public String getDernierDiplome() {
		return dernierDiplome;
	}

	public void setDernierDiplome(String dernierDiplome) {
		this.dernierDiplome = dernierDiplome;
	}

	/*public List<Inscription> getInscriptionss() {
		return inscriptions;
	}

	//public void setInscriptionss(List<Inscription> inscriptions) {
	//	this.inscriptions = inscriptions;
	}*/
	
}

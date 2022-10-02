package fr.user.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeUser {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idType;
	@Column(nullable = false)
	private String nom;
	private String description;
	

	
	public TypeUser() {}

	

	public int getIdType() {
		return idType;
	}



	public void setIdType(int idType) {
		this.idType = idType;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	/*public List<Utilisateur> getUtilisateurs() {
	return utilisateurs;
}

public void setUtilisateurs(List<Utilisateur> utilisateurs) {
	this.utilisateurs = utilisateurs;
}*/
	
}

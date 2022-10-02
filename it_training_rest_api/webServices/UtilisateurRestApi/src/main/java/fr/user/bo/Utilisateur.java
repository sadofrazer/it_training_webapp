package fr.user.bo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn(name="type")
@DiscriminatorValue(value="USER")
public class Utilisateur {
	
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY )
	private int idUtilisateur;
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String codeUser;
	private String prenom;
	@Column(nullable = false)
	private String email;
	private String adresse;
	private String telephone;
	private String societe;
	private LocalDate dateNaiss;
	private String numeroSiret;
	private String statut;
	@Column(nullable = false)
	private String login;
	@Column(nullable = false)
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "idType")
	private TypeUser typeUser;
	
	

	public Utilisateur() {
		
	}


	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getCodeUser() {
		return codeUser;
	}

	public void setCodeUser(String codeUser) {
		this.codeUser = codeUser;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(LocalDate dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public String getNumeroSiret() {
		return numeroSiret;
	}

	public void setNumeroSiret(String numeroSiret) {
		this.numeroSiret = numeroSiret;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public TypeUser getTypeUser() {
		return typeUser;
	}


	public void setTypeUser(TypeUser typeUser) {
		this.typeUser = typeUser;
	}


	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", codeUser=" + codeUser + ", nom=" + nom + ", prenom="
				+ prenom + ", telephone=" + telephone + ", email=" + email + ", dateNaiss=" + dateNaiss
				+ ", numeroSiret=" + numeroSiret + ", login=" + login + ", password=" + password + ", societe="
				+ societe + ", statut=" + statut + ", typeuser=" + typeUser + "]";
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	
	
}
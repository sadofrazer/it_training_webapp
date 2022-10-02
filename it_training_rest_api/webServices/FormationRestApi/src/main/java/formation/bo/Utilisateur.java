package formation.bo;

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
	
	public Utilisateur(int id, String nom, String codeUser, String prenom, String adresse, String telephone,
			String societe, LocalDate dateNaiss, String numeroSiret, String statut, String login, String password,
			TypeUser typeUser) {
		super();
		this.idUtilisateur = id;
		this.nom = nom;
		this.codeUser = codeUser;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.societe = societe;
		this.dateNaiss = dateNaiss;
		this.numeroSiret = numeroSiret;
		this.statut = statut;
		this.login = login;
		this.password = password;
		this.typeUser = typeUser;
	}

	public Utilisateur() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodeUser() {
		return codeUser;
	}

	public void setCodeUser(String codeUser) {
		this.codeUser = codeUser;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
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

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
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

	public TypeUser getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(TypeUser typeUser) {
		this.typeUser = typeUser;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

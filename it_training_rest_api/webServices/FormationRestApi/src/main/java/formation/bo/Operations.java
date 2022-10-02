package formation.bo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Operations {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOperation;
	@Column(nullable = false)
	private String codeOpe;
	private String nom;
	private String description;
	private String typeRes;
	
	@Column(columnDefinition = "DATE")
	private LocalDate dateDebut;
	
	@ManyToOne
	@JoinColumn(name="idUser")
	private Utilisateur utilisateur;
	
	public Operations() {
		// TODO Auto-generated constructor stub
	}

	public int getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(int idOperation) {
		this.idOperation = idOperation;
	}

	public String getCodeOpe() {
		return codeOpe;
	}

	public void setCodeOpe(String codeOpe) {
		this.codeOpe = codeOpe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTypeRes() {
		return typeRes;
	}

	public void setTypeRes(String typeRes) {
		this.typeRes = typeRes;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}

package fr.user.bo;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Alerte {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOperation;
	private String codeOpe;
	private String nom;
	private String description;
	private String typeRes;
	private LocalDate dateDebut;
	
	@ManyToOne
	@JoinColumn(name="idUser")
	private Utilisateur user;
	
	public Alerte() {
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

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
}

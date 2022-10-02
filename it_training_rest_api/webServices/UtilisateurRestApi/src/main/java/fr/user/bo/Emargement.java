package fr.user.bo;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Emargement {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmargement;
	private String codeEmarg;
	private String nom;
	private LocalDate dateSign;
	private String periode;
	private String statut;
	private boolean presenceIsOk;
	
	@ManyToOne
	@JoinColumn(name="idInscription")
	private Inscription inscription;
	
	public Emargement() {
		// TODO Auto-generated constructor stub
	}

	public Emargement(int idEmargement, String codeEmarg, String nom, LocalDate dateSign, String periode, String statut,
			boolean presenceIsOk, Inscription inscription) {
		super();
		this.idEmargement = idEmargement;
		this.codeEmarg = codeEmarg;
		this.nom = nom;
		this.dateSign = dateSign;
		this.periode = periode;
		this.statut = statut;
		this.presenceIsOk = presenceIsOk;
		this.inscription = inscription;
	}

	public int getIdEmargement() {
		return idEmargement;
	}

	public void setIdEmargement(int idEmargement) {
		this.idEmargement = idEmargement;
	}

	public String getCodeEmarg() {
		return codeEmarg;
	}

	public void setCodeEmarg(String codeEmarg) {
		this.codeEmarg = codeEmarg;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDateSign() {
		return dateSign;
	}

	public void setDateSign(LocalDate dateSign) {
		this.dateSign = dateSign;
	}

	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public boolean isPresenceIsOk() {
		return presenceIsOk;
	}

	public void setPresenceIsOk(boolean presenceIsOk) {
		this.presenceIsOk = presenceIsOk;
	}

	public Inscription getInscription() {
		return inscription;
	}

	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}

	
}

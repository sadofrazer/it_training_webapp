package fr.user.bo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AttribSalle {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAttribSalle;
	@Column(nullable = false)
	private LocalDate dateAttrib;
	private String statut;
	
	@ManyToOne
	@JoinColumn(name = "idSalle")
	private Salle salle;
	
	@ManyToOne
	@JoinColumn(name = "idSession")
	private Session session;
	
	@ManyToOne
	@JoinColumn(name="idRespFor")
	private Responsable respFor;
	
	public AttribSalle() {
		// TODO Auto-generated constructor stub
	}
	
	
	public LocalDate getDateAttrib() {
		return dateAttrib;
	}


	public void setDateAttrib(LocalDate dateAttrib) {
		this.dateAttrib = dateAttrib;
	}


	public Salle getSalle() {
		return salle;
	}


	public void setSalle(Salle salle) {
		this.salle = salle;
	}


	public AttribSalle(int idAttribSalle, String statut, Session session, Responsable respFor) {
		super();
		this.idAttribSalle = idAttribSalle;
		this.statut = statut;
		this.session = session;
		this.respFor = respFor;
	}

	public int getIdAttribSalle() {
		return idAttribSalle;
	}

	public void setIdAttribSalle(int idAttribSalle) {
		this.idAttribSalle = idAttribSalle;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}


	public Responsable getRespFor() {
		return respFor;
	}


	public void setRespFor(Responsable respFor) {
		this.respFor = respFor;
	}

	
}

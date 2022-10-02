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
public class Evaluation {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEval;
	@Column(nullable = false)
	private String codeEval;
	private String nom;
	@Column(columnDefinition = "DATE")
	private LocalDate dateEval;
	
	private String description;
	private String statut;
	private boolean evalIsOk;
	
	@ManyToOne
	@JoinColumn(name="idInscription")
	private Inscription inscription;
	
	public Evaluation() {
		// TODO Auto-generated constructor stub
	}

	public Evaluation(int idEval, String codeEval, String nom, LocalDate dateEval, String description,
			String statut, boolean evalIsOk, Inscription inscription) {
		super();
		this.idEval = idEval;
		this.codeEval = codeEval;
		this.nom = nom;
		this.dateEval = dateEval;
		this.description = description;
		this.statut = statut;
		this.evalIsOk = evalIsOk;
		this.inscription = inscription;
	}

	public int getIdEval() {
		return idEval;
	}

	public void setIdEval(int idEvaluation) {
		this.idEval = idEvaluation;
	}

	public String getCodeEval() {
		return codeEval;
	}

	public void setCodeEval(String codeEval) {
		this.codeEval = codeEval;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDateEval() {
		return dateEval;
	}

	public void setDateEval(LocalDate dateEval) {
		this.dateEval = dateEval;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public boolean isEvalIsOk() {
		return evalIsOk;
	}

	public void setEvalIsOk(boolean evalIsOk) {
		this.evalIsOk = evalIsOk;
	}

	public Inscription getInscription() {
		return inscription;
	}

	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}

	

	
	
}

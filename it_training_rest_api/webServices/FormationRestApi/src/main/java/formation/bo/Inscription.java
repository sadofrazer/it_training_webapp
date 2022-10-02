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
public class Inscription {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idInscription;
	
	@Column(nullable = false, unique = true)
	private String codeInscription;
	
	private String statut;
	
	@Column(columnDefinition = "DATE")
	private LocalDate dateInscription;
	
	@ManyToOne
	@JoinColumn(name = "idApprenant")
	private Apprenant apprenant;
	
	@ManyToOne
	@JoinColumn(name = "idSession")
	private Session session;
	
	/*@OneToMany(mappedBy = "inscription")
	private List<Emargement> emargements;
	
	@OneToMany(mappedBy = "inscription")
	private List<Evaluation> evaluations;*/
	
	public Inscription() {
		// TODO Auto-generated constructor stub
	}

	public Inscription(int idInscription, String codeInscription, String statut, LocalDate dateInscription,
			Apprenant apprenant, Session session) {
		super();
		this.idInscription = idInscription;
		this.codeInscription = codeInscription;
		this.statut = statut;
		this.dateInscription = dateInscription;
		this.apprenant = apprenant;
		this.session = session;
	}

	public int getIdInscription() {
		return idInscription;
	}

	public void setIdInscription(int idInscription) {
		this.idInscription = idInscription;
	}

	public String getCodeInscription() {
		return codeInscription;
	}

	public void setCodeInscription(String codeInscription) {
		this.codeInscription = codeInscription;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public LocalDate getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(LocalDate dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Apprenant getIdApprenant() {
		return apprenant;
	}

	public void setIdApprenant(Apprenant apprenant) {
		this.apprenant = apprenant;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Apprenant getApprenant() {
		return apprenant;
	}

	public void setApprenant(Apprenant apprenant) {
		this.apprenant = apprenant;
	}
	
	/*public List<Emargement> getEmargements() {
		return emargements;
	}

	public void setEmargements(List<Emargement> emargements) {
		this.emargements = emargements;
	}

	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}*/
	
}

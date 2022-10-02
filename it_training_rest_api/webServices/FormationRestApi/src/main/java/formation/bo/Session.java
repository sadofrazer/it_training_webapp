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
public class Session {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSession;
	@Column(nullable = false, unique = true)
	private String codeSession;
	private String nom;
	private String description;
	private String statut;
	private String type;
	
	@Column(columnDefinition = "DATE")
	private LocalDate dateDebut;
	
	@Column(columnDefinition = "DATE")
	private LocalDate dateFin;
	
	private float prix;
	
	@ManyToOne
	@JoinColumn(name="idRespFor")
	private Responsable respFor;
	
	@ManyToOne
	@JoinColumn(name = "idFormation")
	private Formation formation;
	
	/*@OneToMany(mappedBy = "session")
	private List<Inscription> inscriptions;*/
	
	@ManyToOne
	@JoinColumn(name="idFormateur")
	private Formateur formateur;
	
	public Session() {
		// TODO Auto-generated constructor stub
	}

	public Session(int idSession, String codeSession, String nom, String description, String statut, String type,
			LocalDate dateDebut, LocalDate dateFin, float prix, Responsable respFor, Formation formation, Formateur formateur) {
		super();
		this.idSession = idSession;
		this.codeSession = codeSession;
		this.nom = nom;
		this.description = description;
		this.statut = statut;
		this.type = type;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prix = prix;
		this.respFor = respFor;
		this.formation = formation;
		this.formateur = formateur;
	}

	public int getIdSession() {
		return idSession;
	}

	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}

	public String getCodeSession() {
		return codeSession;
	}

	public void setCodeSession(String codeSession) {
		this.codeSession = codeSession;
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

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Responsable getRespFor() {
		return respFor;
	}

	public void setRespFor(Responsable respFor) {
		this.respFor = respFor;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	

	/*public List<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}*/

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	
}

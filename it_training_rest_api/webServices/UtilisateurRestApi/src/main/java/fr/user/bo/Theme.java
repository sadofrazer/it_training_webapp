package fr.user.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class Theme {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTheme;
	@Column(nullable = false)
	private String codeTheme;
	@Column(nullable = false)
	private String nom;
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "idDomaine")
	private Domaine domaine;
	
	/*@OneToMany(orphanRemoval = true, mappedBy ="theme")
	@Basic(fetch = FetchType.LAZY)
	private List<SousTheme> sthemes;*/
	
	public Theme() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Theme(int idTheme, String codeTheme, String nom, String description, Domaine domaine) {
		super();
		this.idTheme = idTheme;
		this.codeTheme = codeTheme;
		this.nom = nom;
		this.description = description;
		this.domaine = domaine;
	}

	public Domaine getDomaine() {
		return domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	public int getIdTheme() {
		return idTheme;
	}

	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}

	public String getCodeTheme() {
		return codeTheme;
	}

	public void setCodeTheme(String codeTheme) {
		this.codeTheme = codeTheme;
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
	
	
}

package fr.user.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class Domaine {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDomaine;
	@Column(nullable = false)
	private String codeDom;
	@Column(nullable = false)
	private String nom;
	private String description;
	
	/*@OneToMany(mappedBy = "domaine")
	@Basic(fetch = FetchType.LAZY)
	private List<Theme> themes; */
	
	public Domaine() {
		// TODO Auto-generated constructor stub
	}

	public Domaine(int idDomaine, String codeDom, String nom, String description) {
		super();
		this.idDomaine = idDomaine;
		this.codeDom = codeDom;
		this.nom = nom;
		this.description = description;
	}

	public int getIdDomaine() {
		return idDomaine;
	}

	public void setIdDomaine(int idDomaine) {
		this.idDomaine = idDomaine;
	}

	public String getCodeDom() {
		return codeDom;
	}

	public void setCodeDom(String codeDom) {
		this.codeDom = codeDom;
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

package formation.bo;


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
public class SousTheme {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStheme;

	@Column(nullable = false, unique = true)
	private String codeStheme;
	
	@Column(nullable = false)
	private String nom;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "idTheme")
	private Theme theme;
	
	/*@OneToMany(mappedBy = "stheme")
	@Basic(fetch = FetchType.LAZY)
	private List<Formation> formations;*/
	
	public SousTheme() {
		// TODO Auto-generated constructor stub
	}

	public SousTheme(int idStheme, String codeStheme, String nom, String description, Theme theme) {
		super();
		this.idStheme = idStheme;
		this.codeStheme = codeStheme;
		this.nom = nom;
		this.description = description;
		this.theme = theme;
	}

	public int getIdStheme() {
		return idStheme;
	}

	public void setIdStheme(int idStheme) {
		this.idStheme = idStheme;
	}

	public String getCodeStheme() {
		return codeStheme;
	}

	public void setCodeStheme(String codeStheme) {
		this.codeStheme = codeStheme;
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

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	
}

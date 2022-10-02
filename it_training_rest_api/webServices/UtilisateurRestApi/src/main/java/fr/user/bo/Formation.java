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
public class Formation {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFormation;
	@Column(nullable = false)
	private String codeFormation;
	@Column(nullable = false)
	private String nom;
	private String description;
	
	@Column(nullable = false)
	private int nbreJrs;
	
	@ManyToOne
	@JoinColumn(name = "idStheme")
	private SousTheme stheme;
	
	/*@OneToMany(mappedBy = "formation")
	@Basic(fetch = FetchType.LAZY)
	private List<Session> sessions;*/
	
	@ManyToOne
	@JoinColumn(name="idRespCat")
	private Responsable respCat;
	
	public Formation() {
		// TODO Auto-generated constructor stub
	}

	public Formation(int idFormation, String codeFormation, String nom, String description,int nbrejrs, SousTheme stheme,
		Responsable respCat) {
		super();
		this.idFormation = idFormation;
		this.codeFormation = codeFormation;
		this.nom = nom;
		this.description = description;
		this.nbreJrs=nbrejrs;
		this.stheme = stheme;
		this.respCat = respCat;
	}
	
	public Formation(String codeFormation, String nom, String description,int nbrejrs, SousTheme stheme,
			Responsable respCat) {
		super();
		this.codeFormation = codeFormation;
		this.nom = nom;
		this.description = description;
		this.nbreJrs=nbrejrs;
		this.stheme = stheme;
		this.respCat = respCat;
	}

	public int getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}
	
	public String getCodeFormation() {
		return codeFormation;
	}

	public void setCodeFormation(String codeFormation) {
		this.codeFormation = codeFormation;
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

	public SousTheme getStheme() {
		return stheme;
	}

	public void setStheme(SousTheme stheme) {
		this.stheme = stheme;
	}

	
	public Responsable getRespCat() {
		return respCat;
	}

	public void setRespCat(Responsable respCat) {
		this.respCat = respCat;
	}

	public int getNbreJrs() {
		return nbreJrs;
	}

	public void setNbreJrs(int nbrejrs) {
		this.nbreJrs = nbrejrs;
	}

	@Override
	public String toString() {
		return "Formation [idFormation=" + idFormation + ", codeFormation=" + codeFormation + ", nom=" + nom + ", description="
				+ description + ", nbreJrs=" + nbreJrs + ", stheme=" + stheme + ", idRespCat=" + respCat + "]";
	}

	
}

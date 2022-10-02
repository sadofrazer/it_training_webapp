package formation.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class TestPrerequis {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTest;
	private String nom;
	private String description;
	
	@OneToOne
	@JoinColumn(name = "idFormation")
	private Formation formation;
	
	public TestPrerequis() {
		// TODO Auto-generated constructor stub
	}

	public int getIdTest() {
		return idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
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

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	
}

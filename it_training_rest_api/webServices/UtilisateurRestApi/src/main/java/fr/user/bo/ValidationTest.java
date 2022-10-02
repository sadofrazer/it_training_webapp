package fr.user.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ValidationTest {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVal;
	private String nom;
	private String commentaires;
	private String resultat;
	
	@OneToOne
	@JoinColumn(name = "idTest")
	private TestPrerequis testPrerequis;
	
	@OneToOne
	@JoinColumn(name = "idApprenant")
	private Apprenant apprenant;
	
	public ValidationTest() {
		// TODO Auto-generated constructor stub
	}

	public int getIdVal() {
		return idVal;
	}

	public void setIdVal(int idVal) {
		this.idVal = idVal;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public TestPrerequis getTestPrerequis() {
		return testPrerequis;
	}

	public void setTestPrerequis(TestPrerequis testPrerequis) {
		this.testPrerequis = testPrerequis;
	}

	public Apprenant getApprenant() {
		return apprenant;
	}

	public void setApprenant(Apprenant apprenant) {
		this.apprenant = apprenant;
	}

}

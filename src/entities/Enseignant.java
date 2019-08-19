package entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("ens")
public class Enseignant extends Personne {
	private String matricule;
	private String grade;
	@OneToMany(mappedBy="enseignant")
	private Collection<Matiere> matieres;
	
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	

	public Enseignant(String cin, String nom, String prenom,
			String datenaissance, String adresse, String mail, String tel,
			Ville ville, String matricule, String grade ) {
		super(cin, nom, prenom, datenaissance, adresse, mail, tel, ville);
		this.matricule = matricule;
		this.grade = grade;
	}
	public Enseignant() {
		super();
	}
	

}

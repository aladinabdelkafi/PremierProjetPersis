package entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("etd")
public class Etudiant extends Personne {
	private String numInscription;
	@ManyToOne
	@JoinColumn(name="GROUPE_ID")
	private Groupe groupe;
	@OneToMany(mappedBy="etudiant")
	private Collection<Examen> examens;


	public Collection<Examen> getExamens() {
		return examens;
	}



	public void setExamens(Collection<Examen> examens) {
		this.examens = examens;
	}



	public Groupe getGroupe() {
		return groupe;
	}



	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}



	public String getNumInscription() {
		return numInscription;
	}



	public void setNumInscription(String numInscription) {
		this.numInscription = numInscription;
	}







	public Etudiant(String cin, String nom, String prenom, String datenaissance,
			String adresse, String mail, String tel, Ville ville,
			String numInscription, Groupe groupe) {
		super(cin, nom, prenom, datenaissance, adresse, mail, tel, ville);
		this.numInscription = numInscription;
		this.groupe = groupe;
	}



	public Etudiant() {
		super();
	}
	

}

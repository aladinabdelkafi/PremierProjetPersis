package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Typ_pers", discriminatorType = DiscriminatorType.STRING, length = 3)
@Table(name = "Personne")
public abstract  class Personne implements Serializable{
	@Id
	private String cin;
	private String nom;
	private String prenom;
	private String datenaissance;
	private String adresse;
	private String mail;
	private String tel;
	@ManyToOne
	@JoinColumn(name="CODE_VILLE")
	private Ville ville;

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(String datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Personne(String cin, String nom, String prenom, String datenaissance2,
			String adresse, String mail, String tel, Ville ville) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.datenaissance = datenaissance2;
		this.adresse = adresse;
		this.mail = mail;
		this.tel = tel;
		this.ville = ville;
	}

	public Personne() {
	}

}

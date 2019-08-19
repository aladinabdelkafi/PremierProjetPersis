package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Pers implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@javax.persistence.Id
	@GeneratedValue
	private int Id ;
	private String Nom ;
	private String Prenom ;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	
	
	
}

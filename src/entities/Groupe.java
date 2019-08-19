package entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "groupe")

public class Groupe {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int groupId;
	private String nomGroupe;
	private String nomDepartement;
	@OneToMany(mappedBy="groupe")
	private Collection<Etudiant> etudiants;
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getNomGroupe() {
		return nomGroupe;
	}
	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}
	public String getNomDepartement() {
		return nomDepartement;
	}
	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}
	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	public Groupe(String nomGroupe, String nomDepartement) {
		super();
		this.nomGroupe = nomGroupe;
		this.nomDepartement = nomDepartement;
	}
	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

package entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "matiere")
public class Matiere {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int matiereId;
	private String nomMatiere;
	private int semestre;
	@ManyToOne
	@JoinColumn(name="ENS_CIN")
	private Enseignant enseignant;
	
	@OneToMany(mappedBy="matiere")
	private Collection<Examen> examens;
	
	public Collection<Examen> getExamens() {
		return examens;
	}
	public void setExamens(Collection<Examen> examens) {
		this.examens = examens;
	}
	public int getMatiereId() {
		return matiereId;
	}
	public void setMatiereId(int matiereId) {
		this.matiereId = matiereId;
	}
	public String getNomMatiere() {
		return nomMatiere;
	}
	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public Matiere(String nomMatiere, int semestre, Enseignant enseignant) {
		super();
		this.nomMatiere = nomMatiere;
		this.semestre = semestre;
		this.enseignant = enseignant;
	}
	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}


}

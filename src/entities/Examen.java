package entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Examen")

public class Examen {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int examenId;
	private String dateExamen;
	private double noteExamen;
	private boolean absent;
	@ManyToOne
	@JoinColumn(name="ETUD_CIN")
	private Etudiant etudiant;

	@ManyToOne
	@JoinColumn(name="MATIERE_ID")
	private Matiere matiere;
	
	public int getExamenId() {
		return examenId;
	}
	public void setExamenId(int examenId) {
		this.examenId = examenId;
	}
	
	public String getDateExamen() {
		return dateExamen;
	}
	public void setDateExamen(String dateExamen) {
		this.dateExamen = dateExamen;
	}
	public double getNoteExamen() {
		return noteExamen;
	}
	public void setNoteExamen(double noteExamen) {
		this.noteExamen = noteExamen;
	}
	public boolean isAbsent() {
		return absent;
	}
	public void setAbsent(boolean absent) {
		this.absent = absent;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Examen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Examen(String dateExamen, double noteExamen, boolean absent,
			Etudiant etudiant, Matiere matiere) {
		super();
		this.dateExamen = dateExamen;
		this.noteExamen = noteExamen;
		this.absent = absent;
		this.etudiant = etudiant;
		this.matiere = matiere;
	}
	
	

}

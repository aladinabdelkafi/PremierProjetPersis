package entities;

import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "Ville")
public class Ville {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codeVille;
	private String nomVille;
	@OneToMany(mappedBy="ville")
	private Collection<Personne> personnes;
	public int getCodeVille() {
		return codeVille;
	}
	public void setCodeVille(int codeVille) {
		this.codeVille = codeVille;
	}
	public String getNomVille() {
		return nomVille;
	}
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	public Ville(String nomVille) {
		super();
		this.nomVille = nomVille;
	}
	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

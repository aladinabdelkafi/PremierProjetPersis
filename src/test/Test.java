package test;
import java.util.Date;
import java.util.List;


import dao.*;
import entities.*;


public class Test {

	public static void main(String[] args) {

        //Class
		VilleDAO vDao=new VilleDAO();
		MatiereDAO mDao=new MatiereDAO();
		GroupeDAO gDao=new GroupeDAO();
		ExamenDAO exDao=new ExamenDAO();
		EtudiantDAO etDao=new EtudiantDAO();
		EnseignantDAO enDao=new EnseignantDAO();

        Ville v=new Ville("sfax");
        vDao.addVille(v);
        Groupe g= new Groupe("SEM31", "inf");
        gDao.addGroupe(g);
        Date d = new Date(1997 , 2 ,7) ;
        Enseignant e = new Enseignant("1013100","Masmoudi","Naissen","1996-09-01","gremda","Masmoudi.Naissen@gmail.com","20103052",v,"1213","2");
        enDao.addEnseignant(e); 
        Matiere m=new Matiere("Persistance", 1, e);
        mDao.addMatiere(m);
     Etudiant et=new Etudiant("101021", "louati", "houssem", "1995-07-30", "adresse", "mail", "tel", v, "123", g);
        etDao.addEtudiant(et);
   Examen ex=new Examen("2016-07-10", 20, false, et, m);
       exDao.addExamen(ex);
		System.out.println("________________liste des etudiants_________________");
    	List<Ville> lst=vDao.getAllVille();
    	for(int i=0;i<lst.size();i++)
    	{
    	System.out.println(lst.get(i).getNomVille());
    	}
   
        
	}

}

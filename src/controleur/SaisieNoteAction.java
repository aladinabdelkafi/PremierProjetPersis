package controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EtudiantDAO;
import dao.ExamenDAO;
import dao.MatiereDAO;
import entities.Etudiant;
import entities.Examen;
import entities.Matiere;

@WebServlet("/SaisieNoteAction")
public class SaisieNoteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaisieNoteAction() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
	
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String grp = request.getParameter("groupe");
		String mat = request.getParameter("matiere");
		String date = request.getParameter("date");
		
		EtudiantDAO vDao = new EtudiantDAO();

		List<Etudiant> lst = vDao.getEtudiantByGroupe(grp);
		
		ExamenDAO eDao = new ExamenDAO();
		MatiereDAO mDao = new MatiereDAO();
		
		Matiere m = mDao.getMatiereById(mat).get(0);
	
		for(int i=0 ; i< lst.size() ; i++)
		{
			
			Etudiant e = lst.get(i);
			
			String a = "a"+e.getCin();
			String n = "n"+e.getCin();
			 
			double note = Double.parseDouble(request.getParameter(n));
			boolean abs = request.getParameter(a).equals("Présent");
			
			Examen E = new Examen(date, note,abs,e, m);
			eDao.addExamen(E);
			
		}
		
		
		
			}
}

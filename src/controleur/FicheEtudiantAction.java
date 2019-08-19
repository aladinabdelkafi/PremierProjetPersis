package controleur;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EtudiantDAO;
import dao.GroupeDAO;
import dao.VilleDAO;
import entities.Etudiant;
import entities.Groupe;
import entities.Ville;

/**
 * Servlet implementation class FicheEtudiantAction
 */
@WebServlet("/FicheEtudiantAction")
public class FicheEtudiantAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FicheEtudiantAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GroupeDAO gDao = new GroupeDAO();
		VilleDAO vDao = new VilleDAO();
		String cin = request.getParameter("cin");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String startDateStr = request.getParameter("date");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String adresse = request.getParameter("adresse");
		String mail = request.getParameter("mail");
		String tel = request.getParameter("tel");
		String codeVille = request.getParameter("ville");
		String idGroupe = request.getParameter("groupe");
		Groupe g = gDao.getGroupeById(idGroupe).get(0);
		Ville v = vDao.getVilleById(codeVille).get(0);
		String numInscription = request.getParameter("numInscription");
		//Date startDate = sdf.parse(startDateStr);
		EtudiantDAO edao = new EtudiantDAO();
		System.out.println(g.getNomGroupe() + "-" + v.getNomVille());
		Etudiant e = new Etudiant(cin, nom, prenom, startDateStr, adresse,
				mail, tel, v, numInscription, g);
		edao.addEtudiant(e);
		System.out.println("Ajout avec succé");
		request.getRequestDispatcher("ListeDesEtudiant.jsp").forward(request, 
				response);

	}

}

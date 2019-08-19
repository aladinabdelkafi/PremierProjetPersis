<%@page import="dao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="util.HibernateUtil"%>
<%@page import="org.hibernate.*"%>
<%@page import="entities.*"%>
<%@page import="org.dom4j.*"%>
<%@page import="org.hibernate.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="ISO-8859-1">

<title>Liste des etudiants</title>
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/one-page-wonder.min.css" rel="stylesheet"></head>
<body background="image.jpg">
<nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Acceuil</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="AjoutEtudiant.jsp">Ajout Etudiant</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="ListeDesEtudiant.jsp">Liste Des Etudiants</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="SaisieNote.jsp">Saisie Note</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
<%
		GroupeDAO gDao = new GroupeDAO();
		MatiereDAO mDao = new MatiereDAO();
		
		String mat = request.getParameter("matiere");
		String date = request.getParameter("date");
		String grp = request.getParameter("groupe");
		
		Groupe g = gDao.getGroupeById(grp).get(0);
		Matiere m = mDao.getMatiereById(mat).get(0);
	%>

<br>
	
	<center>
		<h1>
		
		<br>
			Liste <span>Des</span> Etudiants <br> <br> Examen <span>
				<%
					out.print(m.getNomMatiere());
				%>
			</span><br> Date <span> <%
 	out.print(date);
 %>
			</span><br> Groupe <span> <%
 	out.print(g.getNomGroupe());
 %>
			</span>
		</h1>
	</center>

<form action="SaisieNoteAction" method="post">
		<input type="hidden" name="date" value="<%=date%>"/> 
		<input type="hidden" name="matiere" value="<%=mat%>"/>
		<input type="hidden" name="groupe" value="<%=grp%>"/>
<center>
<br><br><br>


<br><br>
	<br>

<table class="table table-hover table-bordered">
  
  <thead class="table-active">
  <tr>
    
    <td>N°</td>
    <td>CIN</td>
    <td>Nom et Prenom</td>
    <td>Note</td>
    <td>Absent</td>
    
  </tr>
  </thead>
  
   
   <%
				EtudiantDAO vDao = new EtudiantDAO();

				List<Etudiant> lst = vDao.getEtudiantByGroupe(grp);
				
				for (int i = 0; i < lst.size(); i++) {
			%>
			<tr>
				<td><%=i + 1%></td>
				<td><%=lst.get(i).getCin()%></td>
				<td>
					<%
						out.print(lst.get(i).getNom() + " " + lst.get(i).getPrenom());
					%>
				</td>
				<td>
					<div class="form-group">
						<div class="col-sm-10">
						
							
							
								<input type="text" class="form-control" name="<%='n'+lst.get(i).getCin()%>">
							
						</div>
					</div>
				</td>
				<td>
						<select name="<%='a'+lst.get(i).getCin()%>">
							<option value="Présent">Présent</option>
							<option value="Absent">Absent</option>
						</select>
					</td>

			</tr>
			<%
				}
			%>

    
</table>
<br>
<table><tr>
	<td> <input type="submit" class="btn btn-primary" value="Enregistrer"/> </td>
	<td><a href="index.html"><input type="button" class="btn btn-warning" value="Retour a la page d'acceuil"/></a></td>
	</tr></table>
</form>

</body>
</html>
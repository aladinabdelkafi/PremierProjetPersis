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
<html lang="en">
<head>
<meta charset="UTF-8">
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/one-page-wonder.min.css" rel="stylesheet"><title>Liste des Etudiants</title>
</head>

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

	<form >
<center>
<br><br><br>


<h1>Liste des Etudiant</h1>
<br><br>
<table>
<tr>
	<td> <a href="AjoutEtudiant.jsp"><input type="button" class="btn btn-primary" value="Nouveau" /></a> </td>
	
	
	
	
 <td><a href="index.html"><input type="button" class="btn btn-warning" value="Retour a la page d'acceuil"/></a></td>
	
	</tr></table>
	<br>
	
<table class="table table-hover table-bordered">
  
  <thead class="table-active">
  <tr>
    
    <td>N�</td>
    <td>CIN</td>
    <td>Nom et Prenom</td>
    <td>Date de naissance</td>
    <td>Ville</td>
    <td>Groupe</td>
  </tr>
  </thead>
   <%--  charger le contenue d�s la bdd --%>	
   
   		<%
			EtudiantDAO vDao = new EtudiantDAO();

			List<Etudiant> lst = vDao.getAllEtudiants();
			for (int i = 0; i < lst.size(); i++) {
		%>
		<tr>
		<td><%=i+1 %></td>
			<td><%=lst.get(i).getCin()%></td>
			<td>
				<%
					out.print(lst.get(i).getNom() + " " + lst.get(i).getPrenom());
				%>
			</td>
			<td><%=lst.get(i).getDatenaissance()%></td>
			<td><%=lst.get(i).getVille().getNomVille()%></td>
			<td><%=lst.get(i).getGroupe().getNomGroupe()%></td>

		</tr>
		<%
			}
		%>
   
</table>
<br>

</form>

</body>
</html>
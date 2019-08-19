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
<title>Saisie note</title>
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/one-page-wonder.min.css" rel="stylesheet">
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

<form action="NoteDesEtudiant.jsp" >
<center>
<br><br><br>


<h1>saisie des notes</h1>
<br><br>

	<br>
<table>
  
  
  <tr>
    
    <td>Groupe</td>
    <td> 	<div class="form-group">
        <div class="col-xs-5 selectContainer">
	<select class="form-control" placeholder="Choisir"
						name="groupe">
						<%
							GroupeDAO gDao = new GroupeDAO();

							List<Groupe> lgrp = gDao.getAllGroupe();
							for (int i = 0; i < lgrp.size(); i++) {
						%>

						<option value="<%out.println(lgrp.get(i).getGroupId());%>">
							<%
								out.println(lgrp.get(i).getNomGroupe());
							%>
						</option>
						<%
							}
						%>
					</select></div></div></td>
    
  </tr>
  
  <tr>
    <td>Matiere</td>
    <td> 	<div class="form-group">
        <div class="col-xs-5 selectContainer">
            <select class="form-control" id="pwd" placeholder="Choisir"
						name="matiere">
						<%
							MatiereDAO mDao = new MatiereDAO();

							List<Matiere> mgrp = mDao.getAllMatiere();
							for (int i = 0; i < mgrp.size(); i++) {
						%>

						<option value="<%out.println(mgrp.get(i).getMatiereId());%>">
							<%
								out.println(mgrp.get(i).getNomMatiere());
							%>
						</option>
						<%
							}
						%>
					</select>
        </div>
    </div> </td>
  </tr>
  <tr>
    <td>Date Examen</td>
    <td> <input type="date" name="date" class="form-control"/> </td>
  </tr>
  
  	
</table>
<br>
<table><tr>
	<td> <input type="submit" class="btn btn-primary btn-block" value="Saisie des Notes"/> </td>
	<td><a href="index.html"><input type="button" class="btn btn-warning" value="Retour a la page d'acceuil"/></a></td>
	</tr></table>
</form>

</body>
</html>
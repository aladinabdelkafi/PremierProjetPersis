<%@page import="dao.*"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Ajouter Etudiant</title>
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
      
			// gestion de la saisie de  l'utilisateur en cours
			String cin =null;
			String nom =null;
			String prenom =null;
			String adresse =null;
			Date date =null;
			String mail =null;
			String tel =null;
			Ville ville=null ;
	//	Groupedao g=new Groupedao();
			Personne p = (Personne)request.getAttribute("pers");
			if (p!=null)
			{
			 cin=p.getCin();
			 nom =p.getNom();
			 prenom =p.getPrenom();
			 adresse =p.getAdresse();
			// date =p.getDatenaissance();
			 mail =p.getMail();
			 tel =p.getTel();
			 ville =p.getVille();
			
			}
		//	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			// Correction des  valleurs nulles
			if (cin==null)cin="";
			if (nom==null)nom="";
			if (prenom==null)prenom="";
			if (adresse==null)adresse="";
			if (date==null){
				
				date = new Date();
			}
			if (mail==null)mail="";
			if (tel==null)tel="";
			if (ville==null){ville= new Ville();ville.setNomVille("");}
		%>
<form action="FicheEtudiantAction" method="POST" >

<center>
<br><br><br>


<h1>Ajout Etudiant</h1>
<br><br>
<table>
  
  <tr>
    
    <td>CIN</td>
    <td><input type="text" name="cin" class="form-control" value="<%=cin%>"/></td>
  
  </tr>
  
   <tr>
    
    <td>Prénom</td>
    <td><input type="text" name="prenom" class="form-control" value="<%=prenom%>"/></td>

  </tr>
  
   <tr>
    
    <td>Nom</td>
    <td><input type="text" name="nom" class="form-control" value="<%=nom%>"/></td>

  </tr>
  
   <tr>
    
    <td>Date naissance</td>
    <td><input type="date" name="date" class="form-control" /></td>

  </tr>
  
   <tr>
    
    <td>Adresse</td>
    <td><input type="text" name="adresse" class="form-control" value="<%=adresse%>" /></td>

  </tr>
  
   <tr>
    
    <td>Ville</td>
    <td>
	
	<select class="form-control"  placeholder="Choisir" name="ville">
						<%
							VilleDAO vDao = new VilleDAO();

							List<Ville> lst = vDao.getAllVille();
							for (int i = 0; i < lst.size(); i++) {
						%>

						<option value="<%out.println(lst.get(i).getCodeVille());%>">
							<%
								out.println(lst.get(i).getNomVille());
							%>
						</option>
						<%
							}
						%>
					</select>
	
	</td>

  </tr>
  
   <tr>
    
    <td>Mail</td>
    <td><input type="text" name="mail" class="form-control" value="<%=mail%>"/></td>

  </tr>
  
   <tr>
    
    <td>Telephone</td>
    <td><input type="number" name="tel" class="form-control" value="<%=tel%>"/></td>

  </tr>
  
   <tr>
    
    <td>Groupe</td>
    <td>	<select class="form-control" name="groupe" placeholder="Choisir">
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
					</select></td>

  </tr>
	<tr>
	<td> <input type="submit" class="btn btn-primary" value="Enregistrer"/> </td>
	<td><a href="index.html"><input type="button" class="btn btn-warning" value="Retour a la page d'acceuil"/></a></td>
	</tr>
</table>
<br>

</form>

</body>
</html>
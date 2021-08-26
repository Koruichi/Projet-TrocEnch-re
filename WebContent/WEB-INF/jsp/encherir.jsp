<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Encherir</title>
</head>
<body>
<div>
		<a href="<%=request.getContextPath()%>/AccueilServlet"><img width="100px"
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxfwbzRR2jK66N7Dn3do6cTGmGGwZjfrJAT9Epoz9unIPxGNGu5aVyeQ-KCJn54C068r4&usqp=CAU"></a>
		
		<h1>Détail vente</h1>
	</div>
	<div>
	<img alt="" src="">
	</div>
	<div>
	<form action="EnchereServlet" method="POST">

	<label for="nom_article">${a.nom_article}</label> 
		<br>
		
	<label for="description">Description : ${a.description}</label> 
	
		<br>
			
    <label for="categorie">Categorie: ${a.categorie.libelle}</label>
      	<br>
      	
    <label for="meilleur_offre">Meilleur offre: ${a.prix_vente}</label>
    	<br>  	

	<label for="prix">Mise à prix: ${a.prix_initial}</label>
    	<br>
    	
      			 
      	<label for="start">Fin de l'enchère: ${a.date_fin_enchere}</label>
		<br>
		
		<label for="retrait">Retrait : ${a.retrait.rue} ${a.retrait.code_postal} ${a.retrait.ville}</label>
		<br>
		
		<label for="vendeur">Vendeur : ${vendeur.pseudo}</label>
		<br>
		<label for="proposition">Ma proposition : </label>
			 <input type="number" name="proposition"  />		
		<br>

		
		<input type="submit" value="Encherir" name="btnEncherir"/>   
	
	<input type = "hidden" name= "idArticle"/>
	</form>
</div>
</body>
</html>
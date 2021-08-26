<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link type="text/css" rel="stylesheet" href="style.css" />

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dosis:wght@200&display=swap" rel="stylesheet">

<style type="text/css">
label {
display:inline-block;
width : 70px;
}
</style>
<title>Encherir</title>
</head>
<body>

		<div class="container">
		<div class="row">
		<div class="col-lg-3 col-sm-4 offset-1">
		<a href="<%=request.getContextPath()%>/AccueilServlet"><img class="transparent" width="100px" src="img/marteaulogo.png" alt="logo marteau du site"></a>
		
		<h1>Détail vente</h1>
	</div>
	</div>
	</div>
	
	<div>
	<img alt="" src="">
	</div>
	
	<div class="container affichlst">
	<div class="row">
	<div class="col-lg-8 offset-2 col-sm-12">
	<form action="EnchereServlet" method="POST">

	<label class="text-nowrap" for="nom_article">${a.nom_article}</label> 
		<br>
		
	<label class="text-nowrap" for="description">Description : ${a.description}</label> 
	
		<br>

    <label class="text-nowrap" for="categorie">Categorie: ${a.categorie.libelle}</label>
      	<br>
      	
    <label class="text-nowrap" for="meilleur_offre">Meilleur offre: ${a.prix_vente}</label>
    		
    	<br>  	

	<label class="text-nowrap" for="prix">Mise à prix: ${a.prix_initial}</label>
    	<br>
    	
      			 
      	<label class="text-nowrap" for="start">Fin de l'enchère: ${a.date_fin_enchere}</label>
		<br>
		
		<label class="text-nowrap" for="retrait">Retrait : ${a.retrait.rue} ${a.retrait.code_postal} ${a.retrait.ville}</label>
		<br>
		
		<label class="text-nowrap" for="vendeur">Vendeur : ${vendeur.pseudo}</label>
		<br>
		<label class="text-nowrap" for="proposition">Ma proposition : </label>
			 <input class="form-control" type="number" name="proposition"  />		
		<br>
	
		
		<input class="form-control" type="submit" value="Encherir" name="btnEncherir"/>   
	
	<input class="form-control" type = "hidden" name= "idArticle" value="${param.id }"/>
	<input class="form-control" type = "hidden" name= "meilleur_offre" value="${a.prix_vente }"/>
	
	</form>
	</div>
	</div>
</div>
</body>
</html>
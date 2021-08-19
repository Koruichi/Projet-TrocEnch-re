<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil - ENI Ench�re</title>
</head>
<body>
	<div>
		<img alt="" src=""> <a href="/Projet-TrocEnchere/ConnexionServlet">S'inscrire - Se connecter</a>
	</div>
	<h1>Liste des ench�res</h1>
	<div>
		<form  method="POST">
			<label for="articleRecherche">Filtres :</label> <input type="search"
				id="site-search" name="q" aria-label="Recherche Article">

			<p>
				<label for="categorie">Cat�gorie : </label><br /> 
				<select name="categorie" id="categorie">
					<option value="toutes">Toutes</option>
					<option value="informatique">Informatique</option>
					<option value="ameublement">Ameublement</option>
					<option value="vetement">V�tement</option>
					<option value="sportLoisirs">Sport & Loisirs</option>
				</select>
			</p>

			<button>Rechercher</button>

		</form>
<c:forEach items="${model.lstArticles}" var="art">
	<div>
		<img alt="" src="">
		<h3>${art.art.nom_article}</h3>
		<p>Prix : ${art.prix_vente} </p>
		<p>Fin de l'ench�re :${art.date_fin_enchere} </p>
		<p>Vendeur : ${art.utilisateur.pseudo}</p>
	</div>
	</c:forEach>
	</div>

</body>
</html>
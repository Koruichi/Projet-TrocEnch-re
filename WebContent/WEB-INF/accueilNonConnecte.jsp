<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil - ENI Enchère</title>
</head>
<body>
	<div>
		<img alt="" src=""> <a href="#">S'inscrire - Se connecter</a>
	</div>
	<h1>Liste des enchères</h1>
	<div>
		<form method="post" action="traitement.php">
			<label for="article-search">Filtres :</label> <input type="search"
				id="site-search" name="q" aria-label="Search Article">

			<p>
				<label for="categorie">Catégorie : </label><br /> 
				<select name="categorie" id="categorie">
					<option value="informatique">Informatique</option>
					<option value="ameublement">Ameublement</option>
					<option value="vetement">Vêtement</option>
					<option value="sportLoisirs">Sport&Loisirs</option>
				</select>
			</p>

			<button>Rechercher</button>

		</form>


	</div>
</body>
</html>
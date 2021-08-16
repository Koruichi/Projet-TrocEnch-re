<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<form  method="POST">
			<label for="articleRecherche">Filtres :</label> <input type="search"
				id="site-search" name="q" aria-label="Recherche Article">

			<p>
				<label for="categorie">Catégorie : </label><br /> 
				<select name="categorie" id="categorie">
					<option value="toutes">Toutes</option>
					<option value="informatique">Informatique</option>
					<option value="ameublement">Ameublement</option>
					<option value="vetement">Vêtement</option>
					<option value="sportLoisirs">Sport&Loisirs</option>
				</select>
			</p>

			<button>Rechercher</button>

		</form>

	<div>
		<img alt="" src="">
		<h3>Titre</h3>
		<p>Prix : </p>
		<p>Fin de l'enchère : </p>
		<p>Vendeur : </p>
	</div>

	</div>
</body>
</html>
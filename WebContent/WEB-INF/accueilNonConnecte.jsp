<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil - ENI Ench�re</title>
</head>
<body>
	<div>
		<img alt="" src=""> <a href="#">S'inscrire - Se connecter</a>
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
					<option value="sportLoisirs">Sport&Loisirs</option>
				</select>
			</p>

			<button>Rechercher</button>

		</form>

	<div>
		<img alt="" src="">
		<h3>Titre</h3>
		<p>Prix : </p>
		<p>Fin de l'ench�re : </p>
		<p>Vendeur : </p>
	</div>

	</div>
</body>
</html>
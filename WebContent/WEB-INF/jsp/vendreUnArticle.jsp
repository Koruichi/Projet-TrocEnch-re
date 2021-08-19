<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendre un article</title>

</head>

<body>
	<div>
		<img alt="" src="">Eni-Enchères
		<h1>Nouvelle vente</h1>
	</div>

	<div>
		<label for="nom_article">Article : </label> <input type="text"
			id="nom_article" name="nom_article" value="" size="20" maxlength="100" />
		<br />
		<label for="description">Description : </label> <input type="text"
			id="description" name="description" value="" size="80" maxlength="200" />
		<br />
		<label for="categorie">Catégorie : </label><br /> 
				<select name="categorie" id="categorie">
					<option value="toutes">Toutes</option>
					<option value="informatique">Informatique</option>
					<option value="ameublement">Ameublement</option>
					<option value="vetement">Vêtement</option>
					<option value="sportLoisirs">Sport & Loisirs</option>
				</select>
				<br/>
	</div>


</body>
</html>
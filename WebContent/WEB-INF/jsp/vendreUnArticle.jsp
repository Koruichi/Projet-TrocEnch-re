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
	
	 <form method="post" action="VendreUnArticleServlet">
		<label for="nom_article">Article : </label> <input type="text"
			id="nom_article" name="nom_article" value="" size="20" maxlength="100" />
		<br>
		
		<label for="description">Description : </label> <input type="text"
			id="description" name="description" value="" size="80" maxlength="200" />
		<br>
		
		<label for="categorie">Catégorie : </label><br /> 
				<select name="categorie" id="categorie">
					<option value="toutes">Toutes</option>
					<option value="informatique">Informatique</option>
					<option value="ameublement">Ameublement</option>
					<option value="vetement">Vêtement</option>
					<option value="sportLoisirs">Sport & Loisirs</option>
				</select>
				<br/>
		
		<form action="/action_page.php">
 			 <label for="img">Photo de l'article:</label>
  			<input type="file" id="img" name="img" accept="image/*">
  			<input type="submit">
		</form>		
		<br>
		
		<label for="prix">Mise à prix:</label>
    		<input type="number" id="credit" name="credit">
    	<br>
    		
    	<label for="start">Début de l'enchère:</label>
			<input type="date" id="date_debut_encheres" name="date_debut_encheres">
      	<br>
      			 
      	<label for="start">Fin de l'enchère:</label>
			<input type="date" id="date_fin_encheres" name="date_fin_encheres">
		<br>
		
		<label for="Rue">Rue : </label> <input type="text"
			id="rue" name="rue" value="" size="20" maxlength="100" />
			
		<br>
		
		<label for="code_postal">Code postal : </label> <input type="text"
			id="code_postal" name="code_postal" value="" size="20" maxlength="100" />
		<br>
		
		<label for="ville">Ville : </label> <input type="text"
			id="ville" name="ville" value="" size="20" maxlength="100" />
		
		<br>
		
		<input type="submit" value="Enregistrer" name="btnRec" /> 
		<input type="reset" value="Annuler" /> 
	
	</form>
</div>


</body>
</html>
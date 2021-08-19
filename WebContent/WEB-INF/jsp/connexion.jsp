<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
<link type="text/css" rel="stylesheet" href="style.css" />

</head>

<body>
	<div>
		<img width="100px"
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxfwbzRR2jK66N7Dn3do6cTGmGGwZjfrJAT9Epoz9unIPxGNGu5aVyeQ-KCJn54C068r4&usqp=CAU">
		Eni-Enchères
	</div>
	<div>
		<form action="ConnexionServlet" method="POST">

			<label>Identifiant:</label>
			<input type="text" name="identifiant" value="" size="20" maxlength="20" /> 
			
			<br> 
			
			<label >Mot de passe: </label> 
			<input type="password" name="mot_de_passe" value="" size="20" maxlength="20" /> 
			
			<br> 
			
			<input type="checkbox" name="souvenir" id="souvenir" /> 
			<label>Se souvenir de moi</label>
			
			<br />
			
			<a href="#">Mot de passe oublié</a> 
		    <input type="submit" value="Connexion" name="btnConnexion" />


		</form>
		<form method="get" action="/Projet-TrocEnchere/CreerCompteServlet">
			<input type="submit" value="Créer un compte" name="btnCreerCompte" />
		</form>
		<br> ${message}
	</div>
</body>
</html>
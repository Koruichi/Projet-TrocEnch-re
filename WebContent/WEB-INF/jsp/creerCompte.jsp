<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Creer compte</title>
<link type="text/css" rel="stylesheet" href="style.css" />

</head>

<body>
	<div>
		<a href="<%=request.getContextPath()%>/AccueilServlet"><img width="100px"
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxfwbzRR2jK66N7Dn3do6cTGmGGwZjfrJAT9Epoz9unIPxGNGu5aVyeQ-KCJn54C068r4&usqp=CAU"></a>
	</div>
	<div>
		<form method="post" action="CreerCompteServlet">
			<h1>Mon profil</h1>

			<label >Pseudo: </label>
			<input type="text" name="pseudo" placeholder="Ex : Jojo44" value="" size="20" maxlength="20" /> 
				
			<br>

			<label >Prénom:</label> 
			<input type="text" name="prenom" value="" size="20" maxlength="20" /> 
			
			<br /> 
				
			<label >Nom:</label> 
			<input type="text" name="nom" value="" size="20" maxlength="20" /> 
			
			<br /> 
				
			<label >Téléphone: </label> 
			<input type="tel" name="telephone" value="" size="20" maxlength="20" /> 
				
			<br /> 
			<label >Code postal: </label> 
			<input type="text"  name="code_postal" value="" size="20" maxlength="20" />
				 
			<br /> 
			
			<label>Rue:</label> 
			<input type="text" name="rue" value="" size="20" maxlength="20" /> 
			
			<br /> 
			
			<label >Email:</label> 
			<input type="email" name="email" value="" size="20" maxlength="60" /> 
			
			<br /> 
			
			<label >Ville: </label>
			<input type="text" name="ville" value="" size="20" maxlength="20" /> 
				
			<br /> 
			
			<label >Mot de passe:</label>
			<input type="password" name="mot_de_passe" value="" size="20" maxlength="20" /> 
				
			<br /> 
				
			<label >Confirmation: </label> 
			<input type="password" name="confirmation" value="" size="20" maxlength="20" /> 
				
			<br /> 
				
			<input type="submit" value="Créer" name="btnCreer" /> 
			<input type="reset" value="Annuler" /> 
			
			<br />
		</form>
		${message}
	</div>
</body>
</html>
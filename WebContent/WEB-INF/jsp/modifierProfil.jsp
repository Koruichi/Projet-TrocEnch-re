<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier profil</title>
<link type="text/css" rel="stylesheet" href="style.css" />

</head>
<body>
	<div>
		<img width="100px"
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxfwbzRR2jK66N7Dn3do6cTGmGGwZjfrJAT9Epoz9unIPxGNGu5aVyeQ-KCJn54C068r4&usqp=CAU">
		Eni-Enchères
	</div>

	<div>
		<form method="get" action=" ">
			<h1>Mon profil</h1>

			<label >Pseudo: </label>
			<input type="text" name="pseudo" placeholder="Ex : Jojo44" value="" size="20" maxlength="20" /> 
				
			<label >Nom:</label> 
			<input type="text" name="nom" value="" size="20" maxlength="20" /> 
			
			<br /> 
				
			<label >Prénom:</label> 
			<input type="text" name="prenom" value="" size="20" maxlength="20" /> 
			
			<label >Email:</label> 
			<input type="email" name="email" value="" size="20" maxlength="60" /> 
			
			<br /> 
				
			<label >Téléphone: </label> 
			<input type="tel" name="telephone" value="" size="20" maxlength="20" /> 
				
			<label>Rue:</label> 
			<input type="text" name="rue" value="" size="20" maxlength="20" /> 
			
			<br /> 
			
			<label >Code postal: </label> 
			<input type="text"  name="code_postal" value="" size="20" maxlength="20" />
			
			<label >Ville: </label>
			<input type="text" name="ville" value="" size="20" maxlength="20" /> 
				
			<br /> 
			
			<label >Mot de passe actuel:</label>
			<input type="password" name="mot_de_passe_actu" value="" size="20" maxlength="20" />
			
			<br>
			
			<label >Nouveau mot de passe:</label>
			<input type="password" name="new_mot_de_passe" value="" size="20" maxlength="20" />  
				
			<label >Confirmation: </label> 
			<input type="password" name="confirmation" value="" size="20" maxlength="20" /> 
				
			<br />

			<label >Crédit: </label> <p></p>
			
			<br>
				
			<input type="submit" value="Enregistrer" name="btnEnregistrer" /> 
			<input type="button" value="Supprimer mon compte" name="btnSupprim"/> 
			
		</form>
	</div>
</body>
</html>
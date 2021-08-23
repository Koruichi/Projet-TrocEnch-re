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
		<a href="<%=request.getContextPath()%>/AccueilServlet"><img width="100px"
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxfwbzRR2jK66N7Dn3do6cTGmGGwZjfrJAT9Epoz9unIPxGNGu5aVyeQ-KCJn54C068r4&usqp=CAU"></a>
	</div>
	
	<div>
		<form method="POST" action="ModifierProfilServlet">
			<h1>Mon profil</h1>

			<label >Pseudo: </label>
			<input type="text" name="pseudo" value="${user.pseudo}" size="20" maxlength="20" /> 
				
			<label >Nom:</label> 
			<input type="text" name="nom" value="${user.nom}" size="20" maxlength="20" /> 
			
			<br> 
				
			<label >Prénom:</label> 
			<input type="text" name="prenom" value="${user.prenom}" size="20" maxlength="20" /> 
			
			<label >Email:</label> 
			<input type="email" name="email" value="${user.email}" size="20" maxlength="60" /> 
			
			<br> 
				
			<label >Téléphone: </label> 
			<input type="tel" name="telephone" value="${user.telephone}" size="20" maxlength="20" /> 
				
			<label>Rue:</label> 
			<input type="text" name="rue" value="${user.rue}" size="20" maxlength="20" /> 
			
			<br> 
			
			<label >Code postal: </label> 
			<input type="text"  name="code_postal" value="${user.code_postal}" size="20" maxlength="20" />
			
			<label >Ville: </label>
			<input type="text" name="ville" value="${user.ville}" size="20" maxlength="20" /> 
				
			<br> 
			
			<label >Mot de passe actuel:</label>
			<input type="password" name="mot_de_passe_actu" size="20" maxlength="20" />
			
			<br>
			
			<label >Nouveau mot de passe:</label>
			<input type="password" name="new_mot_de_passe" size="20" maxlength="20" />  
				
			<label >Confirmation: </label> 
			<input type="password" name="confirmation" size="20" maxlength="20" /> 
		
			<br>

			<p>Crédit: ${user.credit}</p>
			
			<br>
				
			<input type="submit" value="Enregistrer" name="btnEnregistrer" /> 
			<input type="submit" value="Supprimer mon compte" name="btnSupprim"/> 
			
		</form>
		${message}
	</div>
</body>
</html>
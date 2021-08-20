<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mon profil</title>
</head>
<body>	
	<div>
		<a href="<%=request.getContextPath()%>/AccueilServlet"><img width="100px"
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxfwbzRR2jK66N7Dn3do6cTGmGGwZjfrJAT9Epoz9unIPxGNGu5aVyeQ-KCJn54C068r4&usqp=CAU"></a>
	</div>

	<div>
		<ul style ="list-style-type:none">
			<li>Pseudo: ${user.pseudo}</li>
			<li>Nom: ${user.nom}</li>
			<li>Prénom: ${user.prenom}</li>
			<li>Email: ${user.email}</li>
			<li>Téléphone: ${user.telephone}</li>
			<li>Rue: ${user.rue}</li>
			<li>Code Postal: ${user.code_postal}</li>
			<li>Ville: ${user.ville}</li>
		</ul>
		<input type="submit" value="Modifier" name="btnModifier" />
	</div>
</body>
</html>
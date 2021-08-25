<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<title>Profil</title>
</head>
<body>	
	<div>
		<a href="<%=request.getContextPath()%>/AccueilServlet"><img width="100px"
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxfwbzRR2jK66N7Dn3do6cTGmGGwZjfrJAT9Epoz9unIPxGNGu5aVyeQ-KCJn54C068r4&usqp=CAU"></a>
	</div>

	<div>
		<ul style ="list-style-type:none">
			<li>Pseudo : ${u.pseudo}</li>
			<li>Nom : ${u.nom}</li>
			<li>Prénom : ${u.prenom}</li>
			<li>Email : ${u.email}</li>
			<li>Téléphone : ${u.telephone}</li>
			<li>Rue : ${u.rue}</li>
			<li>Code Postal : ${u.code_postal}</li>
			<li>Ville : ${u.ville}</li>
		</ul>
		
	</div>
</body>
</html>
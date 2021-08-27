<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link type="text/css" rel="stylesheet" href="style.css" />

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dosis:wght@200&display=swap" rel="stylesheet">

<style type="text/css">
label {
display:inline-block;
width : 70px;
}
</style>
<title>Mon profil</title>
</head>
<body>	
	<div class="container">
	<div class="row">
	<div class="col-lg-3 offset-1 col-sm-4 offset-1">
		<a href="<%=request.getContextPath()%>/AccueilServlet"><img class="transparent" width="100px" src="img/marteaulogo.png" alt="logo marteau du site"></a>
	</div>
	</div>
	</div>

	<div class="container">
	<div class="row">
	<div class="col-lg-6 offset-3 col-sm-12">
		<ul style ="list-style-type:none">
			<li><b>Pseudo: ${user.pseudo}</b></li>
			<li>Nom: ${user.nom}</li>
			<li>Prénom: ${user.prenom}</li>
			<li>Email: ${user.email}</li>
			<li>Téléphone: ${user.telephone}</li>
			<li>Rue: ${user.rue}</li>
			<li>Code Postal: ${user.code_postal}</li>
			<li>Ville: ${user.ville}</li>
			<li>Crédit: ${user.credit}</li>
		</ul>
		<div class="row">
		<div class="col-lg-6 offset-2 col-sm-12">
		<form action="MonProfilServlet" method="POST">
			<input type="submit" value="Modifier" name="btnModifier"/>
		</form>
		</div>
	</div>
	</div>
	</div>
	</div>
</body>
</html>
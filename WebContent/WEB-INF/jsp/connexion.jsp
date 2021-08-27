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

<title>Connexion</title>
</head>

<body>
	<div class="container">
	<div class="row">
	<div class="col-lg-2 offset-2 col-sm-4 offset-1">
		<a href="<%=request.getContextPath()%>/AccueilServlet"><img class="transparent" width="100px" src="img/marteaulogo.png" alt="logo marteau du site"></a>
	</div>
	</div>
	</div>
	
	
	<div class="container">
		<form action="ConnexionServlet" method="POST">
		<div class="row">
		<div class="col-lg-6 offset-lg-3 col-sm-12">	
			<label class="text-nowrap">Identifiant:</label>
			<input class="form-control" type="text" name="identifiant" value="${param.identifiant}" size="20" maxlength="20" /> 
			</div>
			</div>	
		<div class="row">
		<div class="col-lg-6 offset-lg-3 col-sm-12">	
			<label class="text-nowrap">Mot de passe: </label> 
			<input class="form-control" type="password" name="mot_de_passe" value="" size="20" maxlength="20" /> 
			<br>
		</div>
		</div>
				
		<div class="row">
		<div class="col-lg-6 offset-lg-3 col-sm-12">	
			<input class="form-control" type="submit" value="Connexion" name="btnConnexion" />
			<input type="checkbox" name="souvenir" id="souvenir" /><label class="text-nowrap"> Se souvenir de moi</label><br> 
			<a href="#">Mot de passe oublié</a>
		 </div>
		 </div>
		 

		</form>
		
		<div class="col-lg-6 offset-lg-3 col-sm-12">
		<form method="post" action="ConnexionServlet">
			<input class="form-control" type="submit" value="Créer un compte" name="btnCreerCompte" />
		</form>
		<br> 
		<p class="erreur">${message}</p>
		</div>
		</div>
</body>
</html>
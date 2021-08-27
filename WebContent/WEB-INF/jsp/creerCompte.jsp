<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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

<title>Creer compte</title>
</head>

<body>

	<div class="justify-content-lg-start justify-content-sm-center">
		<a href="<%=request.getContextPath()%>/AccueilServlet"><img class="transparent" width="100px" src="img/marteaulogo.png" alt="logo marteau du site"></a>
	</div>
	
	<div class="container">
	
		<form method="post" action="CreerCompteServlet">
		
			<h1 class="titre">Créez votre compte</h1>
		
		
		<div class="form-group row">
        <div class="col-lg-6 col-sm-12"> 	
			<label class="text-nowrap">Pseudo: </label>
			<input class="form-control" type="text" name="pseudo" placeholder="Ex : Jojo44" value="${param.pseudo}" size="20" maxlength="20" /> 
		</div>
		 <div class="col-lg-6 col-sm-12">	
			<label class="text-nowrap">Nom:</label> 
			<input class="form-control" type="text" name="nom" value="${param.nom}" size="20" maxlength="20" />
		</div>
		</div>		

		<div class="form-group row">
        <div class="col-lg-6 col-sm-12">
			<label class="text-nowrap">Prénom:</label> 
			<input class="form-control" type="text" name="prenom" value="${param.prenom}" size="20" maxlength="20" /> 
		</div>
		<div class="col-lg-6 col-sm-12">	
			<label class="text-nowrap">Email:</label> 
			<input class="form-control" type="email" name="email" value="${param.email}" size="20" maxlength="60" /> 
		</div>
		</div>	
			
		<div class="form-group row">
        <div class="col-lg-6 col-sm-12">	
			<label class="text-nowrap">Téléphone: </label> 
			<input class="form-control" type="tel" name="telephone" value="${param.telephone}" size="20" maxlength="20" /> 
		</div>
		<div class="col-lg-6 col-sm-12">	
			<label class="text-nowrap">Rue:</label> 
			<input class="form-control" type="text" name="rue" value="${param.rue}" size="20" maxlength="20" />	
		</div>
		</div>
		
		<div class="form-group row">
        <div class="col-lg-6 col-sm-12">
			<label class="text-nowrap">Code postal: </label> 
			<input class="form-control" type="text"  name="code_postal" value="${param.code_postal}" size="20" maxlength="20" />
		</div>
		<div class="col-lg-6 col-sm-12">		 
			<label class="text-nowrap">Ville: </label>
			<input class="form-control" type="text" name="ville" value="${param.ville}" size="20" maxlength="20" /> 
		</div>
		</div>		
		
		<div class="form-group row">
        <div class="col-lg-6 col-sm-12">	
			<label class="text-nowrap">Mot de passe:</label>
			<input class="form-control" type="password" name="mot_de_passe" value="" size="20" maxlength="20" /> 
		</div>		
		<div class="col-lg-6 col-sm-12">		
			<label class="text-nowrap">Confirmation: </label> 
			<input class="form-control" type="password" name="confirmation" value="" size="20" maxlength="20" /> 
		</div>
		</div>		

		<div class="form-group row">
        <div class="col-lg-6 offset-3 col-sm-12">				
			<input class="form-control" type="submit" value="Créer" name="btnCreer" /> 
			<input class="form-control" type="reset" value="Annuler" /> 
		</div>
		</div>	
		</form>
		</div>
		
		
		<div class = "erreur">
			<ul>
			<c:if test="${not empty erreurs}">
	
				<c:forEach items="${erreurs}" var="e">
					<li>${e}</li>
				</c:forEach>

			</c:if>
			<c:if test="${not empty message}">
				
					<li>${message}</li>
				
			</c:if>
			</ul> 
		</div>
</body>
</html>
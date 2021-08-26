
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<!-- <meta charset="ISO-8859-1"> -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Modifier profil</title>

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


</head>

<body>
	<div>
		<a href="<%=request.getContextPath()%>/AccueilServlet"><img class="transparent" width="100px" src="img/marteaulogo.png" alt="logo marteau du site"></a>
	</div>
	
	<div class="container">
		<form method="POST" action="ModifierProfilServlet">
		<div class="row">
		<div class="text-center">
			<h1>Mon profil</h1>
        </div>
        </div>
        
        <div class="form-group row">
        <div class="col-lg-6 col-sm-12">
			<label>Pseudo: </label>
			<input class="form-control" type="text" name="pseudo" value="${user.pseudo}"   /> 
		</div>
		<div class="col-lg-6 col-sm-12">		
			<label>Nom:</label> 
			<input class="form-control" type="text" name="nom" value="${user.nom}"  maxlength="20" /> 
		</div>
        </div>
			 
		<div class="form-group row">
		<div class="col-lg-6 col-sm-12">
			<label class=>Prénom:</label> 
			<input class="form-control" type="text" name="prenom" value="${user.prenom}"  maxlength="20" /> 
		</div>
		<div class="col-lg-6 col-sm-12">	
			<label>Email:</label> 
			<input class="form-control" type="email" name="email" value="${user.email}"  maxlength="60" /> 
		</div>
        </div>	
			
		<div class="form-group row">
        <div class="col-lg-6 col-sm-12"> 		
			<label >Téléphone: </label>
		
			<input class="form-control" type="tel" name="telephone" value="${user.telephone}"  maxlength="20" /> 
		</div>
		<div class="col-lg-6 col-sm-12">		
			<label>Rue:</label> 
			<input class="form-control" type="text" name="rue" value="${user.rue}"  maxlength="20" /> 
		</div>
        </div>	

		<div class="form-group row">
        <div class="col-lg-6 col-sm-12">  	
			<label class="text-nowrap">Code postal: </label> 
			<input class="form-control" type="text"  name="code_postal" value="${user.code_postal}"  maxlength="20" />
		</div>
		<div class="col-lg-6 col-sm-12">	
			<label >Ville: </label>
			<input class="form-control" type="text" name="ville" value="${user.ville}"  maxlength="20" /> 
		</div>
        </div>		
			
		<div class="form-group row">
        <div class="col-lg-6 col-sm-12">	
			<label class="text-nowrap" >Mot de passe actuel:</label>
			<input class="form-control" type="password" name="mot_de_passe_actu"  maxlength="20" />
        </div>
        </div>
		<div class="form-group row">
        <div class="col-lg-6 col-sm-12">	
			<label class="text-nowrap">Nouveau mot de passe:</label>
			<input class="form-control" type="password" name="new_mot_de_passe"  maxlength="20" /> 
		</div>
		<div class="col-lg-6 col-sm-12">		
			<label >Confirmation: </label> 
			<input class="form-control" type="password" name="confirmation"  maxlength="20" /> 
		</div>
        </div>
		<div class="form-group row">
       <div class="col-lg-6 col-sm-12">
			<p>Crédit: ${user.credit}</p>
		</div>
        </div>
			
			<br>
		<div class="form-group row">
        <div class="col-lg-4 offset-lg-4 col-sm-6">		
			<input type="submit" value="Enregistrer" name="btnEnregistrer" /> 
			<input type="submit" value="Supprimer mon compte" name="btnSupprim"/> 
		</div>
        </div>	
		</form>
		<c:if test="${not empty erreurs }">
		<div class = "erreur">
			Il existe des erreurs :
			<ul>
				<c:forEach items="${erreurs}" var="e">
					<li>${e }</li>
				</c:forEach>
			</ul>
		</div>
		</c:if>
		<c:if test="${not empty message}">
		<div class = "erreur">
			Il existe une erreur sur le changement de mot de passe :
			<ul>
				<li>${message}</li>
			</ul>
		</div>
		</c:if>
	</div> 
</body>
</html>
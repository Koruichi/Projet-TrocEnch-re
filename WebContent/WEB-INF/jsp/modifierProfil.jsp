<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- <meta charset="ISO-8859-1"> -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Modifier profil</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link type="text/css" rel="stylesheet" href="/style.css" />
</head>
<body>
	<div>
		<a href="<%=request.getContextPath()%>/AccueilServlet"><img width="100px"
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxfwbzRR2jK66N7Dn3do6cTGmGGwZjfrJAT9Epoz9unIPxGNGu5aVyeQ-KCJn54C068r4&usqp=CAU"></a>
	</div>
	
	<div class="container-fluid">
		<form method="POST" action="ModifierProfilServlet">
		<div class="row">
		<div class="col-lg-6">
			<h1>Mon profil</h1>
        </div>
        </div>
        
        <div class="row">
        <div class="col-lg-6 col-lg-6">
			<label >Pseudo: </label>
			<input type="text" name="pseudo" value="${user.pseudo}" size="20" maxlength="20" /> 
		</div>
        </div>
		<div class="row">
        <div class="col-lg-6 col-sm-12">		
			<label >Nom:</label> 
			<input type="text" name="nom" value="${user.nom}" size="20" maxlength="20" /> 
		</div>
        </div>
			<br> 
		<div class="row">
        <div class="col-lg-6 col-sm-12">
			<label >Prénom:</label> 
			<input type="text" name="prenom" value="${user.prenom}" size="20" maxlength="20" /> 
		</div>
        </div>
		<div class="row">
        <div class="col-lg-6 col-sm-12">	
			<label >Email:</label> 
			<input type="email" name="email" value="${user.email}" size="20" maxlength="60" /> 
		</div>
        </div>	
			<br> 
		<div class="row">
        <div class="col-lg-6 col-sm-12">		
			<label >Téléphone: </label> 
			<input type="tel" name="telephone" value="${user.telephone}" size="20" maxlength="20" /> 
		</div>
        </div>
		<div class="row">
        <div class="col-lg-6 col-sm-12">		
			<label>Rue:</label> 
			<input type="text" name="rue" value="${user.rue}" size="20" maxlength="20" /> 
		</div>
        </div>	
			<br> 
		<div class="row">
        <div class="col-lg-6 col-sm-12">	
			<label >Code postal: </label> 
			<input type="text"  name="code_postal" value="${user.code_postal}" size="20" maxlength="20" />
		</div>
        </div>
		<div class="row">
        <div class="col-lg-6 col-sm-12">	
			<label >Ville: </label>
			<input type="text" name="ville" value="${user.ville}" size="20" maxlength="20" /> 
		</div>
        </div>		
			<br> 
		<div class="row">
        <div class="col-lg-6 col-sm-12">	
			<label >Mot de passe actuel:</label>
			<input type="password" name="mot_de_passe_actu" size="20" maxlength="20" />
        </div>
        </div>
			<br>
		<div class="row">
        <div class="col-lg-6 col-sm-12">	
			<label >Nouveau mot de passe:</label>
			<input type="password" name="new_mot_de_passe" size="20" maxlength="20" /> 
		</div>
        </div> 
		<div class="row">
        <div class="col-lg-6 col-sm-12">		
			<label >Confirmation: </label> 
			<input type="password" name="confirmation" size="20" maxlength="20" /> 
		</div>
        </div>
			<br>
		<div class="row">
        <div class="col-lg-6 col-sm-12">
			<p>Crédit: ${user.credit}</p>
		</div>
        </div>
			
			<br>
		<div class="row">
        <div class="col-lg-6 col-sm-12">		
			<input type="submit" value="Enregistrer" name="btnEnregistrer" /> 
			<input type="submit" value="Supprimer mon compte" name="btnSupprim"/> 
		</div>
        </div>	
		</form>
		<c:if test="${not empty erreurs }">
		<div class = "error">
			Il existe des erreurs :
			<ul>
				<c:forEach items="${erreurs}" var="e">
					<li>${e }</li>
				</c:forEach>
			</ul>
		</div>
		</c:if>
		${message}
	</div> 
</body>
</html>
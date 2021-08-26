<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link type="text/css" rel="stylesheet" href="style.css" />

<title>Nouvelle Vente</title>

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

<div class="container">
	<div class="row">
	<div class="justify-content-lg-start justify-content-sm-center">
	<div>
		<a href="<%=request.getContextPath()%>/AccueilServlet"><img width="100px"
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxfwbzRR2jK66N7Dn3do6cTGmGGwZjfrJAT9Epoz9unIPxGNGu5aVyeQ-KCJn54C068r4&usqp=CAU"></a>
	</div>
	</div>
	</div>
	<div class="row">
	<div class="text-center">
	<h1>Nouvelle vente</h1>
	</div>
	</div>
</div>	
<div class="container">
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
</div>	

<form method="POST" action="VendreUnArticleServlet" enctype="multipart/form-data">
<div class="container">
	<div class="row">
	<div class="col-lg-6 offset-3 col-sm-12">
		<label class="text-nowrap" for="nom_article">Article : </label> 
		<input class="form-control" type="text"id="nom_article" name="nom_article" value=""  maxlength="100" />
	</div>
	</div>	
	<div class="row">
	<div class="col-lg-6 offset-3 col-sm-12">
		<label class="text-nowrap" for="description">Description : </label> 
		<input class="form-control" type="textare" id="description" name="description" value=""  maxlength="200" />
		<br>
	</div>
	</div>	
	<div class="row">
	<div class="col-lg-6 offset-3 col-sm-12">

		<label class="text-nowrap" for="categorie">Catégorie : </label> 
				<select name="no_categorie" id="categorie">
					<option value=0>Choisissez une categorie</option>
					<option value=1>Informatique</option>
					<option value=2>Ameublement</option>
					<option value=3>Vêtement</option>
					<option value=4>Sport & Loisirs</option>
				</select>
				
	</div>
	</div>
	

<!-- 		<form action="/action_page.php">
 			 <label for="img">Photo de l'article:</label>
  			<input type="file" id="img" name="img" accept="image/*">
  			<input type="submit">
		</form>	 -->	
	<div class="row">
	<div class="col-lg-6 offset-3 col-sm-12">	
		<label class="text-nowrap" for="prix">Mise à prix:</label>
    	<input class="form-control" type="number"  name="prix_initial">
    </div>
	</div>
			
    <div class="row">
	<div class="col-lg-6 offset-3 col-sm-12">		
    	<label class="text-nowrap" for="start">Début de l'enchère:</label>
		<input class="form-control" class="form-control" type="date"  name="date_debut_enchere">
	</div>
	</div>
			
    <div class="row">
	<div class="col-lg-6 offset-3 col-sm-12">  			 
      	<label class="text-nowrap">Fin de l'enchère:</label>
		<input class="form-control" type="date" name="date_fin_enchere">
	</div>
	</div>
		
	<div class="row">
	<div class="col-lg-6 offset-3 col-sm-12">
		<label class="text-nowrap" for="Rue">Rue : </label> 
		<input class="form-control" type="text" id="rue" name="rue" value="${user.rue}"  maxlength="100" />
	</div>
	</div>
			
	<div class="row">
	<div class="col-lg-6 offset-3 col-sm-12">
		<label class="text-nowrap" for="code_postal">Code postal : </label> 
		<input class="form-control" type="text" id="code_postal" name="code_postal" value="${user.code_postal}" maxlength="100" />
	</div>
	</div>
		
	<div class="row">
	<div class="col-lg-6 offset-3 col-sm-12">
		<label class="text-nowrap" for="ville">Ville : </label> 
		<input class="form-control" type="text" id="ville" name="ville" value="${user.ville}"  maxlength="100" />
	</div>
	</div>
	<br>
		
	<div class="row">
	<div class="col-lg-6 offset-3 col-sm-12">	
		<input type="submit" value="Enregistrer" name="btnRec" /> 
		<input type="reset" value="Annuler" /> 
	</div>
	</div>
	</div>
	</form>
		

</body>
</html>
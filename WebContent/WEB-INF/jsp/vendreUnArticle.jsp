<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Vendre un article</title>

</head>

<body>
	<div>
		<a href="<%=request.getContextPath()%>/AccueilServlet"><img width="100px"
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxfwbzRR2jK66N7Dn3do6cTGmGGwZjfrJAT9Epoz9unIPxGNGu5aVyeQ-KCJn54C068r4&usqp=CAU"></a>
		
		<h1>Nouvelle vente</h1>
	</div>
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
	<div>
	 <form method="POST" action="VendreUnArticleServlet">
		<label for="nom_article">Article : </label> <input type="text"
			id="nom_article" name="nom_article" value="" size="20" maxlength="100" />
		<br>
		
		<label for="description">Description : </label> <input type="text"
			id="description" name="description" value="" size="80" maxlength="200" />
		<br>
		
		<label for="categorie">Cat�gorie : </label><br /> 
				<select name="no_categorie" id="categorie">
					<option value=0>Choisissez une categorie</option>
					<option value=1>Informatique</option>
					<option value=2>Ameublement</option>
					<option value=3>V�tement</option>
					<option value=4>Sport & Loisirs</option>
				</select>
				<br/>
	

<!-- 		<form action="/action_page.php">
 			 <label for="img">Photo de l'article:</label>
  			<input type="file" id="img" name="img" accept="image/*">
  			<input type="submit">
		</form>	 -->	
		<br>
		
		<label for="prix">Mise � prix:</label>
    		<input type="number"  name="prix_initial">
    	<br>
    		
    	<label for="start">D�but de l'ench�re:</label>
			<input type="date"  name="date_debut_enchere">
      	<br>
      			 
      	<label for="start">Fin de l'ench�re:</label>
			<input type="date" name="date_fin_enchere">
		<br>
		
		<label for="Rue">Rue : </label> <input type="text"
			id="rue" name="rue" value="${user.rue}" size="20" maxlength="100" />
			
		<br>
		
		<label for="code_postal">Code postal : </label> <input type="text"
			id="code_postal" name="code_postal" value="${user.code_postal}" size="20" maxlength="100" />
		<br>
		
		<label for="ville">Ville : </label> <input type="text"
			id="ville" name="ville" value="${user.ville}" size="20" maxlength="100" />
		
		<br>
		
		<input type="submit" value="Enregistrer" name="btnRec" /> 
		<input type="reset" value="Annuler" /> 
	
	</form>
</div>


</body>
</html>
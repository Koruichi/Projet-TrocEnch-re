<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Encherir</title>
</head>
<body>
<div>
		<a href="<%=request.getContextPath()%>/AccueilServlet"><img width="100px"
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxfwbzRR2jK66N7Dn3do6cTGmGGwZjfrJAT9Epoz9unIPxGNGu5aVyeQ-KCJn54C068r4&usqp=CAU"></a>
		
		<h1>Detail vente</h1>
	</div>
	<div>
	<img alt="" src="">
	</div>
	<div>
	<form action="EnchereServlet" method="POST">

	<label for="description">Description : </label> 
	<textarea id="description" name="description" rows="" cols=""></textarea>
	
		<br>
			
    <label for="categorie">Categorie:</label>
      	<br>
      	
    <label for="meilleur_offre">Meilleur offre:</label>
    		<input type="number"  name="meilleur_offre">
    	<br>  	

	<label for="prix">Mise � prix:</label>
    	<br>
    	
      			 
      	<label for="start">Fin de l'ench�re:</label>
		<br>
		
		<label for="retrait">Retrait : </label>
		<br>
		
		<label for="vendeur">Vendeur : </label>
		<br>
		<label for="proposition">Ma proposition : </label>
			 <input type="number" name="proposition"  />		
		<br>
		
		<input type="submit" value="Encherir" name="btnEncherir"/>   
	
	<input type = "hidden" name= "idArticle"/>
	</form>
</div>
</body>
</html>
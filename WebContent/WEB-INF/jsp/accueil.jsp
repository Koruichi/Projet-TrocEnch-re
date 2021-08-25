<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link type="text/css" rel="stylesheet" href="style.css" />
<title>Accueil - ENI Ench�re</title>
</head>
<body >
<%-- <c:set var="context" value="${pageContext.request.contextPath}/Images/logo-encheres.jpg"/>
	<img src="${context}" border="0"/>
	<img src="<%=request.getContextPath()%>/Images/logo-encheres.jpg">  --%>
	<div>
		<img width="100px"
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxfwbzRR2jK66N7Dn3do6cTGmGGwZjfrJAT9Epoz9unIPxGNGu5aVyeQ-KCJn54C068r4&usqp=CAU">
		
		<c:if test="${user == null}">
		<a href="/Projet-TrocEnchere/ConnexionServlet">S'inscrire - Se connecter</a>
		</c:if>
		
		<c:if test="${user != null}">
		<a href="/Projet-TrocEnchere/EnchereNonCommenceeServlet">Ench�res</a> 
		<a href="/Projet-TrocEnchere/VendreUnArticleServlet">Vendre un article</a> 
		<a href="/Projet-TrocEnchere/MonProfilServlet">Mon profil</a> 
		<a name="btnDeco" href="/Projet-TrocEnchere/DeconnexionServlet">D�connexion</a>
		<p>Bienvenue  ${user.prenom} ${user.nom}</p>
		</c:if>
		
	</div>
	<h1>Liste des ench�res</h1>
	<div>
		<form method="POST">
			<label for="articleRecherche">Filtres :</label> 
			<input type="search" id="site-search" name="motRecherche" aria-label="Recherche Article">

			<p>
				<label for="categorie">Cat�gorie : </label><br /> <select
					name="categorie" id="categorie">
					<option value="toutes">Toutes</option>
					<option value="informatique">Informatique</option>
					<option value="ameublement">Ameublement</option>
					<option value="vetement">V�tement</option>
					<option value="sportLoisirs">Sport & Loisirs</option>
				</select>
			</p>

			<button type="submit" name="btnRecherche">Rechercher</button>

		<c:if test="${user != null}">
		<div>
 			<input type="radio" name="choixSearch" value="achats" checked>
  			<label>Achats</label><br>

 			<input type="checkbox" name="achatOuvert">
			<label>ench�res ouvertes</label><br>
			<input type="checkbox" name="achatEnCours">
			<label>mes ench�res en cours</label><br>
			<input type="checkbox" name="achatRemporte">
			<label>mes ench�res remport�es</label><br>
		</div>

		<div>
  			<input type="radio" name="choixSearch" value="ventes">
  			<label>Mes ventes</label><br>
  			
  			<input type="checkbox" name="venteEnCours">
			<label>mes ventes en cours</label><br>
			<input type="checkbox" name="venteNoStart">
			<label>ventes non d�but�es</label><br>
			<input type="checkbox" name="venteTermine">
			<label>ventes termin�es</label><br>
		</div>
		</c:if>

	
		 
		
		<c:forEach items="${lst}" var="art" begin="1" end="4">
			<div>
				<img alt="" src="">
				<h3><a href = "/Projet-TrocEnchere/EnchereServlet"> ${art.nom_article}</a></h3>
				<p>Prix : ${art.prix_vente}</p>
				<p>Fin de l'ench�re :${art.date_fin_enchere}</p>
				<c:if test="${user == null}">
				<p>Vendeur : ${art.pseudo}</p>
				</c:if>
				<c:if test="${user != null}">
				<p>Vendeur :<a href="/WEB-INF/jsp/profil.jsp"> ${art.pseudo}</a></p>
				</c:if>
			</div>
		</c:forEach>
	</div>
	
	
</body>
</html>
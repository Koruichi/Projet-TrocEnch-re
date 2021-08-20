<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil - ENI Enchère</title>
</head>
<body>
<%-- <c:set var="context" value="${pageContext.request.contextPath}/Images/logo-encheres.jpg"/>
	<img src="${context}" border="0"/>
	<img src="<%=request.getContextPath()%>/Images/logo-encheres.jpg">  --%>
	<div>
		<a href="<%=request.getContextPath()%>/AccueilServlet"><img width="100px"
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxfwbzRR2jK66N7Dn3do6cTGmGGwZjfrJAT9Epoz9unIPxGNGu5aVyeQ-KCJn54C068r4&usqp=CAU"></a>
		
		<c:if test="${user == null}">
		<a href="/Projet-TrocEnchere/ConnexionServlet">S'inscrire - Se connecter</a>
		</c:if>
		
		<c:if test="${user != null}">
		<a href="/Projet-TrocEnchere/EnchereNonCommenceeServlet">Enchères</a> 
		<a href="/Projet-TrocEnchere/VendreUnArticleServlet">Vendre un article</a> 
		<a href="/Projet-TrocEnchere/MonProfilServlet">Mon profil</a> 
		<a name="btnDeco" href="/Projet-TrocEnchere/DeconnexionServlet">Déconnexion</a>
		<p>Bienvenue  ${user.prenom} ${user.nom}</p>
		</c:if>
		
	</div>
	<h1>Liste des enchères</h1>
	<div>
		<form method="POST">
			<label for="articleRecherche">Filtres :</label> <input type="search"
				id="site-search" name="q" aria-label="Recherche Article">

			<p>
				<label for="categorie">Catégorie : </label><br /> <select
					name="categorie" id="categorie">
					<option value="toutes">Toutes</option>
					<option value="informatique">Informatique</option>
					<option value="ameublement">Ameublement</option>
					<option value="vetement">Vêtement</option>
					<option value="sportLoisirs">Sport & Loisirs</option>
				</select>
			</p>

			<button>Rechercher</button>

		<c:if test="${user != null}">
		<div>
 			<input type="radio" name="choixSearch" value="achats" checked>
  			<label>Achats</label><br>

 			<input type="checkbox" name="achatOuvert">
			<label>enchères ouvertes</label><br>
			<input type="checkbox" name="achatEnCours">
			<label>mes enchères en cours</label><br>
			<input type="checkbox" name="achatRemporte">
			<label>mes enchères remportées</label><br>
		</div>

		<div>
  			<input type="radio" name="choixSearch" value="ventes">
  			<label>Mes ventes</label><br>
  			
  			<input type="checkbox" name="venteEnCours">
			<label>mes ventes en cours</label><br>
			<input type="checkbox" name="venteNoStart">
			<label>ventes non débutées</label><br>
			<input type="checkbox" name="venteTermine">
			<label>ventes terminées</label><br>
		</div>
		</c:if>

		</form>
		<c:forEach items="${model.lstArticles}" var="art">
			<div>
				<img alt="" src="">
				<h3>${art.art.nom_article}</h3>
				<p>Prix : ${art.prix_vente}</p>
				<p>Fin de l'enchère :${art.date_fin_enchere}</p>
				<p>Vendeur : ${art.utilisateur.pseudo}</p>
			</div>
		</c:forEach>
	</div>
</body>
</html>
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

<title>Accueil - ENI Enchère</title>
</head>

<body >

<div class="container">
<div class="row">
	<div class="col-lg-4 col-sm-6">
		<a href="<%=request.getContextPath()%>/AccueilServlet"><img width="100px"
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxfwbzRR2jK66N7Dn3do6cTGmGGwZjfrJAT9Epoz9unIPxGNGu5aVyeQ-KCJn54C068r4&usqp=CAU"></a>
	</div>
	
	<div class="col-lg-4 offset-4 col-sm-6">
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
</div>		
</div>
	
	<div class="container">
	<div class="text-center">
		<h1>Liste des enchères</h1>
	</div>
	</div>
	
	<form method="POST" action="AccueilServlet">
	<div class="container">
	<div class="row">
	<div class="col-lg-6 col-sm-12">
			<label class="text-nowrap" for="articleRecherche">Filtres :</label> 
			<input class="form-control" type="search" placeholder="Le nom de l'article contient" name="motRecherche" aria-label="Recherche Article"><br>
	
			<p>

				<label class="text-nowrap" for="categorie">Catégorie : </label>
				 <select name="categorie" id="categorie">
					<option selected value=0>Choisi une categorie</option>
					<c:forEach items="${list}" var="cat">
						<option value=${cat.no_categorie }>${cat.libelle}</option>
					</c:forEach>
				</select>
			</p>
			
			
	</div>
	</div>
	
	
	<div class="row">
		<c:if test="${user != null}">
		<div class="col-lg-3 col-sm-10">
 			<input type="radio" name="choixSearch" value="achats" checked>
  			<label class="text-nowrap">Achats</label><br>
 			<input type="checkbox" name="achatOuvert">
			<label class="text-nowrap">enchères ouvertes</label><br>
			<input type="checkbox" name="achatEnCours">
			<label class="text-nowrap">mes enchères en cours</label><br>
			<input type="checkbox" name="achatRemporte">
			<label class="text-nowrap">mes enchères remportées</label><br>
		</div>

		<div class="col-lg-3 col-sm-10 ">
  			<input type="radio" name="choixSearch" value="ventes">
  			<label class="text-nowrap">Mes ventes</label><br>
  			<input type="checkbox" name="venteEnCours">
			<label class="text-nowrap">mes ventes en cours</label><br>
			<input type="checkbox" name="venteNoStart">
			<label class="text-nowrap">ventes non débutées</label><br>
			<input type="checkbox" name="venteTermine">
			<label class="text-nowrap">ventes terminées</label><br>
		</div>
		</c:if>
	</div>
		
		<div class="row"></div>
		<div class="col-lg-4 offset-8  col-sm-12"></div>
		<button type="submit" name="btnRecherche">Rechercher</button>
	</div>
</form>
		 
	
		<div class="row">
		<div class="col-lg-6 col-sm-12">
		<div class="card">
		<c:forEach items="${lst}" var="art" begin="1" end="4">
			<div>
				<img class="card-img-left" alt="" src="">
				<div class="card-body">
				<h3 class="card-title"><a href = "/Projet-TrocEnchere/EnchereServlet" class="btn btn-primary"> ${art.nom_article}</a></h3>
				<p>Prix : ${art.prix_vente}</p>
				<p>Fin de l'enchère :${art.date_fin_enchere}</p>
				<c:if test="${user == null}">
				<p>Vendeur : ${art.pseudo}</p>
				</c:if>
				<c:if test="${user != null}">
				<p>Vendeur :<a href="ProfilServlet?id=${art.no_utilisateur }"> ${art.pseudo}</a></p>
				</c:if>
			</div>
			</div>
		</c:forEach>
		</div>
		</div>
	</div>
	
</body>
</html>
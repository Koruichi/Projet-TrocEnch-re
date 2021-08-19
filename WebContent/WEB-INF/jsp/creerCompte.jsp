<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Creer compte</title>
<link type="text/css" rel="stylesheet" href="style.css"/>

</head>

<body>
<div><img alt="" src="">Eni-Enchères</div>
        <div>
            <form method="post" action="CreerCompteServlet">
                    <h1>Mon profil</h1>
    
   					 <label for="nomClient">Pseudo: <span class="requis">*</span></label>
                    <input type="text" id="pseudo" name="pseudo" placeholder="Ex : Jojo44" value="" size="20" maxlength="20" />
                    <br />
                    
                     <label for="prenom">Prénom: <span class="requis">*</span></label>
                    <input type="text" id="prenom" name="prenom" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="nom">Nom: <span class="requis">*</span></label>
                    <input type="text" id="nom" name="nom" value="" size="20" maxlength="20" />
                    <br />
                    
                     <label for="telephone">Téléphone: <span class="requis">*</span></label>
                    <input type="tel" id="telephone" name="telephone" value="" size="20" maxlength="20" />
                    <br />
                   
                    <label for="codePostale">Code postal: <span class="requis">*</span></label>
                    <input type="text" id="code_postal" name="code_postal" value="" size="20" maxlength="20" />
                    <br />
    
                    <label for="rue">Rue: <span class="requis">*</span></label>
                    <input type="text" id="rue" name="rue" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="email">Email: <span class="requis">*</span></label>
                    <input type="email" id="email" name="email" value="" size="20" maxlength="60" />
                    <br />
                    
                     <label for="ville">Ville: <span class="requis">*</span></label>
                    <input type="text" id="ville" name="ville" value="" size="20" maxlength="20" />
                    <br />
                    
                     <label for="mot_de_passe">Mot de passe: <span class="requis">*</span></label>
                    <input type="password" id="mot_de_passe" name="mot_de_passe" value="" size="20" maxlength="20" />
                    <br />
                    
                     <label for="confirmation">Confirmation: <span class="requis">*</span></label>
                    <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                    <br />

                <input type="submit" value="Créer" name="btnCreer" />
                <input type="reset" value="Annuler" /> <br />
            </form>
            ${message}
        </div>
</body>
</html>
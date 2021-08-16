<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier profil</title>
<link type="text/css" rel="stylesheet" href="style.css"/>

</head>
<body>
	<div><img alt="" src="">Eni-Enchères</div>

        <div>
            <form method="get" action=" ">
                    <h1>Mon profil</h1>
    
   					 <label for="nomClient">Pseudo: <span class="requis">*</span></label>
                    <input type="text" id="pseudo" name="pseudo" value="" size="20" maxlength="20" />
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
                    <input type="text" id="telephoneClient" name="telephoneClient" value="" size="20" maxlength="20" />
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
                    
                     <label for="rue">Mot de passe: <span class="requis">*</span></label>
                    <input type="password" id="mdp" name="mdp" value="" size="20" maxlength="20" />
                    <br />
                    
                     <label for="rue">Nouveau mot de passe: <span class="requis">*</span></label>
                    <input type="password" id="mdp" name="mdp" value="" size="20" maxlength="20" />
                    <br />
                    
                     <label for="rue">Confirmation: <span class="requis">*</span></label>
                    <input type="password" id="mdp" name="mdp" value="" size="20" maxlength="20" />
                    <br />
					<label>Crédit</label><br />
                <input type="submit" value="Enregistrer" name="btnEnregistrer"  />
                <input type="button" value="Supprimer mon compte" name="btnSupprimer"/> <br />
            </form>
        </div>
</body>
</html>
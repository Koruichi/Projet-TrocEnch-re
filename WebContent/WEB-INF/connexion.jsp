<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
<link type="text/css" rel="stylesheet" href="style.css"/>

</head>

<body>
	<div><img alt="" src="">Eni-Enchères</div>
        <div>
            <form method="get" action=" ">
    
   					 <label for="nomClient">Identifiant: </span></label>
                    <input type="text" id="pseudo" name="pseudo" value="" size="20" maxlength="20" />
                    <br />
                    
                     <label for="rue">Mot de passe: </label>
                    <input type="password" id="mdp" name="mdp" value="" size="20" maxlength="20" />
                    <br />
                    <input type="checkbox" name="souvenir" id="souvenir" /> <label for="souvenir">Se couvenir de moi</label><br />
                    <a href="#">Mot de passe oublié</a>

                <input type="submit" value="Connexion"  />
                <input type="submit" value="Créer un compte" /> <br />
            </form>
        </div>
    </body>
</html>
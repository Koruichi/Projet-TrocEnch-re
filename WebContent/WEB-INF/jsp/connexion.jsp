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
	<div><img alt="" src="">Eni-Ench�res</div>
        <div>
            <form action="ConnexionServlet" method="POST">
    
   					 <label for="identifiant">Identifiant:<span class="requis">*</span></label>
                    <input type="text" id="identifiant" name="identifiant" value="" size="20" maxlength="20" />
                    <br />
                    
                     <label for="mot_de_passe">Mot de passe: <span class="requis">*</span></label>
                    <input type="password" id="mot_de_passe" name="mot_de_passe" value="" size="20" maxlength="20" />
                    <br />
                    <input type="checkbox" name="souvenir" id="souvenir" /> <label for="souvenir">Se souvenir de moi</label><br />
                    <a href="#">Mot de passe oubli�</a>

                <input type="submit" value="Connexion" name= "btnConnexion"  />
                <input type="submit" value="Cr�er un compte" name="btnCreerCompte"/> <br />
            </form>
            ${message}
        </div>
    </body>
</html>
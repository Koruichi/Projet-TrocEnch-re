<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
</head>
<style type="text/css">

/* Général ------------------------------------------------------------------------------------- */

body, p, legend, label, input {
    font: normal 8pt verdana, helvetica, sans-serif;
}

/* Forms --------------------------------------------------------------------------------------- */
fieldset {
    padding: 10px;
    border: 1px #0568CD solid;
    margin: 10px;
}

legend {
    font-weight: bold;
    color: #0568CD;
}

form label {
    float: left;
    width: 200px;
    margin: 3px 0px 0px 0px;
}

form input {
    margin: 3px 3px 0px 0px;
    border: 1px #999 solid;
}

form input.sansLabel {
    margin-left: 200px;
}

/* Styles et couleurs -------------------------------------------------------------------------- */
.requis {
    color: #c00;
}

.erreur {
    color: #900;
}

.succes {
    color: #090;
}

.info {
    font-style: italic;
    color: #E8A22B;
}</style>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscrire Pilote</title>
<link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>

<body>


		<form method="Post" action="InscrirePilote">
			<fieldset>
				<legend>INSCRIRE PILOTE</legend>
					<label for="nom">Nom</label>
	                <input type="text" id="nom" name="nom" size="20" maxlength="20" value="${pilote.nom}" />
	                <br />
	                <label for="site">Site</label>
	                <input type="text" id="site" name="site" size="20"  value="${pilote.site}" />
	                <br/>
	                <input type="hidden" name="id_pilote" value='${pilote.id}'>
	                <input type="submit"  value="Envoyer" />    
	          </fieldset>
	     </form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/style.css" type="text/css" />
<title>Inscrire Pilote</title>
<style type="text/css">
<%@include file="css/style.css" %>
</style>
</head>
<body>
<%@include file="header.jsp" %>

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
 <%@include file="footer.jsp" %>
</body>
</html>
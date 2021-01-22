<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Byvol</title>
<link rel="stylesheet"  href="./css/style.css"/>
</head>
<body>

<table class="tableau-style">
 
 	<caption><h2>LISTE DES PILOTES PAR VOLS </h2></caption>
 	
 			<tr>
 			
 				<th class="titre">Nom</th>
 				<th class="titre">id_vol</th>
 				<th class="titre">id_avion</th>
 				<th class="titre">id_pilote</th>
 				<th class="titre">Site de Départ</th>
 				<th class="titre">Site d'arrive</th>
 				<th class="titre">Heure de départ</th>
 				<th class="titre">Heure d'arrive</th>
 				
 			</tr>
 			
 				<c:forEach var="vol" items="${lBVol}"> 
 				
 			<tr>
 				<TD><c:out value="${vol.nom_pilote}"></c:out></TD>
                <TD><c:out value="${vol.id_vol}"></c:out></TD>
                <td><c:out value="${vol.id_avion}"></c:out>
                <TD><c:out value="${vol.id_pilote}"></c:out></TD>
                <TD><c:out value="${vol.site_depart}"></c:out></TD>
                <td><c:out value="${vol.site_arrive}"></c:out></td>
                <td><c:out value="${vol.heure_depart}"></c:out></td>
                <td><c:out value="${vol.heure_arrivee}"></c:out></td>
     		</tr>
     		</c:forEach>


</body>
</html>
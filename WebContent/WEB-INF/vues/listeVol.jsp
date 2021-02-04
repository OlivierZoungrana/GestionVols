<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste Vol</title>
<style type="text/css">
<%@include file="css/style.css" %>
</style>
</head>
<body>
<%@include file="header.jsp" %>

<div class="btn">
 <a  href="#">Ajouter un vol</a>
</div>
<table class="tableau-style" border="1">

 
 	<caption><h2>LISTE DES VOLS </h2></caption>
 	
 			<tr>
 			
 				<th class="titre">Id_vol</th>
 				<th class="titre">id_Avion</th>
 				<th class="titre">id_pilote</th>
 				<th class ="titre">nom Pilote</th>
 				<th class="titre">site_depart</th>
 				<th class="titre">site_arrive</th>
 				<th class="titre">heure_depart</th>
 				<th class="titre">heure_arrive</th>
 				<th class="titre" id="action"colspan="2">ACTION</th>
 			</tr>
 			
 				<c:forEach var="vol" items="${Lvol}"> 
 				
 			<tr>
 				<TD><c:out value="${vol.id_vol}"></c:out></TD>
                <TD><c:out value="${vol.id_avion}"></c:out></TD>
                <td><c:out value="${vol.id_pilote}"></c:out></td>
                 <td><c:out value="${vol.nom_pilote}"></c:out></td>
                <TD><c:out value="${vol.site_depart}"></c:out></TD>
                <td><c:out value="${vol.site_arrive}"></c:out></td>
                <TD><c:out value="${vol.heure_depart}"></c:out></TD>
                <td><c:out value="${vol.heure_arrivee}"></c:out></td>
                
                
     			 <td>
               		<form action="ListerVol" method="post"> 
               			<input type="hidden" name="action" value="supprimer"/>
               			<input type="hidden" name="id_vol" value='${vol.id_vol}'/>
               			<input type="submit" value="supprimer"/>
               		</form>
            	</td>
            	
            	<td>
               		<form action="ListerVol" method="post"> 
               			<input type="hidden" name="action" value="modifier"/>
               			<input type="hidden" name="id_vol" value='${vol.id_vol}'/>
               			<input type="submit" value="modifier"/>
               		</form>
               </td>
               
         
             </tr>
             
            </c:forEach>
 
 </table>
 
 <%@include file="footer.jsp" %>


</body>
</html>
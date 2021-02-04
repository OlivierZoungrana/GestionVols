<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste AVION</title>
<style type="text/css">
<%@include file="css/style.css" %>
</style>
</head>

<body>
<%@include file="header.jsp" %>

<div class="btn">
 <a  href="/GestionVol/AjouterAvion">Ajouter un avion</a>
</div>
<table class="tableau-style" border="1">

 
 	<caption><h2>LISTE DES AVIONS </h2></caption>
 	
 			<tr>
 			
 				<th class="titre">Id</th>
 				<th class="titre">Constructeur</th>
 				<th class="titre">Model</th>
 				<th class="titre">Capacite</th>
 				<th class="titre">Site</th>
 				<th class="titre" id="action"colspan="2">ACTION</th>
 			</tr>
 			
 				<c:forEach var="avion" items="${Lavion}"> 
 				
 			<tr>
 				<TD><c:out value="${avion.id_avion}"></c:out></TD>
                <TD><c:out value="${avion.constructeur}"></c:out></TD>
                <td><c:out value="${avion.model}"></c:out></td>
                <TD><c:out value="${avion.capacite}"></c:out></TD>
                <td><c:out value="${avion.site}"></c:out></td>
                
     			 <td>
               		<form action="ListerAvion" method="post"> 
               			<input type="hidden" name="action" value="supprimer"/>
               			<input type="hidden" name="id_pilote" value='${avion.id_avion}'/>
               			<input type="submit" value="supprimer"/>
               		</form>
            	</td>
            	
            	<td>
               		<form action="ListerAvion" method="post"> 
               			<input type="hidden" name="action" value="modifier"/>
               			<input type="hidden" name="id_avion" value='${avion.id_avion}'/>
               			<input type="submit" value="modifier"/>
               		</form>
               </td>
               
         
             </tr>
             
            </c:forEach>
 
 </table>
 
 <%@include file="footer.jsp" %>

</body>
</html>
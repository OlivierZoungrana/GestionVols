<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pilote</title>
<link rel="stylesheet"  href="./css/style.css"/>
</head>
<body>
<table class="tableau-style" border="1">
 
 	<caption><h2>LISTE DES PILOTES </h2></caption>
 	
 			<tr>
 			
 				<th class="titre">Id</th>
 				<th class="titre"> NOM</th>
 				<th class="titre"> SITE </th>
 				<th class="titre" id="action"colspan="3">ACTION</th>
 			</tr>
 			
 				<c:forEach var="pilote" items="${Lpilote}"> 
 				
 			<tr>
 				<TD><c:out value="${pilote.id}"></c:out></TD>
                <TD><c:out value="${pilote.nom}"></c:out></TD>
                <td><c:out value="${pilote.site}"></c:out>
     			<td>
               		<form action="Listerpilote" method="post"> 
               			<input type="hidden" name="action" value="supprimer"/>
               			<input type="hidden" name="id_pilote" value='${Pilote.id}'/>
               			<input type="submit" value="supprimer"/>
               		</form>
            </td>
            <td>
               		<form action="Listerpilote" method="post"> 
               			<input type="hidden" name="action" value="modifier"/>
               			<input type="hidden" name="id_pilote" value='${Pilote.id}'/>
               			<input type="submit" value="modifier"/>
               		</form>
               </td>
               <td>
               		<form action="Listerpilote" method="post"> 
               			<input type="hidden" name="action" value="Afficher vol"/>
               			<input type="hidden" name="id_pilote" value='${Pilote.id}'/>
               			<input type="submit" value="Afficher vol"/>
               		</form>
               </td>
             </tr>
             
            </c:forEach>
 
 </table>

	

</body>
</html>
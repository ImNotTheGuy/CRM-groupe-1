<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des clients</title>
</head>
<body>
<c:import url="/WEB-INF/menu.jsp" />
<h2> LA LISTE DES CLIENTS</h2>
<div>
<c:choose>
	
		<c:when test="${empty listeClients}">
		<p> Aucun clients  </p>
		</c:when>
		<c:otherwise>
		<table >
				<tr>
					<th>companyName</th >
					<th>firstName</th >
				    <th>lastName</th >
		          
				</tr >  
			<c:forEach items="${ listeClients }" var="client" varStatus="boucle">

					<tr>

						<td><c:out value="${client.companyName}" /></td>
						<td><c:out value="${client.firstName}" /></td>
						<td><c:out value="${client.lastName}" /></td>
					
					<td><a href="<c:url value="/detailsClient" ><c:param name="id" value="${client.id }"/> </c:url>">Details</a></td>
					
					<td><a href="<c:url value="/supprimerClient" ><c:param name="id" value="${client.id }"/> </c:url>">Supprimer</a> </td>
					
					<td><a href="<c:url value="/modifierEtAjouterClient" ><c:param name="id" value="${client.id }"/> </c:url>">Modifier</a></td>
															
					</tr>
					
			</c:forEach>
			</table>	
			</c:otherwise>
</c:choose>
</div>
</body>
</html>
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

<div>
<c:choose>
	
		<c:when test="${empty listeClients}">
		</c:when>
		<table >
				<tr>
					<th>companyName</th >
					<th>firstName</th >
				    <th>lastName</th >
		          
				</tr >  
			<c:forEach items="${ listeClients }" var="Client" varStatus="boucle">

					<tr>

						<td><c:out value="${Client.companyName}" /></td>
						<td><c:out value="${Client.firstName}" /></td>
						<td><c:out value="${Client.lastName}" /></td>
				
					
					<td><a href="<c:url value="/detailsClient" ><c:param name="id" value="${Client.id }"/> </c:url>">Détails</a></td>
					
					<td><a href="<c:url value="/supprimerClient" ><c:param name="id" value="${Client.id }"/> </c:url>">Supprimer</a> </td>
					
					<td><a href="<c:url value="/modifierEtAjouterClient" ><c:param name="id" value="${Client.id }"/> </c:url>">Modifier</a></td>
															
					</tr>
					
			</c:forEach>
			</table>	
</c:choose>
</div>
</body>
</html>
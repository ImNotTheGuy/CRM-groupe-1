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
		            <th>email</th >
					<th>phone</th >
					<th>address</th >
					<th>zipCode</th >
					<th>city</th >
					<th>country</th >
					<th>state</th >
				</tr >  
			<c:forEach items="${ listeClients }" var="client" varStatus="boucle">

					<tr>

						<td><c:out value="${client.companyName}" /></td>
						<td><c:out value="${client.firstName}" /></td>
						<td><c:out value="${client.lastName}" /></td>
						<td><c:out value="${client.email}" /></td>
						<td><c:out value="${client.phone}" /></td>
						<td><c:out value="${client.address}" /></td>
						<td><c:out value="${client.zipCode}" /></td>
						<td><c:out value="${client.city}" /></td>
						<td><c:out value="${client.country}" /></td>
						<td><c:out value="${client.state}" /></td>
					
					<td><a href="<c:url value="/detailsClient" ><c:param name="id" value="${client.id }"/> </c:url>">Détails</a></td>
					
					<td><a href="<c:url value="/supprimerClient" ><c:param name="id" value="${client.id }"/> </c:url>">Supprimer</a> </td>
					
					<td><a href="<c:url value="/modifierEtAjouterClient" ><c:param name="id" value="${client.id }"/> </c:url>">Modifier</a></td>
															
					</tr>
					
			</c:forEach>
			</table>	
</c:choose>
</div>
</body>
</html>
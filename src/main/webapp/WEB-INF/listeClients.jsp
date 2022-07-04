<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="inc/style.css">
<title>Liste des clients</title>
</head>
<body>
<c:import url="/WEB-INF/menu.jsp" />
<h2 class="titre">Liste des clients</h2>
<div>
<c:choose>
		<c:when test="${empty listeClients}">
		<p> Aucun client </p>
		</c:when>
		<c:otherwise>
		<table >
			<thead>
				<tr>
					<th>Compagnie</th >
					<th>Prenom</th >
				    <th>Nom</th >
				    <th>Action</th >
				</tr > 
			</thead>
			<tbody> 
			<c:forEach items="${ listeClients }" var="client" varStatus="boucle">	
				<tr>
					<td><c:out value="${client.companyName}" /></td>
					<td><c:out value="${client.firstName}" /></td>
					<td><c:out value="${client.lastName}" /></td>	
					<td>
						<a href="<c:url value="/detailsClient" ><c:param name="id" value="${client.id }"/> </c:url>">Voir</a>
						&ensp;
						<a href="<c:url value="/modifierEtAjouterClient" ><c:param name="id" value="${client.id }"/> </c:url>">Modifier</a>	
						&ensp;							
						<a href="<c:url value="/supprimerClient" ><c:param name="id" value="${client.id }"/> </c:url>">Supprimer</a>
					</td>
				</tr>	
		</c:forEach>
		</tbody>
		</table>	
		</c:otherwise>
</c:choose>
</div>
<br/>
<a href="<c:url value="/modifierEtAjouterClient" />"><button class="bouton">Ajouter un client</button></a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="inc/style.css">
<title>Liste des commandes</title>
</head>
<body>
<c:import url="/WEB-INF/menu.jsp" />
<h2>Liste des commandes</h2>
	<c:choose>
		<c:when test="${empty Orders}">
		<p>Aucune commande</p>
		</c:when>
	<c:otherwise>
		<table>
			<thead>
				<tr>
					<th>Id Commande</th>
					<th>Type de prestation</th>
					<th>Designation</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ Orders }" var="orders">
					<tr>
						<td><c:out value="${ orders.id }" /></td>
						<td><c:out value="${ orders.typePresta }" /></td>
						<td><c:out value="${ orders.designation }" /></td>
						<td>
							<a href="<c:url value="/detailsOrder"><c:param name="id" value="${ orders.id }" /></c:url>">Voir</a>
							&ensp;
							<a href="<c:url value="/modifierEtAjouterClient"><c:param name="id" value="${ orders.id }" /></c:url>">Modifier</a>
							&ensp;
							<a href="<c:url value="/supprimerOrder"><c:param name="id" value="${ orders.id }" /></c:url>">Supprimer</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>
<br/>
<a href="<c:url value="/modifierEtAjouterOrder" />"><button class="bouton">Ajouter une commande</button></a>
</body>
</html>
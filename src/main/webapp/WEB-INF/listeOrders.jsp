<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>listeOrders</title>


<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/style.css" />" />

</head>



<body>

	<c:import url="/WEB-INF/menu.jsp" />

	<h1>Liste des commandes</h1>


<a href="<c:url value="/ajouterOrder" />"><button>Ajouter une commande</button></a>

	<c:choose>
		<c:when test="${empty orders }"></c:when>
		<p>Aucune commande</p>
	</c:choose>

	<c:otherwise>

		<table>

			<thead>
				<tr>
					<th>id du client</th>
					<th>type de prestation</th>
					<th>nombre de jours</th>
					<th>prix unitaire</th>
					<th>status</th>
					<th>cout THT</th>
					<th>cout TTC</th>
					<th>Action</th>
				</tr>

			</thead>

			<tbody>


				<c:forEach items="${ Orders }" var="livre">

					<tr>

						<td><c:out value="${ orders.client.firstName }" /> <c:out
								value="${ orders.client.lastName }" /></td>

						<td><c:out value="${ orders.typePresta }" /></td>
						<td><c:out value="${ orders.designation }" /></td>
						<td><c:out value="${ orders.nbDays }" /></td>
						<td><c:out value="${ orders.unitPrice }" /></td>
						<td><c:out value="${ orders.state }" /></td>
						<td><c:out value="${ orders.totalExcludeTaxe }" /></td>
						<td><c:out value="${ orders.totalWhithTaxe }" /></td>


						<td><a
							href="<c:url value="/detailsOrder"><c:param name="id" value="${ orders.id }" /></c:url>">Voir</a>
							| <a
							href="<c:url value="/modifierOrder"><c:param name="id" value="${ orders.id }" /></c:url>">Modifier</a>
							| <a
							href="<c:url value="/supprimerOrder"><c:param name="id" value="${ orders.id }" /></c:url>">Supprimer</a>
						</td>

					</tr>
				</c:forEach>

			</tbody>


		</table>


	</c:otherwise>

</body>

</html>
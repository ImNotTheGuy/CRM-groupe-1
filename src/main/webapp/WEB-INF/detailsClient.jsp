<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details Client</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css" />" />
</head>
<body>
	<c:import url="/WEB-INF/menu.jsp" />

	<div >
		<table>
			<thead>
				<tr>
					<th>Company Name</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Telephone</th>
					<th>Adresse</th>
					<th>Zip Code</th >
					<th>City</th >
					<th>Country</th >
					<th>State</th >
				</tr>
			</thead>
			<tbody>
				<tr >
					<td><c:out value="${ client.companyName }" /></td>
					<td><c:out value="${ client.firstName }" /></td>
					<td><c:out value="${ client.lastName }" /></td>
					<td><c:out value="${ client.email }" /></td>
					<td><c:out value="${ client.phone }" /></td>
					<td><c:out value="${ client.address }" /></td>
					<td><c:out value="${ client.zipCode }" /></td>
					<td><c:out value="${ client.city }" /></td>
					<td><c:out value="${ client.country }" /></td>
					<td><c:out value="${ client.state }" /></td>
				</tr>
			</tbody>
		</table>

		<h2>Liste des orders du client :</h2>
		<c:choose>
			<c:when test="${ empty orders }">
				<p>Aucun ordre trouve...</p>
			</c:when>
			<c:otherwise>
				<table>
					<thead>
						<tr>
							<th>Type Presta</th>
							<th>Designation</th>
							<th>Number Days</th>
							<th>Unite Price</th>
							<th>Total Exclude Taxe</th>
							<th>Total With Taxe</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ orders }" var="order" >
							<tr >
								<td><c:out value="${ order.typePresta }" /></td>
								<td><c:out value="${ order.designation }" /></td>
								<td><c:out value="${ order.nbDays }" /></td>
								<td><c:out value="${ order.unitPrice }" /></td>
								<td><c:out value="${ order.totalExcludeTaxe }" /></td>
								<td><c:out value="${ order.totalWithTaxe }" /></td>						
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
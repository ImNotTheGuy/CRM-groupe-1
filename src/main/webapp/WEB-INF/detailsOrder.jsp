<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="inc/style.css">
<title>Details de commande</title>
</head>
<body>

	<c:import url="/WEB-INF/menu.jsp" />

<h2 class="titre">Details concernant la commande :</h2>
<ul>
	<li>Numero de commande : <c:out value="${orders.id}"/></li>
	<li>Client : <c:out value="${orders.client.companyName}"/>
				 <a href="<c:url value="/detailsClient"><c:param name="id" value="${ orders.client.id }" /></c:url>">
				 <c:out value="${orders.client.firstName}"/>
				 <c:out value="${orders.client.lastName}"/></a></li>
				 
	<li>Type de prestation : <c:out value="${orders.typePresta}"/></li>
	<li>Designation : <c:out value="${orders.designation}"/></li>
	<li>Duree (en jour(s)) : <c:out value="${orders.nbDays}"/></li>
	<li>Prix (par jour) : <c:out value="${orders.unitPrice}"/></li>
	<li>Statut : <c:out value="${orders.state}"/></li>
	<li>Prix HT : <c:out value="${orders.totalExcludeTaxe}"/></li>
	<li>Prix TTC : <c:out value="${orders.totalWithTaxe}"/></li>
</ul>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="inc/style.css">
<title>Details commande</title>
</head>
<body>

	<c:import url="/WEB-INF/menu.jsp" />

<h2>Dï¿½tails concernant la commande :</h2>
<ul>
	<li>Id commande : <c:out value="${orders.id}"/></li>
	<li>Client : <c:out value="${orders.client.companyName}"/>
				 <c:out value="${orders.client.firstName}"/>
				 <c:out value="${orders.client.lastName}"/></li>
	<li>Type de prestation : <c:out value="${orders.typePresta}"/></li>
	<li>Designation : <c:out value="${orders.designation}"/></li>
	<li>Durï¿½e (en jour(s)) : <c:out value="${orders.nbDays}"/></li>
	<li>Prix (par jour) : <c:out value="${orders.unitPrice}"/></li>
	<li>Statut : <c:out value="${orders.state}"/></li>
	<li>Prix hors taxe : <c:out value="${orders.totalExcludeTaxe}"/></li>
	<li>Prix TTC : <c:out value="${orders.totalWithTaxe}"/></li>
</ul>
</body>
</html>
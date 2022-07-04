<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="inc/style.css">
<nav>
<div class="listeMenu">
	<a href="<c:url value="/" />">Acceuil</a>
	<a href="<c:url value="/listeClients" />">Liste Clients</a>
	<a href="<c:url value="/listeOrders" />">Liste Commandes</a>
</div>
</nav>	
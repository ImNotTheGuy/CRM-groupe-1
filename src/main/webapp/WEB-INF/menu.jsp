<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Menu</h2>
<div class="menu">
<ul>
	<li ><a href="<c:url value="/" />">Acceuil</a></li>
	<li ><a href="<c:url value="/listeClients" />">Liste Clients</a></li>
	<li ><a href="<c:url value="/listeOrders" />">Liste Commandes</a></li>
</ul>
</div>
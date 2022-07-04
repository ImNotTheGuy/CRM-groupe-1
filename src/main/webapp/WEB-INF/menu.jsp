<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h2>Menu</h2>
<div>
<ul>

	<li ><a href="<c:url value="/" />">Acceuil</a></li>
	<li ><a href="<c:url value="/listeClients" />">Liste Clients</a></li>
	<li ><a href="<c:url value="/listeOrders" />">Liste Commande</a></li>
	<li ><a href="<c:url value="/modifierEtAjouterClient" />">Ajouter client</a></li>
	<li ><a href="<c:url value="/modifierEtAjouterCommande" />">Ajouter commande</a></li>
	
</ul>
</div>
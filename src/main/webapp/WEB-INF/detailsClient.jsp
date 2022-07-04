<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details client</title>
<link type="text/css" rel="stylesheet" href="<c:url value="inc/style.css" />" />
</head>
<body>
	<c:import url="/WEB-INF/menu.jsp" />
<div class="scroller">	
<div class="our-team">
	<div class="picture">
        	<img class="image" src="https://www.pinclipart.com/picdir/big/155-1559316_male-avatar-clipart.png">
    </div>
    <div class="team-content">
        	<h2 class="name"><c:out value="${ client.companyName }" /></h2>
          	<h3 class="title"><c:out value="${ client.firstName }" /> <c:out value="${ client.lastName }" /></h3>
		    <h4>Email : <c:out value="${ client.email }" />
		    	<br/>
				Telephone : <c:out value="${ client.phone }" />
				<br/>
				Adresse : <c:out value="${ client.address }" />
				<br/>
				Ville : <c:out value="${ client.city }" />
				<br/>
				Pays : <c:out value="${ client.country }" />
				<br/>
				Code postal : <c:out value="${ client.zipCode }" />
				</h4>					
    </div>
    <ul class="infosSup">
         	<li>Statut : <c:out value="${ client.state }" /></li>
    </ul>
</div>   
<h3 class="titre">Commandes du client :</h3>
	<c:choose>
		<c:when test="${ empty orders }">
			<p>Aucune commande</p>
		</c:when>
		<c:otherwise>
			<table>
				<thead>
					<tr>
						<th>Type de prestation</th>
						<th>Designation</th>
						<th>Duree (en jour(s))</th>
						<th>Prix (par jour)</th>
						<th>Prix HT</th>
						<th>Prix TTC</th>
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
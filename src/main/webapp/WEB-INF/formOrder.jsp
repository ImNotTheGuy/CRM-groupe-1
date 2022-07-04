<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form method="post"
	action="<c:url value = "/modifierEtAjouterClient">
	<c:param name="id" value="${orders.id}"/>
			</c:url>">

	<fieldset>
		<legend>Modifer une Commande</legend>



		<label for="clientId">Client</label>
<select id="clientId" name="clientId">
	<c:forEach items="${ client }" var="client">
		<option value="<c:out value="${ client.id }"/>" ${ client.id == orders.client.id ? "selected" : "" }><c:out value="${ client.firstName }"/> <c:out value="${ client.lastName }"/></option>
	</c:forEach>
</select>

<br/>

 
			<label
			for="typePresta">Type de Prestation</label> 
			<input type="text" name="typePresta" id="typePresta" value="<c:out value="${orders.typePresta}"></c:out>"> <br />



		<label for="designation">designation</label> <input type="text" name="designation"
			id="designation" value="<c:out value="${orders.designation}"></c:out>"> <br />


		<label for="nbDays">Nombre de Jours</label> <input type="text" name="nbDays"
			id="nbDays" value="<c:out value="${orders.nbDays}"></c:out>"> <br /> <label
			for="unitPrice">Prix unitaire</label> <input type="text" name="unitPrice"
			id="unitPrice" value="<c:out value="${orders.unitPrice}"></c:out>"> <br />

		<label for="state">State</label> <input type="text" name="state"
			id="state" value="<c:out value="${orders.state}"></c:out>"> <br /> <input
			type="submit" value="Valider" /><br /> <input type="reset"
			value="Remettre à zéro" />
			
		
		<input type="submit" value="Valider"/><br/>
		<input type="reset" value="Remettre à zéro"/>
		
</fieldset>		
</form>


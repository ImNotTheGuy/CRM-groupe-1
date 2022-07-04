<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<fieldset>
<form method="post"
	action="<c:url value = "/modifierEtAjouterClient">
	<c:if test="${addOrUpdate} == 'Modifier'">
	<c:param name="id" value="${client.id}"/></c:if>
			</c:url>">

	<fieldset>
		<legend>${addOrUpdate} un Client</legend>


		<label for="nom">Company name</label> <input type="text"
			name="companyName" id="companyName"
			value="<c:out value="${client.companyName}"></c:out>"> <br /> <label
			for="firstName">First name</label> <input type="text"
			name="firstName" id="firstName"
			value="<c:out value="${client.firstName}"></c:out>"> <br /> <label
			for="lastName">Last name</label> <input type="text" name="lastName"
			id="lastName" value="<c:out value="${client.lastName}"></c:out>"> <br />



		<label for="email">Email</label> <input type="text" name="email"
			id="email" value="<c:out value="${client.email}"></c:out>"> <br /> <label
			for="phone">Phone</label> <input type="number" name="phone"
			id="phone" value="<c:out value="${client.phone}"></c:out>"> <br /> 
			<label
			for="address">Address</label> 
			<input type="text" name="address" id="address" value="<c:out value="${client.address}"></c:out>"> <br />



		<label for="zipCode">Zipcode</label> <input type="text" name="zipCode"
			id="zipCode" value="<c:out value="${client.zipCode}"></c:out>"> <br />


		<label for="city">City</label> <input type="text" name="city"
			id="city" value="<c:out value="${client.city}"></c:out>"> <br /> <label
			for="country">Country</label> <input type="text" name="country"
			id="country" value="<c:out value="${client.country}"></c:out>"> <br />

		<label for="state">State</label> <input type="text" name="state"
			id="state" value="<c:out value="${client.state}"></c:out>"> <br /> <input
			type="submit" value="Valider" /><br /> <input type="reset"
			value="Remettre à zéro" />
			
</form>

</fieldset>

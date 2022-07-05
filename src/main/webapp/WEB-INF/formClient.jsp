<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<fieldset>
<form method="post"
	action="<c:url value = "/modifierEtAjouterClient">
	<c:if test="${addOrUpdate} == 'Modifier'">
	<c:param name="id" value="${client.id}"/></c:if>
			</c:url>">
<<<<<<< HEAD
<<<<<<< HEAD

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


=======
=======
>>>>>>> 561d5a8b0d4c49311b62450a738b2d680ce3a669
<fieldset>
<legend>${addOrUpdate} un client</legend>

		<label for="nom">Compagnie</label> 
		<input type="text" name="companyName" id="companyName" value="<c:out value="${client.companyName}"></c:out>"> <br /> 
		
		<label for="firstName">Prenom</label> 
		<input type="text" name="firstName" id="firstName" value="<c:out value="${client.firstName}"></c:out>"> <br /> 
		
		<label for="lastName">Nom</label> 
		<input type="text" name="lastName" id="lastName" value="<c:out value="${client.lastName}"></c:out>"> <br />

		<label for="email">Email</label> 
		<input type="text" name="email" id="email" value="<c:out value="${client.email}"></c:out>"> <br /> 
		
		<label for="phone">Telephone</label> 
		<input type="number" name="phone" id="phone" value="<c:out value="${client.phone}"></c:out>"> <br /> 
		
		<label for="address">Adresse</label> 
		<input type="text" name="address" id="address" value="<c:out value="${client.address}"></c:out>"> <br />
<<<<<<< HEAD
>>>>>>> 92e3098f168e61057401dadc1ab14413a3cac4f0
=======
>>>>>>> 561d5a8b0d4c49311b62450a738b2d680ce3a669

		<label for="zipCode">Code postal</label> <input type="text" name="zipCode"
			id="zipCode" value="<c:out value="${client.zipCode}"></c:out>"> <br />

<<<<<<< HEAD
<<<<<<< HEAD

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
=======
=======
>>>>>>> 561d5a8b0d4c49311b62450a738b2d680ce3a669
		<label for="city">Ville</label> 
		<input type="text" name="city" id="city" value="<c:out value="${client.city}"></c:out>"> <br /> 
		
		<label for="country">Pays</label>
		<input type="text" name="country" id="country" value="<c:out value="${client.country}"></c:out>"> <br />

		<label for="state">Statut</label>
		<input type="text" name="state" id="state" value="<c:out value="${client.state}"></c:out>"> <br />
</fieldset>
<input class="bouton" type="submit" value="Valider" /> <input class="bouton" type="reset" value="Remettre à zéro" />	
</form>
<<<<<<< HEAD
>>>>>>> 92e3098f168e61057401dadc1ab14413a3cac4f0
=======
>>>>>>> 561d5a8b0d4c49311b62450a738b2d680ce3a669

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" type="text/css" href="inc/style.css">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Erreur: ${errorTitle}</title>
</head>
<body class="error">


<img src="https://c.tenor.com/8AqUPOC5GMgAAAAj/parrot-party.gif"/>

<h1>Erreur ${errorTitle}</h1>


<h3>
Erreur pour ${errorTitle}. Le ou les conditions suivantes n'ont pas été respectées:

<ul>
<c:forEach items="${errorMessages}" var="error">
<li>${error}</li>
</c:forEach>
</ul>
</h3>
<hr>
retournez à 
<a href="
<c:url value="${redirectURL}"/>">${redirectURL}</a>

</body>
</html>
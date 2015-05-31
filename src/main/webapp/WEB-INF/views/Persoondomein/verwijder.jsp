<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
	<title>Updatenwijzigingenformkut</title>
 
<style>
 
	.error {
		color: #ff0000;
	}
</style>
 
</head>
 
<body>
 
	<h2>U staat op het punt de volgende persoon te verwijderen:</h2>
 

        	<form:form method="POST" modelAttribute="persoon">
		<table>
			<tr>
				<td><label for="voornaam">Voornaam: </label> </td>
				<td>${persoon.voornaam}</td>
				<td><form:errors path="voornaam" cssClass="error"/></td>
		    </tr>
                    <tr>
				<td><label for="achternaam">Achternaam: </label> </td>
				<td>${persoon.achternaam}</td>
				<td><form:errors path="achternaam" cssClass="error"/></td>
		    </tr>
 
			
                                        
                    
 
			<tr>
				<td colspan="3"><input type="submit" value="Bevestig"/></td>
                                
			</tr>
		</table>
	</form:form>
        
        
	<br/>
	<br/>
	Terug naar de <a href="<c:url value='/personen/' />">persoonslijst</a>
</body>
</html>
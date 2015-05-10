<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Updatenwijzigingenformkut</title>
 
<style>
 
	.error {
		color: #ff0000;
	}
</style>
 
</head>
 
<body>
 
	<h2>Persoonsgegevens wijzigen</h2>
                

        	<form:form method="POST" modelAttribute="persoon">
                    
		<table>
			<tr>
				<td><label for="voornaam">Voornaam: </label> </td>
				<td><form:input path="voornaam" id="voornaam"/></td>
				<td><form:errors path="voornaam" cssClass="error"/></td>
		    </tr>
                    <tr>
				<td><label for="achternaam">Achternaam: </label> </td>
				<td><form:input path="achternaam" id="achternaam"/></td>
				<td><form:errors path="achternaam" cssClass="error"/></td>
		    </tr>
 
			<tr>
				<td><label for="tussenvoegsel">Tussenvoegsel: </label> </td>
				<td><form:input path="tussenvoegsel" id="tussenvoegsel"/></td>
				<td><form:errors path="tussenvoegsel" cssClass="error"/></td>
		    </tr>
 
			<tr>
				<td><label for="geboortedatum">Geboortedatum: </label> </td>
				<td><form:input path="geboortedatum" id="geboortedatum"/></td>
				<td><form:errors path="geboortedatum" cssClass="error"/></td>
		    </tr>
                     <tr>
				<td><label for="adres.id" type= "hidden"></label> </td>
				<td><form:input path="adres.id" id="adres.id" type= "hidden"/></td>
				<td><form:errors path="adres.id" cssClass="error" type= "hidden"/></td>
		    </tr>
                    
                    <tr>
				<td><label for="adres.straatnaam">Straatnaam: </label> </td>
				<td><form:input path="adres.straatnaam" id="adres.straatnaam"/></td>
				<td><form:errors path="adres.straatnaam" cssClass="error"/></td>
		    </tr>
                    <tr>
				<td><label for="adres.huisnummer">Huisnummer: </label> </td>
				<td><form:input path="adres.huisnummer" id="adres.huisnummer"/></td>
				<td><form:errors path="adres.huisnummer" cssClass="error"/></td>
		    </tr>
                    
                    <tr>
				<td><label for="adres.toevoeging">toevoeging: </label> </td>
				<td><form:input path="adres.toevoeging" id="adres.toevoeging"/></td>
				<td><form:errors path="adres.toevoeging" cssClass="error"/></td>
		    </tr>
                    <tr>
				<td><label for="adres.postcode">Postcode: </label> </td>
				<td><form:input path="adres.postcode" id="adres.postcode"/></td>
				<td><form:errors path="adres.postcode" cssClass="error"/></td>
		    </tr>
                    
                    <tr>
				<td><label for="adres.woonplaats">Woonplaats: </label> </td>
				<td><form:input path="adres.woonplaats" id="adres.woonplaats"/></td>
				<td><form:errors path="adres.woonplaats" cssClass="error"/></td>
		    </tr>
                                        
                    
 
			<tr>
				<td colspan="3"><input type="submit" value="Update"/></td>
			</tr>
		</table>
	</form:form>
        
        
	<br/>
	<br/>
	Go back to <a href="<c:url value='/list' />">List of All Employees</a>
</body>
</html>
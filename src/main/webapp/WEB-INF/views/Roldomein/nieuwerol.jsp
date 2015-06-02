<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <title>Nieuwe rol toevoegen</title>

        <style>

            .error {
                color: #ff0000;
            }
        </style>

    </head>

    <body>

        <h2>Nieuwe materiaal toevoegen voor student ${persoonsrol.persoon.volledigeNaam}</h2>

        <form:form method="POST" modelAttribute="persoonsrol">
            <table>
                
                <tr>
                    <td><label for="naam">Naam: </label> </td>
                    <td><form:input path="naam" id="naam"/></td>
                    <td><form:errors path="naam" cssClass="error"/></td>
                </tr>
                
                <tr>
                    <td colspan="3"><input type="submit" value="Register"/></td>
                </tr>
            </table>
        </form:form>
        <br/>
        <br/>
        Go back to <a href="<c:url value='/rollen/' />">Terug naar rollenlijst</a>
    </body>
</html>
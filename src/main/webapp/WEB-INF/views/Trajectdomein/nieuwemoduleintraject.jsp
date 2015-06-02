<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <title>Nieuwe module toevoegen</title>

        <style>

            .error {
                color: #ff0000;
            }
        </style>

    </head>

    <body>

        <h2>Nieuwe module toevoegen</h2>

        <form:form method="POST" modelAttribute="module">
            <table>
                <tr>  <td><label for="trajectnaam">Traject: ${module.traject.naam}</label> </td></tr>

                <tr>
                    <td><label for="omschrijving">Omschrijving: </label> </td>
                    <td><form:textarea path="omschrijving" id="omschrijving"/></td>
                    <td><form:errors path="omschrijving" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="lengteInWeken">Tijdsduur in weken: </label> </td>
                    <td><form:input path="lengteInWeken" id="lengteInWeken"/></td>
                    <td><form:errors path="lengteInWeken" cssClass="error"/></td>
                </tr>


                <tr>
                    <td colspan="3"><input type="submit" value="Register"/></td>
                </tr>
            </table>
        </form:form>
        <br/>
        <br/>
        Go back to <a href="<c:url value='/trajecten/' />">Terug naar trajecten overzicht</a>
    </body>
</html>
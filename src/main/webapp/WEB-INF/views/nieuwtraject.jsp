<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <title>Nieuw traject toevoegen</title>

        <style>

            .error {
                color: #ff0000;
            }
        </style>

    </head>

    <body>

        <h2>Nieuw traject toevoegen</h2>

        <form:form method="POST" modelAttribute="traject">
           <table>
                <tr>
                    <td><label for="naam">Naam: </label> </td>
                    <td><form:input path="naam" id="naam"/></td>
                    <td><form:errors path="naam" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="omschrijving">Omschrijving: </label> </td>
                    <td><form:input path="omschrijving" id="omschrijving"/></td>
                    <td><form:errors path="omschrijving" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="startdatum">Startdatum: </label> </td>
                    <td><form:input type = "localDate" path="startdatum" id="startdatum"/></td>
                    <td><form:errors path="startdatum" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="sluitingsdatum">Einddatum: </label> </td>
                    <td><form:input type = "localDate" path="sluitingsdatum" id="sluitingsdatum"/></td>
                    <td><form:errors path="sluitingsdatum" cssClass="error"/></td>
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
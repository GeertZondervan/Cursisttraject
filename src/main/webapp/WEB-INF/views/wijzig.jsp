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
                    <td colspan="3"><input type="submit" value="Update"/></td>
                </tr>
            </table>
        </form:form>
        <a href="<c:url value='${persoon.id}-persoonsrollen ' />">Voeg nieuwe rol toe</a>

        <br/>
        <br/>
        Go back to <a href="<c:url value='/list' />">List of All Employees</a>
    </body>
</html>
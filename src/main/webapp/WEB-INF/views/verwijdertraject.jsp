<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <title>Traject Verwijderent</title>

        <style>

            .error {
                color: #ff0000;
            }
        </style>

    </head>

    <body>

        <h2>U staat op het punt het volgende traject te verwijderen:</h2>


        <form:form method="POST" modelAttribute="traject">
            <table>
                <tr>
                    <td><label for="naam">Naam: </label> </td>
                    <td>${traject.naam}</td><

                </tr>
                <tr>
                    <td><label for="omschrijving">Omschrijving: </label></td>
                    <td>${traject.omschrijving}</td>
                    <td><form:errors path="naam" cssClass="error"/></td>
                </tr>
                <tr>
                    <td colspan="3"><input type="submit" value="Bevestig"/></td>

                </tr>
            </table>
        </form:form>


        <br/>
        <br/>
        <a href="<c:url value='/rollen' />">Ga terug naar de trajecten overzicht</a>
    </body>
</html>
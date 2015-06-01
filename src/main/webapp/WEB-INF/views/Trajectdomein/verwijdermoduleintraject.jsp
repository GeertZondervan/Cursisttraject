<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <title>Module verwijderen</title>

        <style>

            .error {
                color: #ff0000;
            }
        </style>

    </head>

    <body>

        <h2>U staat op het punt de volgende module te verwijderen:</h2>


        <form:form method="POST" modelAttribute="module">
            <table>
                <tr>  <td><label for="trajectnaam">In Traject: ${traject.naam}</label> </td></tr>

                <tr>
                    <td><label for="module.omschrijving">Module Omschrijving: </label> </td>
                    <td>${module.omschrijving}</td>
                </tr>
               
                <tr>
                    <td colspan="3"><input type="submit" value="Bevestig"/></td>

                </tr>
            </table>
        </form:form>


        <br/>
        <br/>
        <a href="<c:url value='/toetsen' />">Ga terug naar het toets overzicht</a>
    </body>
</html>
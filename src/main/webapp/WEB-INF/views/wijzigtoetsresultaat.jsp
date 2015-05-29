<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <title>Toets wijzigen</title>

        <style>

            .error {
                color: #ff0000;
            }
        </style>

    </head>

    <body>

        <h2>Toetsresultaat wijzigen</h2>


        <form:form method="POST" modelAttribute="toetsresultaat">

            <table>
                 <tr>
                    <td><label for="persoonsrol.persoon.volledigeNaam">Persoon: </label> </td>
                    <td>${toetsresultaat.persoonsrol.persoon.volledigeNaam}</td>
                </tr>
                <tr>
                    <td><label for="resultaat">Resultaat: </label> </td>
                    <td><form:input path="resultaat" id="resultaat"/></td>
                    <td><form:errors path="resultaat" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="datum">Datum: </label> </td>
                    <td><form:input path="datum" id="datum"/></td>
                    <td><form:errors path="datum" cssClass="error"/></td>
                </tr>
               
               
                <tr>
                    <td colspan="3"><input type="submit" value="Update"/></td>
                </tr>
            </table>
        </form:form>


        <br/>
        <br/>
        <a href="<c:url value='/toetsen' />">Ga terug naar toets overzicht</a>
    </body>
</html>
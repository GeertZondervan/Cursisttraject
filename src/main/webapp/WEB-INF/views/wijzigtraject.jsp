<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Traject wijzigen</title>

        <style>

            .error {
                color: #ff0000;
            }
        </style>

    </head>

    <body>

        <h2>Traject wijzigen</h2>


        <form:form modelAttribute="traject">

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
                    <td colspan="3"><input type="submit" value="Update"/></td>
                </tr>
            </table>
            <h2>Modules in dit traject</h2>
            <table>
                <tr><td>Omschrijving</td><td>Lengte in weken</td></tr>
                <c:forEach items="${traject.modules}" var="module" >

                    <tr>

                        <td>${module.omschrijving}</td>
                        <td>${module.lengteInWeken}</td>

                    </tr>
                </c:forEach>
            </table>
        </form:form>


        <br/>
        <br/>

    </body>
</html>
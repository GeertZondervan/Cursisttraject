<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
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
                    <td colspan="3"><input type="submit" value="Update"/></td>
                </tr>
            </table>
            <h2>Modules in dit traject</h2>
            <table>
                <tr><td>Omschrijving</td><td>Lengte in weken</td></tr>
                <c:forEach items="${traject.modules}" var="module" >

                    <tr class="element">

                        <td>${module.omschrijving}</td>
                        <td>${module.lengteInWeken}</td>
                        <td><button id="verwijdermodule" name="verwijdermodule" value="${module.id}"  >Verwijder </button></td>
                    </tr>
                </c:forEach>
                            <a href="${pageContext.request.contextPath}/trajecten/${traject.id}/nieuwemoduleintraject" onclick="window.open('${pageContext.request.contextPath}/trajecten/${traject.id}/nieuwemoduleintraject','Nieuwe Module', 'width=600,height=425,scrollbars=no,toolbar=no,location=no'); return false">Voeg nieuwe module toe</a>
            </table>
        </form:form>


        <br/>
        <br/>
        <a href="<c:url value='/trajecten/' />">Terug naar traject overzicht</a><p>
        <a href="<c:url value='/home/' />">Home</a>

    </body>
</html>
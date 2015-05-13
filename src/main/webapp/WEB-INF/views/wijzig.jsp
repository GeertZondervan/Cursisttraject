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

            tr:first-child{
                font-weight: bold;
                background-color:mediumaquamarine;
            }
        </style>

    </head>

    <body>

        <h2>Persoonsgegevens wijzigen</h2>


        <form:form modelAttribute="persoon">
            <h2>Personalia</h2>
            <table>
                <tr></tr>
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
                <tr><td><br/><td></tr>
                <tr><td><h2>Persoonsrollen</h2></td></tr>

            </table>
            <table>
                <tr>
                    <td>Naam</td><td>Begindatum</td>
                </tr>
                <c:forEach items="${persoon.persoonsrollen}" var="persoonsrol" >

                    <tr>
                        <td>${persoonsrol.rol.naam}</td>
                        <td>${persoonsrol.id.begindatum}</td>
                        <td><button id="verwijder" name="verwijderpersoonsrol" value="${persoonsrol.rol.id}" >Verwijder </button>
                    </tr>
                </c:forEach>
                <tr><td><a href="<c:url value='${persoon.id}-persoonsroltoevoegen ' />">Voeg nieuwe persoonsrol toe</a></td></tr>
                <tr><td><br/><td></tr>
               </table> 
                <h2>Expertises</h2>
            
            <table>
                <c:forEach items="${persoon.expertises}" var="expertise" >
                    <td>Naam</td><td>Omschrijving</td>
                    <tr>
                        <td>${expertise.naam}</td>
                        <td>${expertise.omschrijving}</td>

                        <td><button id="verwijder" name="verwijderexpertise" value="${expertise.id}" >Verwijder </button>
                    </tr>
                </c:forEach>


            </table>
        </form:form>


        <br/>
        <br/>
        Terug naar de <a href="<c:url value='/list' />">persoonslijst</a>
    </body>
</html>
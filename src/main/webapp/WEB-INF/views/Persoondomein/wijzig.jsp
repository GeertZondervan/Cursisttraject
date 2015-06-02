<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <title>Updatenwijzigingenform</title>


    </head>

    <body>

        <h2>Persoonsgegevens wijzigen</h2>


        <form:form modelAttribute="persoon">

            <table class="wijzig">
                <tr><td><h3>Personalia</h3></td></tr>
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



            </table >
        </form:form>
        <table class="wijzig">
            <tr><td><h3>Persoonsrollen</h3></td></tr>
            <tr class="tabelheader">
                <td>Naam</td><td>Begindatum</td><td>Einddatum</td>
            </tr>
            <c:forEach items="${persoon.persoonsrollen}" var="persoonsrol" >

                <tr class="element">

                    <td>${persoonsrol.rol.naam}</td>
                    <td>${persoonsrol.id.begindatum}</td>
                    <td>${persoonsrol.einddatum}</td>
                    <td><input type="submit" onclick="window.open('${pageContext.request.contextPath}/personen/update-persoonsrol/pId-${persoonsrol.persoon.id}/rId-${persoonsrol.rol.id}', 'Wijzig persoonsrol', 'width=600,height=425,scrollbars=no,toolbar=no,location=no');
                            return false" name="wijzig" class="button" value="Wijzig" /></td>
                    <td><input type="submit" onclick="window.open('${pageContext.request.contextPath}/personen/delete-persoonsrol/pId-${persoonsrol.persoon.id}/rId-${persoonsrol.rol.id}', 'Verwijder persoonsrol', 'width=600,height=425,scrollbars=no,toolbar=no,location=no');
                            return false" name="verwijder" class="button" value="Verwijder" /></td>
                </tr>
            </c:forEach>
            <tr><td><a href="<c:url value='/personen/${persoon.id}-persoonsroltoevoegen ' />">Voeg nieuwe persoonsrol toe</a></td></tr>
            <tr><td><br/><td></tr>
        </table> 


        <table class="wijzig">
            <tr><td><h3>Expertises</h3></td></tr>
            <tr class="tabelheader"><td>Naam</td><td>Omschrijving</td></tr>
            <c:forEach items="${persoon.expertises}" var="expertise" >

                <tr>
                    <td>${expertise.naam}</td>
                    <td>${expertise.omschrijving}</td>

                    <td><button id="verwijder" name="verwijderexpertise" value="${expertise.id}" >Verwijder </button>
                </tr>
            </c:forEach>


        </table>



        <br/>
        <br/>
        Terug naar de <a href="<c:url value='/personen/' />">persoonslijst</a>
    </body>
</html>
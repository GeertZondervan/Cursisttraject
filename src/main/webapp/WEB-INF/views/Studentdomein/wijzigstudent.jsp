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

        <h2>Student details</h2>


        <form:form modelAttribute="persoonsrol">

            <table class="wijzig">
                <tr><td><h3>Personalia</h3></td></tr>
                <tr>
                    <td>Naam: </td><td>${persoonsrol.persoon.volledigeNaam}</td>      
                </tr>





            </table >
        </form:form>



        <table class="wijzig">
            <tr><td><h3>Trajecten</h3></td></tr>
            <tr class="tabelheader"><td>Naam</td><td>Begindatum</td><td>Einddatum</td><td>Afgerond</td></tr>
            <c:forEach items="${persoonsrol.heeftTrajecten}" var="persoonsrolheeftraject" >

                <tr>
                    <td>${persoonsrolheeftraject.traject.naam}</td>
                    <td>${persoonsrolheeftraject.begindatum}</td>
                    <td>${persoonsrolheeftraject.einddatum}</td>
                    <td>${persoonsrolheeftraject.succesvolAfgerond}</td>
                </tr>
            </c:forEach>
           <td><input type="submit" onclick="location.href = '${pageContext.request.contextPath}/studenten/voegtrajecttoe-${persoonsrol.persoon.id}-${persoonsrol.rol.id} '" name="wijzig" class="button" value="Voeg traject toe" /></td>

        </table>



        <br/>
        <table class="wijzig">
            <tr><td><h3>Materialen</h3></td></tr>
            <tr class="tabelheader"><td>Titel</td><td>Auteur</td><td>ISBN13</td>
                <c:forEach items="${persoonsrol.heeftMateriaal}" var="persoonsrolHasMateriaal" >

                <tr>
                    <td>${persoonsrolHasMateriaal.materiaal.titel}</td>
                    <td>${persoonsrolHasMateriaal.materiaal.auteur}</td>
                    <td>${persoonsrolHasMateriaal.materiaal.isbn13}</td>

                </tr>
            </c:forEach>
            <td><input type="submit" onclick="location.href = '${pageContext.request.contextPath}/studenten/voegmateriaaltoe-${persoonsrol.persoon.id}-${persoonsrol.rol.id} '" name="wijzig" class="button" value="Voeg materiaal toe" /></td>

        </table>
        <br/>
        Terug naar de <a href="<c:url value='/personen/' />">persoonslijst</a>
    </body>
</html>
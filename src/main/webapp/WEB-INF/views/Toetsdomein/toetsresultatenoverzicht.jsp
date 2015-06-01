<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <title>Toets overzicht</title>

    </head>
    <body>
        <h2>Toetsoverzicht voor toets ${toets.naam} in module ${toets.module}</h2>	
        <table>
            <tr class="tabelheader">

                <td>Voornaam</td>
                <td>Achternaam</td>
                <td>Rol</td>
                <td>Resultaat</td>
                <td>Minimumresultaat</td>
                <td>Datum</td>
            </tr>
            <c:forEach items="${toets.toetsResultaten}" var="toetsresultaat">
                <tr>
                    <td>${toetsresultaat.persoonsrol.persoon.voornaam}</td>
                    <td>${toetsresultaat.persoonsrol.persoon.achternaam}</td>
                    <td>${toetsresultaat.persoonsrol.rol.naam}</td>
                    <td>${toetsresultaat.resultaat}</td>
                    <td>${toetsresultaat.toets.minimumResultaat}</td>
                    <td>${toetsresultaat.datum}</td>
                    <td><input type="submit" onclick="window.open('${pageContext.request.contextPath}/toetsen/update-toetsresultaat-${toetsresultaat.toets.id}-${toetsresultaat.persoonsrol.persoon.id}', 'Wijzig toetsresultaat', 'width=600,height=425,scrollbars=no,toolbar=no,location=no');
                            return false" name="wijzig" class="button" value="Wijzig" /></td>
                    <td><input type="submit" onclick="window.open('${pageContext.request.contextPath}/toetsen/delete-toetsresultaat-${toetsresultaat.toets.id}-${toetsresultaat.persoonsrol.persoon.id}', 'Verwijder toetsresultaat', 'width=600,height=425,scrollbars=no,toolbar=no,location=no');
                            return false" name="verwijder" class="button" value="Verwijder" /></td>
                </tr>
            </c:forEach>
        </table>


        <a href="${pageContext.request.contextPath}/toetsen/${toetsId}-nieuwtoetsresultaat" onclick="window.open('${pageContext.request.contextPath}/toetsen/${toetsId}/nieuwtoetsresultaat', 'Nieuw toetsresultaat', 'width=600,height=425,scrollbars=no,toolbar=no,location=no');
                return false" >Nieuw toetsresultaat</a>
        <br/>
        <br/>

        <a href="${pageContext.request.contextPath}/toetsen/" >Terug naar toetsoverzicht</a>
        <br>
        <br>

        <a href="${pageContext.request.contextPath}">Terug naar hoofdmenu</a>
    </body>
</html>
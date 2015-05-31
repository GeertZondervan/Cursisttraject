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
                    <td><input type="submit" onclick="location.href = '${pageContext.request.contextPath}/toetsen/update-toetsresultaat-${toetsresultaat.toets.id}-${toetsresultaat.persoonsrol.persoon.id}'" name="wijzig" class="button" value="Wijzig" /></td>
                    <td><input type="submit" onclick="location.href = '${pageContext.request.contextPath}/toetsen/delete-toetsresultaat-${toetsresultaat.toets.id}-${toetsresultaat.persoonsrol.persoon.id} '" name="verwijder" class="button" value="Verwijder" /></td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        
        <a href="${pageContext.request.contextPath}/toetsen/${toets.id}/nieuwtoetsresultaat" onclick="window.open('${pageContext.request.contextPath}/toetsen/${toets.id}/nieuwtoetsresultaat','Nieuw toetsresultaat', 'width=600,height=425,scrollbars=no,toolbar=no,location=no'); return false">Voeg nieuw toetsresultaat toe</a>
            <a href="<c:url value='/home' />">Home</a>
    </body>
</html>
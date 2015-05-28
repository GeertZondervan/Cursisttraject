<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <title>Trajecten overzicht</title>


    </head>


    <body>
        <h2>Trajecten Overzicht</h2>	
        <table>
            <tr class="tabelheader">
                <td>Traject naam</td>
                <td>Omschrijving</td>
                <td>Startdatum</td>
                <td>Einddatum</td>
            </tr>
            <c:forEach items="${trajecten}" var="traject">
                <tr>
                    <td>${traject.naam}</td>
                    <td>${traject.omschrijving}</td>
                    <td>${traject.startdatum}</td>
                    <td>${traject.sluitingsdatum}</td>
                    <td><input type="submit" onclick="location.href='${pageContext.request.contextPath}/trajecten/updatetraject-${traject.id} '" name="wijzig" class="button" value="Wijzig" /></td>
                    <td><input type="submit" onclick="location.href='${pageContext.request.contextPath}/trajecten/delete-${traject.id} '" name="verwijder" class="button" value="Verwijder" /></td>
                   
                </tr>
            </c:forEach>
        </table>
        <br/>
        <a href="<c:url value='/trajecten/nieuwtraject' />">Voeg nieuw traject toe</a><p>
           <a href="<c:url value='/home' />">Home</a>
    </body>
</html>
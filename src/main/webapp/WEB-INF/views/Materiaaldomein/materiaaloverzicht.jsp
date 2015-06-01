<%-- 
    Document   : expertiseoverzicht
    Created on : May 27, 2015, 3:00:40 PM
    Author     : Geert
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <title>Materialen</title>


    </head>


    <body>
        <h2>Materiaaloverzicht</h2>	
        <table>
            <tr class="tabelheader">
                <td>Titel</td>
                <td>Auteur</td>
                <td>Omschrijving</td>
                <td>Url</td>
                <td>ISBN13</td>
                <td>ISBN10</td>
                <td>Modules</td>
                <td>Personen</td>
            </tr>
            <c:forEach items="${materialen}" var="materiaal">
                <tr>
                    <td>${materiaal.titel}</td>
                    <td>${materiaal.auteur}</td>
                    <td>${materiaal.omschrijving}</td>
                    <td><a href="${materiaal.url}" target="_blank">${materiaal.url}</a></td>
                    <td>${materiaal.isbn13}</td>
                    <td>${materiaal.isbn10}</td>
                    <td>${materiaal.modules.size()}</td>
                    <td>${materiaal.heeftPersoonsrollen.size()}</td>
                    <td><input type="submit" onclick="window.open('${pageContext.request.contextPath}/materialen/update-materiaal-${materiaal.id}', 'Wijzig materiaal', 'width=600,height=425,scrollbars=no,toolbar=no,location=no');
                            return false" name="wijzig" class="button" value="Wijzig" /></td>
                    <td><input type="submit" onclick="window.open('${pageContext.request.contextPath}/materialen/delete-materiaal-${materiaal.id}', 'Verwijder materiaal', 'width=600,height=425,scrollbars=no,toolbar=no,location=no');
                            return false" name="verwijder" class="button" value="Verwijder" /></td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <a href="${pageContext.request.contextPath}/materialen/nieuwmateriaal" onclick="window.open('${pageContext.request.contextPath}/materialen/nieuwmateriaal', 'Nieuw materiaal', 'width=600,height=425,scrollbars=no,toolbar=no,location=no');
                return false" >Nieuw materiaal toevoegen</a>
        <br>
        <br>
        <a href="${pageContext.request.contextPath}">Terug naar hoofdmenu</a>
    </body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <title>Personenlijst</title>

       

    </head>


    <body>
        <h2>Personenlijst</h2>	
        <table class="list">
            <tr class="tabelheader">
                <td>id</td><td>Voornaam</td><td>Achternaam</td>
            </tr>
            <c:forEach items="${personen}" var="persoon">
                <tr  class="element" >
                    <td>${persoon.id}</td>
                    <td>${persoon.voornaam}</td>
                    <td>${persoon.achternaam}</td>
                    <td><input type="submit" onclick="location.href='${pageContext.request.contextPath}/personen/update-${persoon.id} '" name="wijzig" class="button" value="Details" /></td>
                    <td><input type="submit" onclick="location.href='${pageContext.request.contextPath}/personen/delete-${persoon.id} '" name="verwijder" class="button" value="Verwijder" /></td>
                   
                </tr>
            </c:forEach>
                <tr><td colspan="10"><a href="<c:url value='/personen/nieuwpersoon' />">Voeg nieuw persoon toe</a></td></tr>
        </table>
        <br/>
        
    </body>
</html>
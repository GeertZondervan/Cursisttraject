<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <title>Personenlijst</title>



    </head>


    <body>
        <h2>Studentenlijst</h2>	
        <table class="list">
            <tr class="tabelheader">
                <td>Voornaam</td><td>Achternaam</td><td>Begindatum</td><td>Einddatum</td>
            </tr>
            <c:forEach items="${studentenrollen}" var="persoonsrol">
                <tr  class="element" >
                    <td>${persoonsrol.persoon.voornaam}</td>
                    <td>${persoonsrol.persoon.achternaam}</td>
                    <td>${persoonsrol.id.begindatum}</td>
                    <td>${persoonsrol.einddatum}</td>
                    <td><input type="submit" onclick="location.href='${pageContext.request.contextPath}/studenten/update-${persoonsrol.persoon.id}-${persoonsrol.rol.id} '" name="wijzig" class="button" value="Details" /></td>
                </tr>
            </c:forEach>
        </table>

        <br>

        <a href="<c:url value='/' />">Terug naar hoofdmenu</a>

        <br/>

    </body>
</html>
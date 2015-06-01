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
        <h2>Toets Overzicht</h2>	
        <table>
            <tr class="tabelheader">

                <td>Toets naam</td>
                <td>Module</td>
                <td>Traject</td>
                <td>Stof</td>
                <td>Omschrijving</td>
                <td>Status</td>
                <td>Minimum Resultaat</td>
            </tr>
            <c:forEach items="${toetsen}" var="toets">
                <tr>
                    <td>${toets.naam}</td>
                    <td>${toets.module}</td>
                    <td>${toets.module.traject.naam}</td>
                    <td>${toets.stof}</td>
                    <td>${toets.omschrijving}</td>
                    <td>${toets.status}</td>
                    <td>${toets.minimumResultaat}</td>
                    <td><input type="submit" onclick="window.open('${pageContext.request.contextPath}/toetsen/update-toets-${toets.id}', 'Wijzig toets', 'width=600,height=425,scrollbars=no,toolbar=no,location=no');
                            return false" name="wijzig" class="button" value="Wijzig" /></td>
                    <td><input type="submit" onclick="window.open('${pageContext.request.contextPath}/toetsen/delete-toets-${toets.id}', 'Verwijder toets', 'width=600,height=425,scrollbars=no,toolbar=no,location=no');
                            return false" name="verwijder" class="button" value="Verwijder" /></td>

                    <td><p><input type="submit" onclick="location.href='${pageContext.request.contextPath}/toetsen/toets-resultaten-${toets.id}'" name="resultaten" class="button" value="Resultaten" /></p></td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <a href="${pageContext.request.contextPath}/toetsen/nieuwetoets" onclick="window.open('${pageContext.request.contextPath}/toetsen/nieuwetoets', 'Nieuwe toets', 'width=600,height=425,scrollbars=no,toolbar=no,location=no');
                return false" >Nieuwe toets toevoegen</a>
            <a href="<c:url value='/home' />">Home</a>
    </body>
</html>
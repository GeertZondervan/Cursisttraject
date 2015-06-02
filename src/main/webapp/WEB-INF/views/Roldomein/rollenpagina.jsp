<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <title>Rollenlijst</title>



    </head>


    <body>
        <h2>Rollenlijst</h2>	
        <table>
            <tr class="tabelheader">
                <td>Rol</td>
            </tr>
            <c:forEach items="${rollen}" var="rol">
                <tr>
                    <td>${rol.naam}</td>
                    
                    <td><input type="submit" onclick="location.href='${pageContext.request.contextPath}/rollen/updaterol-${rol.id} '" name="wijzig" class="button" value="Wijzig" /></td>
                    <td><input type="submit" onclick="location.href='${pageContext.request.contextPath}/rollen/deleterol-${rol.id} '" name="verwijder" class="button" value="Verwijder" /></td>
                   
                </tr>
            </c:forEach>
        </table>
        <br/>
        <a href="<c:url value='/rollen/nieuwerol' />">Voeg nieuwe rol toe</a><p>
    <a href="<c:url value='/home' />">Home</a>
    </body>
</html>
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
        <title>Expertises</title>


    </head>


    <body>
        <h2>Expertise overzicht</h2>	
        <table>
            <tr class="tabelheader">
                <td>Expertise naam</td>
                <td>Omschrijving</td>
                <td>Bijbehorende Module</td>
            </tr>
            <c:forEach items="${expertises}" var="expertise">
                <tr>
                    <td>${expertise.naam}</td>
                    <td>${expertise.omschrijving}</td>
                    <td>${expertise.module.omschrijving}</td>
                    
                    <td><input type="submit" onclick="location.href='${pageContext.request.contextPath}/expertises/update-expertise-${expertise.id} '" name="wijzig" class="button" value="Wijzig" /></td>
                    <td><input type="submit" onclick="location.href='${pageContext.request.contextPath}/expertises/delete-expertise-${expertise.id} '" name="verwijder" class="button" value="Verwijder" /></td>
                   
                </tr>
            </c:forEach>
        </table>
        <br/>
        <a href="<c:url value='/expertises/nieuwe-expertise' />">Voeg nieuwe expertise toe</a><p>
    <a href="<c:url value='/home' />">Home</a>
    </body>
</html>
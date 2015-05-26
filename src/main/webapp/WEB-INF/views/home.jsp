<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <title>RSVier Beheer hoofdmenu</title>
    </head>
    <body>
        <h2>Hoofdmenu</h2>
        <p><input type="submit" onclick="location.href='${pageContext.request.contextPath}/personen/'" class="hoofdmenubutton" value="Persoonsbeheer" /></p>
        <p><input type="submit" onclick="location.href='${pageContext.request.contextPath}/rollen/'" class="hoofdmenubutton" value="Rollenbeheer" /></p>
        <p><input type="submit" onclick="location.href='${pageContext.request.contextPath}/trajecten/'" class="hoofdmenubutton" value="Trajectenbeheer" /></p>
    </body>
</html>
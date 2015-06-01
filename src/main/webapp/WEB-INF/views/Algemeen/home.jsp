<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" />
        <title>RSVier Beheer hoofdmenu</title>
    </head>
    <body >
       
        <img src="${pageContext.request.contextPath}/resources/images/rsvier.png" alt="RSVIER" id="rsvierlogo">
         <h2>Hoofdmenu</h2>
        <p><input type="submit" onclick="location.href='${pageContext.request.contextPath}/personen/'" class="hoofdmenubutton" value="Persoonsbeheer" /></p>
        <p><input type="submit" onclick="location.href='${pageContext.request.contextPath}/rollen/'" class="hoofdmenubutton" value="Rollenbeheer" /></p>
        <p><input type="submit" onclick="location.href='${pageContext.request.contextPath}/trajecten/'" class="hoofdmenubutton" value="Trajectenbeheer" /></p>
        <p><input type="submit" onclick="location.href='${pageContext.request.contextPath}/expertises/'" class="hoofdmenubutton" value="Expertisebeheer" /></p>
        <p><input type="submit" onclick="location.href='${pageContext.request.contextPath}/toetsen/'" class="hoofdmenubutton" value="Toetsbeheer" /></p>
        <p><input type="submit" onclick="location.href='${pageContext.request.contextPath}/materialen/'" class="hoofdmenubutton" value="Materiaalbeheer" /></p>
    </body>
</html>

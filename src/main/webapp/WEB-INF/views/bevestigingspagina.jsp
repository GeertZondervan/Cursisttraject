<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Registratie bevestiging</title>
    </head>
    <body>
        <h2>Bewerking geslaagd</h2>
        <p>${succes}</p>
        <br/>
        <br/>
        <a href="<c:url value='/personen' />">Ga terug naar de persoonslijst</a>
        <br/>
        <br/>
        <a href="<c:url value='/rollen' />">Ga terug naar de rollenlijst</a>

    </body>

</html>
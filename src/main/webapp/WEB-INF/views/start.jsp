<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" <c:url value="/resources/css/main.css" />>
        <title>Startpagina</title>

        <style>
            tr:first-child{
                font-weight: bold;
                background-color: #C6C9C4;
            }
        </style>

    </head>


    <body>
        <h2>Lijst van personen</h2>	
        <table>
            <tr>
                <td>voornaam</td><td>achternaam</td>
            </tr>
            <c:forEach items="${personen}" var="persoon">
                <tr>
                    <td>${persoon.voornaam}</td>
                    <td>${persoon.achternaam}</td>
                </tr>
            </c:forEach>
        </table>
        <br/>
    </body>
</html>
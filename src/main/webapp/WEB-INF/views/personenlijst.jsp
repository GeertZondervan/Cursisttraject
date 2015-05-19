<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" <c:url value="/resources/css/main.css" />>
        <title>Personenlijst</title>

        <style>
            tr:first-child{
                font-weight: bold;
                background-color:mediumaquamarine;
            }
            tr{
                
            }
            td{
                padding:5px;
                border-bottom: 1px solid mediumaquamarine;
                
            }
            
        </style>

    </head>


    <body>
        <h2>Personenlijst</h2>	
        <table>
            <tr>
                <td>Voornaam</td><td>Achternaam</td>
            </tr>
            <c:forEach items="${personen}" var="persoon">
                <tr>
                    <td>${persoon.voornaam}</td>
                    <td>${persoon.achternaam}</td>
                    <td><input type="submit" onclick="location.href='update-${persoon.id} '" name="wijzig" class="button" value="Wijzig" /></td>
                    <td><input type="submit" onclick="location.href='delete-${persoon.id} '" name="verwijder" class="button" value="Verwijder" /></td>
                   
                </tr>
            </c:forEach>
        </table>
        <br/>
        <a href="<c:url value='/nieuwpersoon' />">Voeg nieuw persoon toe</a>
    </body>
</html>
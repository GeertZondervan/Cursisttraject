<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <title>Rollenlijst</title>

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
        <h2>Rollenlijst</h2>	
        <table>
            <tr>
                <td>Naam</td>
            </tr>
            <c:forEach items="${rollen}" var="rol">
                <tr>
                    <td>${rol.naam}</td>
                    
                    <td><input type="submit" onclick="location.href='updaterol-${rol.id} '" name="wijzig" class="button" value="Wijzig" /></td>
                    <td><input type="submit" onclick="location.href='deleterol-${rol.id} '" name="verwijder" class="button" value="Verwijder" /></td>
                   
                </tr>
            </c:forEach>
        </table>
        <br/>
        <a href="<c:url value='/nieuwerol' />">Voeg nieuwe rol toe</a>
    </body>
</html>
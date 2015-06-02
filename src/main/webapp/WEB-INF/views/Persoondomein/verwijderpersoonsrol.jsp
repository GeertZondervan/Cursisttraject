<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <title>Persoonsrol verwijderen</title>

        <style>

            .error {
                color: #ff0000;
            }
        </style>

    </head>

    <body>

        <h2>U staat op het punt de volgende rol te verwijderen:</h2>


        <form:form method="POST" modelAttribute="persoonsrol">
            <table>
                <tr>
                    <td><label for="persoonsrol.rol.naam">Rol: </label> </td>
                    <td>${persoonsrol.rol.naam}</td>
                </tr>
                <td>Uit de persoon:</td> 
                <tr>
                    <td><label for="persoonsrol.persoon.voornaam">Voornaam: </label> </td>
                    <td>${persoonsrol.persoon.voornaam}</td>
                </tr>
                <tr>
                    <td><label for="persoonsrol.persoon.achternaam">Achternaam: </label> </td>
                    <td>${persoonsrol.persoon.achternaam}</td>
                </tr>



                <tr>
                    <td colspan="3"><input type="submit" value="Bevestig"/></td>

                </tr>
            </table>
        </form:form>




    </body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <title>Nieuwe Expertise toevoegen</title>

        <style>

            .error {
                color: #ff0000;
            }
        </style>

    </head>

    <body>

        <h2>U staat op het punt het volgende materiaal te verwijderen:</h2>


        <form:form method="POST" modelAttribute="materiaal">
            <table>
                 <tr hidden>
                    <td><label for="Id">Id: </label> </td>
                     <td><form:input path="id"/></td>
                </tr>
                <tr>
                    <td><label for="titel">Titel: </label> </td>
                    <td>${materiaal.titel}</td>
                </tr>
                <tr>
                    <td><label for="auteur">Auteur: </label></td>
                    <td>${materiaal.auteur}</td>
                </tr>
                <tr>
                    <td><label for="omschrijving">Omschrijving: </label></td>
                    <td>${materiaal.omschrijving}</td>
                </tr>
                <tr>
                    <td><label for="url">Url: </label></td>
                    <td>${materiaal.url}</td>
                </tr>
                <tr>
                    <td><label for="isbn13">ISBN13: </label></td>
                    <td>${materiaal.isbn13}</td>
                </tr>
                <tr>
                    <td><label for="isbn10">ISBN13: </label></td>
                    <td>${materiaal.isbn10}</td>
                </tr>
                <tr>
                    <td colspan="3"><input type="submit" value="Bevestig"/></td>

                </tr>
            </table>
        </form:form>
        <br/>
        <br/>
    <td><input type="submit" onclick="window.close()" name="sluitvenster" class="button" value="Sluit venster" /></td>
</body>
</html>

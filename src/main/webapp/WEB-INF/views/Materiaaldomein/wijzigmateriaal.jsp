
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

        <h2>Materiaal verwijderen</h2>

        <form:form method="POST" modelAttribute="materiaal">
            <table>

                <tr>
                    <td><label for="titel">Titel: </label> </td>
                    <td><form:input path="titel" id="titel" required="true"/></td>
                    <td><form:errors path="titel" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="auteur">Auteur: </label> </td>
                    <td><form:input path="auteur" id="auteur" required="true"/></td>
                    <td><form:errors path="auteur" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="omschrijving">Omschrijving: </label> </td>
                    <td><form:input path="omschrijving" id="omschrijving"/></td>
                    <td><form:errors path="omschrijving" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="url">Url: </label> </td>
                    <td><form:input type="url" path="url" id="url"/></td>
                    <td><form:errors path="url" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="isbn13">ISBN13: </label> </td>
                    <td><form:input path="isbn13" id="isbn13"/></td>
                    <td><form:errors path="isbn13" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="isbn10">ISBN10: </label> </td>
                    <td><form:input path="isbn10" id="isbn10"/></td>
                    <td><form:errors path="isbn10" cssClass="error"/></td>
                </tr>

                <td colspan="3"><input type="submit" value="Wijzigen"/></td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
<td><input type="submit" onclick="window.close()" name="sluitvenster" class="button" value="Sluit venster" /></td>
</body>
</html>

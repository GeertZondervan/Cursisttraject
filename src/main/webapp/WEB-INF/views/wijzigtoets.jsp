<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <title>Toets wijzigen</title>

        <style>

            .error {
                color: #ff0000;
            }
        </style>

    </head>

    <body>

        <h2>Toets wijzigen</h2>


        <form:form method="POST" modelAttribute="toets">

            <table>
                <tr><td>Module: </td>
                    <td>
                        <form:select path="module.id">  
                            <form:option value="0">Geen module</form:option>
                            <form:options items="${modules}" itemValue="id" itemLabel="omschrijving" />  
                        </form:select>  

                    </td>  
                </tr> 
                <tr>
                    <td><label for="naam">Naam: </label> </td>
                    <td><form:input path="naam" id="naam"/></td>
                    <td><form:errors path="naam" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="stof">Stof: </label> </td>
                    <td><form:input path="stof" id="omschrijving"/></td>
                    <td><form:errors path="stof" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="status">Status: </label> </td>
                    <td><form:input path="status" id="omschrijving"/></td>
                    <td><form:errors path="status" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="omschrijving">Omschrijving: </label> </td>
                    <td><form:input path="omschrijving" id="omschrijving"/></td>
                    <td><form:errors path="omschrijving" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="minimumResultaat">Minimum Resultaat: </label> </td>
                    <td><form:input path="minimumResultaat" id="omschrijving"/></td>
                    <td><form:errors path="minimumResultaat" cssClass="error"/></td>
                </tr>
                <tr>
                <tr>
                    <td colspan="3"><input type="submit" value="Update"/></td>
                </tr>
            </table>
        </form:form>


        <br/>
        <br/>
        <a href="<c:url value='/toetsen' />">Ga terug naar toets overzicht</a>
    </body>
</html>
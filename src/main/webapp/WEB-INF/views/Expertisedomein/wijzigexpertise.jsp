<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <title>Expertise wijzigen</title>

        <style>

            .error {
                color: #ff0000;
            }
        </style>

    </head>

    <body>

        <h2>Expertise wijzigen</h2>


        <form:form method="POST" modelAttribute="expertise">

            <table>
                <tr>
                    <td><label for="naam">Naam: </label> </td>
                    <td><form:input path="naam" id="naam"/></td>
                    <td><form:errors path="naam" cssClass="error"/></td>
                </tr>

                <tr>
                    <td><label for="omschrijving">Omschrijving: </label> </td>
                    <td><form:input path="omschrijving" id="omschrijving"/></td>
                    <td><form:errors path="omschrijving" cssClass="error"/></td>
                </tr>
                <tr>

                <tr><td>Module: </td>
                    <td>
                        <form:select path="module.id">  
                            <form:option value="0">Geen module</form:option>
                            <form:options items="${modules}" itemValue="id" itemLabel="omschrijving" />  
                        </form:select>  

                    </td>  
                </tr> 
                <tr>
                    <td colspan="3"><input type="submit" value="Update"/></td>
                </tr>
            </table>
        </form:form>


        <br/>
        <br/>
        <a href="<c:url value='/expertises' />">Ga terug naar expertise overzicht</a>
    </body>
</html>
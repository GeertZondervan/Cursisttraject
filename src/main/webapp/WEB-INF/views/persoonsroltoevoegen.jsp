<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
         <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <title>Updatenwijzigingenform</title>

        <style>

            .error {
                color: #ff0000;
            }
        </style>

    </head>

    <body>

        <h2>Persoonsrol toevoegen voor ${persoon.voornaam} ${persoon.achternaam}</h2>

        <form:form modelAttribute="persoon">
            <table>
            <c:forEach items="${rollen}" var="rol">
                <tr  class="element" >
                    <td>${rol.id}</td>
                    <td>${rol.naam}</td>
                                      
                    <td><button type="submit" name="nieuwepersoonsrol" value="${rol.id}">Voeg toe </button></td>
                </tr>
            </c:forEach>
               
            </table>
        </form:form>

        <br/>





        <br/>
        <br/>
        Go back to <a href="<c:url value='/personen/' />">List of All Employees</a>
    </body>
</html>
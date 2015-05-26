<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Updatenwijzigingenform</title>

        <style>

            .error {
                color: #ff0000;
            }
        </style>

    </head>

    <body>

        <h2>Persoonsrol toevoegen voor ${persoon.voornaam} ${persoon.achternaam}</h2>

        <form:form method="POST" modelAttribute="persoonsrol">

            <table>
                <tr>
                    <td>Rol:</td><td><form:select items="${rollen}" path="rol" /></td>
                </tr>
                
                <tr>
                    <td colspan="3"><input type="submit"  value="Update"/></td>
<!--                    onclick="location.href='${pageContext.request.contextPath}/personen/${persoon.id}-persoonsroltoevoegen '" 
                                           class="button" name ="update"-->
                </tr>
            </table>
        </form:form>

        <br/>


        


        <br/>
        <br/>
        Go back to <a href="<c:url value='/personen/' />">List of All Employees</a>
</body>
</html>
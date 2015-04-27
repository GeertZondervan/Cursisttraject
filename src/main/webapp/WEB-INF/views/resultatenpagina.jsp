<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Updatenwijzigingenformkut</title>

        <style>

            .error {
                color: #ff0000;
            }
        </style>

    </head>

    <body>

        <h2>Resultaten voor ${persoon.voornaam} ${persoon.achternaam}</h2>

        <table>
            <tr>
                <td>Modulenaam </td><td>Resultaat </td><td>Voldoende</td>
            </tr>

            <c:forEach items="${resultaten}" var="resultaat">
                <form:form method = "POST" modelAttribute="resultaat" value = "resultaat.id">
                    <tr>

                        <td>${resultaat.modulenaam}</td>
                        <td>${resultaat.resultaat}</td>
                        <td>${resultaat.voldoende}</td>
                        <td><button type="submit" name="verwijder" id = "verwijder" value="${resultaat.id}">Verwijder</td>

                    </tr>
                </form:form>
            </c:forEach>


        </table>
        <br/>
        <br/>
        <h3>Resultaat toevoegen</h2>

        <form:form method="POST" modelAttribute="resultaat">
            <table>

                <tr>
                    <td><label for="modulenaam">Modulenaam: </label> </td>
                    <td><form:input path="modulenaam" id="modulenaam"/></td>
                    <td><form:errors path="modulenaam" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="resultaat">Resultaat: </label> </td>
                    <td><form:input path="resultaat" id="resultaat"/></td>
                    <td><form:errors path="resultaat" cssClass="error"/></td>
                </tr>







                <tr>
                    <td><button type="submit" name="voegtoe" id = "voegtoe" value="${persoon.id}">Voegtoe</td>
                </tr>
            </table>
        </form:form>


        <br/>
        <br/>
        Go back to <a href="<c:url value='/list' />">List of All Employees</a>
</body>
</html>
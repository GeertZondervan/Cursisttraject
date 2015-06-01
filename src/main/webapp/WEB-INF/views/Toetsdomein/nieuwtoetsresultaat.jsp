<%-- 
    Document   : nieuweexpertise
    Created on : May 27, 2015, 3:15:19 PM
    Author     : Geert
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <title>Nieuwe Toets toevoegen</title>

        <style>

            .error {
                color: #ff0000;
            }
        </style>

    </head>

    <body>

        <h2>Nieuw toetsresultaat toevoegen voor ${toetsresultaat.toets.naam}</h2>

        <form:form method="POST" modelAttribute="toetsresultaat">
            <table>
                <tr><td>Persoon: </td>
                    <td>
                        <form:select path="id.persoonsrolPersoonId">      
                            <form:options items="${personen}" itemValue="id" itemLabel="volledigeNaam"/>  
                        </form:select>  

                    </td>  

                </tr> 


                <tr>
                    <td><label for="datum">Datum: </label> </td>
                    <td><form:input path="datum" id="datum" type="localdate" /></td>
                    <td><form:errors path="datum" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="resultaat">Resultaat: </label> </td>
                    <td><form:input path="resultaat" type="float" id="resultaat" /></td>
                    <td><form:errors path="resultaat" cssClass="error"/></td>
                </tr>

                <td colspan="3"><input type="submit" value="Register"/></td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Go back to <a href="<c:url value='/toetsen/' />">Terug naar toets overzicht</a>
</body>
</html>

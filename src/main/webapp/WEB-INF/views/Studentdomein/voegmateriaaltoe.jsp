<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
        <title>Nieuw materiaal toevoegen voor ${persoonsrolHeeftMateriaal.persoonsrol.persoon.volledigeNaam}</title>

        <style>

            .error {
                color: #ff0000;
            }
        </style>

    </head>

    <body>

        <h2>Nieuw materiaal toevoegen voor ${persoonsrolHeeftMateriaal.persoonsrol.persoon.volledigeNaam}</h2>

        <form:form method="POST" modelAttribute="persoonsrolHeeftMateriaal">
            <table>
                
                 <form:select path="materiaal.id">      
                            <form:options items="${materialen}" itemValue="id" itemLabel="titel"/>  
                        </form:select>  
                
                <tr>
                    <td colspan="3"><input type="submit" value="Register"/></td>
                </tr>
            </table>
        </form:form>
        <br/>
        <br/>
        Go back to <a href="<c:url value='/rollen/' />">Terug naar rollenlijst</a>
    </body>
</html>
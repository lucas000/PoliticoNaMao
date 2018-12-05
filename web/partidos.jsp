<%-- 
    Document   : gastos
    Created on : 10/11/2018, 21:13:05
    Author     : Lucas
--%>
<%@page import="Consultas.TesteQueriesDeputados"%>
<%@page import="Modelos.Estado"%>
<%@page import="Modelos.Partidos "%>
<%@page import="java.util.List"%>
<%@page import="Consultas.TesteQueriesPartidos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Político na mão</title>
        <link rel="stylesheet" href="../../../PoliticoNaMao/resources/node_modules/bootstrap/compiler/bootstrap.css"/>
    
    </head>
    <body>
       <%@include file="barraMenu.jsp" %>
        
        <div class="ml-3 mt-5">

            <div class="container">
                <h5 class="display-5">Partidos</h5>
               
                
                           
                     <div class="md-12">
                        <form>
                            <table class="table table-hover table-sm">
                            <thead>
                                <tr>
                                    <th scope="col">Sigla</th>
                                    <th scope="col">Nome</th>
                                    <th scope="col">Informações</th>
                            
                                </tr>
                            </thead>
                            <tbody>

                            <c:forEach var="partidos" items="${partidos}">
                                <tr>
                                    <td><a href='<c:url value="/faces/DeputadoServlet?estados=Todos&partidos=${partidos.sigla}"/>' class="alert-link-link">${partidos.sigla}</a></td>
                                    <td>${partidos.nome}</td>
                                    <td><a href='<c:url value="/faces/FichaPartidoServlet?sigla=${partidos.sigla}"/>' class="alert-link-link">Info</a></td>
                                 </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </form>
                </div>
                    
                  
            </div>
        </div>

        <%@include file="quemSomos.jsp" %>
    <script src="../../../PoliticoNaMao/resources/node_modules/jquery/dist/jquery.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/popper.js/dist/umd/popper.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/bootstrap/dist/js/bootstrap.js"></script>
   
    </body>
</html>
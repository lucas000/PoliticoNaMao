<%-- 
    Document   : gastos
    Created on : 10/11/2018, 21:13:05
    Author     : Lucas
--%>
<%@page import="Modelos.Partidos "%>
<%@page import="java.util.List"%>
<%@page import="Consultas.TesteQueriesPartidos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <p>Filtrar por:</p>
                <table class="table table-hover table-sm" id="example">
                    <thead>
                        <tr>
                            <th scope="col">Sigla</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Uri</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                            <%
                                TesteQueriesPartidos query = new TesteQueriesPartidos();
                                
                                List<Partidos> partidos = query.buscaPartidos();
                                
                                for (Object partido : partidos) {
                                    Partidos d = (Partidos) partido;
                                    
                                    out.print("<tr id='" + d.getId()+ "'>");
                                    out.print("<td Sigla='row'>" + d.getSigla()+ "</td>");
                                    out.print("<td Nome='row'>" + d.getNome() + "</td>");
                                    out.print("<td URI='row'>" + d.getUri()+ "</td>");
                                    out.print("</tr>");
                                }
                            %>
                    </tbody>
                </table>
            </div>
        </div>

        <%@include file="quemSomos.jsp" %>
    <script src="../../../PoliticoNaMao/resources/node_modules/jquery/dist/jquery.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/popper.js/dist/umd/popper.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/bootstrap/dist/js/bootstrap.js"></script>
   
    </body>
</html>
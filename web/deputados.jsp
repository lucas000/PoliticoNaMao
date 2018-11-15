<%-- 
    Document   : deputados
    Created on : 10/11/2018, 20:58:58
    Author     : Lucas
--%>

<%@page import="Modelos.Deputados"%>
<%@page import="java.util.List"%>
<%@page import="Consultas.TesteQueriesDeputados"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Político na mão</title>
        <link rel="stylesheet" href="../../../resources/TrabalhoAvaliativo3/node_modules/bootstrap/compiler/bootstrap.css"/>

    </head>
    <body>
        <%@include file="barraMenu.jsp" %>

        <div class="ml-3 mt-5">

            <div class="container">
                <h5 class="display-5">Deputados</h5>
                <p>Filtrar por:</p>
                <table class="table table-hover table-sm">
                    <thead>
                        <tr>
                            <th scope="col">Nome</th>
                            <th scope="col">Partido</th>
                            <th scope="col">Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                            <%
                                TesteQueriesDeputados query = new TesteQueriesDeputados();
                                
                                List<Deputados> deputados = query.buscaDeputados();
                                
                                for (Object deputado : deputados) {
                                    Deputados d = (Deputados) deputado;
                                    
                                    out.print("<tr>");
                                    out.print("<td scope='row'>" + d.getNome() + "</td>");
                                    out.print("<td scope='row'>" + d.getPartido()+ "</td>");
                                    out.print("<td scope='row'>" + d.getUf()+ "</td>");
                                    out.print("</tr>");
                                }
                            %>
                    </tbody>
                </table>
            </div>
        </div>

        <%@include file="quemSomos.jsp" %>
        <script src="../../../TrabalhoAvaliativo3/resources/node_modules/jquery/dist/jquery.js"></script>
        <script src="../../../TrabalhoAvaliativo3/resources/node_modules/popper.js/dist/umd/popper.js"></script>
        <script src="../../../TrabalhoAvaliativo3/resources/node_modules/bootstrap/dist/js/bootstrap.js"></script>
    </body>
</html>

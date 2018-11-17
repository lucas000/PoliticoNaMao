<%-- 
    Document   : deputados
    Created on : 10/11/2018, 20:58:58
    Author     : Lucas
--%>

<%@page import="Modelos.Estado"%>
<%@page import="Modelos.Deputados"%>
<%@page import="java.util.List"%>
<%@page import="Consultas.TesteQueriesDeputados"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Político na mão</title>
        <link rel="stylesheet" href="../../../PoliticoNaMao/resources/node_modules/bootstrap/compiler/bootstrap.css"/>
        <script src="../../../PoliticoNaMao/resources/node_modules/jquery/dist/jquery.js"></script>
    
    </head>
    <body>
        <%@include file="barraMenu.jsp" %>
        <div class="ml-1 mt-2">

            <div class="container">
                <h5 class="display-5">Deputados</h5>
                <form action="DeputadoServelt" class="form-row">
                 <p class="form-group mr-2 mt-2">Estados</p>
                  <div class="form-group">
                    <select class="form-control md-1" name="estado" id="estados" onchange="estado(this.value);">
                        <option>Todos</option>
                        <%
                                TesteQueriesDeputados estado = new TesteQueriesDeputados();
                                
                                List<Estado> estados = estado.buscaEstado();
                                
                                
                                for (Object deputado : estados) {
                                    Estado est = (Estado) deputado;
                                    out.print("<option value='" + est.getUf() + "'>" + est.getUf() + "</option>");
                                }
                            %>
                    </select>
                  </div>
                 <p class="form-group ml-2 mr-2">Partidos</p>
                    <div class="form-group">
                    <select class="form-control md-1" name="partido" id="partidos" onchange="partido();">
                        <a class="dropdown-item" href="#">DEM</a>
                            <option>Todos</option>
                            <option>AVANTE</option>
                            <option>MDB</option>
                            <option>PATRI</option>
                            <option>PCdoB</option>
                            <option>PDT</option>
                            <option>PHS</option>
                            <option>PODE</option>
                            <option>PP</option>
                            <option>PPL</option>
                            <option>PRB</option>
                            <option>PROS</option>
                            <option>PSB</option>
                            <option>PSC</option>
                            <option>PSD</option>
                            <option>PSDB</option>
                            <option>PSL</option>
                            <option>PT</option>
                            <option>PTB</option>
                            <option>PV</option>
                            <option>REDE</option>
                            <option>SD</option>
                    </select>
                  </div>
                 <div class="form-group">
                    <button type="submit" class="btn btn-default ml-2">Ordenar</button>
                 </div>
                </form>
                    
                <table class="table table-hover table-sm" id="example">
                    <thead>
                        <tr>
                            <th scope="col">Nome</th>
                            <th scope="col">Partido</th>
                            <th scope="col">Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="deputado" items="${deputados}">
                                <tr>
                                    <td scope='row'>${deputado.nome}</td>
                                    <td scope='row'>${deputado.partido}</td>
                                    <td scope='row'>${deputado.uf}</td>
                                </tr>
                            </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <%@include file="quemSomos.jsp" %>
    <script src="../../../PoliticoNaMao/resources/js/deputados.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/jquery/dist/jquery.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/popper.js/dist/umd/popper.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/bootstrap/dist/js/bootstrap.js"></script>
    </body>
</html>
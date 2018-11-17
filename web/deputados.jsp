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
                <p>Filtrar por:</p>
                <form class="form-row">
                 <p class="form-group mr-2 mt-2">Estados</p>
                  <div class="form-group">
                    <select class="form-control md-1" id="exampleFormControlSelect1">
                        <%
                                TesteQueriesDeputados estado = new TesteQueriesDeputados();
                                
                                List<Estado> estados = estado.buscaEstado();
                                
                                for (Object deputado : estados) {
                                    Estado est = (Estado) deputado;
                                    out.print("<option>" + est.getUf() + "</option>");
                                }
                            %>
                    </select>
                  </div>
                 <p class="form-group ml-2 mr-2">Partidos</p>
                    <div class="form-group">
                    <select class="form-control md-1" id="exampleFormControlSelect2">
                        <a class="dropdown-item" href="#">DEM</a>
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
                </form>
                    <!--Partidos-->
                    <!--
                    <div class="dropdown ml-1">
                        <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Todos os artidos
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="#">DEM</a>
                            <a class="dropdown-item" href="#">AVANTE</a>
                            <a class="dropdown-item" href="#">MDB</a>
                            <a class="dropdown-item" href="#">PATRI</a>
                            <a class="dropdown-item" href="#">PCdoB</a>
                            <a class="dropdown-item" href="#">PDT</a>
                            <a class="dropdown-item" href="#">PHS</a>
                            <a class="dropdown-item" href="#">PODE</a>
                            <a class="dropdown-item" href="#">PP</a>
                            <a class="dropdown-item" href="#">PPL</a>
                            <a class="dropdown-item" href="#">PRB</a>
                            <a class="dropdown-item" href="#">PROS</a>
                            <a class="dropdown-item" href="#">PSB</a>
                            <a class="dropdown-item" href="#">PSC</a>
                            <a class="dropdown-item" href="#">PSD</a>
                            <a class="dropdown-item" href="#">PSDB</a>
                            <a class="dropdown-item" href="#">PSL</a>
                            <a class="dropdown-item" href="#">PT</a>
                            <a class="dropdown-item" href="#">PTB</a>
                            <a class="dropdown-item" href="#">PV</a>
                            <a class="dropdown-item" href="#">REDE</a>
                            <a class="dropdown-item" href="#">SD</a>
                        </div>
                    </div>
                    -->
                    
                    <!-- Estados-->
                    <!--
                    <div class="dropdown ml-1">
                        <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Todos os estados
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" id="item">
                            <%
                                //TesteQueriesDeputados estado = new TesteQueriesDeputados();
                                
                                //List<Estado> estados = estado.buscaEstado();
                                
                                for (Object deputado : estados) {
                                    Estado est = (Estado) deputado;
                                    //out.print("<a class='dropdown-item' href='#'>" + est.getUf() + "</a>");
                                }
                            %>
                        </div>
                    </div>
                        -->
                <table class="table table-hover table-sm" id="example">
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
                                    
                                    out.print("<tr id='" + d.getIdParlamentar() + "'>");
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
    <script src="../../../PoliticoNaMao/resources/js/deputados.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/jquery/dist/jquery.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/popper.js/dist/umd/popper.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/bootstrap/dist/js/bootstrap.js"></script>
    </body>
</html>
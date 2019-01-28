<%-- 
    Document   : descricaoProposicao
    Created on : 03/12/2018, 11:44:17
    Author     : Vicom
--%>

<%@page import="Modelos.ProposicaoAutor"%>
<%@page import="Consultas.TesteQueriesProposicao"%>
<%@page import="Modelos.Proposicao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%int x = 10;%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Descrição Proposicao</title>
        <link rel="stylesheet" href="../../../PoliticoNaMao/resources/node_modules/bootstrap/compiler/bootstrap.css"/>
    </head>
    <body>



        <%@include file="barraMenu.jsp" %>
        <br>

        <%

            TesteQueriesProposicao b = new TesteQueriesProposicao();
            int id = Integer.parseInt(request.getParameter("idproposicao"));
            ProposicaoAutor pa = b.buscaProposicaoautor(id);
            Proposicao p = b.buscaProposicao(id);

        %>
        <h5 class="display-5" style="text-align: center;color: blue">Descrição Proposição(<%out.print(id);%>)</h5>
        <table style="width: 100% ; border: 1px solid black;" class="table table-hover table-sm">

            <tr>
                <th style="width: 20%;"  s scope="col">ID</th>
                <th scope="col" style="font-family: initial"><%out.print(p.getId());%></th>
            </tr>
            <tr>
                <th s scope="col">Data</th>
                <th scope="col" style="font-family: initial"><%out.print(p.getDataApresentacao());%></th>
            </tr>
            <tr>
                <th s scope="col">ID Tipo</th>
                <th scope="col" style="font-family: initial"><%out.print(p.getIdTipo());%></th>
            </tr>
            <tr>
                <th s scope="col">Número</th>
                <th scope="col" style="font-family: initial"><%out.print(p.getNumero());%></th>
            </tr>
            <tr>
                <th s scope="col">Uri</th>
                <th scope="col" style="font-family: initial"><%out.print(p.getUri());%></th>
            </tr>
            <tr>
                <th s scope="col">Uri Orgao Numerador</th>
                <th scope="col" style="font-family: initial"><%out.print(p.getUriOrgaoNumerador());%></th>
            </tr>
            <tr>
                <th s scope="col">Url Inteiro Teor</th>
                <th scope="col" style="font-family: initial"<%out.print(p.getUrlInteiroTeor());%><</th>
            </tr>
            <tr>
                <th s scope="col">Autor</th>
                <th scope="col" style="font-family: initial"><%out.print(pa.getNomeAutor());%></th>
            </tr>
            <tr>
                <th s scope="col">Partido</th>
                <th scope="col" style="font-family: initial"><%out.print(pa.getSiglaPartidoAutor());%></th>
            </tr>
            <tr>
                <th s scope="col">Uri Partido</th>
                <th scope="col" style="font-family: initial"><%out.print(pa.getUriPartidoAutor());%></th>
            </tr>
            <tr>
                <th scope="col">Ementa</th>
                <th scope="col" style="font-family: initial;text-align: justify"><%out.print(p.getEmenta());%></th>
            </tr>

        </table>
        <br>
        <br>
        <br>
        <br>
        <hr>

        <script src="../../../PoliticoNaMao/resources/node_modules/jquery/dist/jquery.js"></script>
        <script src="../../../PoliticoNaMao/resources/node_modules/popper.js/dist/umd/popper.js"></script>
        <script src="../../../PoliticoNaMao/resources/node_modules/bootstrap/dist/js/bootstrap.js"></script>
    </body>
</html>

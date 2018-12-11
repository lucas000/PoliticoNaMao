<%-- 
    Document   : index
    Created on : 10/11/2018, 21:06:20
    Author     : Lucas
--%>

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
        <div class="card mt-5" style="width: 100%;" align="center">
            <div class="card-body">
                <h5 class="card-title">O que é o Político na mão?</h5>
                <p class="card-text">Somos uma equipe que busca disceminar informações sobre deputados, partidos e proposições do Brasil.<br>
                Atualmente temos dados de 513 deputados, todos os partidos que estão na câmara dos deputados e proposições de
                1934 até 2018.</p>
            </div>
        </div>
        
        <div class="card mt-5" style="width: 100%;" align="center">
            <div class="card-body">
                <h5 class="card-title">Como usar?</h5>
                <p class="card-text">Para utilizar nosso sistema você deve clicar em umas das opções na barra de menu acima.<br>
                Ao clicar em Deputado você verá todos os deputados em exercício no Brasil, podendo também ordenar por estado e partido.
                <br>A cada deputado temos mais informações que podem ser acessadas clicando no nome.<br>
                Ao clicar em Partido terá informações dos partidos que estão na câmara, você pode também ordenar e clicando no link info você verá mais informações do partido.<br>
                Na opção de Proposições mostrára todas as proposições que passaram pela câmara, podendo ordenar por ano.
                <br>Ao clicar no id da proposta você terá mais informações sobre a proposta.
                </p>
            </div>
        </div>
        <br>
        <br>
        <%@include file="footer.jsp" %>
    <script src="../../../PoliticoNaMao/resources/node_modules/jquery/dist/jquery.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/popper.js/dist/umd/popper.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/bootstrap/dist/js/bootstrap.js"></script>
    </body>
</html>

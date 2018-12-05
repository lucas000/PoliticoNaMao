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
        
        <div align="center">
            <h5 class="display-5 mt-3">Index</h5>
        </div>
        
        <%@include file="quemSomos.jsp" %>
        <div class="card mt-5" style="width: 100%;" align="center">
            <div class="card-body">
                <h5 class="card-title">Você sabia?</h5>
                <p class="card-text">Que o deputado ABEL MESQUITA JR. gastou com combustiveis 344.444.77 R$ em 2018.</p>
            </div>
        </div>
        
    <script src="../../../PoliticoNaMao/resources/node_modules/jquery/dist/jquery.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/popper.js/dist/umd/popper.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/bootstrap/dist/js/bootstrap.js"></script>
    </body>
</html>

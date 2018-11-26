<%-- 
    Document   : fichapartidos
    Created on : 22/11/2018, 09:24:05
    Author     : Allan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ficha do Partido</title>
        <link rel="stylesheet" href="../../../PoliticoNaMao/resources/node_modules/bootstrap/compiler/bootstrap.css"/>
    
    </head>
    <body>
        <%@include file="barraMenu.jsp" %>
        
        <div class="mt-3 ml-2 mr-2">
            <div class="card-deck">
                <div class="card">
                <img class="card-img-top" src='${fpartidoss.urlFoto}' alt="Card image cap">
                <div class="card-body">
                    <p class="card-text">Nome: ${fpartidoss.nome}</p>
                    <p class="card-text">Partido/Estado: ${fpartidoss.partido}/${fpartidoss.uf}</p>
                 </div>
            </div>
       
          </div>
        </div>
        <br>
        <%@include file="quemSomos.jsp" %>
        <script src="../../../PoliticoNaMao/resources/node_modules/jquery/dist/jquery.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/popper.js/dist/umd/popper.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/bootstrap/dist/js/bootstrap.js"></script>
    </body>
</html>

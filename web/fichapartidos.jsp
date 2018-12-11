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
        
        <div class="container mt-3">
            <div class="col-sm-2"></div>
                <div class="col-sm-8">
            <div class="card-deck">
                <div class="card">
                    <h5 class="card-title">Partido:</h5>
                     <div class="mt-3 ml-2 mr-2">
                <div class="card">
                <img class="card-img-top" src='${fpartidoss.urlLogo}' alt="Card image cap">
                <div class="card-body">
                    <p class="card-text">Nome: ${fpartidoss.nome}</p>
                    <p class="card-text">Sigla/UF: ${fpartidoss.sigla}/${fpartidoss.uf}</p>
                    <p class="card-text">Situação atual: ${fpartidoss.situacao}</p>
                    <p class="card-text">Qtd. de Membros: ${fpartidoss.totalMembros}</p>
                 </div>
                 </div>
                 </div>
            </div>
       
          
                 
        <div class="card">
            <h5 class="card-title">Lider:</h5>
                 <div class="mt-3 ml-2 mr-2">
            
                <div class="card">
                <img class="card-img-top" src='${fpartidoss.urlFoto}' alt="Card image cap">
                <div class="card-body">
                   <p>Nome:  <a href='<c:url value="/faces/fichaParlamentar?nome=${fpartidoss.nomel}"/>' class="alert-link-link">${fpartidoss.nomel}</a></p>
                    <p class="card-text">Cargo: Lider do Partido</p>
                   
                 </div>
            </div>
       
          
        </div>
        </div>
                    </div>
        </div>
        </div>
        <br>
        <%@include file="footer.jsp" %>
        <script src="../../../PoliticoNaMao/resources/node_modules/jquery/dist/jquery.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/popper.js/dist/umd/popper.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/bootstrap/dist/js/bootstrap.js"></script>
    </body>
</html>

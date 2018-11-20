<%-- 
    Document   : fichaParlamentar
    Created on : 15/11/2018, 16:14:50
    Author     : Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ficha parlamentar</title>
        <link rel="stylesheet" href="../../../PoliticoNaMao/resources/node_modules/bootstrap/compiler/bootstrap.css"/>
    
    </head>
    <body>
        <%@include file="barraMenu.jsp" %>
        
        <c:out value="${nome}"/>
        <c:out value="${deputadoss.uf}"/>
        <c:out value="${deputadoss.gabinete}"/>
        <div class="mt-3 ml-2 mr-2">
            <div class="card-deck">
                <div class="card">
                <img class="card-img-top" src="http://www.camara.gov.br/internet/deputado/bandep/160587.jpg" alt="Card image cap">
                <div class="card-body">
                    <p class="card-text">Nome parlamentar</p>
                    <p class="card-text">PPP/PP</p>
                 </div>
            </div>
            <div class="card">
              <div class="card-body">
                  <h5 class="card-title">Ficha parlamentar</h5>
                  <hr>
                  <p class="card-text">Telefone: 3333-1122</p>
                  <p class="card-text">Email: email@email.com</p>
                  </div>
            </div>
            <div class="card">
              <div class="card-body">
                  <h5 class="card-title">Informações</h5>
                  <hr>
                  <p class="card-text">Gastos: R$ 857.129,91</p>
                  <p class="card-text">Propostas: 91 <a href="propostas.jsp">Ver propostas</a></p>
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

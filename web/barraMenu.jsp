<%-- 
    Document   : barraMenu
    Created on : 10/11/2018, 20:10:08
    Author     : Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Político na mão</title>
        <link rel="stylesheet" href="../../../PoliticoNaMao/resources/node_modules/bootstrap/compiler/bootstrap.css"/>
    
    </head>
    <body>
        <nav class="navbar navbar-expand-lg  navbar-light bg-light"> 
            <a class="navbar-brand" href="index.jsp">Político na mão</a> 
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> 
                <span class="navbar-toggler-icon">
                </span> 
            </button> 

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto"> 
                    <li class="nav-item">
                        <a class="nav-link" href='<c:url value="faces/DeputadoServlet?estados=Todos&partidos=Todos"/>'>Deputados</a> 
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href='<c:url value="/faces/PartidoServlet"/>'>Partidos</a>
                    </li> 
                    <li class="nav-item">
                        <a class="nav-link" href="propostas.jsp">Proposições</a> 
                    </li> 
                </ul> 
            </div> 
        </nav>
        
        <script src="../../../PoliticoNaMao/resources/node_modules/jquery/dist/jquery.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/popper.js/dist/umd/popper.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/bootstrap/dist/js/bootstrap.js"></script>
    </body>
</html>

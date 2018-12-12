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
        <div>
            <div class="row mt-3">
                <div class="col-sm-2"></div>
                <div class="col-sm-8"><h5 class="display-5">Seus deputados favoritos ${usuario.nome}</h5></div>
                <div class="col-sm-2"></div>
            </div>
            
            <div class="row">
            <div class="col-2"></div>

            <div class="col-8">
                <form>
                    <table class="table table-hover table-sm">
                        <thead>
                            <tr>
                                <th scope="col">Nome</th>
                                <th scope="col">Partido</th>
                                <th scope="col">Estado</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="favorito" items="${favoritos}">
                                <tr>
                                    <td><a href='<c:url value="/faces/fichaParlamentar?nome=${favorito.nomeParlamentar}"/>' class="alert-link-link">${favorito.nome}</a></td>
                                    <td>${favorito.partido}</td>
                                    <td>${favorito.estado}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </form>
            </div>
            <div class="col-2"></div>
        </div>  
        </div>
        <%@include file="footer.jsp" %>
        <script src="../../../PoliticoNaMao/resources/node_modules/jquery/dist/jquery.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/popper.js/dist/umd/popper.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/bootstrap/dist/js/bootstrap.js"></script>
    </body>
</html>

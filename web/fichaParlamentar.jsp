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
        <div class="container mt-2" align="center">
            <form action="UsuarioServlet?cmd=addFavorito&nome=${deputadoss.nome}&nomeParlamentar=${deputadoss.nomeParlamentar}&partido=${deputadoss.partido}&estado=${deputadoss.uf}&nomeSeguidor=${usuario.email}" method="POST" >
                <button type="submit" class="btn btn-primary" >Adicionar aos favoritos</button>
            </form>
        </div>
        <div class="container mt-2">
            <div class="row">
                <div class="col-sm-2"></div>
                <div class="col-sm-8">
                <div class="card-deck">
                    <div class="card">
                    <img class="card-img-top" src='${deputadoss.urlFoto}' alt="Foto deputado">
                    <div class="card-body">
                        <p class="card-text">Nome: ${deputadoss.nome}</p>
                        <p class="card-text">Partido: ${deputadoss.partido}</p>
                        <p class="card-text">Estado: ${deputadoss.uf}</p>
                        <p class="card-text">Anexo: ${deputadoss.anexo}</p>
                        <p class="card-text">Gabinete: ${deputadoss.gabinete}</p>
                     </div>
                </div>
                <div class="card">
                  <div class="card-body">
                      <h5 class="card-title">Ficha parlamentar</h5>
                      <hr>
                      <p class="card-text">Telefone: ${deputadoss.fone}</p>
                      <p class="card-text">E-mail: ${deputadoss.email}</p>
                      </div>
                </div>
                <div class="card">
                  <div class="card-body">
                      <h5 class="card-title">Informações</h5>
                      <hr>
                      <p class="card-text">Gastos: ${gastodeputado}</p>
                      <p class="card-text">Propostas: ${prop.size()} </p>
                      </div>
                </div>
                      </div>
              </div>
                      <div class="col-sm-2"></div>
            </div>
        </div>
        <br>
        
        <div class="container md-12">
                    <form>
                        <table class="table table-hover table-sm">
                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">EMENTA</th>
                                    <th scope="col">SITUAÇÃO</th>
                                    <th scope="col">DATA</th>


                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach var="prop" items="${prop}">
                                    <tr>
                                        <td><a href='<c:url value="./descricaoProposicao.jsp?idproposicao=${prop.id}"/>'<b>${prop.id}</b></a></td>
                                        <td style="text-align:justify;"><u>${prop.ementa}</u></td>
                                        <td>${prop.ultimoStatus_descricaoSituacao}</td>
                                        <td>${prop.dataApresentacao}</td>

                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>     
                    </form>
                </div>
        <%@include file="footer.jsp" %>
    <script src="../../../PoliticoNaMao/resources/node_modules/jquery/dist/jquery.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/popper.js/dist/umd/popper.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/bootstrap/dist/js/bootstrap.js"></script>
    </body>
</html>

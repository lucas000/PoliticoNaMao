<%-- 
    Document   : entrar
    Created on : 04/12/2018, 08:30:53
    Author     : Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitar código</title>
    </head>
    <body>
        <%@include file="barraMenu.jsp" %>
        <h3 class='display-5 mt-3' align='center'>Solicitar código de acesso</h3>
        <div class="container">
            <c:if test="${msg != null}">
                <p style="color: red">${msg}</p>
                <a href='recuperarSenha.jsp' class="badge badge-warning mr-2">Esqueceu a senha?</a>
            </c:if>
        </div>
        <div class="container mt-4">
            <form action="UsuarioServlet?cmd=recuperar" method="POST">
                <div class="form-group">
                  <label for="exampleInputEmail1">E-mail</label>
                  <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Seu e-mail">
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Nome completo</label>
                  <input type="text" class="form-control" id="nome" name="nome" placeholder="Seu nome completo">
                </div>
                <button type="submit" class="btn btn-sucess">Solicitar</button>
            </form>
        </div>
    </body>
</html>

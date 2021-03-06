<%-- 
    Document   : entrar
    Created on : 04/12/2018, 08:30:53
    Author     : Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entrar</title>
    </head>
    <body>
        <%@include file="barraMenu.jsp" %>
        <h3 class='display-5 mt-3' align='center'>Entrar</h3>
        <p>${usuario.email}</p>
        <div class="container">
            <c:if test="${msg != null}">
                <p style="color: green">${msg}</p>
            </c:if>
        </div>
        <div class="container mt-4">
            <form action="UsuarioServlet?cmd=entrar" method="POST" name="entrar">
         <%@include file="barraMenu.jsp" %>
         
         <div class="container mt-4">
             <form action="UsuarioServlet" method="POST">
                <div class="form-group">
                  <label for="exampleInputEmail1">E-mail</label>
                  <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Seu e-mail">
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Senha</label>
                  <input type="password" class="form-control" id="senha" name="senha" placeholder="Sua senha">
                </div>
                <a href='recuperarSenha.jsp' class="badge badge-warning mr-2">Esqueceu a senha?</a>
                <a href='cadastrar.jsp' class="badge badge-primary">Cadastrar-se</a><br>
                <button type="submit" class="btn btn-sucess">Entrar</button>
            </form>
        </div>
                <button type="submit" class="btn btn-sucess">Entrar</button>
                <button type="submit" class="btn btn-sucess">Esqueceu a senha?</button>
                <button type="submit" class="btn btn-sucess">Cadastrar-se</button>
            </form>
         </div>
    </body>
</html>

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
        <title>Criar conta</title>
    </head>
    <body>
        <%@include file="barraMenu.jsp" %>
        <h3 class='display-5 mt-3' align='center'>Criar conta</h3>
        
        <div class="container mt-4">
            <form action="UsuarioServlet?cmd=cadastrar" method="POST">
                <div class="form-group">
                  <label for="exampleInputPassword1">Nome completo</label>
                  <input type="text" class="form-control" id="senha1" name="nome" placeholder="Seu nome completo">
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail1">E-mail</label>
                  <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Seu e-mail">
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Senha</label>
                  <input type="password" class="form-control" id="senha1" name="senha1" placeholder="Sua senha">
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Confirmar Senha</label>
                  <input type="password" class="form-control" id="senha2" name="senha2" placeholder="Confirme sua senha">
                </div>
                <button type="submit" class="btn btn-sucess">Cadastrar</button>
            </form>
        </div>
    </body>
</html>

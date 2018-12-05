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
        <title>Entrar</title>
    </head>
    <body>
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
                <button type="submit" class="btn btn-sucess">Entrar</button>
                <button type="submit" class="btn btn-sucess">Esqueceu a senha?</button>
                <button type="submit" class="btn btn-sucess">Cadastrar-se</button>
            </form>
         </div>
    </body>
</html>

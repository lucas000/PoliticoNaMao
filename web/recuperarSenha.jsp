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
        <title>Recuperar senha</title>
    </head>
    <body>
        <%@include file="barraMenu.jsp" %>
        <h3 class='display-5 mt-3' align='center'>Recuperar conta</h3>
        
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
                <button type="submit" class="btn btn-sucess">Restaurar</button>
            </form>
        </div>
    </body>
</html>

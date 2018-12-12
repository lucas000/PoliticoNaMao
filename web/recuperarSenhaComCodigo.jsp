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
            <form action="UsuarioServlet?cmd=recuperarComCodigo" method="POST">
                <div class="form-group">
                  <label for="exampleInputEmail1">E-mail</label>
                  <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" value="${usuarioParaRestaurar.email}">
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail1">Código de acesso</label>
                  <input type="text" class="form-control" id="codigo" name="codigo" aria-describedby="emailHelp" placeholder="Seu código de acesso">
                </div>
                <button type="submit" class="btn btn-sucess">Recuperar</button>
            </form>
        </div>
    </body>
</html>

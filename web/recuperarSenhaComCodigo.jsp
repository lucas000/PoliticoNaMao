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
        <title>Insira o código</title>
    </head>
    <body>
        <%@include file="barraMenu.jsp" %>
        <h3 class='display-5 mt-3' align='center'>Digite o código de acesso</h3>
        <div class="container">
            <c:if test="${msg != null}">
                <p style="color: red">${msg}</p>
            </c:if>
                <p>Por favor, acesse seu e-mail para ver o código de acesso.</p>    
        </div>
        
        <div class="container mt-4">
            <form action="UsuarioServlet?cmd=recuperarComCodigo" method="POST">
                <div class="form-group">
                  <label for="exampleInputEmail1">E-mail</label>
                  <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" value="${usuarioParaRestaurar.email}">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Código de acesso</label>
                    <input type="number" class="form-control" id="codigo" name="codigo" aria-describedby="emailHelp" placeholder="Seu código de acesso" maxlength="8">
                    <small id="emailHelp" class="form-text text-muted">Deve conter apenas 8 números.</small>
                </div>
                <button type="submit" class="btn btn-sucess">Recuperar</button>
            </form>
        </div>
    </body>
</html>

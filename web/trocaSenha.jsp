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
        <title>Alterar senha</title>
    </head>
    <body>
        <%@include file="barraMenu.jsp" %>
        <h3 class='display-5 mt-3' align='center'>Alterar senha</h3>
        <div class="container">
            <c:if test="${msg != null}">
                <p style="color: green">${msg}</p>
            </c:if>
                <p>Após a alteração da sua senha, você será redirecionado(a) para a tela de login.</p>
        </div>
        <div class="container mt-4">
            <form action="UsuarioServlet?cmd=trocarSenha" method="POST">
                <div class="form-group">
                  <label for="exampleInputEmail1">E-mail</label>
                  <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" value="${usuarioParaRestaurar.email}">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Senha</label>
                    <input type="password" class="form-control" id="senha1" name="senha1" placeholder="Sua senha" maxlength="20">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Confirmar Senha</label>
                    <input type="password" class="form-control" id="senha2" name="senha2" placeholder="Confirme sua senha" maxlength="20">
                </div>
                <button type="submit" class="btn btn-sucess">Trocar senha</button>
            </form>
        </div>
    </body>
</html>

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
        <title>Apagar a conta</title>
    </head>
    <body>
        <%@include file="barraMenu.jsp" %>
        <h3 class='display-5 mt-3' align='center'>Apagar conta</h3>
        <div class="container">
            <c:if test="${msg != null}">
                <p style="color: red">${msg}</p>
            </c:if>
        </div>
        
        <div class="container mt-4">
            <form action="UsuarioServlet?cmd=apagar&user=${usuario.email}" method="POST">
                <div class="form-group">
                  <label for="exampleInputPassword1">Nome completo</label>
                  <input type="text" class="form-control" id="senha1" name="nome" value="${usuario.nome}" maxlength="256">
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail1">E-mail</label>
                  <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" value=${usuario.email}>
                </div>
                <button type="submit" class="btn btn-sucess">Apagar conta</button>
            </form>
        </div>
    </body>
</html>

<%-- 
    Document   : propostas
    Created on : 10/11/2018, 21:13:13
    Author     : Lucas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Político na mão</title>
        <link rel="stylesheet" href="../../../PoliticoNaMao/resources/node_modules/bootstrap/compiler/bootstrap.css"/>
    </head>
    <body>
        
        
       
        <%@include file="barraMenu.jsp" %>

        <c:if test="${proposicao == null}">
            <jsp:include page="/ProposicaoServlet" flush="true"/>
        </c:if>
        
     
         
        
            <div class="ml-3 mt-5">

            <div class="container">
                <h5 class="display-5">Proposta</h5>
               
                <form action="ProposicaoServlet" method="post">
                          
                            <div class="form-group">
                                <select class="form-control md-1" name="ano">
                                    <a class="dropdown-item" href="#">DEM</a>
                                    <option>2018</option>
                                    <option>2017</option>
                                    <option>2016</option>
                                    <option>2015</option>
                                    <option>2014</option>
                                    <option>2013</option>
                                    <option>2012</option>
                                    <option>2011</option>
                                    <option>2010</option>
                                    <option>2009</option>
                                    <option>2008</option>
                                    <option>2007</option>
                                    <option>2006</option>
                                    <option>2005</option>
                                    <option>2004</option>
                                    <option>2003</option>
                                    <option>2002</option>
                                    <option>2001</option>
                                    <option>2000</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-default ml-2">Buscar</button>
                            </div>
                    
                </form>
                
              
                           
                     <div class="md-12">
                        <form>
                            <table class="table table-hover table-sm">
                            <thead>
                                <tr>
                            <th scope="col">ID</th>
                            <th scope="col">EMENTA</th>
                             <th scope="col">ANO</th>
                                </tr>
                            </thead>
                            <tbody>

                            <c:forEach var="prop" items="${proposicao}">
                                <tr>
                                    <td><b>${prop.id}</b></td>
                                    <td style="text-align:justify;"><u>${prop.ementa}</u></td>
                                    <td><b>${prop.ano}</b></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>     
                    </form>
                </div>
                    
                  
            </div>
        </div>
        
        
        <hr/>
        
        <%@include file="quemSomos.jsp" %>
        <script src="../../../PoliticoNaMao/resources/node_modules/jquery/dist/jquery.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/popper.js/dist/umd/popper.js"></script>
    <script src="../../../PoliticoNaMao/resources/node_modules/bootstrap/dist/js/bootstrap.js"></script>
    </body>
</html>

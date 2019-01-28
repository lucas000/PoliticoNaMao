/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Consultas.TesteQueriesFavoritos;
import Consultas.TesteUsuarios;
import Modelos.Favorito;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas
 */
@WebServlet(name = "FavoritoServlet", urlPatterns = {"/FavoritoServlet"})
public class FavoritoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String opcao = request.getParameter("remover");
        String nomeParlamentar = request.getParameter("parlamentar");
        String seguidor = request.getParameter("seguidor");
        
        
        System.out.println("Opcao: " + opcao + "Parlamenta: " + nomeParlamentar + "Seguidor: " + seguidor);
            TesteQueriesFavoritos favorit = new TesteQueriesFavoritos();
            
            Favorito fav = favorit.buscaFavorito(nomeParlamentar, seguidor);
            System.out.println("Favo: " + fav.toString());
            if (fav != null) {
                TesteUsuarios te = new TesteUsuarios();
                
                favorit.apagaFavorito(fav);

                request.setAttribute("msg", "O deputado: " + nomeParlamentar + " foi removido dos favoritos com sucesso<br>Por favor, clique em Buscar para ver a lista de todos os deputados.<br>Para ver os favoritos ");
                request.getRequestDispatcher("deputados.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

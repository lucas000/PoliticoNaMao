package Servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Consultas.TesteQueriesDeputados;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas
 */
@WebServlet(name = "DeputadoServlet", urlPatterns = {"/DeputadoServlet"})
public class DeputadoServlet extends HttpServlet {

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
        
        String estado = request.getParameter("estados");
        String partido = request.getParameter("partidos");
        String opcao = request.getParameter("remover");
        String nomeParlamentar = request.getParameter("nome");
        
        
        TesteQueriesDeputados d = new TesteQueriesDeputados();
        request.setAttribute("deputados", d.buscaDeputados());
        String targetUrl = "";
        String contextPath = this.getServletContext().getContextPath();
        System.out.println("COntexto path: " + contextPath);
        targetUrl = contextPath + "/faces/deputados.jsp";
        System.out.println("Target: " + targetUrl);
        System.out.println("Srin query: " + request.getQueryString());
        if (estado.equals("Todos") && partido.equals("Todos")) {
            request.setAttribute("deputados", d.buscaDeputados());
            request.getRequestDispatcher("deputados.jsp").forward(request, response);
        } else if(estado.equals("Todos") && !"Todos".equals(partido)){
            request.setAttribute("deputados", d.buscaDeputadosPorPartido(partido));

            request.getRequestDispatcher("deputados.jsp").forward(request, response);
        } else if(!"Todos".equals(estado) && partido.equals("Todos")){
            request.setAttribute("deputados", d.buscaDeputadosPorEstado(estado));
        
            request.getRequestDispatcher("deputados.jsp").forward(request, response);
        } else if(!"Todos".equals(estado) && !"Todos".equals(partido)){
            request.setAttribute("deputados", d.buscaPorPartidoEstado(estado, partido));
        
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

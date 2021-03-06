/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Consultas.TesteQueriesDeputados;
import Consultas.TesteQueriesProposicao;
import Modelos.Deputados;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas
 */
@WebServlet(name = "fichaParlamentar", urlPatterns = {"/fichaParlamentar"})
public class FichaParlamentarServlet extends HttpServlet {

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

        String nome = request.getParameter("nome");
        
        System.out.println("Nome normal: " + nome);
        String novoNome = new String(nome.getBytes("UTF-8"), "UTF-8");
        System.out.println("Nome charsetado: " + novoNome);
        TesteQueriesDeputados teste = new TesteQueriesDeputados();
        TesteQueriesProposicao pro = new TesteQueriesProposicao();

        Deputados d = (Deputados) teste.buscaDeputadosPorNome(nome);
        
        request.setAttribute("deputadoss", d);
        request.setAttribute("gastodeputado", teste.buscaGastosTotaisDeputado(nome));
        request.setAttribute("projetosDeputado", teste.buscaPropostasPorDeputado(nome));
        request.setAttribute("prop", pro.buscaProposicaoPorNomeAutor(nome));
        
        request.getRequestDispatcher("fichaParlamentar.jsp").forward(request, response);
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

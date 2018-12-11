/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Consultas.MandaEmail;
import Consultas.TesteQueriesDeputados;
import Consultas.TesteUsuarios;
import Criptografia.Criptografia;
import Modelos.Favorito;
import Modelos.Usuario;
import Persistencia.FavoritoDAO;
import Persistencia.UsuariosDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lucas
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        
        String opcao = request.getParameter("cmd");
        if(opcao.equals("fav")){
            TesteQueriesDeputados fav = new TesteQueriesDeputados();
            String email = request.getParameter("user");
            
            List favorito = fav.verFavoritos(email);
            request.setAttribute("favoritos", favorito);
            request.getRequestDispatcher("favoritos.jsp").forward(request, response);
        }
        
        if (opcao.equals("cadastrar")) {
            Usuario user = new Usuario();
            
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha1 = request.getParameter("senha1");
            
            String senha2 = request.getParameter("senha2");
            
            if (senha1.equals(senha2)) {
                String senhaCifrada = Criptografia.computeSHA(senha1);
                
                user.setSenha(senhaCifrada);
                user.setEmail(email);
                user.setNome(nome);
                
                UsuariosDAO dao = new UsuariosDAO();
                dao.addDeputado(user);
                dao.fechaConexao();
                
            } else {
                System.out.println("Algo deu errado");
            }
        } 
        if(opcao.equals("entrar")){
            Usuario user = new Usuario();
            
            String senha = request.getParameter("senha");
            String email = request.getParameter("email");
            
            TesteUsuarios bu = new TesteUsuarios();
            
            Usuario r = bu.buscaUsuario(email);
            
            if (r != null) {
                String senhaCifrada = Criptografia.computeSHA(senha);
                if (senhaCifrada.equals(r.getSenha())) {
                    
                    System.out.println(r.toString());
                    //Controle de sessão
                    HttpSession sessao = request.getSession();
                    sessao.setAttribute("usuario", r.getEmail());
                    sessao.setMaxInactiveInterval(1800);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    System.out.println("Senhas diferentes");
                }
            } else {
                System.out.println("Nao encontrou!!");
            }
        }
        
        if(opcao.equals("recuperar")){
            Usuario user = new Usuario();
            
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            
            TesteUsuarios bu = new TesteUsuarios();
            
            Usuario r = bu.buscaUsuario(email);
            String senha = "NovaSenha";
            
            
            if (r != null) {
                MandaEmail e = new MandaEmail();
                
                TesteUsuarios se = new TesteUsuarios();
                se.atualizaSenha(email, nome);
                
                e.setAssunto("Recuperação de senha - Político na mão");
                e.setEmailDestino(email);
                e.setMsg("Olá " + nome + " essa é a sua nova senha: " + senha);
                
                e.enviarGmail();
                
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                System.out.println("Nao encontrou!!");
            }
        }
        
        if(opcao.equals("addFavorito")){
            FavoritoDAO dao = new FavoritoDAO();
            
            Favorito favorito = new Favorito();
            String nomeCivil = request.getParameter("nome");
            String nomeDeputado = request.getParameter("nomeParlamentar");
            String nomeSeguidor = request.getParameter("nomeSeguidor");
            String partido = request.getParameter("partido");
            String estado = request.getParameter("estado");
            
            favorito.setNome(nomeCivil);
            favorito.setNomeParlamentar(nomeDeputado);
            favorito.setEmailSeguidor(nomeSeguidor);
            favorito.setPartido(partido);
            favorito.setEstado(estado);
            
            System.out.println(favorito.toString());
            dao.addFavorito(favorito);
            dao.fechaConexao();
            
            request.getRequestDispatcher("fichaParlamentar.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

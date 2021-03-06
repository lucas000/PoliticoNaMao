/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Consultas.MandaEmail;
import Consultas.TesteQueriesDeputados;
import Consultas.TesteUsuarios;
import Consultas.VerificaSenha;
import Criptografia.Criptografia;
import Log.ArquivoLog;
import Log.Registro;
import Modelos.Favorito;
import Modelos.Usuario;
import Persistencia.FavoritoDAO;
import Persistencia.UsuariosDAO;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.io.PrintWriter;
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
        
        /* Ordem das opções de entrada
        *   1 - fav, quer dizer favorito, mostra os favoritos do usuario logado
        *   3 - alterar conta,
        *   3 - cadastrar inseri o usuario no sistema e redireciona para a entrar.jsp
        *   4 - entrar, verifica se existe, se sim, vai para a index.jsp
        *   5 - apagar, pedi credenciais, e vai para a index.jsp
        *   6 - recuperar, pedi o nome e email e envia o codigo para o email do usuario
        *   7 - recupera com codigo, pedi o codigo e vai para tela de alterar senha
        *   8- trocar senha, pega os dados do formulario e altera a conta
        *   9 - addFavorito, adiciona favorito ao usuario logado.
        *   10 - sair, fecha a sessao e vai para a index.jsp
        */
        String opcao = request.getParameter("cmd");

        if (opcao.equals("fav")) {
            TesteQueriesDeputados fav = new TesteQueriesDeputados();
            String email = request.getParameter("user");
            
            List favorito = fav.verFavoritos(email);

            request.setAttribute("favoritos", favorito);

            for (Object d : favorito) {
                System.out.println(d.toString());
            }
            request.getRequestDispatcher("favoritos.jsp").forward(request, response);
        }

        if (opcao.equals("alterarConta")) {
            String email = request.getParameter("email");
            String senha1 = request.getParameter("senha1");
            String senha2 = request.getParameter("senha2");
            String nome = request.getParameter("nome");

            VerificaSenha v = new VerificaSenha();

            boolean resultadoValidacao = true;

            if (v.verificaCampos(nome, email, senha1, senha2) == false) {
                //Registro de Log 
                Date data = new Date();
                String date = String.valueOf(data);
                ArquivoLog s = new ArquivoLog();
                s.gerarLog("Email=" + email + ";Operação=Tentou alterar a conta" + ";Data=" + date);
                //
                resultadoValidacao = false;
                request.setAttribute("msg", "Verifique! Campos Vazios");
                request.getRequestDispatcher("alterar.jsp").forward(request, response);

            } else if (!(senha1.length() >= 8 && senha1.length() <= 20)) {
                //Registro de Log 
                Date data = new Date();
                String date = String.valueOf(data);
                ArquivoLog s = new ArquivoLog();
                s.gerarLog("Email=" + email + ";Operação=Tentou alterar a conta" + ";Data=" + date);
                //
                resultadoValidacao = false;
                request.setAttribute("msg", "Senha(Mínimo 8 e Máximo 20 caractere)");
                request.getRequestDispatcher("alterar.jsp").forward(request, response);
            } else if (!(senha1.equals(senha2))) {
                //Registro de Log 
                Date data = new Date();
                String date = String.valueOf(data);
                ArquivoLog s = new ArquivoLog();
                s.gerarLog("Email=" + email + ";Operação=Tentou alterar a conta" + ";Data=" + date);
                //
                resultadoValidacao = false;
                request.setAttribute("msg", "Senhas não são iguais!");
                request.getRequestDispatcher("alterar.jsp").forward(request, response);

            } else if (v.senhaBoa(senha1) == false) {
                //Registro de Log 
                Date data = new Date();
                String date = String.valueOf(data);
                ArquivoLog s = new ArquivoLog();
                s.gerarLog("Email=" + email + ";Operação=Tentou alterar a conta" + ";Data=" + date);
                //
                resultadoValidacao = false;
                request.setAttribute("msg", "Senha fraca! <br> Requisitos Mínimos:<br> 8 caracteres <br> Letras Maiúsculas e Minúsculas <br> Caracteres Especiais");
                request.getRequestDispatcher("alterar.jsp").forward(request, response);
            }

            if (resultadoValidacao == true) {
                TesteUsuarios bu = new TesteUsuarios();

                Usuario r = bu.buscaUsuario(email);
                System.out.println(r.toString());
                if (r != null) {
                    if (senha1.equals(senha2)) {

                        //Controle de sessão
                        HttpSession sessao = request.getSession();
                        String senhaCifrada = Criptografia.computeSHA(senha1);

                        r.setSenha(senhaCifrada);
                        r.setNome(nome);
                        r.setEmail(email);

                        System.out.println("novo usuario: " + r.toString());
                        UsuariosDAO dao = new UsuariosDAO();

                        dao.alterUsuario(r);
                        sessao.setAttribute("usuario", r);
                        System.out.println("Alterou no altear");
                        //Registro de Log 
                Date data = new Date();
                String date = String.valueOf(data);
                ArquivoLog s = new ArquivoLog();
                s.gerarLog("Email=" + email + ";Operação=Alterou a conta" + ";Data=" + date);
                //
                        sessao.setMaxInactiveInterval(1800);
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    } else {
                        //Registro de Log 
                Date data = new Date();
                String date = String.valueOf(data);
                ArquivoLog s = new ArquivoLog();
                s.gerarLog("Email=" + email + ";Operação=Tentou entrar no sistema" + ";Data=" + date);
                //
                        request.setAttribute("msg", "Erro ao realizar login!");
                        request.getRequestDispatcher("alterar.jsp").forward(request, response);
                    }
                } else {
                    //Registro de Log 
                Date data = new Date();
                String date = String.valueOf(data);
                ArquivoLog s = new ArquivoLog();
                s.gerarLog("Email=" + email + ";Operação=Tentou entrar no sistema" + ";Data=" + date);
                //
                    request.setAttribute("msg", "Usuário não encontrado");
                    request.getRequestDispatcher("alterar.jsp").forward(request, response);
                }
            }
        }

        if (opcao.equals("cadastrar")) {
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha1 = request.getParameter("senha1");
            String senha2 = request.getParameter("senha2");
            VerificaSenha v = new VerificaSenha();

            boolean resultadoValidacao = true;
            if (v.verificaCampos(nome, email, senha1, senha2) == false) {
                //Registro de Log 
                Date data = new Date();
                String date = String.valueOf(data);
                ArquivoLog s = new ArquivoLog();
                s.gerarLog("Email=" + email + ";Operação=Tentou cadastrar no sistema" + ";Data=" + date);
                //
                resultadoValidacao = false;
                request.setAttribute("msg", "Verifique ! Campos Vazios");
                request.getRequestDispatcher("cadastrar.jsp").forward(request, response);
            } else if (!(senha1.length() >= 8 && senha1.length() <= 20)) {
                //Registro de Log 
                Date data = new Date();
                String date = String.valueOf(data);
                ArquivoLog s = new ArquivoLog();
                s.gerarLog("Email=" + email + ";Operação=Tentou cadastrar no sistema" + ";Data=" + date);
                //
                resultadoValidacao = false;
                request.setAttribute("msg", "Senha(Mínimo 8 e Máximo 20 caractere)");
                request.getRequestDispatcher("cadastrar.jsp").forward(request, response);
            } else if (!(senha1.equals(senha2))) {
                //Registro de Log 
                Date data = new Date();
                String date = String.valueOf(data);
                ArquivoLog s = new ArquivoLog();
                s.gerarLog("Email=" + email + ";Operação=Tentou cadastrar no sistema" + ";Data=" + date);
                //
                resultadoValidacao = false;
                request.setAttribute("msg", "Senhas não são iguais!");
                request.getRequestDispatcher("cadastrar.jsp").forward(request, response);

            } else if (v.senhaBoa(senha1) == false) {
                //Registro de Log 
                Date data = new Date();
                String date = String.valueOf(data);
                ArquivoLog s = new ArquivoLog();
                s.gerarLog("Email=" + email + ";Operação=Tentou cadastrar no sistema" + ";Data=" + date);
                //
                resultadoValidacao = false;
                request.setAttribute("msg", "Senha fraca! <br> Requisitos Mínimos:<br> 8 caracteres <br> Letras Maiúsculas e Minúsculas <br> Caracteres Especiais");
                request.getRequestDispatcher("cadastrar.jsp").forward(request, response);
            }
            
            else if (v.verificarSenha(email, senha2) == false) {
                //Registro de Log 
                Date data = new Date();
                String date = String.valueOf(data);
                ArquivoLog s = new ArquivoLog();
                s.gerarLog("Email=" + email + ";Operação=Tentou cadastrar no sistema" + ";Data=" + date);
                //
                resultadoValidacao = false;
                request.setAttribute("msg", "A senha não pode ter partes do e-mail. Tente novamente.");
                request.getRequestDispatcher("cadastrar.jsp").forward(request, response);

            }
            if (resultadoValidacao == true) {
                TesteUsuarios tu = new TesteUsuarios();
                Usuario user = tu.buscaUsuario(email);

                if (user == null) {
                    String senhaCifrada = Criptografia.computeSHA(senha1);

                    Usuario usuario = new Usuario();

                    usuario.setEmail(email);
                    usuario.setSenha(senhaCifrada);
                    usuario.setNome(nome);
                    usuario.setStatus(1);

                    UsuariosDAO dao = new UsuariosDAO();
                    dao.addDeputado(usuario);
                    dao.fechaConexao();

                    request.setAttribute("msg", "Sua conta foi criada com sucesso.<br>Por favor, entre com seus dados informados na página anterior para acessar o sistema.");
                    request.getRequestDispatcher("entrar.jsp").forward(request, response);
                } else {
                    //Registro de Log 
                    Date data = new Date();
                    String date = String.valueOf(data);
                    ArquivoLog s = new ArquivoLog();
                    s.gerarLog("Email=" + email + ";Operação=Tentou cadastrar no sistema" + ";Data=" + date);
                    //
                    request.setAttribute("msg", "Usuário já está cadastrado. <br>Tente recuperar a senha!<br>");
                    request.getRequestDispatcher("cadastrar.jsp").forward(request, response);
                }
            }
        }
        if (opcao.equals("entrar")) {
            String senha = request.getParameter("senha");
            String email = request.getParameter("email");

            VerificaSenha v = new VerificaSenha();

            boolean resultadoValidacao = true;

            if (v.verificaCampos(email, senha) == false) {
                resultadoValidacao = false;
                request.setAttribute("msg", "Verifique ! Campos Vazios");
                //Registro de Log 
                Date data = new Date();
                String date = String.valueOf(data);
                ArquivoLog s = new ArquivoLog();
                s.gerarLog("Email=" + email + ";Operação=Tentou entrar no sistema" + ";Data=" + date);
                //
                request.getRequestDispatcher("entrar.jsp").forward(request, response);
            }

            if (resultadoValidacao == true) {
                TesteUsuarios bu = new TesteUsuarios();

                Usuario r = bu.buscaUsuario(email);

                if (r != null) {
                    String senhaCifrada = Criptografia.computeSHA(senha);
                    if (senhaCifrada.equals(r.getSenha())) {
                        if (r.getStatus() == 1) {
                            //Controle de sessão
                            HttpSession sessao = request.getSession();
                            sessao.setAttribute("usuario", r);
                            sessao.setMaxInactiveInterval(1800);
                            //Registro de Log 

                            Date data = new Date();
                            String date = String.valueOf(data);
                            ArquivoLog s = new ArquivoLog();
                            s.gerarLog("Email=" + email + ";Operação=Entrou no sistema" + ";Data=" + date);
                            //
                            request.getRequestDispatcher("index.jsp").forward(request, response);

                        } else {
                            //Registro de Log 
                            Date data = new Date();
                            String date = String.valueOf(data);
                            ArquivoLog s = new ArquivoLog();
                            s.gerarLog("Email=" + email + ";Operação=Tentou emtrar no sistema" + ";Data=" + date);
                            //
                            request.setAttribute("msg", "Usuário bloqueado, recupere a senha!");
                            request.getRequestDispatcher("entrar.jsp").forward(request, response);
                        }
                    } else {

                        if (r.getStatus() == 0) {
                            request.setAttribute("msg", "Usuário bloqueado, recupere a senha!");
                            //Registro de Log 
                            Date data = new Date();
                            String date = String.valueOf(data);
                            ArquivoLog s = new ArquivoLog();
                            s.gerarLog("Email=" + email + ";Operação=Tentou emtrar no sistema" + ";Data=" + date);
                            //
                        } else {
                    //Registro de Log 
                    Date data = new Date();
                    String date = String.valueOf(data);
                    ArquivoLog s = new ArquivoLog();
                    s.gerarLog("Email=" + email + ";Operação=Tentou entrar no sistema" + ";Data=" + date);
                    //
                            request.setAttribute("msg", "Tente novamente, por favor!");
                        }
                        bu.Cont_Erro_Acesso(email);

                        request.getRequestDispatcher("entrar.jsp").forward(request, response);
                    }
                } else {

                    //Registro de Log 
                    Date data = new Date();
                    String date = String.valueOf(data);
                    ArquivoLog s = new ArquivoLog();
                    s.gerarLog("Email=" + email + ";Operação=Tentou emtrar no sistema" + ";Data=" + date);
                    //
                    request.setAttribute("msg", "Usuário não encontrado, por favor, tente novamente!");
                    request.getRequestDispatcher("entrar.jsp").forward(request, response);
                }
            }
        }

        if (opcao.equals("apagar")) {
            String email = request.getParameter("user");

            TesteUsuarios bu = new TesteUsuarios();
            Usuario r = bu.buscaUsuario(email);

            if (r != null) {
                TesteUsuarios ser = new TesteUsuarios();
                
                ser.apagaConta(email);
                HttpSession sessao = request.getSession();
                sessao.setAttribute("usuario", null);
                
                //Registro de Log 
                Date data = new Date();
                String date = String.valueOf(data);
                ArquivoLog s = new ArquivoLog();
                s.gerarLog("Email=" + email + ";Operação=Apagou Conta" + ";Data=" + date);
                //aqui vem o metodo delete
                response.sendRedirect("index.jsp");

            } else {
                //Registro de Log 
                Date data = new Date();
                String date = String.valueOf(data);
                ArquivoLog s = new ArquivoLog();
                s.gerarLog("Email=" + email + ";Operação=Tentou apagar Conta" + ";Data=" + date);
                //
                request.setAttribute("msg", "Usuário não encontrado, por favor, tente novamente!");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        if (opcao.equals("recuperar")) {

            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            VerificaSenha v = new VerificaSenha();

            boolean resultadoValidacao = true;

            if (v.verificaCampos(email, nome) == false) {
                //Registro de Log 
                Date data = new Date();
                String date = String.valueOf(data);
                ArquivoLog s = new ArquivoLog();
                s.gerarLog("Email=" + email + ";Operação=Tentou recuperar Conta" + ";Data=" + date);
                //
                resultadoValidacao = false;
                request.setAttribute("msg", "Verifique! Campos Vazios");
                request.getRequestDispatcher("entrar.jsp").forward(request, response);
            }

            if (resultadoValidacao == true) {
                TesteUsuarios bu = new TesteUsuarios();

                Usuario r = bu.buscaUsuarioRecuperar(email, nome);
                
                if (r != null) {
                    MandaEmail e = new MandaEmail();

                    TesteUsuarios se = new TesteUsuarios();
                    int codigoAcesso = geraCodigoAcesso();

                    if (r.getNome().equals(nome) && r.getEmail().equals(email)) {
                        se.atualizaCodigo(email, nome, codigoAcesso);

                        e.setAssunto("Recuperação de senha - Político na mão");
                        e.setEmailDestino(email);
                        e.setMsg("Olá " + nome + " seu código para acesso é: " + codigoAcesso);

                        e.enviarGmail();

                        //Registro de Log 
                        Date data = new Date();
                        String date = String.valueOf(data);
                        ArquivoLog s = new ArquivoLog();
                        s.gerarLog("Email=" + email + ";Operação=Recuperou senha" + ";Data=" + date);
                        //

                        request.setAttribute("msg", "Seu código foi enviado ao e-mail, verifique sua caixa de entrada, por favor!");
                        request.setAttribute("usuarioParaRestaurar", r);
                        response.sendRedirect("recuperarSenhaComCodigo.jsp");
                    } else {
                        //Registro de Log 
                        Date data = new Date();
                        String date = String.valueOf(data);
                        ArquivoLog s = new ArquivoLog();
                        s.gerarLog("Email=" + email + ";Operação=Tentou recuperar senha" + ";Data=" + date);
                        //
                        request.setAttribute("msg", "Nome de usuário ou e-mail diferente que o cadastrado!");
                        request.getRequestDispatcher("recuperarSenha.jsp").forward(request, response);
                    }

                } else {
                    //Registro de Log 
                        Date data = new Date();
                        String date = String.valueOf(data);
                        ArquivoLog s = new ArquivoLog();
                        s.gerarLog("Email=" + email + ";Operação=Tentou recuperar senha" + ";Data=" + date);
                        //
                    request.setAttribute("msg", "Usuário não encontrado! por favor tente novamente!");
                    request.getRequestDispatcher("recuperarSenha.jsp").forward(request, response);
                }
            }
        }

        if (opcao.equals("recuperarComCodigo")) {

            String email = request.getParameter("email");
            String codigo = request.getParameter("codigo");

            TesteUsuarios bu = new TesteUsuarios();

            Usuario r = bu.buscaUsuario(email);

            if (codigo.isEmpty()) {
                //Registro de Log 
                        Date data = new Date();
                        String date = String.valueOf(data);
                        ArquivoLog s = new ArquivoLog();
                        s.gerarLog("Email=" + email + ";Operação=Tentou recuperar senha" + ";Data=" + date);
                        //
                request.setAttribute("msg", "Código com tamanho inválido");
                request.getRequestDispatcher("recuperarSenhaComCodigo.jsp").forward(request, response);
            } else {
                String codigoCifrado = Criptografia.computeSHA(String.valueOf(codigo));

                if (r != null) {
                    if (r.getCodigoAcesso().equals(codigoCifrado)) {
                        request.setAttribute("msg", "Código verificado<br>Por favor, troque sua senha");

                        request.setAttribute("usuarioParaRestaurar", r);
                        request.getRequestDispatcher("trocaSenha.jsp").forward(request, response);
                    } else{
                        request.setAttribute("msg", "Código inválido, tente novamente!");
                        request.getRequestDispatcher("recuperarSenhaComCodigo.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("msg", "Código inválido, tente novamente!");
                    request.getRequestDispatcher("recuperarSenhaComCodigo.jsp").forward(request, response);
                }
            }
        }

        if (opcao.equals("trocarSenha")) {
            String senha1 = request.getParameter("senha1");
            String senha2 = request.getParameter("senha2");
            String email = request.getParameter("email");

            TesteUsuarios bu = new TesteUsuarios();
            Usuario usuario = bu.buscaUsuario(email);

            if (usuario != null) {

                //Registro de Log 
                Date data = new Date();
                String date = String.valueOf(data);
                ArquivoLog s = new ArquivoLog();
                s.gerarLog("Email=" + email + ";Operação=Trocar de Senha" + ";Data=" + date);
                //

                String senhaCifrada = Criptografia.computeSHA(senha1);
                usuario.setSenha(senhaCifrada);

                TesteUsuarios d = new TesteUsuarios();
                d.atualizaContaBloqueada(email);
                request.setAttribute("msg", "Sua senha foi alterada com sucesso.<br>Coloque suas credenciais abaixo para entrar no sistema.");
                request.getRequestDispatcher("entrar.jsp").forward(request, response);
            }
        }
        if (opcao.equals("addFavorito")) {
            FavoritoDAO dao = new FavoritoDAO();

            //Registro de Log 
            String email = request.getParameter("nomeSeguidor");
            Date data = new Date();
            String date = String.valueOf(data);
            ArquivoLog s = new ArquivoLog();
            s.gerarLog("Email=" +email+ ";Operação=Adicionou Favorito" + ";Data=" + date);
            //

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

            dao.addFavorito(favorito);
            dao.fechaConexao();

            request.setAttribute("msg", "Deputado: " + nomeDeputado + " foi adicionado aos favoritos, para ver os deputados favoritos ");
            request.getRequestDispatcher("deputados.jsp").forward(request, response);
        }

        if (opcao.equals("sair")) {

            //Registro de Log 
            String email = request.getParameter("user");
            Date data = new Date();
            String date = String.valueOf(data);
            ArquivoLog s = new ArquivoLog();
            s.gerarLog("Email=" + email + ";Operação=Sair" + ";Data=" + date);
            //

            HttpSession sessao = request.getSession();
            sessao.setMaxInactiveInterval(0);
            request.setAttribute("usuario", null);
            response.sendRedirect("index.jsp");

        }

    }

    private int geraCodigoAcesso() {
        Random r = new Random();

        return r.nextInt(999999999);
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        System.out.println("Email e senha: " + email +  senha);
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

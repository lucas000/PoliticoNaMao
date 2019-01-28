/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Criptografia.Criptografia;
import Modelos.Usuario;
import Persistencia.UsuariosDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Lucas
 */
public class TesteUsuarios {

    public Usuario buscaUsuario(String email) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Usuario e Where e.email=:email");
        query.setParameter("email", email);
        List usuario = query.getResultList();

        if (usuario.isEmpty()) {
            manager.close();
            return null;
        } else {
            Usuario user = (Usuario) usuario.get(0);
            manager.close();
            return user;
        }

    }

    public Usuario buscaUsuarioRecuperar(String email, String nome) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Usuario e Where e.email=:email and e.nome=:nome");
        query.setParameter("email", email);
        query.setParameter("nome", nome);
                
        List usuario = query.getResultList();

        if (usuario.isEmpty()) {
            manager.close();
            return null;
        } else {
            Usuario user = (Usuario) usuario.get(0);
            manager.close();
            return user;
        }

    }

    public void atualizaCodigo(String email, String nome, int codigoAcesso) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Usuario e Where e.email=:email and e.nome=:nome");
        query.setParameter("email", email);
        query.setParameter("nome", nome);
        
        List usuario = query.getResultList();
        Usuario user = (Usuario) usuario.get(0);

        UsuariosDAO d = new UsuariosDAO();

        String codigoCifrado = Criptografia.computeSHA(String.valueOf(codigoAcesso));

        user.setCodigoAcesso(codigoCifrado);
        
        d.alterUsuario(user);
        manager.close();
        d.fechaConexao();
    }
    public void atualizaContaBloqueada(String email) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Usuario e Where e.email=:email");
        query.setParameter("email", email);
        
        List usuario = query.getResultList();
        Usuario user = (Usuario) usuario.get(0);

        UsuariosDAO d = new UsuariosDAO();

        user.setCodigoAcesso(null);
        user.setStatus(1);
        user.setTentativas(0);
        
        d.alterUsuario(user);
        manager.close();
        d.fechaConexao();
    }
    public void apagaConta(String email) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        System.out.println("APagou");
        Query query = manager.createQuery("DELETE FROM Usuario e Where e.email=:email");
        query.setParameter("email", email);
        query.executeUpdate();
        manager.getTransaction().commit();
        manager.close();
    }

    public void Cont_Erro_Acesso(String email) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Usuario e Where e.email=:email");
        query.setParameter("email", email);
        
        List usuario = query.getResultList();
        Usuario user = (Usuario) usuario.get(0);

        UsuariosDAO d = new UsuariosDAO();

        if (user.getTentativas() > 8) {
            user.setStatus(0);
        } else {
            user.setTentativas(user.getTentativas() + 1);
        }
        d.alterUsuario(user);
        d.fechaConexao();
        manager.close();
    }
}

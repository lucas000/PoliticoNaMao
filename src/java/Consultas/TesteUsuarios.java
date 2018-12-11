/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

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
    public Usuario buscaUsuario(String email){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();
        
        Query query = manager.createQuery("SELECT e FROM Usuario e Where e.email like '" + email + "'");
        List usuario = query.getResultList();
        
        if(usuario.isEmpty()){
            return null;
        }else{
            Usuario user = (Usuario) usuario.get(0);
            return user;
        }
        
    }
    
    public void atualizaSenha(String email, String nome){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();
        
        Query query = manager.createQuery("SELECT e FROM Usuario e Where e.email like '" + email + "'");
        List usuario = query.getResultList();
        Usuario user = (Usuario) usuario.get(0);
        UsuariosDAO d = new UsuariosDAO();
        
        user.setSenha("Nova senha 2");
        
        d.alterUsuario(user);
    }
}
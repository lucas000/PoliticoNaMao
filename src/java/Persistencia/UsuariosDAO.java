/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelos.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class UsuariosDAO {
    EntityManagerFactory usuarios = Persistence.createEntityManagerFactory("PU");
    EntityManager manager = usuarios.createEntityManager();
    
    public void addDeputado(Usuario usuario){
        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit();
    }
    
    public void alterUsuario(Usuario usuarios){
        manager.getTransaction().begin();
        manager.merge(usuarios);
        manager.getTransaction().commit();
    }
    
    public void deleteDeputado(Usuario usuarios){
        manager.getTransaction().begin();
        manager.remove(usuarios);
        manager.getTransaction().commit();
    }
    public void fechaConexao(){
        manager.close();
    }
}
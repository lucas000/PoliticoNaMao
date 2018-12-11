/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelos.Favorito;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class FavoritoDAO {
    EntityManagerFactory deputados = Persistence.createEntityManagerFactory("PU");
    EntityManager manager = deputados.createEntityManager();
    
    public void addFavorito(Favorito favo){
        manager.getTransaction().begin();
        manager.persist(favo);
        manager.getTransaction().commit();
    }
    
    public void fechaConexao(){
        manager.close();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelos.FichaPartidos;
import Modelos.Partidos;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Allan
 */
public class FichaPartidosDAO {
    EntityManagerFactory partidos = Persistence.createEntityManagerFactory("PU");
    EntityManager manager = partidos.createEntityManager();
    
    public void addFichaPartido(FichaPartidos partido){
        manager.getTransaction().begin();
        manager.persist(partido);
        manager.getTransaction().commit();
    }
    
    public void fechaConexao(){
        manager.close();
    }
    
}

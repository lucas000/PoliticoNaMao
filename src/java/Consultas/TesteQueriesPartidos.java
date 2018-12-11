/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Modelos.Partidos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Allan
 */
public class TesteQueriesPartidos {
    /**
     * @param args the command line arguments
     */
    
    public List<Partidos> buscaPartidos(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Partidos e");
        List partidos = query.getResultList();
        
        return partidos;
        
    }
    
}

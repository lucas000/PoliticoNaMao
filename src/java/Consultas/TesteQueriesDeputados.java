/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Modelos.Deputados;
import Modelos.Estado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Lucas
 */
public class TesteQueriesDeputados {

    /**
     * @return 
     */
    
    public List<Deputados> buscaDeputados(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Deputados");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Deputados e");
        List deputados = query.getResultList();
        
        return deputados;
        
    }
    
    public List<Estado> buscaEstado(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Estado");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Estado e");
        List estados = query.getResultList();
        
        return estados;
    }
        /*
        Query query = manager.createQuery("SELECT nome FROM Deputados d");
        List<String> list = query.getResultList();
        
        System.out.println("Deputados no Brasil");
        for (String e : list) {
            System.out.println(e);
        }
        */
}
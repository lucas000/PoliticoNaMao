/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Modelos.Deputados;
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
     * @param args the command line arguments
     */
    
    public List<Deputados> buscaDeputados(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Deputados");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Deputados e where uf = 'GO' order by nome");
        List deputados = query.getResultList();
        
        return deputados;
        
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Modelos.Partidos;
import Modelos.Proposicao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Vicom
 */
public class TesteQueriesProposicao {
    
    /**
     * @param args the command line arguments
     */
    
    public List<Proposicao> buscaProposicao(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Partidos");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Proposicao e");
        List proposicao = query.getResultList();
        
        return proposicao;
        
    }
    
}

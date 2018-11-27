/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Modelos.Deputados;
import Modelos.FichaPartidos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Allan
 */
public class TesteQueriesFichaPartidos {
    public List<FichaPartidos> buscaFichaPartidos(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("FichaPartidos");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM fichaPartidos e");
        List partidos = query.getResultList();
        
        return partidos;
        
    }
    public FichaPartidos buscaFichaPartidosPor(String nome){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("FichaPartidos");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM FichaPartidos e WHERE e.nome=:nome");
        query.setParameter("nome", nome);
        FichaPartidos fpartidoss = (FichaPartidos) query.getSingleResult();
        
        return fpartidoss;
        
    }
    
}

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

        Query query = manager.createQuery("SELECT e FROM Deputados e ORDER BY NOME ASC");
        List deputados = query.getResultList();
        
        return deputados;
        
    }
    
    public Deputados buscaDeputadosPorNome(String nome){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Deputados");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Deputados e WHERE e.nome=:nome");
        query.setParameter("nome", nome);
        Deputados deputados = (Deputados) query.getSingleResult();
        
        return deputados;
        
    }
    public List<Estado> buscaEstado(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Estado");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Estado e");
        List estados = query.getResultList();
        
        return estados;
    }
    
    public List<Deputados> buscaPorPartidoEstado(String estado, String partido){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Deputados");
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT e FROM Deputados e WHERE e.uf=:estado and e.partido =:partido");
        query.setParameter("estado", estado);
        query.setParameter("partido", partido);
        
        List deputados = query.getResultList();
        
        return deputados;
        
    }
    
    public List<Deputados> buscaPorEstado(String estado){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Deputados");
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT e FROM Deputados e WHERE e.uf=:estado");
        query.setParameter("estado", estado);
        
        List deputados = query.getResultList();
        
        return deputados;
        
    }
    
    public List<Deputados> buscaDeputadosPorPartido(String partido){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Deputados");
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT e FROM Deputados e WHERE e.partido=:partido");
        query.setParameter("partido", partido);
        
        List deputados = query.getResultList();
        
        return deputados;
        
    }
    
    public List<Deputados> buscaDeputadosPorEstado(String estado){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Deputados");
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT e FROM Deputados e WHERE e.uf=:estado");
        query.setParameter("estado", estado);
        
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
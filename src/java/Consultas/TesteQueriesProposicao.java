/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Modelos.Proposicao;
import Modelos.ProposicaoAutor;
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
   
    
       public List<Proposicao> buscaProposicaoAno(int ano){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Proposicao e Where e.ano=:ano");
        query.setParameter("ano", ano);
        
        List proposicao = query.getResultList();
        
        return proposicao;
        
    }
 public ProposicaoAutor buscaProposicaoautor(int idProposicao){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM ProposicaoAutor e Where e.idProposicao=:idProposicao");
        query.setParameter("idProposicao", idProposicao);
        List proposicao = query.getResultList();
        
        if(proposicao.isEmpty()){
            return null;
        } else {
            ProposicaoAutor novo = (ProposicaoAutor) proposicao.get(0);
            return novo;
        }
    }
 
  public Proposicao buscaProposicao(int idProposicao){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Proposicao e Where e.id=:idProposicao");
        query.setParameter("idProposicao", idProposicao);
        
        List proposicao = query.getResultList();
        
        if(proposicao.isEmpty()){
        return null;
        }else{
            Proposicao novo = (Proposicao) proposicao.get(0);
            return novo;
        }
        
        
        
    }
  
   public Proposicao buscaProposicoesAutores(String nomeAutor){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT e from proposicao p inner join proposicaoautor pa where pa.uriproposicao = p.uri and pa.nomeautor=:"+nomeAutor);
        query.setParameter("nomeautor", nomeAutor);
        List proposicao = query.getResultList();
        
        if(proposicao.isEmpty()){
        return null;
        }else{
            Proposicao novo = (Proposicao) proposicao.get(0);
            return novo;
        }
        
        
        
    }
   
   public List<Proposicao> buscaProposicaoPorNomeAutor(String nomeAutor){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT e FROM Proposicao e join ProposicaoAutor p on e.id = p.idProposicao join Deputados d on d.nomeParlamentar = p.nomeAutor where d.nomeParlamentar=:nomeAutor");
        query.setParameter("nomeAutor", nomeAutor);
        
        List proposicoes = query.getResultList();
        
        for(Object d : proposicoes){
            Proposicao de = (Proposicao) d;
            
            System.out.println(de);
        }
        return proposicoes;
    }
 
 
   
 
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Modelos.Partidos;
import Modelos.Proposicao;
import Modelos.ProposicaoAutor;
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
   
    
       public List<Proposicao> buscaProposicaoAno(int ano){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Partidos");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Proposicao e Where e.ano="+ano);
        List proposicao = query.getResultList();
        
        return proposicao;
        
    }
 public ProposicaoAutor buscaProposicaoautor(int idProposicao){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Partidos");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM ProposicaoAutor e Where e.idProposicao="+idProposicao);
        List proposicao = query.getResultList();
        
        if(proposicao.isEmpty()){
        return null;
        }else{
            ProposicaoAutor novo = (ProposicaoAutor) proposicao.get(0);
            return novo;
        }
        
        
        
    }
 
 
  public Proposicao buscaProposicao(int idProposicao){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Partidos");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Proposicao e Where e.id="+idProposicao);
        List proposicao = query.getResultList();
        
        if(proposicao.isEmpty()){
        return null;
        }else{
            Proposicao novo = (Proposicao) proposicao.get(0);
            return novo;
        }
        
        
        
    }
 
 
   
 
    }

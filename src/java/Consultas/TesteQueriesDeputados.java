/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Modelos.AutorProposicoes2018;
import Modelos.Deputados;
import Modelos.DespesasCotaExercicioAtividadeParlamentar_1;
import Modelos.Estado;
import Modelos.Favorito;
import java.text.DecimalFormat;
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
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Deputados e ORDER BY NOME ASC");
        List deputados = query.getResultList();
        
        return deputados;
        
    }
    
    public double buscaGastosTotaisDeputado(String nome){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT dcp FROM DespesasCotaExercicioAtividadeParlamentar_1 dcp where dcp.txNomeParlamentar=:nome");
        query.setParameter("nome", nome);
        
        List gastos = query.getResultList();
        double gastoTotal = 0.0;
        
        for (Object deputado : gastos) {
            DespesasCotaExercicioAtividadeParlamentar_1 est = (DespesasCotaExercicioAtividadeParlamentar_1) deputado;
            gastoTotal+=est.getVlrdocumento();
        }
        
        DecimalFormat df = new DecimalFormat("0.##");
        String dx = df.format(gastoTotal);
        dx = dx.replaceAll(",", ".");
        
        return Double.parseDouble(dx);
    }
    
    public List<Favorito> verFavoritos(String email){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Favorito e where e.emailSeguidor like '" + email + "'");
        List favoritos = query.getResultList();
        
        return favoritos;
        
    }
    public int buscaPropostasPorDeputado(String nome){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("select dcp from AutorProposicoes2018 dcp where dcp.nomeAutor=:nome");
        query.setParameter("nome", nome);
        
        List projetos = query.getResultList();
        
        int numeroProjetos = 0;
        
        for (Object propos : projetos) {
            AutorProposicoes2018 proposicoes = (AutorProposicoes2018) propos;
            numeroProjetos+=1;
        }
        return numeroProjetos;
    }
    
    public int buscaProposicoesDeputado(String nome){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT dcp FROM AutorProposicoes2018 dcp where dcp.nomeautor=:nome");
        query.setParameter("nome", nome);
        
        List gastos = query.getResultList();
        double gastoTotal = 0.0;
        for (Object deputado : gastos) {
            DespesasCotaExercicioAtividadeParlamentar_1 est = (DespesasCotaExercicioAtividadeParlamentar_1) deputado;
            System.out.println(est.toString());
            gastoTotal+=est.getVlrdocumento();
        }
        return (int) gastoTotal;
    }
    
    public Deputados buscaDeputadosPorNome(String nome){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();

        System.out.println("Nome passdo no buscaDeputadosPorNome: " + nome);
        Query query = manager.createQuery("SELECT e FROM Deputados e WHERE e.nomeParlamentar=:nome");
        query.setParameter("nome", nome);
        Deputados deputados = (Deputados) query.getSingleResult();
        
        return deputados;
        
    }
    public List<Estado> buscaEstado(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Estado e");
        List estados = query.getResultList();
        
        return estados;
    }
    
    public List<Deputados> buscaPorPartidoEstado(String estado, String partido){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT e FROM Deputados e WHERE e.uf=:estado and e.partido =:partido");
        query.setParameter("estado", estado);
        query.setParameter("partido", partido);
        
        List deputados = query.getResultList();
        
        return deputados;
        
    }
    
    public List<Deputados> buscaPorEstado(String estado){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT e FROM Deputados e WHERE e.uf=:estado");
        query.setParameter("estado", estado);
        
        List deputados = query.getResultList();
        
        return deputados;
        
    }
    
    public List<Deputados> buscaDeputadosPorPartido(String partido){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
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
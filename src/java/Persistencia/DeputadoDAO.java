/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelos.Deputados;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class DeputadoDAO {
    EntityManagerFactory deputados = Persistence.createEntityManagerFactory("PU");
    EntityManager manager = deputados.createEntityManager();
    
    public void addDeputado(Deputados deputado){
        manager.getTransaction().begin();
        manager.persist(deputado);
        manager.getTransaction().commit();
    }
    
    public void fechaConexao(){
        manager.close();
    }
}
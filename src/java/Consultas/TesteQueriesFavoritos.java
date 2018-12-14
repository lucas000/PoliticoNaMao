/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import Modelos.Favorito;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Lucas
 */
public class TesteQueriesFavoritos {
    public void apagaFavorito(Favorito fav) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();

        System.out.println("Favo: " + fav.toString());
        manager.getTransaction().begin();
        Query query = manager.createQuery("DELETE FROM Favorito e Where e.nomeParlamentar=:parlamentar and e.emailSeguidor=:seguidor");
        query.setParameter("parlamentar", fav.getNomeParlamentar());
        query.setParameter("seguidor", fav.getEmailSeguidor());
        query.executeUpdate();
        manager.getTransaction().commit();
        manager.close();
    }
    
    public Favorito buscaFavorito(String parlamentar, String seguidor) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Favorito e Where e.nomeParlamentar=:parlamentar and e.emailSeguidor=:seguidor");
        query.setParameter("parlamentar", parlamentar);
        query.setParameter("seguidor", seguidor);

        Favorito d = new Favorito();
        d = (Favorito) query.getSingleResult();
        
        return d;
        
    }
}

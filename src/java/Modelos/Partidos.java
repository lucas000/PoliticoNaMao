/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Allan
 */

@Entity
public class Partidos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String sigla;
    private String nome;
    private String uri;

    public Partidos(int id, String partido, String nome, String uri) {
        this.id = id;
        this.sigla = partido;
        this.nome = nome;
        this.uri = uri;
    }

    public Partidos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String partido) {
        this.sigla = partido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "Partidos{" + "id=" + id + ", sigla=" + sigla + ", nome=" + nome + ", uri=" + uri + '}';
    }
    
       
    
}

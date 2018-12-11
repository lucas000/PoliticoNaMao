/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Lucas
 */
@Entity
public class Favorito implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nomeParlamentar;
    private String nome;
    private String partido;
    private String estado;
    private String emailSeguidor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeParlamentar() {
        return nomeParlamentar;
    }

    public void setNomeParlamentar(String nomeParlamentar) {
        this.nomeParlamentar = nomeParlamentar;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmailSeguidor() {
        return emailSeguidor;
    }

    public void setEmailSeguidor(String emailSeguidor) {
        this.emailSeguidor = emailSeguidor;
    }

    @Override
    public String toString() {
        return "Favorito{" + "id=" + id + ", nomeParlamentar=" + nomeParlamentar + ", nome=" + nome + ", partido=" + partido + ", estado=" + estado + ", emailSeguidor=" + emailSeguidor + '}';
    }

    
}
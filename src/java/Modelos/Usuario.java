/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Lucas
 */

@Entity
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String email;
    private String senha;
    
    private int status;
    
    @Column(nullable=true)
    private int tentativas;
    
    @Column(nullable=true) 
    private String codigoAcesso;
    
public class Usuario {
    private int id;
    private String email;
    private String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", email=" + email + ", senha=" + senha + '}';
    }
}
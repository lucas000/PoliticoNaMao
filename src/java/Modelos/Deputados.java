package Modelos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
@Entity
public class Deputados {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private int ideCadastro;
    private String condicao;
    private String matricula;
    private int idParlamentar;
    private String nome;
    private String nomeParlamentar;
    private String urlFoto;
    private String sexo;
    private String uf;
    private String partido;
    private String gabinete;
    private String anexo;
    private String fone;
    private String email;

    public Deputados() {
    }

    public int getIdeCadastro() {
        return ideCadastro;
    }

    public void setIdeCadastro(int ideCadastro) {
        this.ideCadastro = ideCadastro;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getIdParlamentar() {
        return idParlamentar;
    }

    public void setIdParlamentar(int idParlamentar) {
        this.idParlamentar = idParlamentar;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeParlamentar() {
        return nomeParlamentar;
    }

    public void setNomeParlamentar(String nomeParlamentar) {
        this.nomeParlamentar = nomeParlamentar;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getGabinete() {
        return gabinete;
    }

    public void setGabinete(String gabinete) {
        this.gabinete = gabinete;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Deputados{" + "ideCadastro=" + ideCadastro + ", condicao=" + condicao + ", matricula=" + matricula + ", idParlamentar=" + idParlamentar + ", nome=" + nome + ", nomeParlamentar=" + nomeParlamentar + ", urlFoto=" + urlFoto + ", sexo=" + sexo + ", uf=" + uf + ", partido=" + partido + ", gabinete=" + gabinete + ", anexo=" + anexo + ", fone=" + fone + ", email=" + email + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
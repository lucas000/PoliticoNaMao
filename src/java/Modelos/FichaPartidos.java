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
public class FichaPartidos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String data;
    private String idLegislatura ;
    private String situacao;
    private String totalPosse;
    private String totalMembros;
    private String uri;
    private String nome;
    private String sigla;
    private String siglaPartido;
    private String uriPartido;
    private String uf;
    private String urlFoto;
    private String urlLogo;

    public FichaPartidos() {
    }

    
    
    public FichaPartidos(int id, String data, String idLegislatura, String situacao, String totalPosse, String totalMembros, String uri, String nome, String sigla, String siglaPartido, String uriPartido, String uf, String urlFoto, String urlLogo) {
        this.id = id;
        this.data = data;
        this.idLegislatura = idLegislatura;
        this.situacao = situacao;
        this.totalPosse = totalPosse;
        this.totalMembros = totalMembros;
        this.uri = uri;
        this.nome = nome;
        this.sigla = sigla;
        this.siglaPartido = siglaPartido;
        this.uriPartido = uriPartido;
        this.uf = uf;
        this.urlFoto = urlFoto;
        this.urlLogo = urlLogo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getIdLegislatura() {
        return idLegislatura;
    }

    public void setIdLegislatura(String idLegislatura) {
        this.idLegislatura = idLegislatura;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getTotalPosse() {
        return totalPosse;
    }

    public void setTotalPosse(String totalPosse) {
        this.totalPosse = totalPosse;
    }

    public String getTotalMembros() {
        return totalMembros;
    }

    public void setTotalMembros(String totalMembros) {
        this.totalMembros = totalMembros;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getSiglaPartido() {
        return siglaPartido;
    }

    public void setSiglaPartido(String siglaPartido) {
        this.siglaPartido = siglaPartido;
    }

    public String getUriPartido() {
        return uriPartido;
    }

    public void setUriPartido(String uriPartido) {
        this.uriPartido = uriPartido;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    @Override
    public String toString() {
        return "FichaPartidos{" + "id=" + id + ", data=" + data + ", idLegislatura=" + idLegislatura + ", situacao=" + situacao + ", totalPosse=" + totalPosse + ", totalMembros=" + totalMembros + ", uri=" + uri + ", nome=" + nome + ", sigla=" + sigla + ", siglaPartido=" + siglaPartido + ", uriPartido=" + uriPartido + ", uf=" + uf + ", urlFoto=" + urlFoto + ", urlLogo=" + urlLogo + '}';
    }
    
    
}

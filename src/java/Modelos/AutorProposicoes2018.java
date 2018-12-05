/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Lucas
 */
@Entity
public class AutorProposicoes2018 {
    
    @Id
    @GeneratedValue
    private int id;
    
    private int idProposicao;
    private String uriProposicao;
    private int idAutor;
    private String uriAutor;
    private int codTipoAutor;
    private String tipoAutor;
    private String nomeAutor;
    private String siglaPartidoAutor;
    private String uriPartidoAutor;
    private String siglaUFAutor;

    public AutorProposicoes2018() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdProposicao() {
        return idProposicao;
    }

    public void setIdProposicao(int idProposicao) {
        this.idProposicao = idProposicao;
    }

    public String getUriProposicao() {
        return uriProposicao;
    }

    public void setUriProposicao(String uriProposicao) {
        this.uriProposicao = uriProposicao;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getUriAutor() {
        return uriAutor;
    }

    public void setUriAutor(String uriAutor) {
        this.uriAutor = uriAutor;
    }

    public int getCodTipoAutor() {
        return codTipoAutor;
    }

    public void setCodTipoAutor(int codTipoAutor) {
        this.codTipoAutor = codTipoAutor;
    }

    public String getTipoAutor() {
        return tipoAutor;
    }

    public void setTipoAutor(String tipoAutor) {
        this.tipoAutor = tipoAutor;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getSiglaPartidoAutor() {
        return siglaPartidoAutor;
    }

    public void setSiglaPartidoAutor(String siglaPartidoAutor) {
        this.siglaPartidoAutor = siglaPartidoAutor;
    }

    public String getUriPartidoAutor() {
        return uriPartidoAutor;
    }

    public void setUriPartidoAutor(String uriPartidoAutor) {
        this.uriPartidoAutor = uriPartidoAutor;
    }

    public String getSiglaUFAutor() {
        return siglaUFAutor;
    }

    public void setSiglaUFAutor(String siglaUFAutor) {
        this.siglaUFAutor = siglaUFAutor;
    }
    
    @Override
    public String toString() {
        return "AutorProposicoes_2018{" + "idProposicao=" + idProposicao + ", idAutor=" + idAutor + ", uriAutor=" + uriAutor + ", codTipoAutor=" + codTipoAutor + ", tipoAutor=" + tipoAutor + ", nomeAutor=" + nomeAutor + ", siglaPartidoAutor=" + siglaPartidoAutor + ", uriPartidoAutor=" + uriPartidoAutor + ", siglaUFAutor=" + siglaUFAutor + '}';
    }

}

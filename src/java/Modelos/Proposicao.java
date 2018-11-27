/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;

/**
 *
 * @author ifgoiano
 */
@Entity
public class Proposicao {

    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String uri;
    private int numero;
    private int ano;
    private int idTipo;
    @Column(length = 2000)
    private String ementa;
    private String dataApresentacao;
    private String uriOrgaoNumerador;
    private String urlInteiroTeor;
    private String ultimoStatus_descricaoTramitacao;
    private String ultimoStatus_descricaoSituacao;

    public Proposicao(int id, String uri, int numero, int ano, int idTipo, String ementa, String dataApresentacao, String uriOrgaoNumerador, String urlInteiroTeor, String ultimoStatus_descricaoTramitacao, String ultimoStatus_descricaoSituacao) {
        this.id = id;
        this.uri = uri;
        this.numero = numero;
        this.ano = ano;
        this.idTipo = idTipo;
        this.ementa = ementa;
        this.dataApresentacao = dataApresentacao;
        this.uriOrgaoNumerador = uriOrgaoNumerador;
        this.urlInteiroTeor = urlInteiroTeor;
        this.ultimoStatus_descricaoTramitacao = ultimoStatus_descricaoTramitacao;
        this.ultimoStatus_descricaoSituacao = ultimoStatus_descricaoSituacao;
    }

    public Proposicao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getDataApresentacao() {
        return dataApresentacao;
    }

    public void setDataApresentacao(String dataApresentacao) {
        this.dataApresentacao = dataApresentacao;
    }

    public String getUriOrgaoNumerador() {
        return uriOrgaoNumerador;
    }

    public void setUriOrgaoNumerador(String uriOrgaoNumerador) {
        this.uriOrgaoNumerador = uriOrgaoNumerador;
    }

    public String getUrlInteiroTeor() {
        return urlInteiroTeor;
    }

    public void setUrlInteiroTeor(String urlInteiroTeor) {
        this.urlInteiroTeor = urlInteiroTeor;
    }

    public String getUltimoStatus_descricaoTramitacao() {
        return ultimoStatus_descricaoTramitacao;
    }

    public void setUltimoStatus_descricaoTramitacao(String ultimoStatus_descricaoTramitacao) {
        this.ultimoStatus_descricaoTramitacao = ultimoStatus_descricaoTramitacao;
    }

    public String getUltimoStatus_descricaoSituacao() {
        return ultimoStatus_descricaoSituacao;
    }

    public void setUltimoStatus_descricaoSituacao(String ultimoStatus_descricaoSituacao) {
        this.ultimoStatus_descricaoSituacao = ultimoStatus_descricaoSituacao;
    }

    @Override
    public String toString() {
        return "Preposicao{" + "id=" + id + ", uri=" + uri + ", numero=" + numero + ", ano=" + ano + ", idTipo=" + idTipo + ", ementa=" + ementa + ", dataApresentacao=" + dataApresentacao + ", uriOrgaoNumerador=" + uriOrgaoNumerador + ", urlInteiroTeor=" + urlInteiroTeor + ", ultimoStatus_descricaoTramitacao=" + ultimoStatus_descricaoTramitacao + ", ultimoStatus_descricaoSituacao=" + ultimoStatus_descricaoSituacao + '}';
    }

    

}

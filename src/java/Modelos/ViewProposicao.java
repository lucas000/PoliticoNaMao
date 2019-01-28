/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Vicom
 */
public class ViewProposicao {
    
    private int id;
    private String ementa;
    private String Situacao;
    private String autor;
    private int idAutor;
    private String data;
    private int ano;

    public ViewProposicao(int id, String ementa, String Situacao, String autor, int idAutor, String data, int ano) {
        this.id = id;
        this.ementa = ementa;
        this.Situacao = Situacao;
        this.autor = autor;
        this.idAutor = idAutor;
        this.data = data;
        this.ano = ano;
    }

    public ViewProposicao() {
    }

    

    @Override
    public String toString() {
        return "ViewProposicao{" + "id=" + id + ", ementa=" + ementa + ", Situacao=" + Situacao + ", autor=" + autor + ", idAutor=" + idAutor + ", data=" + data + ", ano=" + ano + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getSituacao() {
        return Situacao;
    }

    public void setSituacao(String Situacao) {
        this.Situacao = Situacao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Vicom
 */
public class ViewProposicao {
    
    private int id;
    private String ementa;
    private String Situacao;
    private String autor;
    private int idAutor;
    private String data;
    private int ano;

    public ViewProposicao(int id, String ementa, String Situacao, String autor, int idAutor, String data, int ano) {
        this.id = id;
        this.ementa = ementa;
        this.Situacao = Situacao;
        this.autor = autor;
        this.idAutor = idAutor;
        this.data = data;
        this.ano = ano;
    }

    public ViewProposicao() {
    }

    

    @Override
    public String toString() {
        return "ViewProposicao{" + "id=" + id + ", ementa=" + ementa + ", Situacao=" + Situacao + ", autor=" + autor + ", idAutor=" + idAutor + ", data=" + data + ", ano=" + ano + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getSituacao() {
        return Situacao;
    }

    public void setSituacao(String Situacao) {
        this.Situacao = Situacao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    
    
}

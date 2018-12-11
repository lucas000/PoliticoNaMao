/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;

/**
 *
 * @author Vicom
 */
@Entity
public class ProposicaoAutor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPropAutor;
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

    public ProposicaoAutor(long idPropAutor, int idProposicao, String uriProposicao, int idAutor, String uriAutor, int codTipoAutor, String tipoAutor, String nomeAutor, String siglaPartidoAutor, String uriPartidoAutor, String siglaUFAutor) {
        this.idPropAutor = idPropAutor;
        this.idProposicao = idProposicao;
        this.uriProposicao = uriProposicao;
        this.idAutor = idAutor;
        this.uriAutor = uriAutor;
        this.codTipoAutor = codTipoAutor;
        this.tipoAutor = tipoAutor;
        this.nomeAutor = nomeAutor;
        this.siglaPartidoAutor = siglaPartidoAutor;
        this.uriPartidoAutor = uriPartidoAutor;
        this.siglaUFAutor = siglaUFAutor;
    }

    public ProposicaoAutor() {
    }

    public long getIdPropAutor() {
        return idPropAutor;
    }

    public void setIdPropAutor(long idPropAutor) {
        this.idPropAutor = idPropAutor;
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
        return "ProposicaoAutor{" + "idPropAutor=" + idPropAutor + ", idProposicao=" + idProposicao + ", uriProposicao=" + uriProposicao + ", idAutor=" + idAutor + ", uriAutor=" + uriAutor + ", codTipoAutor=" + codTipoAutor + ", tipoAutor=" + tipoAutor + ", nomeAutor=" + nomeAutor + ", siglaPartidoAutor=" + siglaPartidoAutor + ", uriPartidoAutor=" + uriPartidoAutor + ", siglaUFAutor=" + siglaUFAutor + '}';
    }
    
    
     static public void lerProposicaoAutor() throws ParseException, IOException {

      //  baixarPreposicoesDiretorio();
    //    List<File> listaDir = Proposicao.ler_Arquivos_Diretorio();
    //    List<Preposicao> lista = new ArrayList<>();
    
    
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
            EntityManager manager = factory.createEntityManager();
    
            String arquivoCSV = "C:\\Users\\Lucas\\Desktop\\proposicoesAutores-2018.csv";
            BufferedReader br = null;
            String linha = "";
            String csvDivisor = ";";
            try {

                br = new BufferedReader(new FileReader(arquivoCSV));

                
                
                
                br.readLine();
                while ((linha = br.readLine()) != null) {
                    linha = linha.replaceAll("\"", "");
                    String[] l = linha.split(csvDivisor);
                    
                    
                  
                  
                if (l.length == 10) {
                    
                  ProposicaoAutor novo = new ProposicaoAutor();  
                  novo.setIdProposicao(Integer.parseInt(l[0]));
                  novo.setUriProposicao(l[1]);
                  novo.setIdAutor(Integer.parseInt(l[2]));
                  novo.setUriAutor(l[3]);
                  novo.setCodTipoAutor(Integer.parseInt(l[4]));
                  novo.setTipoAutor(l[5]);
                  novo.setNomeAutor(l[6]);
                  novo.setSiglaPartidoAutor(l[7]);
                  novo.setUriPartidoAutor(l[8]);
                  novo.setSiglaUFAutor(l[9]);
                  
                  if(novo.getCodTipoAutor() == 10000){
                  manager.getTransaction().begin();
                  manager.persist(novo);
                  manager.getTransaction().commit();
                  }
                  
                }

                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(Proposicao.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            
          manager.close();
          factory.close();

        }
}
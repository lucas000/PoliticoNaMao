package Modelos;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
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

@Entity
public class DespesasCotaExercicioAtividadeParlamentar_1 implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDespCota;
    private String txNomeParlamentar;
    private String txtDescricao;
    private String txtDescricaoEspecificacao;
    private String txtFornecedor;
    private String datEmissao;
    private double vlrDocumento;
    private double vlrLiquido;
    private String txtPassageiro;

    public DespesasCotaExercicioAtividadeParlamentar_1() {
    }

    public DespesasCotaExercicioAtividadeParlamentar_1(int idDespCota, String txNomeParlamentar, String txtDescricao, String txtDescricaoEspecificacao, String txtFornecedor, String datEmissao, double vlrDocumento, double vlrLiquido, String txtPassageiro) {
        this.idDespCota = idDespCota;
        this.txNomeParlamentar = txNomeParlamentar;
        this.txtDescricao = txtDescricao;
        this.txtDescricaoEspecificacao = txtDescricaoEspecificacao;
        this.txtFornecedor = txtFornecedor;
        this.datEmissao = datEmissao;
        this.vlrDocumento = vlrDocumento;
        this.vlrLiquido = vlrLiquido;
        this.txtPassageiro = txtPassageiro;
    }

 

    public String getTxnomeparlamentar() {
        return txNomeParlamentar;
    }

    public void setTxnomeparlamentar(String txNomeParlamentar) {
        this.txNomeParlamentar = txNomeParlamentar;
    }

    public String getTxtdescricao() {
        return txtDescricao;
    }

    public void setTxtdescricao(String txtDescricao) {
        this.txtDescricao = txtDescricao;
    }

    public String getTxtdescricaoespecificacao() {
        return txtDescricaoEspecificacao;
    }

    public void setTxtdescricaoespecificacao(String txtDescricaoEspecificacao) {
        this.txtDescricaoEspecificacao = txtDescricaoEspecificacao;
    }

    public String getTxtfornecedor() {
        return txtFornecedor;
    }

    public void setTxtfornecedor(String txtFornecedor) {
        this.txtFornecedor = txtFornecedor;
    }

    public String getDatemissao() {
        return datEmissao;
    }

    public void setDatemissao(String datEmissao) {
        this.datEmissao = datEmissao;
    }

    public double getVlrdocumento() {
        return vlrDocumento;
    }

    public void setVlrdocumento(double vlrDocumento) {
        this.vlrDocumento = vlrDocumento;
    }

    public double getVlrliquido() {
        return vlrLiquido;
    }

    public void setVlrliquido(double vlrLiquido) {
        this.vlrLiquido = vlrLiquido;
    }

    public String getTxtpassageiro() {
        return txtPassageiro;
    }

    public void setTxtpassageiro(String txtPassageiro) {
        this.txtPassageiro = txtPassageiro;
    }

    @Override
    public String toString() {
        return "DespesasCotaExercicioAtividadeParlamentar{" + "txNomeParlamentar=" + txNomeParlamentar + ", txtDescricao=" + txtDescricao + ", txtDescricaoEspecificacao=" + txtDescricaoEspecificacao + ", txtFornecedor=" + txtFornecedor + ", datEmissao=" + datEmissao + ", vlrDocumento=" + vlrDocumento + ", vlrLiquido=" + vlrLiquido + ", txtPassageiro=" + txtPassageiro + '}';
    }
    
    
   static public List<DespesasCotaExercicioAtividadeParlamentar_1> ler(){
        
        
        List<DespesasCotaExercicioAtividadeParlamentar_1> lista = new ArrayList<>();
                
        String arquivoCSV = "C:\\Users\\Lucas\\Desktop\\Ano-2018.csv";
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ";";
        
  
        try {

        br = new BufferedReader(new FileReader(arquivoCSV));
        br.readLine();
         EntityManagerFactory deputadosss = Persistence.createEntityManagerFactory("DespesasCotaExercicioAtividadeParlamentar_1");
            EntityManager manager = deputadosss.createEntityManager();
        while ((linha = br.readLine()) != null) {
      //  linha = linha.replaceAll("\"","");
         DespesasCotaExercicioAtividadeParlamentar_1 novo = new DespesasCotaExercicioAtividadeParlamentar_1();
          String [] l = linha.split(csvDivisor);
          
          String vlrdocumento = "";
          String vlrliquido = "";
          
          novo.setTxnomeparlamentar(l[0]);
          novo.setTxtdescricao(l[8]);
          novo.setTxtdescricaoespecificacao(l[10]);
          novo.setTxtfornecedor(l[11]);
          novo.setDatemissao(l[15]);
          vlrdocumento = l[16].replaceAll(",", ".");
          vlrliquido = l[18].replaceAll(",", ".");
          novo.setVlrdocumento(Double.parseDouble(vlrdocumento));
          novo.setVlrliquido(Double.parseDouble(vlrliquido));
          novo.setTxtpassageiro(l[22]);

          manager.getTransaction().begin();
                        manager.persist(novo);
                        manager.getTransaction().commit();
          
          
        }
        manager.close();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }   catch (IOException ex) {
        } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
  
        
        
    
    return lista;
    }

    public String getTxNomeParlamentar() {
        return txNomeParlamentar;
    }

    public void setTxNomeParlamentar(String txNomeParlamentar) {
        this.txNomeParlamentar = txNomeParlamentar;
    }
    
    
      static public void salvarBanco(List<DespesasCotaExercicioAtividadeParlamentar_1> l) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("despesasCotaExercicioAtividadeParlamentar");

        EntityManager manager = factory.createEntityManager();
        for (int i = 0; i < 5; i++) {

           DespesasCotaExercicioAtividadeParlamentar_1 t = l.get(i);

            manager.getTransaction().begin();
            manager.persist(t);
            manager.getTransaction().commit();

        }

        manager.close();
        factory.close();

    }
}
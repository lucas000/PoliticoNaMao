/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lendo;

import Modelos.Proposicao;
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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Vicom
 */
public class ProposicaoDOM {
    
    static public void lerPreposicao2018() throws ParseException {

        // List<Preposicao> lista = new ArrayList<>();
        //List li = ProposicaoDOM.ler_Arquivos_Diretorio();
        String diretorio = "C:\\Users\\Lucas\\Desktop\\proposicoes-2018.csv";
        String arquivoCSV = diretorio;
      
        String datahora;
        String data;
      
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Partidos");
        EntityManager manager = factory.createEntityManager();

        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ";";
        try {

            br = new BufferedReader(new FileReader(arquivoCSV));

            br.readLine();

            int quant = ProposicaoDOM.quantidade2018();

            for (int i = 0; i <quant; i++) {
                linha = br.readLine();
                linha = linha.replaceAll("\"", "");
                Proposicao novo = new Proposicao();
                String[] l = linha.split(csvDivisor);

                if (i == 6862 || i == 6863 || i == 6868) {

                    continue;
                }

                if (l[0].length() == 7 && l[1].charAt(0) == 'h' && l.length == 29) {

                    novo.setId(Integer.parseInt(l[0]));
                    novo.setUri(l[1]);
                    novo.setNumero(Integer.parseInt(l[3]));
                    novo.setAno(Integer.parseInt(l[4]));
                    novo.setIdTipo(Integer.parseInt(l[5]));
                    novo.setEmenta(l[7]);
                    datahora = l[10];
                    String vet[] = datahora.split("T");
                    data = vet[0];
                    novo.setDataApresentacao(data);
                    novo.setUriOrgaoNumerador(l[11]);
                    novo.setUrlInteiroTeor(l[15]);
                    novo.setUltimoStatus_descricaoTramitacao(l[24]);
                    novo.setUltimoStatus_descricaoSituacao(l[26]);

                    manager.getTransaction().begin();
                    manager.persist(novo);
                    manager.getTransaction().commit();

                    //  lista.add(novo);
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(ProposicaoDOM.class.getName()).log(Level.SEVERE, null, ex);
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

    static public int quantidade2018() {
//        List li = ProposicaoDOM.ler_Arquivos_Diretorio();
        String diretorio = "C:\\Users\\Lucas\\Desktop\\proposicoes-2018.csv";
        String arquivoCSV = diretorio;
        BufferedReader br = null;
        String linha = "";
        int cont = 0;
        try {

            br = new BufferedReader(new FileReader(arquivoCSV));
            br.readLine();
            while ((linha = br.readLine()) != null) {

                cont++;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(ProposicaoDOM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return cont;
    }

    static public void lerPreposicoes() throws ParseException, IOException {

      //  baixarPreposicoesDiretorio();
        //List<File> listaDir = ProposicaoDOM.ler_Arquivos_Diretorio();
    //    List<Preposicao> lista = new ArrayList<>();
    
    
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Partidos");
        EntityManager manager = factory.createEntityManager();

        
        String datahora;
        String data;
        
        //for (int j = 0; j < listaDir.size(); j++) {

            String arquivoCSV = "C:\\Users\\Lucas\\Desktop\\proposicoes-2018.csv";
            BufferedReader br = null;
            String linha = "";
            String csvDivisor = ";";
            try {

                br = new BufferedReader(new FileReader(arquivoCSV));

                br.readLine();
                while ((linha = br.readLine()) != null) {
                    linha = linha.replaceAll("\"", "");
                    Proposicao novo = new Proposicao();
                    String[] l = linha.split(csvDivisor);
                  
                if (l.length > 0) {

                    if (l[0].length() >= 5 && l.length == 29 && l[1].charAt(0) == 'h') {

                        novo.setId(Integer.parseInt(l[0]));
                        novo.setUri(l[1]);
                        novo.setNumero(Integer.parseInt(l[3]));
                        novo.setAno(Integer.parseInt(l[4]));
                        novo.setIdTipo(Integer.parseInt(l[5]));
                        novo.setEmenta(l[7]);
                        datahora = l[10];
                        String vet[] = datahora.split("T");
                        data = vet[0];
                    novo.setDataApresentacao(data);
                        novo.setUriOrgaoNumerador(l[11]);
                        novo.setUrlInteiroTeor(l[15]);
                        novo.setUltimoStatus_descricaoTramitacao(l[24]);
                        novo.setUltimoStatus_descricaoSituacao(l[26]);

                        manager.getTransaction().begin();
                        manager.persist(novo);
                        manager.getTransaction().commit();

                    }
                }

                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(ProposicaoDOM.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        //}
        
          manager.close();
        factory.close();

       
    }
/*
    static public void baixarPreposicoesDiretorio() throws IOException {

        String[] lista_arquivos = {"proposicoes-2000.csv", "proposicoes-2001.csv", "proposicoes-2002.csv",
            "proposicoes-2003.csv", "proposicoes-2004.csv", "proposicoes-2005.csv", "proposicoes-2006.csv",
            "proposicoes-2007.csv", "proposicoes-2008.csv", "proposicoes-2009.csv", "proposicoes-2010.csv",
            "proposicoes-2011.csv", "proposicoes-2012.csv", "proposicoes-2013.csv", "proposicoes-2014.csv",
            "proposicoes-2015.csv", "proposicoes-2016.csv", "proposicoes-2017.csv", "proposicoes-2018.csv"};

        //for (int i = 0; i < lista_arquivos.length - 10; i++) {

            //URL url = new URL("https://dadosabertos.camara.leg.br/arquivos/proposicoes/csv/" + lista_arquivos[i]);
            String destino = "E:\\GitHub\\PoliticoNaMao\\src\\java\\Arquivos\\Preposicoes_2000_2018\\proposicoes-2000.csv";
            //String destino = "L:\\HOJE 1\\Preposicoes_2000_2018" + lista_arquivos[i];

            InputStream is = url.openStream();

            FileOutputStream fos = new FileOutputStream(destino);

            int bytes = 0;

            while ((bytes = is.read()) != -1) {
                fos.write(bytes);
            }

            is.close();

            fos.close();
        //}

    }
*/
    static public List<File> ler_Arquivos_Diretorio() {
        List<File> lista = new ArrayList<>();
        // File file = new File("/home/ifgoiano/Área de Trabalho/Preposicoes_2000_2018");
        File file = new File("..\\PoliticoNaMao\\src\\java\\Arquivos\\Preposicoes_2000_2018");
        

        File[] arquivos = file.listFiles();

        for (File arquivo : arquivos) {
            lista.add(arquivo);
        }

        return lista;

    }

    
}

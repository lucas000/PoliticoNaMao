/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Log;


import static com.oracle.jrockit.jfr.ContentType.Bytes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author Allan
 */

public class ArquivoLog {

    public ArquivoLog() {
    }
    
   public void gerarLog(String log){

       String texto = readLog();
       if(texto.isEmpty()){
           write(log);
       }else{
           System.out.println("Leitura feita!");
           
           write(texto+log);
       }
        
        
           
       
   } 
    
    private static String readLog(){
        String caminho= "D:\\A\\PoliticoNaMao\\src\\java\\Log\\RegistroDeLog.txt";
        String conteudo = "";
        
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerarq = new BufferedReader(arq);
            String linha = "";
            
            try {
                linha = lerarq.readLine();
                while(linha!=null){
                conteudo+=linha+"\r\n";    
                linha = lerarq.readLine();
                }
                arq.close();
                
    return conteudo;
                
            } catch (IOException ex) {
                System.out.println("Erro ao ler arquivo:"+ex);
                
       return "";    
            }
        } catch (FileNotFoundException ex) {
                System.out.println("Log Criado!");
            
       return "";    
        }
    }
    private static boolean write(String log){
        String caminho= "D:\\A\\PoliticoNaMao\\src\\java\\Log\\RegistroDeLog.txt";
        try {
            FileWriter arq = new FileWriter(caminho);
            PrintWriter gravararq = new PrintWriter(arq);
            gravararq.println(log);
            gravararq.close();
            System.out.println("Log Gravado!"); 
            
            return true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        return false;
        }
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lendo;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Allan
 */
public class TestePartidosDOM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        try {
            PartidosDOM myExampleDOM = new PartidosDOM();
       
            // Imprimir os dados do arquivo
            myExampleDOM.fazerParsing("..\\PoliticoNaMao\\src\\java\\Arquivos\\Partidos.xml");
            // Contar a quantidade de paises
            //System.out.printf("\nExistem %d países neste documento\n\n", myExampleSax.contadorPaises);       
        } catch (ParserConfigurationException | SAXException | IOException e) {
            StringBuffer msg = new StringBuffer();
            msg.append("Erro:\n");
            msg.append(e.getMessage() + "\n");
            msg.append(e.toString());
            System.out.println(msg);
        }
    }
        
    }
    


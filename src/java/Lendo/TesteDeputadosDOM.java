/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lendo;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Lucas
 */
public class TesteDeputadosDOM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException, SAXException, ParserConfigurationException {
        URL url = new URL("http://www.camara.gov.br/SitCamaraWS/Deputados.asmx/ObterDeputados");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream content = connection.getInputStream();
        
        new DeputadosDOM().fazerParsing(content);
    }
}
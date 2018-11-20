/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lendo;

import Modelos.Deputados;
import Modelos.Partidos;
import Persistencia.DeputadoDAO;
import Persistencia.PartidosDAO;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Allan
 */
public class PartidosDOM {
     public void fazerParsing(String pathArq) throws SAXException,
            IOException, ParserConfigurationException {

        File xmlFile = new File(pathArq);
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        //System.out.println("Elemento raiz: " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("partido_");
        System.out.println("Quantidade de partidos: " + nList.getLength());
        
        PartidosDAO dao = new PartidosDAO();
        
        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);

            //System.out.println("\nElemento corrente: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) nNode;

               

                Node node2 = elem.getElementsByTagName("sigla").item(0);
                String sigla = node2.getTextContent();

                Node node3 = elem.getElementsByTagName("nome").item(0);
                String nome = node3.getTextContent();

                Node node4 = elem.getElementsByTagName("uri").item(0);
                String uri = node4.getTextContent();
                
                             
                Partidos partido = new Partidos();
                
                partido.setNome(nome);
                partido.setSigla(sigla);
                partido.setUri(uri);
               
                
                dao.addPartido(partido);
                System.out.println(partido.toString());
                
            } // end if
        } // end for
        dao.fechaConexao();
        //System.out.printf("\nQuantidade de países: %d\n\n", nList.getLength());
    } // end method fazerParsing
}

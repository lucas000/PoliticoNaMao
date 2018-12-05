/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lendo;

import Modelos.Deputados;
import Modelos.FichaPartidos;
import Persistencia.DeputadoDAO;
import Persistencia.FichaPartidosDAO;
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
public class FichaPartidosDOM {
    public void fazerParsing(String pathArq) throws SAXException,
            IOException, ParserConfigurationException {

        File xmlFile = new File(pathArq);
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        //System.out.println("Elemento raiz: " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("dados");
        System.out.println("Quantidade de FichaPartidos: " + nList.getLength());
        
        FichaPartidosDAO dao = new FichaPartidosDAO();
        
        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);

            //System.out.println("\nElemento corrente: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) nNode;
                Node node0 = elem.getElementsByTagName("nome").item(0);
                String nome = node0.getTextContent();

                Node node1 = elem.getElementsByTagName("data").item(0);
                String data = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("idLegislatura").item(0);
                String idLegislatura = node2.getTextContent();

                Node node3 = elem.getElementsByTagName("situacao").item(0);
                String situacao = node3.getTextContent();

                Node node4 = elem.getElementsByTagName("totalPosse").item(0);
                String totalPosse = node4.getTextContent();
                
                Node node5 = elem.getElementsByTagName("totalMembros").item(0);
                String totalMembros = node5.getTextContent();

                           
                Node node7 = elem.getElementsByTagName("uri").item(0);
                String uri = node7.getTextContent();

                Node node8 = elem.getElementsByTagName("nomel").item(0);
                String nomel = node8.getTextContent();
                
                Node node9 = elem.getElementsByTagName("sigla").item(0);
                String sigla = node9.getTextContent();

                Node node10 = elem.getElementsByTagName("siglaPartido").item(0);
                String siglaPartido = node10.getTextContent();
            
                Node node11 = elem.getElementsByTagName("uriPartido").item(0);
                String uriPartido = node11.getTextContent();

                Node node12 = elem.getElementsByTagName("uf").item(0);
                String uf = node12.getTextContent();
                
                Node node13 = elem.getElementsByTagName("urlFoto").item(0);
                String urlFoto = node13.getTextContent();

                Node node14 = elem.getElementsByTagName("urlLogo").item(0);
                String urlLogo = node14.getTextContent();
                
                FichaPartidos fpartidos = new FichaPartidos();
                
                fpartidos.setNome(nome);
                fpartidos.setData(data);
                fpartidos.setIdLegislatura(idLegislatura);
                fpartidos.setSituacao(situacao);
                fpartidos.setTotalPosse(totalPosse);
                fpartidos.setTotalMembros(totalMembros);
                
                fpartidos.setUri(uri);
                fpartidos.setNomel(nomel);
                fpartidos.setSigla(sigla);
                fpartidos.setSiglaPartido(siglaPartido);
                fpartidos.setUriPartido(uriPartido);
                fpartidos.setUf(uf);
                fpartidos.setUrlFoto(urlFoto);
                fpartidos.setUrlLogo(urlLogo);
                
                dao.addFichaPartido(fpartidos);
                System.out.println(fpartidos.toString());
                
            } // end if
        } // end for
        dao.fechaConexao();
        //System.out.printf("\nQuantidade de países: %d\n\n", nList.getLength());
    } // end method fazerParsing
    
}

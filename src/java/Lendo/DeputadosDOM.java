/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lendo;

import Modelos.Deputados;
import Persistencia.DeputadoDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
 * @author Lucas
 */


public class DeputadosDOM {
    public void fazerParsing(InputStream pathArq) throws SAXException,
            IOException, ParserConfigurationException {
        OutputStream outputStream = null;
        //InputStream raw = new FileInputStream(new File(xml_file_path));
        File file = new File("..\\PoliticoNaMao\\src\\java\\Arquivos\\DeputadosTitulares.xml");
        outputStream = new FileOutputStream(file);
        
        int read = 0;
        byte[] bytes = new byte[1024];
        while ((read = pathArq.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }
        File xmlFile = new File("..\\PoliticoNaMao\\src\\java\\Arquivos\\DeputadosTitulares.xml");
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        //System.out.println("Elemento raiz: " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("deputado");
        System.out.println("Quantidade de deputados: " + nList.getLength());
        
        DeputadoDAO dao = new DeputadoDAO();
        
        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);

            //System.out.println("\nElemento corrente: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) nNode;

                Node node1 = elem.getElementsByTagName("ideCadastro").item(0);
                String ideCadastro = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("condicao").item(0);
                String condicao = node2.getTextContent();

                Node node3 = elem.getElementsByTagName("matricula").item(0);
                String matricula = node3.getTextContent();

                Node node4 = elem.getElementsByTagName("idParlamentar").item(0);
                String idParlamentar = node4.getTextContent();
                
                Node node5 = elem.getElementsByTagName("nome").item(0);
                String nome = node5.getTextContent();

                Node node6 = elem.getElementsByTagName("nomeParlamentar").item(0);
                String nomeParlamentar = node6.getTextContent();
            
                Node node7 = elem.getElementsByTagName("urlFoto").item(0);
                String urlFoto = node7.getTextContent();

                Node node8 = elem.getElementsByTagName("sexo").item(0);
                String sexo = node8.getTextContent();
                
                Node node9 = elem.getElementsByTagName("uf").item(0);
                String uf = node9.getTextContent();

                Node node10 = elem.getElementsByTagName("partido").item(0);
                String partido = node10.getTextContent();
            
                Node node11 = elem.getElementsByTagName("gabinete").item(0);
                String gabinete = node11.getTextContent();

                Node node12 = elem.getElementsByTagName("anexo").item(0);
                String anexo = node12.getTextContent();
                
                Node node13 = elem.getElementsByTagName("fone").item(0);
                String fone = node13.getTextContent();

                Node node14 = elem.getElementsByTagName("email").item(0);
                String email = node14.getTextContent();
                
                Deputados deputado = new Deputados();
                
                deputado.setIdeCadastro(Integer.parseInt(ideCadastro));
                deputado.setCondicao(condicao);
                deputado.setMatricula(matricula);
                deputado.setIdParlamentar(Integer.parseInt(idParlamentar));
                deputado.setNome(nome);
                deputado.setNomeParlamentar(nomeParlamentar);
                deputado.setUrlFoto(urlFoto);
                deputado.setSexo(sexo);
                deputado.setUf(uf);
                deputado.setPartido(partido);
                deputado.setGabinete(gabinete);
                deputado.setAnexo(anexo);
                deputado.setFone(fone);
                deputado.setEmail(email);
                
                //dao.addDeputado(deputado);
                System.out.println(deputado.toString());
                
            } // end if
        } // end for
        dao.fechaConexao();
        //System.out.printf("\nQuantidade de países: %d\n\n", nList.getLength());
    } // end method fazerParsing
}

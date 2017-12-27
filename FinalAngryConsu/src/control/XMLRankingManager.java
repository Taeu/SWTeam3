/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author user
 */
public class XMLRankingManager {
     Document doc;
    private File xmlFile;
    DocumentBuilderFactory dbFactory;
    DocumentBuilder dBuilder;
    

    public HashMap readXML(String filePath, String fileName) throws IOException {
        try {
            xmlFile = new File(filePath, fileName);
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataConvert();
    }

    private HashMap dataConvert() {
        HashMap xmlDataHashMap = new HashMap();
        HashMap dataMapper;

        NodeList nList = doc.getElementsByTagName("brandranking");
        if (nList == null) {
            return null;
        }
        for (int i = 0; i < nList.getLength(); i++) {
            dataMapper = new HashMap();
            Node nNode = nList.item(i);
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;

                dataMapper.put("id", element.getElementsByTagName("id").item(0).getTextContent());
                                dataMapper.put("name", element.getElementsByTagName("name").item(0).getTextContent());

                dataMapper.put("industry", element.getElementsByTagName("industry").item(0).getTextContent());
                dataMapper.put("bci", element.getElementsByTagName("bci").item(0).getTextContent());
                dataMapper.put("rank", element.getElementsByTagName("rank").item(0).getTextContent());
                dataMapper.put("rankTime", element.getElementsByTagName("rankTime").item(0).getTextContent());
                dataMapper.put("numComplaint", element.getElementsByTagName("numComplaint").item(0).getTextContent());
                dataMapper.put("overall", element.getElementsByTagName("overall").item(0).getTextContent());
                dataMapper.put("speed", element.getElementsByTagName("speed").item(0).getTextContent());
                dataMapper.put("detailedness", element.getElementsByTagName("detailedness").item(0).getTextContent());
                dataMapper.put("process", element.getElementsByTagName("process").item(0).getTextContent());

                xmlDataHashMap.put(element.getAttribute("num"), dataMapper);
            }
                    
        }

        return xmlDataHashMap;
    }


    public String searchXML(String filePath, String fileName) throws IOException, ParserConfigurationException,
            SAXException, TransformerConfigurationException, TransformerException {
        xmlFile = new File(filePath, fileName);
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(xmlFile);
        Node nNode;
        Element element;
        String A = "";
        NodeList nList = doc.getElementsByTagName("clikeduser");
        for (int i = 0; i < nList.getLength(); i++) {
            System.out.println("nList " +nList.getLength());
            nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                element = (Element) nNode;
                NodeList list = nNode.getChildNodes();
                
                    for (int j = 0 ; j < list.getLength();j++){
                        Node nnn = list.item(j);
                        if("status".equals(nnn.getNodeName())){
                           A = nnn.getTextContent();
                        }
                        
                    }
                
            }
        }
        
        doc.getDocumentElement().normalize();

        DOMSource xmlDOM = new DOMSource(doc);
        StreamResult xmlResultFile = new StreamResult(new File(filePath, fileName));
        TransformerFactory.newInstance().newTransformer().transform(xmlDOM, xmlResultFile);
        
        return A;
     }
     public String searchNameXML(String filePath, String fileName) throws IOException, ParserConfigurationException,
            SAXException, TransformerConfigurationException, TransformerException {
        xmlFile = new File(filePath, fileName);
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(xmlFile);
        Node nNode;
        Element element;
        String A = "";
        NodeList nList = doc.getElementsByTagName("clikeduser");
        for (int i = 0; i < nList.getLength(); i++) {
            System.out.println("nList " +nList.getLength());
            nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                element = (Element) nNode;
                NodeList list = nNode.getChildNodes();
                
                    for (int j = 0 ; j < list.getLength();j++){
                        Node nnn = list.item(j);
                        if("name".equals(nnn.getNodeName())){
                           A = nnn.getTextContent();
                        }
                        
                    }
                
            }
        }
        
        doc.getDocumentElement().normalize();

        DOMSource xmlDOM = new DOMSource(doc);
        StreamResult xmlResultFile = new StreamResult(new File(filePath, fileName));
        TransformerFactory.newInstance().newTransformer().transform(xmlDOM, xmlResultFile);
        
        return A;
     }
     public String searchIdXML(String filePath, String fileName) throws IOException, ParserConfigurationException,
            SAXException, TransformerConfigurationException, TransformerException {
        xmlFile = new File(filePath, fileName);
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(xmlFile);
        Node nNode;
        Element element;
        String A = "";
        NodeList nList = doc.getElementsByTagName("clikeduser");
        for (int i = 0; i < nList.getLength(); i++) {
            System.out.println("nList " +nList.getLength());
            nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                element = (Element) nNode;
                NodeList list = nNode.getChildNodes();
                
                    for (int j = 0 ; j < list.getLength();j++){
                        Node nnn = list.item(j);
                        if("id".equals(nnn.getNodeName())){
                           A = nnn.getTextContent();
                        }
                        
                    }
                
            }
        }
        
        doc.getDocumentElement().normalize();

        DOMSource xmlDOM = new DOMSource(doc);
        StreamResult xmlResultFile = new StreamResult(new File(filePath, fileName));
        TransformerFactory.newInstance().newTransformer().transform(xmlDOM, xmlResultFile);
        
        return A;
     }
    
    
    
}

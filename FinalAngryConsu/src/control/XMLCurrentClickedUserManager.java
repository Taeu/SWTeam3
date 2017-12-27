/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.UserBrandMarketer;
import java.io.File;
import java.io.IOException;
import java.util.Date;
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
public class XMLCurrentClickedUserManager {
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

        NodeList nList = doc.getElementsByTagName("clikeduser");
        if (nList == null) {
            return null;
        }
        for (int i = 0; i < nList.getLength(); i++) {
            dataMapper = new HashMap();
            Node nNode = nList.item(i);
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;

                dataMapper.put("name", element.getElementsByTagName("name").item(0).getTextContent());
                dataMapper.put("status", element.getElementsByTagName("status").item(0).getTextContent());
                dataMapper.put("id", element.getElementsByTagName("id").item(0).getTextContent());
                xmlDataHashMap.put(element.getAttribute("num"), dataMapper);
            }
                    
        }

        return xmlDataHashMap;
    }

    public void createXML(String filePath, String fileName, HashMap cliked) throws IOException, ParserConfigurationException, TransformerConfigurationException, TransformerException, SAXException {
        File xmlFiles = new File(filePath, fileName);
        DocumentBuilderFactory dbFactorys = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilders = dbFactorys.newDocumentBuilder();
        Document docs = dBuilders.parse(xmlFiles);

        Node root = docs.getDocumentElement();
        System.out.println(root.getNodeName());
        if (root.getNodeType() == Node.ELEMENT_NODE) {
            Element clikeduser = docs.createElement("clikeduser");
            clikeduser.setAttribute("num", cliked.get("num").toString());
            root.appendChild(clikeduser);

            Element name = docs.createElement("name");
            name.appendChild(docs.createTextNode(cliked.get("name").toString()));
            clikeduser.appendChild(name);
            
            Element status = docs.createElement("status");
            status.appendChild(docs.createTextNode(cliked.get("status").toString()));
            clikeduser.appendChild(status);
            
            Element id = docs.createElement("id");
            id.appendChild(docs.createTextNode(cliked.get("id").toString()));
            clikeduser.appendChild(id);

           

           
        }

        docs.getDocumentElement().normalize();

        DOMSource xmlDOM = new DOMSource(docs);
        StreamResult xmlResultFile = new StreamResult(new File(filePath, fileName));
        TransformerFactory.newInstance().newTransformer().transform(xmlDOM, xmlResultFile);
    }

    public void deleteAllXML(String filePath, String fileName) throws IOException, ParserConfigurationException,
            SAXException, TransformerConfigurationException, TransformerException {
        xmlFile = new File(filePath, fileName);
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(xmlFile);

        NodeList nList = doc.getElementsByTagName("clikeduser");
        System.out.println(nList.getLength());
        for (int i = 0; i < nList.getLength(); ) {
            Node nNode = nList.item(nList.getLength()-1);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                    nNode.getParentNode().removeChild(nNode);
            }
        }

        doc.getDocumentElement().normalize();

        DOMSource xmlDOM = new DOMSource(doc);
        StreamResult xmlResultFile = new StreamResult(new File(filePath, fileName));
        TransformerFactory.newInstance().newTransformer().transform(xmlDOM, xmlResultFile);
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

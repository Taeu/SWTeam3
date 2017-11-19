/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counterbrand;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
public class XMLComplainManager {

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
        System.out.println("dataconvert start");
        HashMap xmlDataHashMap = new HashMap();
        HashMap dataMapper;

        NodeList nList = doc.getElementsByTagName("complain");
        if (nList == null) {
            System.out.println("Null");
            return null;

        }
        //if("complain".equals(nList.item(0).getNodeName()))
        //{
        
            System.out.println("제대로읽었으면 7num"+nList.getLength());
        for (int i = 0; i < nList.getLength(); i++) {
            dataMapper = new HashMap();
            Node nNode = nList.item(i);
            
            System.out.println("dataconvert start");
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;

                dataMapper.put("name", element.getElementsByTagName("name").item(0).getTextContent());
                dataMapper.put("industry", element.getElementsByTagName("industry").item(0).getTextContent());
                dataMapper.put("sub", element.getElementsByTagName("sub").item(0).getTextContent());
                dataMapper.put("time", element.getElementsByTagName("time").item(0).getTextContent());
                dataMapper.put("content", element.getElementsByTagName("content").item(0).getTextContent());

                dataMapper.put("title", element.getElementsByTagName("title").item(0).getTextContent());
                xmlDataHashMap.put(element.getAttribute("id"), dataMapper);
            }
            System.out.println("Dd'");
                    
        }

        return xmlDataHashMap;
    }

    public void editXML(String filePath, String fileName, HashMap complaininfo) throws IOException, ParserConfigurationException, TransformerConfigurationException, TransformerException, SAXException {
        File xmlFiles = new File(filePath, fileName);
        DocumentBuilderFactory dbFactorys = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilders = dbFactorys.newDocumentBuilder();
        Document docs = dBuilders.parse(xmlFiles);

        Node root = docs.getDocumentElement();
        System.out.println(root.getNodeName());
        System.out.println("starteditXML");
        if (root.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println("this is editXML");
            Element complain = docs.createElement("complain");
            complain.setAttribute("id", complaininfo.get("id").toString());
            root.appendChild(complain);

            Element name = docs.createElement("name");
            name.appendChild(docs.createTextNode(complaininfo.get("name").toString()));
            complain.appendChild(name);

            Element industry = docs.createElement("industry");
            industry.appendChild(docs.createTextNode(complaininfo.get("industry").toString()));
            complain.appendChild(industry);

            Element sub = docs.createElement("sub");
            sub.appendChild(docs.createTextNode(complaininfo.get("sub").toString()));
            complain.appendChild(sub);

            Element time = docs.createElement("time");
            time.appendChild(docs.createTextNode(complaininfo.get("time").toString()));
            complain.appendChild(time);

            Element content = docs.createElement("content");
            content.appendChild(docs.createTextNode(complaininfo.get("content").toString()));
            complain.appendChild(content);

            Element title = docs.createElement("title");
            title.appendChild(docs.createTextNode(complaininfo.get("title").toString()));
            complain.appendChild(title);
           
        }

        docs.getDocumentElement().normalize();

        DOMSource xmlDOM = new DOMSource(docs);
        StreamResult xmlResultFile = new StreamResult(new File(filePath, fileName));
        TransformerFactory.newInstance().newTransformer().transform(xmlDOM, xmlResultFile);
    }

    public void deleteIdXML(String filePath, String fileName, String id) throws IOException, ParserConfigurationException,
            SAXException, TransformerConfigurationException, TransformerException {
        xmlFile = new File(filePath, fileName);
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(xmlFile);

        NodeList nList = doc.getElementsByTagName("complain");
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                if (element.getAttribute("id").equals(id)) {
                    nNode.getParentNode().removeChild(nNode);
                }
            }
        }

        doc.getDocumentElement().normalize();

        DOMSource xmlDOM = new DOMSource(doc);
        StreamResult xmlResultFile = new StreamResult(new File(filePath, fileName));
        TransformerFactory.newInstance().newTransformer().transform(xmlDOM, xmlResultFile);
    }
    
    public void addFeedbackXML(String filePath, String fileName, String id, String feedbackContent, Date feedbackTime) throws IOException, ParserConfigurationException,
            SAXException, TransformerConfigurationException, TransformerException {
        xmlFile = new File(filePath, fileName);
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(xmlFile);
        
        NodeList nList = doc.getElementsByTagName("complain");
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                if (element.getAttribute("id").equals(id)) {
                    Element feedback = doc.createElement("feedback");
                    feedback.setAttribute("id", id);
                    element.appendChild(feedback);

                    Element feedbackDetailContent = doc.createElement("feedbackDetailContent");
                    feedbackDetailContent.appendChild(doc.createTextNode(feedbackContent));
                    feedback.appendChild(feedbackDetailContent);

                    Element feedbackDetailTime = doc.createElement("feedbackDetailTime");
                    feedbackDetailTime.appendChild(doc.createTextNode(feedbackTime.toString()));
                    feedback.appendChild(feedbackDetailTime);
                }
            }
        }

        doc.getDocumentElement().normalize();

        DOMSource xmlDOM = new DOMSource(doc);
        StreamResult xmlResultFile = new StreamResult(new File(filePath, fileName));
        TransformerFactory.newInstance().newTransformer().transform(xmlDOM, xmlResultFile);
    }
}
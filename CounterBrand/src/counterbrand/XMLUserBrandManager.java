/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counterbrand;

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
 * @author JunHo
 */
public class XMLUserBrandManager {
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

        NodeList nList = doc.getElementsByTagName("userbrand");
        if (nList == null) {
            System.out.println("Null");
            return null;

        }
        //if("userBrand".equals(nList.item(0).getNodeName()))
        //{
        System.out.println("이제 nList.getLength()");
        for (int i = 0; i < nList.getLength(); i++) {
            System.out.println(i);
            dataMapper = new HashMap();
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                
                dataMapper.put("id", element.getElementsByTagName("id").item(0).getTextContent());
                dataMapper.put("password", element.getElementsByTagName("password").item(0).getTextContent());
                dataMapper.put("name", element.getElementsByTagName("name").item(0).getTextContent());
                dataMapper.put("industry", element.getElementsByTagName("industry").item(0).getTextContent());
                dataMapper.put("sales", element.getElementsByTagName("sales").item(0).getTextContent());
                dataMapper.put("SNSAddress", element.getElementsByTagName("SNSAddress").item(0).getTextContent());
                dataMapper.put("Email", element.getElementsByTagName("Email").item(0).getTextContent());

                xmlDataHashMap.put(element.getAttribute("num"), dataMapper);
            }
        }
         return xmlDataHashMap;
    }
        public void editXML(String filePath, String fileName, HashMap userBrandinfo) throws IOException, ParserConfigurationException, TransformerConfigurationException, TransformerException, SAXException {
        File xmlFiles = new File(filePath, fileName);
        DocumentBuilderFactory dbFactorys = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilders = dbFactorys.newDocumentBuilder();
        Document docs = dBuilders.parse(xmlFiles);

        Node root = docs.getDocumentElement();
        System.out.println(root.getNodeName());
        System.out.println("starteditXML");
        if (root.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println("this is editXML");
            Element userbrand = docs.createElement("userbrand");
            userbrand.setAttribute("num", userBrandinfo.get("num").toString());
            root.appendChild(userbrand);
            System.out.println("ddd");
            Element id = docs.createElement("id");
            id.appendChild(docs.createTextNode(userBrandinfo.get("id").toString()));
            userbrand.appendChild(id);
            
            Element password = docs.createElement("password");
            password.appendChild(docs.createTextNode(userBrandinfo.get("password").toString()));
            userbrand.appendChild(password);

            Element name = docs.createElement("name");
            name.appendChild(docs.createTextNode(userBrandinfo.get("name").toString()));
            userbrand.appendChild(name);

            Element industry = docs.createElement("industry");
            industry.appendChild(docs.createTextNode(userBrandinfo.get("industry").toString()));
            userbrand.appendChild(industry);

            Element sales = docs.createElement("sales");
            sales.appendChild(docs.createTextNode(userBrandinfo.get("sales").toString()));
            userbrand.appendChild(sales);
            

            Element SNSAddress = docs.createElement("SNSAddress");
            SNSAddress.appendChild(docs.createTextNode(userBrandinfo.get("SNSAddress").toString()));
            userbrand.appendChild(SNSAddress);
            
            
            Element Email = docs.createElement("Email");
            Email.appendChild(docs.createTextNode(userBrandinfo.get("Email").toString()));
            userbrand.appendChild(Email);
            System.out.println("ddddd");
            

        }
        System.out.println("ddddddddddd");
        docs.getDocumentElement().normalize();

        DOMSource xmlDOM = new DOMSource(docs);
        StreamResult xmlResultFile = new StreamResult(new File(filePath, fileName));
        TransformerFactory.newInstance().newTransformer().transform(xmlDOM, xmlResultFile);
    }
        
     public void deleteNumXML(String filePath, String fileName, String num) throws IOException, ParserConfigurationException,
            SAXException, TransformerConfigurationException, TransformerException {
        xmlFile = new File(filePath, fileName);
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(xmlFile);

        NodeList nList = doc.getElementsByTagName("userBrand");
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                if (element.getAttribute("num").equals(num)) {
                    nNode.getParentNode().removeChild(nNode);
                }
            }
        }

        doc.getDocumentElement().normalize();

        DOMSource xmlDOM = new DOMSource(doc);
        StreamResult xmlResultFile = new StreamResult(new File(filePath, fileName));
        TransformerFactory.newInstance().newTransformer().transform(xmlDOM, xmlResultFile);
    }
}

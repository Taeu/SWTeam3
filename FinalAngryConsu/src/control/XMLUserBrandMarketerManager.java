/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.UserBrandMarketer;
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
public class XMLUserBrandMarketerManager {
   
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
            return null;

        }
        
        for (int i = 0; i < nList.getLength(); i++) {
            System.out.println(i);
            dataMapper = new HashMap();
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                
                dataMapper.put("num", element.getElementsByTagName("num").item(0).getTextContent());
                
                dataMapper.put("id", element.getElementsByTagName("id").item(0).getTextContent());
                dataMapper.put("password", element.getElementsByTagName("password").item(0).getTextContent());
                dataMapper.put("email", element.getElementsByTagName("email").item(0).getTextContent());
                dataMapper.put("numComplaint", element.getElementsByTagName("numComplaint").item(0).getTextContent());
                
                dataMapper.put("sales", element.getElementsByTagName("sales").item(0).getTextContent());
                dataMapper.put("SNSAddress", element.getElementsByTagName("SNSAddress").item(0).getTextContent());
             
                dataMapper.put("brandId", element.getElementsByTagName("brandId").item(0).getTextContent());
                dataMapper.put("name", element.getElementsByTagName("name").item(0).getTextContent());
                dataMapper.put("industry", element.getElementsByTagName("SNSAddress").item(0).getTextContent());
                

                xmlDataHashMap.put(element.getAttribute("num"), dataMapper);
            }
        }
         return xmlDataHashMap;
    }
    
     public void createXML(String filePath, String fileName, UserBrandMarketer userBrandinfo) throws IOException, ParserConfigurationException, TransformerConfigurationException, TransformerException, SAXException {
        File xmlFiles = new File(filePath, fileName);
        DocumentBuilderFactory dbFactorys = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilders = dbFactorys.newDocumentBuilder();
        Document docs = dBuilders.parse(xmlFiles);

        Node root = docs.getDocumentElement();
        System.out.println(root.getNodeName());
        if (root.getNodeType() == Node.ELEMENT_NODE) {
            Element userbrand = docs.createElement("userbrand");
            userbrand.setAttribute("num", userBrandinfo.getNum());
            root.appendChild(userbrand);
            // User
            Element id = docs.createElement("id");
            id.appendChild(docs.createTextNode(userBrandinfo.getId()));
            userbrand.appendChild(id);
            
            Element password = docs.createElement("password");
            password.appendChild(docs.createTextNode(userBrandinfo.getPassword()));
            userbrand.appendChild(password);
            
            Element Email = docs.createElement("email");
            Email.appendChild(docs.createTextNode(userBrandinfo.getEmail()));
            userbrand.appendChild(Email);
             
            Element numComplaint = docs.createElement("numComplaint");
            numComplaint.appendChild(docs.createTextNode(Integer.toString(userBrandinfo.getNumComplaint())));
            userbrand.appendChild(numComplaint);
            
            //BrandMarketer
            Element sales = docs.createElement("sales");
            sales.appendChild(docs.createTextNode(userBrandinfo.getSales()));
            userbrand.appendChild(sales);
            

            Element SNSAddress = docs.createElement("SNSAddress");
            SNSAddress.appendChild(docs.createTextNode(userBrandinfo.getSNSAddress()));
            userbrand.appendChild(SNSAddress);
            
            //Brand
            Element brandId = docs.createElement("brandId");
            brandId.appendChild(docs.createTextNode(userBrandinfo.getBrand().getId()));
            userbrand.appendChild(brandId);
            
            Element name = docs.createElement("name");
            name.appendChild(docs.createTextNode(userBrandinfo.getBrand().getName()));
            userbrand.appendChild(name);
            
            Element industry = docs.createElement("industry");
            industry.appendChild(docs.createTextNode(userBrandinfo.getBrand().getIndustry()));
            userbrand.appendChild(industry);
            
        }
        docs.getDocumentElement().normalize();

        DOMSource xmlDOM = new DOMSource(docs);
        StreamResult xmlResultFile = new StreamResult(new File(filePath, fileName));
        TransformerFactory.newInstance().newTransformer().transform(xmlDOM, xmlResultFile);
    }
      public UserBrandMarketer searchNumXML(String filePath, String fileName, String num) throws IOException, ParserConfigurationException,
            SAXException, TransformerConfigurationException, TransformerException {
        xmlFile = new File(filePath, fileName);
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(xmlFile);

        NodeList nList = doc.getElementsByTagName("userbrand");
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                if (element.getAttribute("num").equals(num)) {
                   
                    element.getAttribute("num");
                    
                    
                    UserBrandMarketer a= new UserBrandMarketer(
                            element.getAttribute("num"),
                            element.getAttribute("id"),
                            element.getAttribute("password"),
                            element.getAttribute("email"),
                            Integer.parseInt(element.getAttribute("numComplaint")),
                            element.getAttribute("sales"),
                            element.getAttribute("SNSAddress"),
                            element.getAttribute("brandId"),
                            element.getAttribute("name"),
                            element.getAttribute("industry")
                    );
                    DOMSource xmlDOM = new DOMSource(doc);
                    StreamResult xmlResultFile = new StreamResult(new File(filePath, fileName));
                    TransformerFactory.newInstance().newTransformer().transform(xmlDOM, xmlResultFile);
                    UserBrandMarketer b = new UserBrandMarketer();
                    return a;
                }
            }
        }

        doc.getDocumentElement().normalize();

        DOMSource xmlDOM = new DOMSource(doc);
        StreamResult xmlResultFile = new StreamResult(new File(filePath, fileName));
        TransformerFactory.newInstance().newTransformer().transform(xmlDOM, xmlResultFile);
        UserBrandMarketer b = new UserBrandMarketer();
        return b;
    }
     
    
}

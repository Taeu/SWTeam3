/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaehoon;

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
 * @author JAEHOON
 */
public class XMLUserCustomerManager {
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

        NodeList nList = doc.getElementsByTagName("userCustomer");
        if (nList == null) {
            System.out.println("Null");
            return null;

        }
        //if("userBrand".equals(nList.item(0).getNodeName()))
        //{
        for (int i = 0; i < nList.getLength(); i++) {
            dataMapper = new HashMap();
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                
                dataMapper.put("id", element.getElementsByTagName("id").item(0).getTextContent());
                dataMapper.put("password", element.getElementsByTagName("password").item(0).getTextContent());
                dataMapper.put("name", element.getElementsByTagName("name").item(0).getTextContent());
                dataMapper.put("gender", element.getElementsByTagName("gender").item(0).getTextContent());
                dataMapper.put("birth", element.getElementsByTagName("birth").item(0).getTextContent());
                dataMapper.put("email", element.getElementsByTagName("email").item(0).getTextContent());
                dataMapper.put("phone", element.getElementsByTagName("phone").item(0).getTextContent());
                dataMapper.put("job", element.getElementsByTagName("job").item(0).getTextContent());

                xmlDataHashMap.put(element.getAttribute("num"), dataMapper);
            }
        }
         return xmlDataHashMap;
    }
        public void editXML(String filePath, String fileName, HashMap customerinfo) throws IOException, ParserConfigurationException, TransformerConfigurationException, TransformerException, SAXException {
        File xmlFiles = new File(filePath, fileName);
        DocumentBuilderFactory dbFactorys = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilders = dbFactorys.newDocumentBuilder();
        Document docs = dBuilders.parse(xmlFiles);

        Node root = docs.getDocumentElement();
        System.out.println(root.getNodeName());
        System.out.println("starteditXML");
        if (root.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println("this is editXML");
            Element customer = docs.createElement("userCustomer");
            customer.setAttribute("num", customerinfo.get("num").toString());
            root.appendChild(customer);

            Element name = docs.createElement("name");
            name.appendChild(docs.createTextNode(customerinfo.get("name").toString()));
            customer.appendChild(name);

            Element id = docs.createElement("id");
            id.appendChild(docs.createTextNode(customerinfo.get("id").toString()));
            customer.appendChild(id);
            
            Element password = docs.createElement("password");
            password.appendChild(docs.createTextNode(customerinfo.get("password").toString()));
            customer.appendChild(password);

            Element gender = docs.createElement("gender");
            gender.appendChild(docs.createTextNode(customerinfo.get("gender").toString()));
            customer.appendChild(gender);

            Element birth = docs.createElement("birth");
            birth.appendChild(docs.createTextNode(customerinfo.get("birth").toString()));
            customer.appendChild(birth);

            Element email = docs.createElement("email");
            email.appendChild(docs.createTextNode(customerinfo.get("email").toString()));
            customer.appendChild(email);

            Element phone = docs.createElement("phone");
            phone.appendChild(docs.createTextNode(customerinfo.get("phone").toString()));
            customer.appendChild(phone);
            
            Element job = docs.createElement("job");
            job.appendChild(docs.createTextNode(customerinfo.get("job").toString()));
            customer.appendChild(job);

        }

        docs.getDocumentElement().normalize();

        DOMSource xmlDOM = new DOMSource(docs);
        StreamResult xmlResultFile = new StreamResult(new File(filePath, fileName));
        TransformerFactory.newInstance().newTransformer().transform(xmlDOM, xmlResultFile);
    }
}

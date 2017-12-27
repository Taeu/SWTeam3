/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.Complaint;
import entity.Feedback;
import entity.Rating;
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
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author user
 */
public class XMLComplaintManager {
    
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

        NodeList nList = doc.getElementsByTagName("complaint");
        if (nList == null) {
            return null;
        }
        
        for (int i = 0; i < nList.getLength(); i++) {
            dataMapper = new HashMap();
            Node nNode = nList.item(i);
            System.out.println("dataconvert start");
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                System.out.println("dataconvert puc=t");
                dataMapper.put("id", element.getElementsByTagName("id").item(0).getTextContent());
                dataMapper.put("title", element.getElementsByTagName("title").item(0).getTextContent());
                dataMapper.put("content", element.getElementsByTagName("content").item(0).getTextContent());
                dataMapper.put("time", element.getElementsByTagName("time").item(0).getTextContent());
                dataMapper.put("brandid", element.getElementsByTagName("brandid").item(0).getTextContent());
                dataMapper.put("name", element.getElementsByTagName("name").item(0).getTextContent());
                dataMapper.put("industry", element.getElementsByTagName("industry").item(0).getTextContent());
                dataMapper.put("sub", element.getElementsByTagName("sub").item(0).getTextContent());
                dataMapper.put("feedbackContent", element.getElementsByTagName("feedbackContent").item(0).getTextContent());
                dataMapper.put("feedbackTimeend", element.getElementsByTagName("feedbackTimeend").item(0).getTextContent());
                dataMapper.put("overallRating", element.getElementsByTagName("overallRating").item(0).getTextContent());
                dataMapper.put("speedRating", element.getElementsByTagName("speedRating").item(0).getTextContent());
                dataMapper.put("detailednessRating", element.getElementsByTagName("detailednessRating").item(0).getTextContent());
                dataMapper.put("processRating", element.getElementsByTagName("processRating").item(0).getTextContent());
                dataMapper.put("status", element.getElementsByTagName("status").item(0).getTextContent());
               
                xmlDataHashMap.put(element.getAttribute("num"), dataMapper);
            }
                    
        }

                System.out.println("dataconvert end");
        return xmlDataHashMap;
    }

    public void editXML(String filePath, String fileName, Complaint complaintinfo) throws IOException, ParserConfigurationException, TransformerConfigurationException, TransformerException, SAXException {
        File xmlFiles = new File(filePath, fileName);
        DocumentBuilderFactory dbFactorys = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilders = dbFactorys.newDocumentBuilder();
        Document docs = dBuilders.parse(xmlFiles);

        Node root = docs.getDocumentElement();
        if (root.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println("this is editXML");
            Element complaint = docs.createElement("complaint");
            complaint.setAttribute("num", complaintinfo.getNum());
            root.appendChild(complaint);
            Element id = docs.createElement("id");
            id.appendChild(docs.createTextNode(complaintinfo.getId()));
            complaint.appendChild(id);
            Element title = docs.createElement("title");
            title.appendChild(docs.createTextNode(complaintinfo.getTitle()));
            complaint.appendChild(title);
            Element content = docs.createElement("content");
            content.appendChild(docs.createTextNode(complaintinfo.getContent()));
            complaint.appendChild(content);
            Element time = docs.createElement("time");
            time.appendChild(docs.createTextNode(complaintinfo.getTime()));
            complaint.appendChild(time);
            Element brandid = docs.createElement("brandid");
            brandid.appendChild(docs.createTextNode(complaintinfo.getBrand().getId()));
            complaint.appendChild(brandid);
            Element name = docs.createElement("name");
            name.appendChild(docs.createTextNode(complaintinfo.getBrand().getName()));
            complaint.appendChild(name);
            Element industry = docs.createElement("industry");
            industry.appendChild(docs.createTextNode(complaintinfo.getBrand().getIndustry()));
            complaint.appendChild(industry);
            Element sub = docs.createElement("sub");
            sub.appendChild(docs.createTextNode(complaintinfo.getSub()));
            complaint.appendChild(sub);
            Element feedbackContent = docs.createElement("feedbackContent");
            feedbackContent.appendChild(docs.createTextNode(complaintinfo.getFeedback().getContent()));
            complaint.appendChild(feedbackContent);
            Element feedbackTimeend = docs.createElement("feedbackTimeend");
            feedbackTimeend.appendChild(docs.createTextNode(complaintinfo.getFeedback().getTimeEnd()));
            complaint.appendChild(feedbackTimeend);
            Element overallRating = docs.createElement("overallRating");
            overallRating.appendChild(docs.createTextNode(Integer.toString(complaintinfo.getRating().getOverallRating())));
            complaint.appendChild(overallRating);
            Element speedRating = docs.createElement("speedRating");
            speedRating.appendChild(docs.createTextNode(Integer.toString(complaintinfo.getRating().getSpeedRating())));
            complaint.appendChild(speedRating);
            Element detailednessRating = docs.createElement("detailednessRating");
            detailednessRating.appendChild(docs.createTextNode(Integer.toString(complaintinfo.getRating().getdetailednessRating())));
            complaint.appendChild(detailednessRating);
            Element processRating = docs.createElement("processRating");
            processRating.appendChild(docs.createTextNode(Integer.toString(complaintinfo.getRating().getProcessRating())));
            complaint.appendChild(processRating);
            Element status = docs.createElement("status");
            status.appendChild(docs.createTextNode(complaintinfo.getStatus()));
            complaint.appendChild(status);

        }

        docs.getDocumentElement().normalize();

        DOMSource xmlDOM = new DOMSource(docs);
        StreamResult xmlResultFile = new StreamResult(new File(filePath, fileName));
        TransformerFactory.newInstance().newTransformer().transform(xmlDOM, xmlResultFile);
    }

    public void deleteIdXML(String filePath, String fileName, String num) throws IOException, ParserConfigurationException,
            SAXException, TransformerConfigurationException, TransformerException {
        xmlFile = new File(filePath, fileName);
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(xmlFile);

        NodeList nList = doc.getElementsByTagName("complaint");
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
    
    public void addFeedbackXML(String filePath, String fileName, String num, Feedback feedbackinfo) throws IOException, ParserConfigurationException,
            SAXException, TransformerConfigurationException, TransformerException {
        xmlFile = new File(filePath, fileName);
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(xmlFile);
        
        NodeList nList = doc.getElementsByTagName("complaint");
        for (int i = 0; i < nList.getLength(); i++) {
            System.out.println(nList.getLength());
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                if(element.getAttribute("num").equals(num)){
                    NodeList list = nNode.getChildNodes();
                    for (int j = 0 ; j < list.getLength();j++){
                        Node nnn = list.item(j);
                        if("feedbackContent".equals(nnn.getNodeName())){
                            nnn.setTextContent(feedbackinfo.getContent());
                        }
                        if("feedbackTimeend".equals(nnn.getNodeName())){
                            nnn.setTextContent(feedbackinfo.getTimeEnd()); 
                        }
                        if("status".equals(nnn.getNodeName())){
                            nnn.setTextContent("2"); 
                        }
                        
                    }
                }
            }
        }
        
        
        
        
        
        
        Element root = doc.getDocumentElement();
        NodeList rootlist = root.getChildNodes();
        
        
        for(int i =0; i< rootlist.getLength();i++){
            
            /*
            Element complaint = (Element) rootlist.item(i);
            NodeList complaintList = complaint.getChildNodes();
 
            Element B = (Element) complaintList.item(1);
            NodeList titleList = B.getChildNodes();
            
            NodeList fbcList = I.getChildNodes();
            NodeList fbtList = J.getChildNodes();
            NodeList fbsList = O.getChildNodes();
            Text titletext = (Text)titleList.item(0);
            String title_i = titletext.getData();
            if(title_i.equals(title)){
                Text fbcontent = (Text);
                Text fbtime;
                Text fbstatus;
                
            }
            NodeList fbc = id.getChildNodes();
            
        }
        */
            
        
        /*
        NodeList nList = doc.getElementsByTagName("complaint");
        
        for (int i = 0; i < nList.getLength(); i++) {
            
            
            Element complaint = (Element)nList.item(i);
            NodeList complaintList = complaint.getChildNodes();
            System.out.println(i +" : " +complaintList.getLength());
            Element number = (Element)complaintList.item(0);
            if(number.getAttribute("num").equals(num)){
                   
                    Node fbc = complaintList.item(9);
                    Node fbt = complaintList.item(10);
                    Node fbs = complaintList.item(15);
                     System.out.println("same as "+num);
                    System.out.println(fbc.toString());
                    System.out.println(fbt.toString());
                    
                    fbc.setTextContent(feedbackinfo.getContent());
                    fbt.setTextContent(feedbackinfo.getTimeEnd());
                    fbs.setTextContent("2");

            }
            */
        }

       
        doc.getDocumentElement().normalize();

        DOMSource xmlDOM = new DOMSource(doc);
        StreamResult xmlResultFile = new StreamResult(new File(filePath, fileName));
        TransformerFactory.newInstance().newTransformer().transform(xmlDOM, xmlResultFile);
    }
    
    public void addRatingXML(String filePath, String fileName, String num, Rating ratinginfo) throws IOException, ParserConfigurationException,
            SAXException, TransformerConfigurationException, TransformerException {
        xmlFile = new File(filePath, fileName);
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(xmlFile);
         
        NodeList nList = doc.getElementsByTagName("complaint");
        for (int i = 0; i < nList.getLength(); i++) {
            System.out.println(nList.getLength());
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                if(element.getAttribute("num").equals(num)){
                    NodeList list = nNode.getChildNodes();
                    for (int j = 0 ; j < list.getLength();j++){
                        Node nnn = list.item(j);
                        if("overallRating".equals(nnn.getNodeName())){
                            nnn.setTextContent(Integer.toString(ratinginfo.getOverallRating()));
                        }
                        if("speedRating".equals(nnn.getNodeName())){
                            nnn.setTextContent(Integer.toString(ratinginfo.getSpeedRating()));
                        }
                        if("detailednessRating".equals(nnn.getNodeName())){
                            nnn.setTextContent(Integer.toString(ratinginfo.getdetailednessRating()));
                        }
                        if("processRating".equals(nnn.getNodeName())){
                            nnn.setTextContent(Integer.toString(ratinginfo.getProcessRating()));
                        }
                        if("status".equals(nnn.getNodeName())){
                            nnn.setTextContent("3");
                        }
                        
                    }
                }
            }
        }
        
        

        doc.getDocumentElement().normalize();

        DOMSource xmlDOM = new DOMSource(doc);
        StreamResult xmlResultFile = new StreamResult(new File(filePath, fileName));
        TransformerFactory.newInstance().newTransformer().transform(xmlDOM, xmlResultFile);
    }
    public int searchXML(String filePath, String fileName) throws IOException, ParserConfigurationException,
            SAXException, TransformerConfigurationException, TransformerException {
        xmlFile = new File(filePath, fileName);
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(xmlFile);
        Node nNode;
        Element element;
        String A = "";
        NodeList nList = doc.getElementsByTagName("complaint");
        return nList.getLength();
     }

}
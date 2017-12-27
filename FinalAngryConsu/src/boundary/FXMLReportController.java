/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import control.XMLComplaintManager;
import control.XMLCurrentClickedUserManager;
import entity.Complaint;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import others.FilePath;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLReportController implements Initializable {
private ObservableList<Complaint> data;
    private XMLComplaintManager complaintManager;
    private HashMap hm;
    private HashMap temphm;
    private HashMap idhm;
    private HashMap tempidhm;
    FilePath fp = new FilePath();
    private XMLCurrentClickedUserManager currentUser =new XMLCurrentClickedUserManager();
   
    public String A;
    @FXML
    private Label labelCounterBrand1;
    @FXML
    private Label labelCounterBrand2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         A="";
            System.out.println("gggg");
            try {
                A = currentUser.searchXML(fp.xml,"CurrentUser.xml");
            } catch (IOException ex) {
                Logger.getLogger(boundary1.FXMLMainPageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(boundary1.FXMLMainPageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(boundary1.FXMLMainPageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(boundary1.FXMLMainPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(A.equals("1")){ // customer
                // 이런경우 없음
            }
            else if(A.equals("2")){ // brand
                System.out.println("2");
                String B="";
                System.out.println("gggg");
            try {
                B = currentUser.searchNameXML(fp.xml,"CurrentUser.xml");
            } catch (IOException ex) {
                Logger.getLogger(boundary1.FXMLMainPageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(boundary1.FXMLMainPageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(boundary1.FXMLMainPageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(boundary1.FXMLMainPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
                labelCounterBrand1.setText("Report for "+B);
            }
        // TODO
    }    

    @FXML
    private void labelCounterBrandCliked(MouseEvent event) {
    }
    
}

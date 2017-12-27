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
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import others.FilePath;
import others.complaintDetail;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLComplaintDetailReadController implements Initializable {
 private ObservableList<Complaint> data;
    private XMLComplaintManager complaintManager;
    private HashMap hm;
    private HashMap temphm;
    private HashMap idhm;
    private HashMap tempidhm;
    FilePath fp = new FilePath();
    String industry="";
    String name ="";
    @FXML
    private Label brandLogo;
    @FXML
    private MenuItem menuComplainWrite;
    @FXML
    private MenuItem menuComplainRead;
    @FXML
    private MenuItem menuRankView;
    @FXML
    private MenuItem menuMypage;
    @FXML
    private TextArea textAreaContent;
    @FXML
    private TextField textFieldTitle;
    @FXML
    private TextField textFieldSub;
    @FXML
    private ImageView a1;
    @FXML
    private TextArea textAreaFeedbackContent;
    @FXML
    private Button btnFeedbackSubmit;
    @FXML
    private Label lbrt2;
    @FXML
    private Label lbfb;
    @FXML
    private Label lbrt;
    @FXML
    private Label lbfb2;
    @FXML
    private ImageView a111;
    @FXML
    private TextField textFieldName1;
    @FXML
    private Label brandLogo1;
    @FXML
    private Button btnRatingSubmit;
    @FXML
    private Label labelOverall;
    @FXML
    private ImageView brandLogo2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initComplainDetailReadView();
    }    
    public void initComplainDetailReadView() {
        complaintManager = new XMLComplaintManager();
        data = FXCollections.observableArrayList();
        hm = new HashMap();
        try {
            hm = complaintManager.readXML(fp.xml, "ComplaintDetail.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterator<String> iterator = hm.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();

            temphm = (HashMap) hm.get(key);
            complaintDetail tempComplainDetail
                    = new complaintDetail(
                    key, 
                    temphm.get("id").toString().trim(), 
                    temphm.get("title").toString().trim(), 
                    temphm.get("content").toString().trim(), 
                    temphm.get("time").toString().trim(),
                    temphm.get("brandid").toString().trim(),
                    temphm.get("name").toString().trim(),
                    temphm.get("industry").toString().trim(),
                   temphm.get("sub").toString().trim(),
                    temphm.get("feedbackContent").toString().trim(), 
                    temphm.get("feedbackTimeend").toString().trim(),
                    
                   temphm.get("overallRating").toString().trim(),temphm.get("speedRating").toString().trim(),
                   temphm.get("detailednessRating").toString().trim(),temphm.get("processRating").toString().trim(),
                   
                   
                    
                    temphm.get("status").toString().trim()
            );
            textFieldName1.setText(tempComplainDetail.getName());
            textFieldSub.setText(tempComplainDetail.getSub());
            textFieldTitle.setText(tempComplainDetail.getTitle());
            textAreaContent.setText(tempComplainDetail.getContent());
            XMLCurrentClickedUserManager currentUser = new XMLCurrentClickedUserManager();
            String A="";
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
            String usertype = "";
            if(A.equals("1")){ // customer
                usertype="customer";
            }
            else if(A.equals("2")){ // brand
                usertype="brandmarketer";
                
                
            }
            if(tempComplainDetail.getStatus().equals("1")){
                if(usertype.equals("brandmarketer")){
                    btnFeedbackSubmit.setVisible(true);
                    textAreaFeedbackContent.setDisable(false);
                    textAreaFeedbackContent.setEditable(true);
                }
            }
            else if(tempComplainDetail.getStatus().equals("2")){
                if(usertype.equals("customer")){
                    btnRatingSubmit.setVisible(true);
                    
                }
                textAreaFeedbackContent.setText(tempComplainDetail.getFeedbackContent());
                
            }
            else if(tempComplainDetail.getStatus().equals("3")){
                labelOverall.setVisible(true);
                textAreaFeedbackContent.setText(tempComplainDetail.getFeedbackContent());
                labelOverall.setText(tempComplainDetail.getOverallRating());
            }
            String cdkey=tempComplainDetail.getNum();
            // 조회한 정보 삭제 , 단순히 view 용이니.
            try {
                complaintManager.deleteIdXML(fp.xml, "complaintDetail.xml", cdkey);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    @FXML
    private void labelAngryCustomerClicked(MouseEvent event) {
    }

    @FXML
    private void menuComplainWriteCliked(ActionEvent event) {
    }

    @FXML
    private void menuComplainReadCliked(ActionEvent event) {
    }

    @FXML
    private void menuRankViewCliked(ActionEvent event) {
    }

    @FXML
    private void menuMypageCliked(ActionEvent event) {
    }

    @FXML
    private void a1Clicked(MouseEvent event) {
    }

    @FXML
    private void btnFeedbackSubmitCliked(ActionEvent event) {
    }

    @FXML
    private void a111Clicked(MouseEvent event) {
    }
    
}

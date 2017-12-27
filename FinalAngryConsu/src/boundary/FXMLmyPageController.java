/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import control.XMLComplaintManager;
import control.XMLCurrentClickedUserManager;
import entity.Brand;
import entity.Complaint;
import entity.Feedback;
import entity.Rating;
import java.io.File;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
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
public class FXMLmyPageController implements Initializable {
      @FXML
    private TableView<complaintDetail> tableViewComplaint;
    @FXML
    private TableColumn<complaintDetail, String> tableColumnName;
    @FXML
    private TableColumn<complaintDetail, String> tableColumnSub;
    @FXML
    private TableColumn<complaintDetail, String> tableColumnTitle;
    @FXML
    private TableColumn<complaintDetail, String> tableColumnId;
    @FXML
    private TableColumn<complaintDetail, String> tableColumnIndustry;
    @FXML
    private TableColumn<complaintDetail, String> tableColumnContent;
    @FXML
    private TableColumn<complaintDetail, String> tableColumnTime;
      private String thisUser;
      private ObservableList<complaintDetail> data;
    private XMLComplaintManager complaintManager;
    private HashMap hm;
    private HashMap temphm;
    private HashMap idhm;
    private HashMap tempidhm;
    FilePath fp = new FilePath();
     private XMLCurrentClickedUserManager currentUser;
    String industry="";
    String name ="";
    String B="";
    String A="";
    @FXML
    private TableColumn<complaintDetail, String> tableColumnStatus;
    @FXML
    private Label UserType;
    @FXML
    private Button btnCustomerRegister;
    @FXML
    private TextField textFieldID;
    @FXML
    private TextField textFieldName1;
    @FXML
    private Button btnCustomerRegister1;
    @FXML
    private MenuItem menuComplainWrite;
    @FXML
    private MenuItem menuComplainRead;
    @FXML
    private MenuItem menuRankView;
    @FXML
    private MenuItem menuMypage;
    @FXML
    private Pane brandImg;
    @FXML
    private Label brandLogo;
    
    @FXML
    private TextField texFieldUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // 아래 부분 부터가 페이지 브랜드인지 아닌지 체크해줌.
       initComplaintReadTableView();
        // 아래 부분 부터가 페이지 브랜드인지 아닌지 체크해줌.
        int num=0;         // num count 해주어야함.
        currentUser = new XMLCurrentClickedUserManager();
        HashMap hm = new HashMap();
        HashMap idhm = new HashMap();
        HashMap currentUserList = new HashMap();
        data = FXCollections.observableArrayList();
        try {
            currentUserList = currentUser.readXML(fp.xml, "CurrentUser.xml");
            idhm = currentUser.readXML(fp.xml, "CurrentUser.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterator<String> iterator = idhm.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            num = Integer.parseInt(key);
        }
        num = num + 1;
        // num 완료
        System.out.println("this num : "+num);
        // id 
        String id;          // current user 의 id도 넣어주어야함.
        
        
        //
        if ( num ==1 ) {
            
        }
        else {
            
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
                System.out.println("1");
                 B="";
                 texFieldUser.setText("customer");
                System.out.println("gggg");
                btnCustomerRegister1.setVisible(false);
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
            
            }
            else if(A.equals("2")){ // brand
                System.out.println("2");
                texFieldUser.setText("brandmarketer");
                B="";
                System.out.println("gggg");
                btnCustomerRegister1.setVisible(true);
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
            }
                // init again,
                complaintManager = new XMLComplaintManager();
        data = FXCollections.observableArrayList();
        hm = new HashMap();

        try {
            hm = complaintManager.readXML(fp.xml, "Complaint.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
        iterator = hm.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            temphm = (HashMap) hm.get(key);
            if((A.equals("1")&&temphm.get("id").toString().trim().equals(B))||(A.equals("2")&temphm.get("name").toString().trim().equals(B))){
            data.add(new complaintDetail(
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
            ));
            }
        }
        textFieldID.setText(B);
        textFieldName1.setText(B);
        
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnIndustry.setCellValueFactory(new PropertyValueFactory<>("industry"));
        tableColumnSub.setCellValueFactory(new PropertyValueFactory<>("sub"));
        tableColumnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnContent.setCellValueFactory(new PropertyValueFactory<>("content"));
        tableColumnTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        
        tableColumnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tableViewComplaint.setItems(null);
        tableViewComplaint.setItems(data);
            }
        }
        
        // TODO
        
public void initComplaintReadTableView() {
        complaintManager = new XMLComplaintManager();
        data = FXCollections.observableArrayList();
        hm = new HashMap();

        try {
            hm = complaintManager.readXML(fp.xml, "Complaint.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterator<String> iterator = hm.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            temphm = (HashMap) hm.get(key);
            data.add(new complaintDetail(
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
            ));
        }
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnIndustry.setCellValueFactory(new PropertyValueFactory<>("industry"));
        tableColumnSub.setCellValueFactory(new PropertyValueFactory<>("sub"));
        tableColumnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnContent.setCellValueFactory(new PropertyValueFactory<>("content"));
        tableColumnTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        
        tableColumnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        tableViewComplaint.setItems(null);
        tableViewComplaint.setItems(data);

    }
    @FXML
    private void btnCustomerRegisterClicked(ActionEvent event) {
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
    private void labelAngryClicked(MouseEvent event) throws IOException {
        Stage stageThis;
        stageThis = (Stage) brandLogo.getScene().getWindow();
        stageThis.close();
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMainPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void btnReportClicked(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLReport.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void ComplainReadDetailCliked(MouseEvent event) throws IOException {
        complaintManager = new XMLComplaintManager();
        data = FXCollections.observableArrayList();
        hm = new HashMap();
        HashMap complainDetailList = new HashMap();
        try {
            complainDetailList = complaintManager.readXML(fp.xml, "ComplaintDetail.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }

        complaintDetail c = tableViewComplaint.getSelectionModel().getSelectedItem();
        Complaint cc = new Complaint(
                c.getNum(),
                c.getId(),
                c.getTitle(),
                c.getContent(),
                c.getTime(),
                new Feedback(c.getFeedbackContent(),c.getFeedbackTimeend()),
                new Rating(Integer.parseInt(c.getOverallRating()),Integer.parseInt(c.getSpeedRating())
                        ,Integer.parseInt(c.getDetailednessRating()),Integer.parseInt(c.getProcessRating())),
                new Brand(),
                c.getSub(),
                c.getStatus()
        );

        System.out.println("선택한 정보 :" + hm);
        try {
            complaintManager.editXML(fp.xml, "ComplaintDetail.xml", cc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //showTest();
        Stage stage = new Stage();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("FXMLComplaintDetailRead.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}

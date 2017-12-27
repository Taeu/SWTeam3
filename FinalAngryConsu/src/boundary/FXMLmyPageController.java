/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import control.XMLComplaintManager;
import control.XMLCurrentClickedUserManager;
import entity.Complaint;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import others.FilePath;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLmyPageController implements Initializable {
    private ObservableList<Complaint> data;
    private XMLComplaintManager complaintManager;
    private HashMap hm;
    private HashMap temphm;
    private HashMap idhm;
    private HashMap tempidhm;
    FilePath fp = new FilePath();
    @FXML
    private ImageView UserType;
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
    private Label labelAngry;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // 아래 부분 부터가 페이지 브랜드인지 아닌지 체크해줌.
        int num=0;         // num count 해주어야함.
        XMLCurrentClickedUserManager currentUser = new XMLCurrentClickedUserManager();
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
            
                System.out.println("0");
        hm.put("num", Integer.toString(num));
        hm.put("name","no");
        hm.put("id", "no");
        hm.put("status", "0");
        // 이부분을 클래스로 바꿔주고.
        if (currentUserList == null || currentUserList.get(Integer.toString(num)) == null) {
            try {
                currentUser.createXML(fp.xml, "CurrentUser.xml", hm);
            } catch (Exception e) {
            }
        } else if (currentUserList.get(Integer.toString(num)) != null) {  
        }
        }
        else {
            String A="";
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
                
                
            }
            else if(A.equals("2")){ // brand
                System.out.println("2");
                
            }
        }
        
        // TODO
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
    private void labelAngryClicked(MouseEvent event) {
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary1;

import control.XMLComplaintManager;
import control.XMLCurrentClickedUserManager;
import control.*;
import entity.Brand;
import entity.Complaint;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
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
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import others.FilePath;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLMainPageController implements Initializable {
   
    private ObservableList<HashMap> data;
    private XMLCurrentClickedUserManager currentUser;
    private HashMap hm;
    private HashMap temphm;
    private HashMap idhm;
    private HashMap tempidhm;    FilePath fp = new FilePath();

    @FXML
    private MenuItem menuComplainWrite;
    @FXML
    private MenuItem menuComplainRead;
    @FXML
    private MenuItem menuRankView;
    @FXML
    private MenuItem menuMypage;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnComplainWrite;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
                Logger.getLogger(FXMLMainPageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(FXMLMainPageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(FXMLMainPageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(FXMLMainPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(A.equals("1")){ // customer
                System.out.println("1");
                btnLogin.setText("customer");
                btnLogin.setDisable(true);
            }
            else if(A.equals("2")){ // brand
                System.out.println("2");
                btnLogin.setText("brand");
                btnLogin.setDisable(true);
                
            }
        }
        
        
        /*
        complainDetailReadOpen();
        // close this scene.
        Stage stageThis;
        stageThis = (Stage) btnComplainSubmit.getScene().getWindow();
        stageThis.close();
        */
        // TODO
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
    private void btnLoginClicked(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin2.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void btnComplainWriteCliked(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnComplainWrite.getScene().getWindow(); // 버튼 이름 수정 필요? 아니 그거 FXML 네임만 수정 필요
        Parent root = FXMLLoader.load(getClass().getResource("FXMLComplainWrite.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import control.XMLCurrentClickedUserManager;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import others.FilePath;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLLoginController implements Initializable {
    private ObservableList<HashMap> data;
    private XMLCurrentClickedUserManager currentUser;
    private HashMap hm;
    private HashMap temphm;
    private HashMap idhm;
    private HashMap tempidhm;    FilePath fp = new FilePath();
    @FXML
    private TextField textFeildLoginID;
    @FXML
    private PasswordField textFeildLoginPW;
    @FXML
    private Button btnBrandRegister;
    @FXML
    private Button btnCustomerRegister;
    @FXML
    private Button btnLogin;
    @FXML
    private MenuItem menuComplainWrite;
    @FXML
    private MenuItem menuComplainRead;
    @FXML
    private MenuItem menuRankView;
    @FXML
    private MenuItem menuMypage;
    @FXML
    private RadioButton radioLoginType_b;
    @FXML
    private RadioButton radioLoginType_a;
    @FXML
    private Label brandLogo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnBrandRegisterClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBrandRegister.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLBrandRegister.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void btnCustomerRegisterClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnCustomerRegister.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLCustomerRegister.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
        /*
        NextForm next = new NextForm("FXMLMainPage.fxml");
        next.show(btnLogin);
        */
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
        }else if (currentUserList.get(Integer.toString(num)) != null) {  
        }
        } // if 1 끝
        else {
            if(radioLoginType_a.isSelected()){
                 hm.put("num", Integer.toString(num));
                 hm.put("name","b");
                 hm.put("id", "b");
                 hm.put("status", "1");
                 try {
                 currentUser.createXML(fp.xml, "CurrentUser.xml", hm);
                    } catch (Exception e) {
                        
                    }
            }
            else if(radioLoginType_b.isSelected()){
                 hm.put("num", Integer.toString(num));
                 hm.put("name",textFeildLoginID.getText());
                 hm.put("id",textFeildLoginID.getText());
                 hm.put("status", "2");
                 try {
                 currentUser.createXML(fp.xml, "CurrentUser.xml", hm);
                    } catch (Exception e) {
                    }
            
            }
        }
       
         Stage stage = (Stage) btnLogin.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMainPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void labelAngryClicked(MouseEvent event) throws IOException {
         Stage stage = (Stage) brandLogo.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMainPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}

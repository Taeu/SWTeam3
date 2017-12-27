/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;


import control.XMLCurrentClickedUserManager;
import java.io.File;
import java.io.FileInputStream;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import others.FilePath;
import static sun.plugin.javascript.navig.JSType.Image;

import java.io.File;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
    public String A;
    @FXML
    private AnchorPane maingpage_Anchorbar;
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
    @FXML
    private Pane menu_image3;
    @FXML
    private Pane menu_image1;
    @FXML
    private Pane menu_image11;
    @FXML
    private Pane menu_image111;
    @FXML
    private Pane menu_image1111;
    @FXML
    private Pane menu_image31;
    @FXML
    private Pane menu_image1112;
    @FXML
    private Label brandLogo;
    @FXML
    private ImageView second;
    @FXML
    private ImageView firstBrand;
    @FXML
    private ImageView fourth;
    @FXML
    private ImageView fifth;
    @FXML
    private ImageView sixth;
    @FXML
    private ImageView third;
    @FXML
    private ImageView seventh;
    @FXML
    private Button btnFeedbackWrite;
    @FXML
    private Button Logout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // init rank view;
        File file = new File("src/images/outback.png");
        Image image = new Image(file.toURI().toString());
        second.setImage(image);
        file = new File("src/images/vips.png");
        image = new Image(file.toURI().toString());
        firstBrand.setImage(image);
        file = new File("src/images/uniqlo.png");
        image = new Image(file.toURI().toString());
        third.setImage(image);
        file = new File("src/images/ashley.jpg");
        image = new Image(file.toURI().toString());
        fourth.setImage(image);
        file = new File("src/images/zara.png");
        image = new Image(file.toURI().toString());
        fifth.setImage(image);
        file = new File("src/images/shilla.jpg");
        image = new Image(file.toURI().toString());
        sixth.setImage(image);
        file = new File("src/images/lotte.png");
        image = new Image(file.toURI().toString());
        seventh.setImage(image);
        
        
        /*
        image = new Image("uniqlo.png");
        third.setImage(image);
                image = new Image("ashley.png");
        fourth.setImage(image);
        image = new Image("zara.png");
        fifth.setImage(image);
                image = new Image("shilla.png");
        sixth.setImage(image);
        image = new Image("lotte.png");
        seventh.setImage(image);
*/
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
                btnLogin.setText("customer");
                btnLogin.setDisable(true);
                btnFeedbackWrite.setVisible(false);
                
         Logout.setVisible(true);
            }
            else if(A.equals("2")){ // brand
                System.out.println("2");
                btnLogin.setText("brand");
                btnLogin.setDisable(true);
                btnComplainWrite.setVisible(false);
                
         Logout.setVisible(true);
                
                
            }
        }
        // TODO
    }    

    @FXML
    private void menuComplainWriteCliked(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnComplainWrite.getScene().getWindow(); // 버튼 이름 수정 필요? 아니 그거 FXML 네임만 수정 필요
        Parent root = FXMLLoader.load(getClass().getResource("FXMLComplainWrite.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void menuComplainReadCliked(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnComplainWrite.getScene().getWindow(); 
        Parent root = FXMLLoader.load(getClass().getResource("FXMLComplainRead.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void menuRankViewCliked(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnComplainWrite.getScene().getWindow(); 
        Parent root = FXMLLoader.load(getClass().getResource("FXMLRankingPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void menuMypageCliked(ActionEvent event) throws IOException {
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
                
            }
            else if(A.equals("2")){ // brand
            }
            else return;
         Stage stageThis;
        stageThis = (Stage) brandLogo.getScene().getWindow();
        stageThis.close();
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLmyPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void btnLoginClicked(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
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


    @FXML
    private void labeAngryCustomerClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) brandLogo.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMainPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void btnFeedbackWriteCliked(ActionEvent event) throws IOException {
        Stage stage = (Stage) brandLogo.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLComplainRead.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void btnLogoutClicked(ActionEvent event) {
        // 0 껄 넣어야함
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
        String id;
        hm.put("num", Integer.toString(num));
        hm.put("name","no");
        hm.put("id", "no");
        hm.put("status", "0");
         try {
                currentUser.createXML(fp.xml, "CurrentUser.xml", hm);
            } catch (Exception e) {
            }
         Logout.setVisible(false);
         btnLogin.setText("Login");
         btnLogin.setDisable(false);
         btnFeedbackWrite.setVisible(true);
         btnComplainWrite.setVisible(true);
         btnLogin.setVisible(true);
         
    }
    
}

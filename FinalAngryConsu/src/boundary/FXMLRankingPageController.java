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
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import others.FilePath;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLRankingPageController implements Initializable {
    private ObservableList<Complaint> data;
    private XMLComplaintManager complaintManager;
    private HashMap hm;
    private HashMap temphm;
    private HashMap idhm;
    private HashMap tempidhm;
    FilePath fp = new FilePath();
    private XMLCurrentClickedUserManager currentUser;
   
    public String A;
    @FXML
    private Label labelCounterBrand1;
    @FXML
    private Label labelCounterBrand2;
    @FXML
    private Label brandLogo;
    @FXML
    private Button btnTotal;
    @FXML
    private Button btnFood;
    @FXML
    private Button btnf;
    @FXML
    private Button btnAcc;
    @FXML
    private Pane menu_image1;
    @FXML
    private ImageView firstBrand;
    @FXML
    private Pane menu_image3;
    @FXML
    private ImageView second;
    @FXML
    private Pane menu_image31;
    @FXML
    private ImageView third;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        File file = new File("src/images/outback.png");
        Image image = new Image(file.toURI().toString());
        second.setImage(image);
        file = new File("src/images/vips.png");
        image = new Image(file.toURI().toString());
        firstBrand.setImage(image);
        file = new File("src/images/uniqlo.png");
        image = new Image(file.toURI().toString());
        third.setImage(image);
    }    

    @FXML
    private void labelCounterBrandCliked(MouseEvent event) {
    }

    @FXML
    private void labelAngryClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) brandLogo.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMainPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void btnTotalClicked(ActionEvent event) {
        File file = new File("src/images/outback.png");
        Image image = new Image(file.toURI().toString());
        second.setImage(image);
        file = new File("src/images/vips.png");
        image = new Image(file.toURI().toString());
        firstBrand.setImage(image);
        file = new File("src/images/uniqlo.png");
        image = new Image(file.toURI().toString());
        third.setImage(image);
    }

    @FXML
    private void btnFoodClicked(ActionEvent event) {
        File file = new File("src/images/outback.png");
        Image image = new Image(file.toURI().toString());
        second.setImage(image);
        file = new File("src/images/vips.png");
        image = new Image(file.toURI().toString());
        firstBrand.setImage(image);
        file = new File("src/images/ashley.jpg");
        image = new Image(file.toURI().toString());
        third.setImage(image);
    }

    @FXML
    private void btnfClicked(ActionEvent event) {
        File file = new File("src/images/zara.png");
        Image image = new Image(file.toURI().toString());
        second.setImage(image);
        file = new File("src/images/uniqlo.png");
        image = new Image(file.toURI().toString());
        firstBrand.setImage(image);
        file = new File("src/images/spao.png");
        image = new Image(file.toURI().toString());
        third.setImage(image);
    }

    @FXML
    private void btnAccClicked(ActionEvent event) {
        File file = new File("src/images/shilla.jpg");
        Image image = new Image(file.toURI().toString());
        second.setImage(image);
        file = new File("src/images/lotte.png");
        image = new Image(file.toURI().toString());
        firstBrand.setImage(image);
        file = new File("src/images/westin.png");
        image = new Image(file.toURI().toString());
        third.setImage(image);
    }
    
}

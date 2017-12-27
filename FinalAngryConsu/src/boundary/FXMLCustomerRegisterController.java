/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLCustomerRegisterController implements Initializable {

    @FXML
    private TextField textFieldId;
    @FXML
    private TextField passwordFieldPw;
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldYearOfBirth;
    @FXML
    private TextField textFieldGender;
    @FXML
    private TextField textFieldPhoneNumber;
    @FXML
    private TextField textFieldEmailAdress;
    @FXML
    private Button btnCustomerRegister;
    @FXML
    private TextField textFieldJob;
    @FXML
    private MenuItem menuComplainWrite;
    @FXML
    private MenuItem menuComplainRead;
    @FXML
    private MenuItem menuRankView;
    @FXML
    private MenuItem menuMypage;
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
         Stage stage = (Stage) brandLogo.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMainPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}

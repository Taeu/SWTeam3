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
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import others.*;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLLogin2Controller implements Initializable {

    @FXML
    private Label labelCounterBrand;
    @FXML
    private TextField textFeildLoginID;
    @FXML
    private PasswordField textFeildLoginPW;
    @FXML
    private Button btnBrandRegister;
    @FXML
    private Button btnCustomerRegister;
    @FXML
    private RadioButton radioLoginType_a;
    @FXML
    private RadioButton radioLoginType_b;
    @FXML
    private Button btnLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void labelCounterBrandCliked(MouseEvent event) {
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
    private void btnLoginCliked(ActionEvent event) throws IOException {
        /*
        NextForm next = new NextForm("FXMLMainPage.fxml");
        next.show(btnLogin);
        */
         Stage stage = (Stage) btnLogin.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMainPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}

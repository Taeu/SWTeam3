/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLBrandRegisterController implements Initializable {

    @FXML
    private Label labelCounterBrand;
    @FXML
    private TextField textFieldID;
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldSNSAddress;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private Button btnBrandRegister;
    @FXML
    private PasswordField passwordFieldPW;
    @FXML
    private TextField textFieldIndustry;
    @FXML
    private TextField textFieldSales;

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
    private void btnSignInSubmitCliked(ActionEvent event) {
    }
    
}

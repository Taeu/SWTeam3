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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLCustomerRegisterController implements Initializable {

    @FXML
    private Label labelCounterBrand;
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
    private void btnCustomerRegisterClicked(ActionEvent event) {
    }
    
}

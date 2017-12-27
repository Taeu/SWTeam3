/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary1;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.ButtonGroup;
import others.*;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLLoginController implements Initializable {

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
    private Button btnLogin;
    @FXML
    private RadioButton radioLoginType_a;
    @FXML
    private RadioButton radioLoginType_b;

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
        /*NextForm next = new NextForm("FXMLMainPage.xml");
        next.show(btnLogin);
        */
        final ToggleGroup group = new ToggleGroup();
        radioLoginType_a.setToggleGroup(group);
        radioLoginType_b.setToggleGroup(group);
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
    public void changed(ObservableValue<? extends Toggle> ov,
        Toggle old_toggle, Toggle new_toggle) {
            if (group.getSelectedToggle() != null) {
                if(group.getSelectedToggle().getUserData().toString().equals("일반회원")){
                    
                }
                else{
                    
                }
            }                
        }
});
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMainPage"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
    }   
}

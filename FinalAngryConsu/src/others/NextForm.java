/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class NextForm {
    public String a;
    public NextForm(){
    }
    public NextForm(String a){ 
        this.a = a;
    }
    
    public void show(Button btnname) throws IOException{
        Stage stage = (Stage) btnname.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(this.a));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}

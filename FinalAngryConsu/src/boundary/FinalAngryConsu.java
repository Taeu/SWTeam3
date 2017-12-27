/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import control.XMLCurrentClickedUserManager;
import java.util.HashMap;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import others.FilePath;
/**
 *
 * @author user
 */
public class FinalAngryConsu extends Application {
    private ObservableList<HashMap> data;
    private XMLCurrentClickedUserManager currentUser = new XMLCurrentClickedUserManager();
    private HashMap hm;
    private HashMap temphm;
    private HashMap idhm;
    private HashMap tempidhm;    FilePath fp = new FilePath();
    @Override
    public void start(Stage stage) throws Exception {
        currentUser.deleteAllXML(fp.xml,"CurrentUser.xml");
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMainPage.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();

        System.out.println("시작");
        FilePath fp = new FilePath();
        System.out.println(fp.boundary);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

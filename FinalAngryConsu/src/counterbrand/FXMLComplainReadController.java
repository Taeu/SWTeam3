/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counterbrand;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLComplainReadController implements Initializable {

    @FXML
    private TableView<?> tableViewComplain;
    @FXML
    private TableColumn<?, ?> tableColumnName;
    @FXML
    private TableColumn<?, ?> tableColumnSub;
    @FXML
    private TableColumn<?, ?> tableColumnTitle;
    @FXML
    private TableColumn<?, ?> tableColumnId;
    @FXML
    private TableColumn<?, ?> tableColumnIndustry;
    @FXML
    private TableColumn<?, ?> tableColumnContent;
    @FXML
    private TableColumn<?, ?> tableColumnTime;
    @FXML
    private Label brandLogo;
    @FXML
    private MenuItem menuComplainWrite;
    @FXML
    private MenuItem menuComplainRead;
    @FXML
    private MenuItem menuRankView;
    @FXML
    private MenuItem menuMypage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ComplainReadDetailCliked(MouseEvent event) {
    }

    @FXML
    private void labelAngryClicked(MouseEvent event) {
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
    
}

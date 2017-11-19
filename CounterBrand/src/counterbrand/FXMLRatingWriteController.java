/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counterbrand;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXMLRatingWriteController implements Initializable {

    @FXML
    private MenuItem menuComplainWrite;
    @FXML
    private MenuItem menuComplainRead;
    @FXML
    private MenuItem menuRankView;
    @FXML
    private MenuItem menuMypage;
    @FXML
    private TextArea textAreaContent;
    @FXML
    private Label labelIndustry;
    @FXML
    private Label labelName;
    @FXML
    private Label labelSub;
    @FXML
    private TextArea textAreaFeedbackContent;
    @FXML
    private Label labelTitle;
    @FXML
    private Label labelCounterBrand;
    @FXML
    private ChoiceBox<String> ChoiceBoxOverall;
    @FXML
    private ChoiceBox<String> ChoiceBoxSpeed;
    @FXML
    private ChoiceBox<String> ChoiceBoxSpec;
    @FXML
    private ChoiceBox<String> ChoiceBoxProc;
    @FXML
    private TextArea ratingContent;
    @FXML
    private Button ratingRegister;
    private ObservableList<ComplainDetail> data;
    private XMLComplainManager complainManager;
    private HashMap hm;
    private HashMap idhm;
    static int id = 0; //

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ChoiceBoxOverall.getItems().addAll("1", "2", "3","4","5");
        ChoiceBoxSpeed.getItems().addAll("1", "2", "3","4","5");
        ChoiceBoxSpec.getItems().addAll("1", "2", "3","4","5");
        ChoiceBoxProc.getItems().addAll("1", "2", "3","4","5");
        
        
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
    private void labelCounterBrandCliked(MouseEvent event) {
    }

    @FXML
    private void registerClicked(MouseEvent event) {
        int a =  Integer.parseInt(ChoiceBoxOverall.getValue());
        int b =  Integer.parseInt(ChoiceBoxSpeed.getValue());
        int c =  Integer.parseInt(ChoiceBoxSpec.getValue());
        int d =  Integer.parseInt(ChoiceBoxProc.getValue());
        String content = ratingContent.getText();
        RatingDetail rating = new RatingDetail(a,b,c,d);
        
       complainManager = new XMLComplainManager();
        hm = new HashMap();
        idhm = new HashMap();
        HashMap complainSubmitList = new HashMap();
        data = FXCollections.observableArrayList();
        

        hm.put("overallRating", Integer.toString(a));
        hm.put("speedRating", Integer.toString(b));
        hm.put("specificityRating", Integer.toString(c));
        hm.put("processRating", Integer.toString(d));
        hm.put("content", content);
        
        System.out.println(hm);
        if (complainSubmitList == null || complainSubmitList.get(Integer.toString(a)) == null) { // 이 부분이 좀 이상한가?
            try {
                // 넣기 전에 각 값들이 널이 아닌지 체크하기!
                complainManager.editXML("C:\\Users\\LENOVO\\Desktop\\SWTeam3-master\\SWTeam3-master\\CounterBrand\\src\\counterbrand\\", "complain.xml", hm);
                complainManager.editXML("C:\\Users\\LENOVO\\Desktop\\SWTeam3-master\\SWTeam3-master\\CounterBrand\\src\\counterbrand\\", "complainDetail.xml", hm);
                
                System.out.println("ok");
            } catch (Exception e) {
            }
            this.id++; // 이 부분 바꿔야하는데,
            a = a + 1;
        } else if (complainSubmitList.get(Integer.toString(a)) != null) {
            this.id++;
            a = a + 1;
        }
        /*
        complainDetailReadOpen();
        // close this scene.
        Stage stageThis;
        stageThis = (Stage) btnComplainSubmit.getScene().getWindow();
        stageThis.close();
        */
    }
    
}

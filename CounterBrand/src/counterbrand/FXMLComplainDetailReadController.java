/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counterbrand;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLComplainDetailReadController implements Initializable {

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

    private ObservableList<ComplainDetail> data;
    private XMLComplainManager complainManager;
    private XMLComplainManager tempComplainManager;
    private HashMap hm;
    private HashMap temphm;
    private String cdKey;
    
    @FXML
    private Label labelCounterBrand;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initComplainDetailReadView();

    }

    public void initComplainDetailReadView() {
        complainManager = new XMLComplainManager();
        data = FXCollections.observableArrayList();
        hm = new HashMap();
        try {
            hm = complainManager.readXML("C:\\Users\\user\\Documents\\GitHub\\SWTeam3\\CounterBrand\\src\\counterbrand\\", "complainDetail.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterator<String> iterator = hm.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();

            temphm = (HashMap) hm.get(key);
            ComplainDetail tempComplainDetail
                    = new ComplainDetail(
                            key,
                            temphm.get("industry").toString(),
                            temphm.get("name").toString(),
                            temphm.get("sub").toString(),
                            temphm.get("time").toString(),
                            temphm.get("title").toString(),
                            temphm.get("content").toString());
            labelName.setText(tempComplainDetail.getName());
            labelIndustry.setText(tempComplainDetail.getIndustry());
            labelSub.setText(tempComplainDetail.getSub());
            labelTitle.setText(tempComplainDetail.getTitle());
            textAreaContent.setText(tempComplainDetail.getContent());
            // 조회한 정보 삭제 , 단순히 view 용이니.
            
            cdKey = tempComplainDetail.getId();
            
            try {
                complainManager.deleteIdXML("C:\\Users\\user\\Documents\\GitHub\\SWTeam3\\CounterBrand\\src\\counterbrand\\", "complainDetail.xml", key);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    private void menuComplainWriteCliked(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLComplainWrite.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void menuComplainReadCliked(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLComplainRead.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void menuRankViewCliked(ActionEvent event) {
    }

    @FXML
    private void menuMypageCliked(ActionEvent event) {
    }

    @FXML
    private void labelCounterBrandCliked(MouseEvent event) throws IOException {
        Stage stageThis;
        stageThis = (Stage) labelCounterBrand.getScene().getWindow();
        stageThis.close();
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMainPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void btnEDITcompleted(ActionEvent event) {
       
        String a = textAreaFeedbackContent.getText();
        Date d = new Date();
        System.out.println("cdKey is : "+cdKey);
       
        complainManager = new XMLComplainManager();
        data = FXCollections.observableArrayList();
        hm = new HashMap();
        
            try {
                complainManager.addFeedbackXML("C:\\Users\\user\\Documents\\GitHub\\SWTeam3\\CounterBrand\\src\\counterbrand\\", "complain.xml", cdKey,"수정완료");
                // addFeedbackXML(경로/이름/id/a/d.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    // 완료된 페이지.fxml  // open 

        
    }






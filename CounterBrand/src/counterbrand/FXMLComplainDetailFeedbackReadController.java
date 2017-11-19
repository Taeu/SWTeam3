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
import javafx.scene.control.Button;
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
public class FXMLComplainDetailFeedbackReadController implements Initializable {

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

    private String cdkey;
    private ObservableList<ComplainDetail> data;
    private XMLComplainManager complainManager;
    private XMLComplainManager tempComplainManager;
    private HashMap hm;
    private HashMap idhm;
    private HashMap temphm;
    static int id = 0; //
    @FXML
    private Label labelCounterBrand;
    @FXML
    private Button btnFeedbackSubmit;
    FilePath fp = new FilePath();

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
<<<<<<< HEAD
            hm = complainManager.readXML(fp.a, "complainDetail.xml");
=======
            hm = complainManager.readXML("C:\\Users\\JunHo\\Documents\\GitHub\\SWTeam3\\CounterBrand\\src\\counterbrand\\", "complainDetail.xml");
>>>>>>> 43f8dace8b210d8558de6b058ca879349305db79

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
                            temphm.get("industry").toString().trim(),
                            temphm.get("name").toString().trim(),
                            temphm.get("sub").toString().trim(),
                            temphm.get("time").toString().trim(),
                            temphm.get("title").toString().trim(),
                            temphm.get("content").toString().trim());
            labelName.setText(tempComplainDetail.getName());
            labelIndustry.setText(tempComplainDetail.getIndustry());
            labelSub.setText(tempComplainDetail.getSub());
            labelTitle.setText(tempComplainDetail.getTitle());
            textAreaContent.setText(tempComplainDetail.getContent());
            
            cdkey=tempComplainDetail.getId();
            // 조회한 정보 삭제 , 단순히 view 용이니.
            try {
<<<<<<< HEAD
                complainManager.deleteIdXML(fp.a, "complainDetail.xml", key);
=======
                complainManager.deleteIdXML("C:\\Users\\JunHo\\Documents\\GitHub\\SWTeam3\\CounterBrand\\src\\counterbrand\\", "complainDetail.xml", key);
>>>>>>> 43f8dace8b210d8558de6b058ca879349305db79

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
    private void btnFeedbackSubmitClicked(ActionEvent event) {  //수정
        int a = 0;
        String c = textAreaFeedbackContent.getText();
        Date fbdate = new Date();
        System.out.println(fbdate.toString());
        // AF 1 ) 누락정보
        /*int r = nullCheck(
                fbdate.toString(),
                c);
        if (r == 1) {
            return;
        }*/
        // AF1 끝

        complainManager = new XMLComplainManager();
        hm = new HashMap();
        HashMap complainSubmitList = new HashMap();
        data = FXCollections.observableArrayList();
        try {
<<<<<<< HEAD
            complainManager.addFeedbackXML(fp.a, "complainDetail.xml", cdkey, c, fbdate);
=======
            complainManager.addFeedbackXML("C:\\Users\\JunHo\\Documents\\GitHub\\SWTeam3\\CounterBrand\\src\\counterbrand\\", "complainDetail.xml", cdkey, c, fbdate);
>>>>>>> 43f8dace8b210d8558de6b058ca879349305db79
        } catch (Exception e) { e.printStackTrace();}
        
        Iterator<String> iterator = idhm.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            a = Integer.parseInt(key);
             temphm = (HashMap) hm.get(key);
            ComplainDetail tempComplainDetail
                    = new ComplainDetail(
                            key,
                            temphm.get("industry").toString().trim(),
                            temphm.get("name").toString().trim(),
                            temphm.get("sub").toString().trim(),
                            temphm.get("time").toString().trim(),
                            temphm.get("title").toString().trim(),
                            temphm.get("content").toString().trim());
            labelName.setText(tempComplainDetail.getName());
            labelIndustry.setText(tempComplainDetail.getIndustry());
            labelSub.setText(tempComplainDetail.getSub());
            labelTitle.setText(tempComplainDetail.getTitle());
            textAreaContent.setText(tempComplainDetail.getContent());
            textAreaFeedbackContent.setText(tempComplainDetail.getContent());
            
            cdkey=tempComplainDetail.getId();
            // 조회한 정보 삭제 , 단순히 view 용이니.
            try {
<<<<<<< HEAD
                complainManager.deleteIdXML(fp.a, "complainDetail.xml", key);
=======
                complainManager.deleteIdXML("C:\\Users\\JunHo\\Documents\\GitHub\\SWTeam3\\CounterBrand\\src\\counterbrand\\", "complainDetail.xml", key);
>>>>>>> 43f8dace8b210d8558de6b058ca879349305db79

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        a = a + 1;

        hm.put("feedbackContent", textAreaContent.getText());
        hm.put("feedbackTime", fbdate.toString());
        System.out.println(hm);
        
        if (complainSubmitList == null || complainSubmitList.get(Integer.toString(a)) == null) { // 이 부분이 좀 이상한가?
            try {
                // 넣기 전에 각 값들이 널이 아닌지 체크하기!
<<<<<<< HEAD
                complainManager.editXML(fp.a, "complain.xml", hm);
                complainManager.editXML(fp.a, "complainDetail.xml", hm);
=======
                complainManager.editXML("C:\\Users\\JunHo\\Documents\\GitHub\\SWTeam3\\CounterBrand\\src\\counterbrand\\", "complain.xml", hm);
                complainManager.editXML("C:\\Users\\JunHo\\Documents\\GitHub\\SWTeam3\\CounterBrand\\src\\counterbrand\\", "complainDetail.xml", hm);
>>>>>>> 43f8dace8b210d8558de6b058ca879349305db79
                
                System.out.println("ok");
            } catch (Exception e) {}
            this.id++; // 이 부분 바꿔야하는데,
        } else if (complainSubmitList.get(Integer.toString(a)) != null) {
            this.id++;
        }
    }

}

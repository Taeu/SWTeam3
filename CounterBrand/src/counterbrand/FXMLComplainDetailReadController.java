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
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLComplainDetailReadController implements Initializable {

    @FXML
    private TextArea textAreaFeedbackContent;
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
    private Label labelCounterBrand;

    private String cdkey;
    private ObservableList<ComplainDetail> data;
    private XMLComplainManager complainManager;
    private XMLComplainManager tempComplainManager;
    private HashMap hm;
    private HashMap idhm;
    private HashMap temphm;
    static int id = 0; //
    @FXML
    private Label labelTitle;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initComplainDetailReadView();
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
    
    
    
    public void initComplainDetailReadView() {
        complainManager = new XMLComplainManager();
        data = FXCollections.observableArrayList();
        hm = new HashMap();
        try {
            hm = complainManager.readXML("C:\\Users\\LENOVO\\Documents\\GitHub\\SWTeam3\\CounterBrand\\src\\counterbrand\\", "complainDetail.xml");

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
                complainManager.deleteIdXML("C:\\Users\\LENOVO\\Documents\\GitHub\\SWTeam3\\CounterBrand\\src\\counterbrand\\", "complainDetail.xml", key);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

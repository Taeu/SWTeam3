/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counterbrand;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JunHo
 */
public class FXMLBrandRegisterController implements Initializable {

    @FXML
    private MenuItem menuComplainWrite;
    @FXML
    private MenuItem menuComplainRead;
    @FXML
    private MenuItem menuRankView;
    @FXML
    private MenuItem menuMypage;
    @FXML
    private Label labelCounterBrand;
    @FXML
    private TextField textFieldID;
    @FXML
    private TextField textFieldSNSAddress;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private PasswordField passwordFieldPW;
    @FXML
    private ChoiceBox<String> choiceBoxIndustry;
    @FXML
    private ChoiceBox<String> choiceBoxSales;
    @FXML
    private Button btnBrandRegister;
    
    private ObservableList<UserBrandDetail> data;
    private XMLUserBrandManager brandManger;
    private HashMap hm;
    private HashMap idhm;
    @FXML
    private TextField textFieldName;
    FilePath fp = new FilePath();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        choiceBoxIndustry.getItems().addAll("패션", "음식", "숙박");
        choiceBoxSales.getItems().addAll("0~100억", "100억~500억", "500억~2000억", "2000억 이상");
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
    private void btnSignInSubmitCliked(ActionEvent event) {
        int a = 0;
        Date date = new Date();
        System.out.println(date.toString());
        // AF 1 ) 누락정보
        
        /*  NULLCHECK 생략
        int r = nullCheck(Integer.toString(a),
                textFieldId.getText(),
                passwordFieldPw.getText(),
                textFieldName.getText(),
                textFieldYearOfBirth.getText(),
                textFieldGender.getText(),
                textFieldPhoneNumber.getText(),
                textFieldEmailAdress.getText(),
                textFieldJob.getText());
        if (r == 1) {
            return;
        }
        */
        // AF1 끝

        brandManger = new XMLUserBrandManager();
        hm = new HashMap();
        idhm = new HashMap();
        HashMap brandSubmitList = new HashMap();
        data = FXCollections.observableArrayList();
        try {
            idhm = brandManger.readXML(fp.a, "userBrand.xml");

            brandSubmitList = brandManger.readXML("C:\\Users\\JunHo\\Documents\\GitHub\\SWTeam3\\CounterBrand\\src\\counterbrand\\", "userBrand.xml");
           
            // ok no problem.
        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterator<String> iterator = brandSubmitList.keySet().iterator();
        System.out.println(iterator);
        while (iterator.hasNext()) {
            System.out.println("key");
            String key = iterator.next();
            a = Integer.parseInt(key);
        }
        a = a + 1;
        ////////////// id 도 들어갈 때 마다 하나씩 증가해야하는 것.
        //hm.put("id", industry.);
        ////////////// choice 블럭에 잇는 것들도
        // 아래는 제대로 넣어지는군

        System.out.println(Integer.toString(a));
        System.out.println(textFieldID.getText());
        System.out.println(passwordFieldPW.getText());
        System.out.println(textFieldName.getText());
        System.out.println(textFieldSNSAddress.getText());
        System.out.println(textFieldEmail.getText());
        System.out.println(choiceBoxIndustry.getValue());
        System.out.println(choiceBoxSales.getValue());

        hm.put("num", Integer.toString(a));
        hm.put("id", textFieldID.getText());
        hm.put("password", passwordFieldPW.getText());
        hm.put("name", textFieldName.getText());
        hm.put("SNSAddress", textFieldSNSAddress.getText());
        hm.put("Email", textFieldEmail.getText());
        hm.put("industry", choiceBoxIndustry.getValue());
        hm.put("sales", choiceBoxSales.getValue());
        System.out.println(hm);
        if (brandSubmitList == null || brandSubmitList.get(Integer.toString(a)) == null) { // 이 부분이 좀 이상한가?
            try {
                // 넣기 전에 각 값들이 널이 아닌지 체크하기!
                brandManger.editXML(fp.a, "userBrand.xml", hm);

                
                System.out.println("ok");
            } catch (Exception e) {
            }
            
            a = a + 1;
            
        } else if (brandSubmitList.get(Integer.toString(a)) != null) {
            a = a + 1;
        }
        
        // close this scene.
        Stage stageThis;
        stageThis = (Stage) btnBrandRegister.getScene().getWindow();
        stageThis.close();
        showAlert();
        
    }
    void showAlert() {
        Alert.AlertType AlterType = null;
        Alert alert = new Alert(AlterType.INFORMATION);
        alert.setTitle("안내");
        alert.setHeaderText("가입을 환영합니다.");
        alert.setContentText("축하드립니다.");
        alert.showAndWait().ifPresent(rs
                -> {
            if (rs == ButtonType.OK) {
                alert.close();
            }
        });
    }
    
}

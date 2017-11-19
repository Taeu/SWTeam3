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
import javafx.scene.control.Button;
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
public class FXMLCustomerRegisterController implements Initializable {

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
    private TextField textFieldId;
    @FXML
    private TextField textFieldName;
    private TextField textFieldYearOfBirth;
    @FXML
    private TextField textFieldGender;
    @FXML
    private TextField textFieldPhoneNumber;
    @FXML
    private TextField textFieldEmailAdress;
    @FXML
    private TextField textFieldJob;
    @FXML
    private TextField passwordFieldPw;
    @FXML
    private Button btnCustomerRegister;
    
    private ObservableList<UserCustomerDetail> data;
    private XMLUserCustomerManager customerManger;
    private HashMap hm;
    private HashMap temphm;
    private HashMap idhm;
    private HashMap tempidhm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void btnCustomerRegisterClicked(ActionEvent event) {
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

        customerManger = new XMLUserCustomerManager();
        hm = new HashMap();
        idhm = new HashMap();
        HashMap customerSubmitList = new HashMap();
        data = FXCollections.observableArrayList();
        try {
            customerSubmitList = customerManger.readXML("C:\\Users\\user\\Desktop\\cc\\CounterBrand\\src\\counterbrand\\", "userCustomer.xml");
            idhm = customerManger.readXML("C:\\Users\\user\\Desktop\\cc\\CounterBrand\\src\\counterbrand\\", "userCustomer.xml");
            // ok no problem.
        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterator<String> iterator = idhm.keySet().iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            /* data.clear();
            tempidhm = (HashMap) hm.get(key);
            data.add(new ComplainDetails(key, tempidhm.get("id").toString().trim()));
             */
            a = Integer.parseInt(key);
        }
        a = a + 1;
        ////////////// id 도 들어갈 때 마다 하나씩 증가해야하는 것.
        //hm.put("id", industry.);
        ////////////// choice 블럭에 잇는 것들도
        // 아래는 제대로 넣어지는군

        System.out.println(Integer.toString(a));
        System.out.println(textFieldId.getText());
        System.out.println(passwordFieldPw.getText());
        System.out.println(textFieldName.getText());
        System.out.println(textFieldYearOfBirth.getText());
        System.out.println(textFieldGender.getText());
        System.out.println(textFieldPhoneNumber.getText());
        System.out.println(textFieldEmailAdress.getText());
        System.out.println(textFieldJob.getText());

        hm.put("num", Integer.toString(a));
        hm.put("id", textFieldId.getText());
        hm.put("password", passwordFieldPw.getText());
        hm.put("name", textFieldName.getText());
        hm.put("gender", textFieldGender.getText());
        hm.put("birth", textFieldYearOfBirth.getText());
        hm.put("email", textFieldEmailAdress.getText());
        hm.put("phone", textFieldPhoneNumber.getText());
        hm.put("job", textFieldJob.getText());
        System.out.println(hm);
        if (customerSubmitList == null || customerSubmitList.get(Integer.toString(a)) == null) { // 이 부분이 좀 이상한가?
            try {
                // 넣기 전에 각 값들이 널이 아닌지 체크하기!
                customerManger.editXML("C:\\Users\\user\\Desktop\\cc\\CounterBrand\\src\\counterbrand\\", "userCustomer.xml", hm);
                
                System.out.println("ok");
            } catch (Exception e) {
            }
            
            a = a + 1;
            
        } else if (customerSubmitList.get(Integer.toString(a)) != null) {
            a = a + 1;
        }
        
        // close this scene.
        Stage stageThis;
        stageThis = (Stage) btnCustomerRegister.getScene().getWindow();
        stageThis.close();
    }

    @FXML
    private void textFieldYearOfBirth(ActionEvent event) {
    }
    
}

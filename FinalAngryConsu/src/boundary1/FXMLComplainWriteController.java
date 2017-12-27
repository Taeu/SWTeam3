/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary1;

import control.XMLComplaintManager;
import entity.Brand;
import entity.Complaint;
import entity.Feedback;
import entity.Rating;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import others.FilePath;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLComplainWriteController implements Initializable {
    private ObservableList<Complaint> data;
    private XMLComplaintManager complaintManager;
    private HashMap hm;
    private HashMap temphm;
    private HashMap idhm;
    private HashMap tempidhm;    FilePath fp = new FilePath();

    @FXML
    private TextArea textAreaContent;
    @FXML
    private TextField textFieldTitle;
    @FXML
    private Button btnComplainSubmit;
    @FXML
    private Label labelCounterBrand;
    @FXML
    private TextField overall;
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldSub;
    @FXML
    private TextArea textAreaFeedbackContent;
    @FXML
    private Button btnFeedbackSubmit;
    @FXML
    private TextArea textAreaRatingContent;
    @FXML
    private Button btnEvaluate;
    @FXML
    private TextField textFieldIndustry1;
    @FXML
    private TextField speed;
    @FXML
    private TextField specificity;
    @FXML
    private TextField process;
    
    Complaint c;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
    public Brand chkBrand(String name){
        Brand b;
        if(name.equals("uniqlo")){
            b= new Brand("101","패션",name);
        }else if(name.equals("zara")){
            b= new Brand("102","패션",name);
        }else if(name.equals("h&m")){
            b= new Brand("103","패션",name);
        }else {
            b= new Brand("104","패션",name);
        }
        return b;
    } 
    
    int nullCheck(String id, String ind, String name, String sub, String time, String title, String content) {

        if (id == null) {
            showAlert("아이디");
            return 1;
        } else if (ind == null) {
            showAlert("산업");
            return 1;
        } else if (name == null) {
            showAlert("브랜드");
            return 1;
        } else if (sub == null) {
            showAlert("세부사항");
            return 1;
        } else if (time.equals("")) {
            showAlert("시간");
            return 1;
        } //시간정보
        else if (title == null) {
            showAlert("제목");
            return 1;
        } else if (content == null) {
            showAlert("세부내용");
            return 1;
        }

        if (id.equals("")) {
            showAlert("아이디");
            return 1;
        } else if (ind.equals("")) {
            showAlert("산업");
            return 1;
        } else if (name.equals("")) {
            showAlert("브랜드");
            return 1;
        } else if (sub.equals("")) {
            showAlert("세부사항");
            return 1;
        } else if (time.equals("")) {
            showAlert("시간");
            return 1;
        } //시간정보
        else if (title.equals("")) {
            showAlert("제목");
            return 1;
        } else if (content.equals("")) {
            showAlert("세부내용");
            return 1;
        }
        return 0;

    }
    int nullCheck2(String over, String speed, String detail, String process) {

        
        if (over.equals("")) {
            showAlert("종합평가");
            return 1;
        } else if (speed.equals("")) {
            showAlert("스피드");
            return 1;
        } else if (detail.equals("")) {
            showAlert("구체성");
            return 1;
        } else if (process.equals("")) {
            showAlert("공정성");
            return 1;
        } 
        return 0;

    }
    @FXML
    private void btnComplainSubmitCliked(ActionEvent event) {
        //////////////////////////////////////////////////////////////////////// 맨처음 AF1 누락체크
        // AF 1 ) 누락정보
        int r = nullCheck(
                "1",
                textFieldName.getText(),
                textFieldIndustry1.getText(),
                textFieldSub.getText(),
                "1",
                textFieldTitle.getText(),
                textAreaContent.getText());
        if (r == 1) {
            return;
        }
        // AF1 끝
        ////////////////////////////////////////////////////////////////////////
        
        // num (key 값 받기)
        int num=0;         // num count 해주어야함.
        complaintManager = new XMLComplaintManager();
        hm = new HashMap();
        idhm = new HashMap();
        HashMap complaintSubmitList = new HashMap();
        data = FXCollections.observableArrayList();
        try {
            complaintSubmitList = complaintManager.readXML(fp.xml, "complaint.xml");
            idhm = complaintManager.readXML(fp.xml, "complaint.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterator<String> iterator = idhm.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            num = Integer.parseInt(key);
        }
        num = num + 1;
        // num 완료
        
        // id 
        String id;          // current user 의 id도 넣어주어야함.
        
        
        //
        
        Date date = new Date();
        String checkBrand = textFieldName.getText();
        Brand brand = chkBrand(checkBrand);
        
        c = new Complaint(
                Integer.toString(num),
                "a",
                textFieldTitle.getText(),
                textAreaContent.getText(),
                date.toString(),
                brand,
                textFieldSub.getText()
        );
        
        if (complaintSubmitList == null || complaintSubmitList.get(Integer.toString(num)) == null) {
            try {
                complaintManager.editXML(fp.xml, "complaint.xml", c); // 여기 hm 대신 complaint 가 들어가면 됨.
            } catch (Exception e) {
            }
        } else if (complaintSubmitList.get(Integer.toString(num)) != null) {
           
        }
        
    }

    @FXML
    private void labelCounterBrandCliked(MouseEvent event) {
    }

    @FXML
    private void btnFeedbackSubmitCliked(ActionEvent event) {
        int r = nullCheck(
                "1",
                "1",
                "1",
                "1",
                "1",
                "1",
                textAreaFeedbackContent.getText());
        if (r == 1) {
            return;
        }
        // read
        complaintManager = new XMLComplaintManager();
        hm = new HashMap();
        idhm = new HashMap();
        HashMap complaintSubmitList = new HashMap();
        data = FXCollections.observableArrayList();
        try {
            complaintSubmitList = complaintManager.readXML(fp.xml, "complaint.xml");
            idhm = complaintManager.readXML(fp.xml, "complaint.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // read end
        
        // addFeedback
        Date date = new Date();
        Feedback fb = new Feedback(textAreaFeedbackContent.getText(),date.toString());
        int num = 2;
        System.out.println(fb.getContent());
        if (complaintSubmitList == null || complaintSubmitList.get(Integer.toString(num)) != null) {
            try {
                System.out.println("try to add");
                complaintManager.addFeedbackXML(fp.xml, "complaint.xml", Integer.toString(num),fb); // 여기 hm 대신 complaint 가 들어가면 됨.
            } catch (Exception e) {
            }
        } else if (complaintSubmitList.get(Integer.toString(num)) == null) {
           System.out.println("there is no such information to add");
        }
        
        //
        
    }

    @FXML
    private void btnEvalutateCliked(ActionEvent event) {
        int r = nullCheck2(
                "1",
                "1",
                "1",
                "1"
                );
        if (r == 1) {
            return;
        }
        // read
        complaintManager = new XMLComplaintManager();
        hm = new HashMap();
        idhm = new HashMap();
        HashMap complaintSubmitList = new HashMap();
        data = FXCollections.observableArrayList();
        try {
            complaintSubmitList = complaintManager.readXML(fp.xml, "complaint.xml");
            idhm = complaintManager.readXML(fp.xml, "complaint.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // read end
        
        // addRating
        
        Rating rating = new Rating(5,5,5,5);
        int num = 2;
        if (complaintSubmitList == null || complaintSubmitList.get(Integer.toString(num)) != null) {
            try {
                System.out.println("try to add");
                complaintManager.addRatingXML(fp.xml, "complaint.xml", Integer.toString(num),rating); // 여기 hm 대신 complaint 가 들어가면 됨.
            } catch (Exception e) {
            }
        } else if (complaintSubmitList.get(Integer.toString(num)) == null) {
           System.out.println("there is no such information to add");
        }
        
        //
        
        
    }

    public void showAlert(String a) {
        Alert.AlertType AlterType = null;
        Alert alert = new Alert(AlterType.INFORMATION);
        alert.setTitle("안내");
        alert.setHeaderText("불만접수 오류 메시지");
        alert.setContentText(a + " 정보가 누락되었습니다.");
        alert.showAndWait().ifPresent(rs
                -> {
            if (rs == ButtonType.OK) {
                alert.close();
            }
        });
    }
    
    
}

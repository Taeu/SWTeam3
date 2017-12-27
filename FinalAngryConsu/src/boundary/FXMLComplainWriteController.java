/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import control.XMLComplaintManager;
import control.XMLCurrentClickedUserManager;
import entity.Brand;
import entity.Complaint;
import entity.Feedback;
import entity.Rating;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
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
    private HashMap tempidhm;
    FilePath fp = new FilePath();
    String industry="";
    String name ="";
    
    @FXML
    private Label labelCounterBrand1;
    @FXML
    private Label labelCounterBrand2;
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
    private TextField textFieldTitle;
    @FXML
    private Button btnComplainSubmit;
    @FXML
    private TextField textFieldName;
    @FXML
    private Label brandLogo;
    @FXML
    private Button btnFood;
    @FXML
    private Button btnFashion;
    @FXML
    private Button btnAccommodation;
    @FXML
    private ImageView a;
    @FXML
    private ImageView a11;
    @FXML
    private ImageView a1;
    @FXML
    private ImageView a111;
    @FXML
    private TextArea textAreaFeedbackContent;
    @FXML
    private Button btnFeedbackSubmit;
    @FXML
    private RadioButton overall1;
    @FXML
    private RadioButton overall2;
    @FXML
    private RadioButton overall4;
    @FXML
    private RadioButton overall3;
    @FXML
    private RadioButton overall5;
    @FXML
    private RadioButton d1;
    @FXML
    private RadioButton d2;
    @FXML
    private RadioButton d4;
    @FXML
    private RadioButton d3;
    @FXML
    private RadioButton d5;
    @FXML
    private RadioButton sp1;
    @FXML
    private RadioButton sp2;
    @FXML
    private RadioButton sp4;
    @FXML
    private RadioButton sp3;
    @FXML
    private RadioButton sp5;
    @FXML
    private RadioButton p1;
    @FXML
    private RadioButton p2;
    @FXML
    private RadioButton p4;
    @FXML
    private RadioButton p3;
    @FXML
    private RadioButton p5;
    @FXML
    private TextArea textAreaRatingContent;
    @FXML
    private Button btnRatingSubmit;
    @FXML
    private Label lbrt2;
    @FXML
    private Label lbfb;
    @FXML
    private Label lbrt;
    @FXML
    private Label lbfb2;

     public Brand chkBrand(String name){
        Brand b;
        if(name.equals("uniqlo")){
            b= new Brand("101",name, "패션");
        }else if(name.equals("zara")){
            b= new Brand("102",name,"패션");
        }else if(name.equals("h_m")){
            b= new Brand("103",name,"패션");
        }else if(name.equals("spao")){
            b= new Brand("104",name,"패션");
        }
        if(name.equals("lotte")){
            b= new Brand("201",name, "숙박");
        }else if(name.equals("shilla")){
            b= new Brand("202",name,"숙박");
        }else if(name.equals("westin")){
            b= new Brand("203",name,"숙박");
        }else if(name.equals("hilton")){
            b= new Brand("204",name,"숙박");
        }
        if(name.equals("vips")){
            b= new Brand("301",name, "음식");
        }else if(name.equals("ashley")){
            b= new Brand("302",name,"음식");
        }else if(name.equals("outback")){
            b= new Brand("303",name,"음식");
        }else {
            b= new Brand("304",name,"패션");
        }
        return b;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // 아래 부분 부터가 페이지 브랜드인지 아닌지 체크해줌.
        int num=0;         // num count 해주어야함.
        XMLCurrentClickedUserManager currentUser = new XMLCurrentClickedUserManager();
        HashMap hm = new HashMap();
        HashMap idhm = new HashMap();
        HashMap currentUserList = new HashMap();
        data = FXCollections.observableArrayList();
        try {
            currentUserList = currentUser.readXML(fp.xml, "CurrentUser.xml");
            idhm = currentUser.readXML(fp.xml, "CurrentUser.xml");
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
        System.out.println("this num : "+num);
        // id 
        String id;          // current user 의 id도 넣어주어야함.
        
        
        //
        if ( num ==1 ) {
            
                System.out.println("0");
        hm.put("num", Integer.toString(num));
        hm.put("name","no");
        hm.put("id", "no");
        hm.put("status", "0");
        // 이부분을 클래스로 바꿔주고.
        if (currentUserList == null || currentUserList.get(Integer.toString(num)) == null) {
            try {
                currentUser.createXML(fp.xml, "CurrentUser.xml", hm);
            } catch (Exception e) {
            }
        } else if (currentUserList.get(Integer.toString(num)) != null) {  
        }
        }
        else {
            String A="";
            System.out.println("gggg");
            try {
                A = currentUser.searchXML(fp.xml,"CurrentUser.xml");
            } catch (IOException ex) {
                Logger.getLogger(boundary1.FXMLMainPageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(boundary1.FXMLMainPageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(boundary1.FXMLMainPageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(boundary1.FXMLMainPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(A.equals("1")){ // customer
                System.out.println("1");
                lbfb.setVisible(false);
                lbfb2.setVisible(false);
                textAreaFeedbackContent.setVisible(false);
                btnFeedbackSubmit.setVisible(false);
                
            }
            else if(A.equals("2")){ // brand
                System.out.println("2");
                String B="";
                System.out.println("gggg");
            try {
                B = currentUser.searchNameXML(fp.xml,"CurrentUser.xml");
            } catch (IOException ex) {
                Logger.getLogger(boundary1.FXMLMainPageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(boundary1.FXMLMainPageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(boundary1.FXMLMainPageController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(boundary1.FXMLMainPageController.class.getName()).log(Level.SEVERE, null, ex);
            }
                File file; Image image;
        
                if(B.equals("uniqlo")){
                    file = new File("src/images/uniqlo.png");
                    image = new Image(file.toURI().toString());
                    a.setImage(image);
                }
                if(B.equals("zara")){
                    file = new File("src/images/zara.png");
                    image = new Image(file.toURI().toString());
                    a.setImage(image);
                }
                if(B.equals("h_m")){
                    file = new File("src/images/h&m.png");
                    image = new Image(file.toURI().toString());
                    a.setImage(image);
                }
                if(B.equals("spao")){
                    file = new File("src/images/spao.png");
                    image = new Image(file.toURI().toString());
                    a.setImage(image);
                }
                if(B.equals("vips")){
                    file = new File("src/images/vips.png");
                    image = new Image(file.toURI().toString());
                    a.setImage(image);
                }
                if(B.equals("ashley")){
                    file = new File("src/images/ashley.jpg");
                    image = new Image(file.toURI().toString());
                    a.setImage(image);
                }
                if(B.equals("dmaris")){
                    file = new File("src/images/dmaris.jpg");
                    image = new Image(file.toURI().toString());
                    a.setImage(image);
                }
                if(B.equals("outback")){
                    file = new File("src/images/outback.png");
                    image = new Image(file.toURI().toString());
                    a.setImage(image);
                }
                if(B.equals("lotte")){
                    file = new File("src/images/lotte.png");
                    image = new Image(file.toURI().toString());
                    a.setImage(image);
                }
                if(B.equals("shilla")){
                    file = new File("src/images/shilla.jpg");
                    image = new Image(file.toURI().toString());
                    a.setImage(image);
                }
                if(B.equals("hilton")){
                    file = new File("src/images/hilton.png");
                    image = new Image(file.toURI().toString());
                    a.setImage(image);
                }
                if(B.equals("westin")){
                    file = new File("src/images/westin.png");
                    image = new Image(file.toURI().toString());
                    a.setImage(image);
                }
                
                a1.setVisible(false);
                a11.setVisible(false);
                a111.setVisible(false);
                textFieldName.setDisable(true);
                textFieldTitle.setDisable(true);
                textAreaContent.setDisable(true);
                btnComplainSubmit.setVisible(false);
            }
        }
        // TODO
    }    

    @FXML
    private void labelCounterBrandCliked(MouseEvent event) throws IOException {
         
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
    private void btnComplainSubmitCliked(ActionEvent event) throws IOException {
        //////////////////////////////////////////////////////////////////////// 맨처음 AF1 누락체크
        // AF 1 ) 누락정보
        int r = nullCheck(
                "1",
                name,
                industry,
                textFieldName.getText(),
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
        int count=0;
        try{
            count = complaintManager.searchXML(fp.xml, "complaint.xml");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        num = count + 1;
        // num 완료
        
        // id 
        String id;          // current user 의 id도 넣어주어야함.
        
        
        //
        
        Date date = new Date();
        String checkBrand = name;
        Brand brand = chkBrand(checkBrand);
        
        Complaint c = new Complaint(
                Integer.toString(num),
                "b",
                textFieldTitle.getText(),
                textAreaContent.getText(),
                date.toString(),
                brand,
                textFieldName.getText()
        );
        
        if (complaintSubmitList == null || complaintSubmitList.get(Integer.toString(num)) == null) {
            try {
                complaintManager.editXML(fp.xml, "complaint.xml", c); // 여기 hm 대신 complaint 가 들어가면 됨.
            } catch (Exception e) {
            }
        } else if (complaintSubmitList.get(Integer.toString(num)) != null) {
           
        }
         Stage stageThis;
        stageThis = (Stage) btnComplainSubmit.getScene().getWindow();
        stageThis.close();
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMainPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void labelAngryCustomerClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) brandLogo.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMainPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void btnFoodClicked(ActionEvent event) {
        File file = new File("src/images/vips.png");
        Image image = new Image(file.toURI().toString());
        a.setImage(image);
        file = new File("src/images/ashley.jpg");
        image = new Image(file.toURI().toString());
        a1.setImage(image);
        file = new File("src/images/outback.png");
        image = new Image(file.toURI().toString());
        a11.setImage(image);
        file = new File("src/images/dmaris.jpg");
        image = new Image(file.toURI().toString());
        a111.setImage(image);
        industry = "음식";
    }

    @FXML
    private void btnFashionClicked(ActionEvent event) {
        File file = new File("src/images/uniqlo.png");
        Image image = new Image(file.toURI().toString());
        a.setImage(image);
        file = new File("src/images/zara.png");
        image = new Image(file.toURI().toString());
        a1.setImage(image);
        file = new File("src/images/h&m.png");
        image = new Image(file.toURI().toString());
        a11.setImage(image);
        file = new File("src/images/spao.png");
        image = new Image(file.toURI().toString());
        a111.setImage(image);
        industry = "패션";
    }

    @FXML
    private void btnAccommodationClicked(ActionEvent event) {
        File file = new File("src/images/lotte.png");
        Image image = new Image(file.toURI().toString());
        a.setImage(image);
        file = new File("src/images/shilla.jpg");
        image = new Image(file.toURI().toString());
        a1.setImage(image);
        file = new File("src/images/westin.png");
        image = new Image(file.toURI().toString());
        a11.setImage(image);
        file = new File("src/images/hilton.png");
        image = new Image(file.toURI().toString());
        a111.setImage(image);
        industry = "숙박";
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
    private void btnRatingSubmitCliked(ActionEvent event) {
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

    @FXML
    private void aClicked(MouseEvent event) {
        if(industry.equals("패션")) name = "uniqlo";
        if(industry.equals("숙박")) name = "lotte";
        if(industry.equals("음식")) name = "vips";
        
    }

    

    @FXML
    private void a1Clicked(MouseEvent event) {
        if(industry.equals("패션")) name = "zara";
        if(industry.equals("숙박")) name = "shilla";
        if(industry.equals("음식")) name = "ashley";
    }
    @FXML
    private void a11Clicked(MouseEvent event) {
        if(industry.equals("패션")) name = "h&m";
        if(industry.equals("숙박")) name = "westin";
        if(industry.equals("음식")) name = "outback";
        
        
    }
    @FXML
    private void a111Clicked(MouseEvent event) {
                if(industry.equals("패션")) name = "spao";
        if(industry.equals("숙박")) name = "hilton";
        if(industry.equals("음식")) name = "dmaris";
    }
    
}

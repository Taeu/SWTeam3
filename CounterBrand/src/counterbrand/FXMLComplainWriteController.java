/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counterbrand;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Optional;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import java.util.Date;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLComplainWriteController implements Initializable {

    @FXML
    private MenuItem menuComplainWrite;
    @FXML
    private MenuItem menuComplainRead;
    @FXML
    private MenuItem menuRankView;
    @FXML
    private MenuItem menuMypage;
    @FXML
    private ChoiceBox<String> choiceBoxIndustry;
    @FXML
    private ChoiceBox<String> choiceBoxName;
    @FXML
    private ChoiceBox<String> choiceBoxSub;
    @FXML
    private TextArea textAreaContent;
    @FXML
    private TextField textFieldTitle;
    @FXML
    private Button btnComplainSubmit;

    private ObservableList<ComplainDetail> data;
    private XMLComplainManager complainManager;
    private HashMap hm;
    private HashMap temphm;
    private HashMap idhm;
    private HashMap tempidhm;
    static int id = 0; //
    @FXML
    private Label labelCounterBrand;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initChoiceBox();
    }

    public void initChoiceBox() {
        // 초이스박스 선택지를 init
        choiceBoxIndustry.getItems().addAll("패션", "음식", "숙박");
        choiceBoxIndustry.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                if (choiceBoxIndustry.getItems().get(0) == choiceBoxIndustry.getItems().get(number2.intValue())) {
                    choiceBoxName.getItems().clear();
                    choiceBoxSub.getItems().clear();
                    choiceBoxName.getItems().addAll("ZARA", "SPAO", "유니클로", "지오다노", "탑텐");
                    choiceBoxSub.getItems().addAll("환불/교환/AS", "내구성", "사이즈");
                } else if (choiceBoxIndustry.getItems().get(1) == choiceBoxIndustry.getItems().get(number2.intValue())) {
                    choiceBoxName.getItems().clear();
                    choiceBoxSub.getItems().clear();
                    choiceBoxName.getItems().addAll("봉구스", "홍콩반점", "서브웨이");
                    choiceBoxSub.getItems().addAll("위생", "서비스", "맛");

                } else {
                    choiceBoxName.getItems().clear();
                    choiceBoxSub.getItems().clear();
                    choiceBoxName.getItems().addAll("롯데", "신라", "쉐라톤", "힐튼");
                    choiceBoxSub.getItems().addAll("위생", "안전", "편의시설", "친절도");
                }
            }
        });
    }

    //////// 아래는 FXML 코드
    @FXML
    private void menuComplainWriteCliked(ActionEvent event) {
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

    void complainDetailReadOpen() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLComplainDetailRead.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void btnComplainSubmitCliked(ActionEvent event) throws IOException, Exception {

        int a = 0;
        Date date = new Date();
        System.out.println(date.toString());
        // AF 1 ) 누락정보
        int r = nullCheck(Integer.toString(a),
                choiceBoxIndustry.getValue(),
                choiceBoxName.getValue(),
                choiceBoxSub.getValue(),
                date.toString(),
                textFieldTitle.getText(),
                textAreaContent.getText());
        if (r == 1) {
            return;
        }
        // AF1 끝

        complainManager = new XMLComplainManager();
        hm = new HashMap();
        idhm = new HashMap();
        HashMap complainSubmitList = new HashMap();
        data = FXCollections.observableArrayList();
        try {
            complainSubmitList = complainManager.readXML("C:\\Users\\user\\Documents\\GitHub\\SWTeam3\\CounterBrand\\src\\counterbrand\\", "complain.xml");
            idhm = complainManager.readXML("C:\\Users\\user\\Documents\\GitHub\\SWTeam3\\CounterBrand\\src\\counterbrand\\", "complain.xml");
            // ok no problem.
        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterator<String> iterator = idhm.keySet().iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            /* data.clear();
            tempidhm = (HashMap) hm.get(key);
            data.add(new ComplainDetails(key, tempidhm.get("id").toString()));
             */
            a = Integer.parseInt(key);
        }
        a = a + 1;
        ////////////// id 도 들어갈 때 마다 하나씩 증가해야하는 것.
        //hm.put("id", industry.);
        ////////////// choice 블럭에 잇는 것들도
        // 아래는 제대로 넣어지는군

        System.out.println(Integer.toString(a));
        System.out.println(choiceBoxName.getValue());
        System.out.println(choiceBoxIndustry.getValue());
        System.out.println(choiceBoxSub.getValue());
        System.out.println(date.toString());
        System.out.println(textFieldTitle.getText());
        System.out.println(textAreaContent.getText());

        hm.put("id", Integer.toString(a));
        hm.put("name", choiceBoxName.getValue());
        hm.put("industry", choiceBoxIndustry.getValue());
        hm.put("sub", choiceBoxSub.getValue());
        hm.put("time", date.toString());
        hm.put("title", textFieldTitle.getText());
        hm.put("content", textAreaContent.getText());
        System.out.println(hm);
        if (complainSubmitList == null || complainSubmitList.get(Integer.toString(a)) == null) { // 이 부분이 좀 이상한가?
            try {
                // 넣기 전에 각 값들이 널이 아닌지 체크하기!
                complainManager.editXML("C:\\Users\\user\\Documents\\GitHub\\SWTeam3\\CounterBrand\\src\\counterbrand\\", "complain.xml", hm);
                complainManager.editXML("C:\\Users\\user\\Documents\\GitHub\\SWTeam3\\CounterBrand\\src\\counterbrand\\", "complainDetail.xml", hm);
                
                System.out.println("ok");
            } catch (Exception e) {
            }
            this.id++; // 이 부분 바꿔야하는데,
            a = a + 1;
        } else if (complainSubmitList.get(Integer.toString(a)) != null) {
            this.id++;
            a = a + 1;
        }
        complainDetailReadOpen();
        // close this scene.
        Stage stageThis;
        stageThis = (Stage) btnComplainSubmit.getScene().getWindow();
        stageThis.close();
    }

    void showAlert(String a) {
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

    //AF1
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

    
}

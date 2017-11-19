/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counterbrand;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLComplainReadController implements Initializable {

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
    private TableView<ComplainDetail> tableViewComplain;
    @FXML
    private TableColumn<ComplainDetail, String> tableColumnName;
    @FXML
    private TableColumn<ComplainDetail, String> tableColumnSub;
    @FXML
    private TableColumn<ComplainDetail, String> tableColumnTitle;

    private ObservableList<ComplainDetail> data;
    private XMLComplainManager complainManager;
    private HashMap hm;
    private HashMap temphm;

    //아래는 invisble
    @FXML
    private TableColumn<ComplainDetail, String> tableColumnId;
    @FXML
    private TableColumn<ComplainDetail, String> tableColumnIndustry;
    @FXML
    private TableColumn<ComplainDetail, String> tableColumnContent;
    @FXML
    private TableColumn<ComplainDetail, String> tableColumnTime;
    @FXML
    private Label labelCounterBrand;
    FilePath fp = new FilePath();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initComplainReadTableView();
        initChoiceBox();

    }

    private void initComplainReadTableView() {
        complainManager = new XMLComplainManager();
        data = FXCollections.observableArrayList();
        hm = new HashMap();

        try {
            hm = complainManager.readXML(fp.a, "complain.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterator<String> iterator = hm.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            temphm = (HashMap) hm.get(key);
            data.add(new ComplainDetail(key, temphm.get("name").toString().trim(), temphm.get("industry").toString().trim(), temphm.get("sub").toString().trim(), temphm.get("time").toString().trim(), temphm.get("title").toString().trim(), temphm.get("content").toString().trim()));
        }
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnSub.setCellValueFactory(new PropertyValueFactory<>("sub"));
        tableColumnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnContent.setCellValueFactory(new PropertyValueFactory<>("content"));
        tableColumnTime.setCellValueFactory(new PropertyValueFactory<>("time"));

        tableViewComplain.setItems(null);
        tableViewComplain.setItems(data);

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
    private void menuComplainReadCliked(ActionEvent event) {
    }

    @FXML
    private void menuRankViewCliked(ActionEvent event) {
    }

    @FXML
    private void menuMypageCliked(ActionEvent event) {
    }

    @FXML
    private void ComplainReadDetailCliked(MouseEvent event) throws IOException {
        complainManager = new XMLComplainManager();
        data = FXCollections.observableArrayList();
        hm = new HashMap();
        HashMap complainDetailList = new HashMap();
        try {
            complainDetailList = complainManager.readXML(fp.a, "complainDetail.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }

        ComplainDetail complainDetail = tableViewComplain.getSelectionModel().getSelectedItem();
        hm.put("id", complainDetail.getId());
        hm.put("name", complainDetail.getName());
        hm.put("sub", complainDetail.getSub());
        hm.put("industry", complainDetail.getIndustry());
        hm.put("time", complainDetail.getTime());
        hm.put("title", complainDetail.getTitle());
        hm.put("content", complainDetail.getContent());

        System.out.println("선택한 정보 :" + hm);
        try {
            complainManager.editXML(fp.a, "complainDetail.xml", hm);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLComplainDetailRead.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

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

    public void initChoiceBox() {
        // 초이스박스 선택지를 init
        choiceBoxIndustry.getItems().addAll("패션", "음식", "숙박", " ");
        choiceBoxIndustry.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                if (choiceBoxIndustry.getItems().get(0).equals(choiceBoxIndustry.getItems().get(number2.intValue()))) {
                    initComplainReadTableView(0);
                    choiceBoxName.getItems().clear();
                    choiceBoxSub.getItems().clear();
                    choiceBoxName.getItems().addAll("ZARA", "SPAO", "유니클로", "지오다노", "탑텐");
                    choiceBoxSub.getItems().addAll("환불/교환/AS", "내구성", "사이즈");
                } else if (choiceBoxIndustry.getItems().get(1).equals(choiceBoxIndustry.getItems().get(number2.intValue()))) {
                    initComplainReadTableView(1);
                    choiceBoxName.getItems().clear();
                    choiceBoxSub.getItems().clear();
                    choiceBoxName.getItems().addAll("봉구스", "홍콩반점", "서브웨이");
                    choiceBoxSub.getItems().addAll("위생", "서비스", "맛");

                } else if (choiceBoxIndustry.getItems().get(2).equals(choiceBoxIndustry.getItems().get(number2.intValue()))) {
                     initComplainReadTableView(2);
                    choiceBoxName.getItems().clear();
                    choiceBoxSub.getItems().clear();
                    choiceBoxName.getItems().addAll("롯데", "신라", "쉐라톤", "힐튼");
                    choiceBoxSub.getItems().addAll("위생", "안전", "편의시설", "친절도");
                }
                else {
                    // 
                    choiceBoxIndustry.getItems().clear();
                    choiceBoxName.getItems().clear();
                    choiceBoxSub.getItems().clear();
                    initComplainReadTableView();
                    initChoiceBox();
                }
            }
        });
    }

    @FXML
    private void choiceBoxIndustryCliked(MouseEvent event) {

    }

    @FXML
    private void choiceBoxNameCliked(MouseEvent event) {

    }

    @FXML
    private void choiceBoxSubCliked(MouseEvent event) {

    }

    private void initComplainReadTableView(int industry) {
        complainManager = new XMLComplainManager();
        data = FXCollections.observableArrayList();
        hm = new HashMap();

        try {
            hm = complainManager.readXML(fp.a, "complain.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterator<String> iterator = hm.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            temphm = (HashMap) hm.get(key);
            if (industry == 0) {
                if (temphm.get("industry").toString().trim().equals("패션")) {
                    data.add(new ComplainDetail(key, temphm.get("name").toString().trim(), temphm.get("industry").toString().trim(), temphm.get("sub").toString().trim(), temphm.get("time").toString().trim(), temphm.get("title").toString().trim(), temphm.get("content").toString().trim()));
                }
            } else if (industry == 1) {
                if (temphm.get("industry").toString().trim().equals("음식")) {
                    data.add(new ComplainDetail(key, temphm.get("name").toString().trim(), temphm.get("industry").toString().trim(), temphm.get("sub").toString().trim(), temphm.get("time").toString().trim(), temphm.get("title").toString().trim(), temphm.get("content").toString().trim()));
                }
            } else {
                if (temphm.get("industry").toString().trim().equals("숙박")) {
                    data.add(new ComplainDetail(key, temphm.get("name").toString().trim(), temphm.get("industry").toString().trim(), temphm.get("sub").toString().trim(), temphm.get("time").toString().trim(), temphm.get("title").toString().trim(), temphm.get("content").toString().trim()));
                }
            }
            tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
            tableColumnSub.setCellValueFactory(new PropertyValueFactory<>("sub"));
            tableColumnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
            tableColumnContent.setCellValueFactory(new PropertyValueFactory<>("content"));
            tableColumnTime.setCellValueFactory(new PropertyValueFactory<>("time"));

            tableViewComplain.setItems(null);
            tableViewComplain.setItems(data);
        }
    }

    private void initComplainReadTableView(int industry, int name) {

    }

    private void initComplainReadTableView(int industry, int name, int sub) {

    }

}

package com.accountant.controller.impl;

import com.accountant.controller.Controller;
import com.accountant.pojo.po.ConsumePO;
import com.accountant.service.ConsumeService;
import com.accountant.service.TypeService;
import com.accountant.util.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class AddConsumeController implements Controller {

    @FXML
    private GridPane gridPane;
    @FXML
    private ChoiceBox choiceBoxParent;
    @FXML
    private ChoiceBox choiceBoxChild;
    private Integer[] choiceBoxChildIds = null;
    @FXML
    private TextField consumerTextField;
    @FXML
    private DatePicker consumeDateDatePicker;
    @FXML
    private TextField consumeAddressTextField;
    private List<List<TextField>> textFields = new ArrayList<>();

    private TypeService typeService = new TypeService();

    private ConsumeService consumeService = new ConsumeService();

    @Override
    public void initUI(){

        consumeDateDatePicker.setValue(LocalDate.now());

        choiceBoxParent.setMinWidth(93);
        choiceBoxChild.setMinWidth(93);

        choiceBoxParent.setItems(FXCollections.observableArrayList("必须", "非必须"));
        choiceBoxParent.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                Map<String, Object> data = typeService.list("" + newValue);
                List<Map<String, Object>> datas = (List<Map<String, Object>>)data.get("data");
                choiceBoxChildIds = new Integer[datas.size()];
                String[] v = new String[datas.size()];
                for (int i = 0; i < datas.size(); i++) {
                    choiceBoxChildIds[i] = Integer.valueOf(String.valueOf(datas.get(i).get("id")));
                    v[i] = String.valueOf(datas.get(i).get("name"));
                }
                choiceBoxChild.setItems(FXCollections.observableArrayList(v));
            }
        });

        String[] promptText = {"商品名称", "金额", "数量", "单价"};
        TextField textField = null;
        for (int i = 0; i < 15; i++) {
            List<TextField> textFieldRow = new ArrayList<>();
            for (int j = 0; j < promptText.length; j++) {
                textField = new TextField();
                textField.setPromptText(promptText[j]);
                gridPane.add(textField, j, i);
                textFieldRow.add(textField);
            }
            textFields.add(textFieldRow);
        }
    }

    @Override
    public void initData() {

    }

    @FXML
    public void addConsume(){

        ConsumePO consumePO = null;
        if (choiceBoxChild.getValue() == null || StringUtils.isEmpty(choiceBoxChild.getValue().toString())){
            ParsResult.toast("请选择类型.");
            return;
        }
        if (StringUtils.isAnyEmpty(consumerTextField.getText(), consumeAddressTextField.getText())){
            ParsResult.toast("请填写基本信息.");
            return;
        }
        for (int i = 0; i < textFields.size(); i++) {
            if (StringUtils.isAnyEmpty(textFields.get(i).get(0).getText(),
                    textFields.get(i).get(1).getText())){
                continue;
            }
            consumePO = new ConsumePO();
            consumePO.setTypeId(""+choiceBoxChildIds[choiceBoxChild.getSelectionModel().getSelectedIndex()]);
            consumePO.setUserId(LoginEr.getId());
            consumePO.setItem(textFields.get(i).get(0).getText());
            consumePO.setAmount(textFields.get(i).get(1).getText());
            consumePO.setNumber(textFields.get(i).get(2).getText());
            consumePO.setPrice(textFields.get(i).get(3).getText());
            consumePO.setConsumer(consumerTextField.getText());
            consumePO.setConsumeDate(consumeDateDatePicker.getValue().toString());
            consumePO.setConsumeAddress(consumeAddressTextField.getText());
            consumePO.setRemark("");
            consumePO.setCreateDate(DateUtil.currentDateTime());
            consumeService.add(consumePO);

            if (ControllerManager.getController(ControllerManager.CONSUMELIST_CONTROLLER) != null){
                ControllerManager.getController(ControllerManager.CONSUMELIST_CONTROLLER).initData();
            }
        }

        UIManager.closeUI(UIManager.ADDCONSUME_UI);
        ParsResult.toast("操作成功.");
    }

}

package com.accountant.controller.impl;

import com.accountant.controller.Controller;
import com.accountant.service.TypeService;
import com.accountant.util.ParsResult;
import com.accountant.util.StringUtils;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeController implements Controller {

    private TypeService typeService = new TypeService();

    @FXML
    private GridPane necessary;
    @FXML
    private GridPane notNecessary;
    @FXML
    private TextField necessaryTextField;
    @FXML
    private TextField notNecessaryTextField;

    @FXML
    public void addNecessary(){
        if (StringUtils.isEmpty(necessaryTextField.getText())){
            ParsResult.toast("请录入信息");
            return;
        }
        Map<String, Object> data = typeService.add("0", necessaryTextField.getText());
        if (ParsResult.isOk(data)){
            necessaryTextField.setText("");
            setData();
        }
    }

    @FXML
    public void addNotNecessary(){
        if (StringUtils.isEmpty(notNecessaryTextField.getText())){
            ParsResult.toast("请录入信息");
            return;
        }
        Map<String, Object> data = typeService.add("1", notNecessaryTextField.getText());
        if (ParsResult.isOk(data)){
            notNecessaryTextField.setText("");
            setData();
        }
    }

    public void setData(){
        setGridPaneDate(necessary, "0");
        setGridPaneDate(notNecessary, "1");
    }

    @Override
    public void initUI() {

    }

    @Override
    public void initData() {
        setData();
    }

    private void setGridPaneDate(GridPane gridPane, String v){
        gridPane.getChildren().clear();
        Map<String, Object> data = typeService.list(v);
        if (ParsResult.isOk(data)){
            List<Map<String, Object>> datas = (List<Map<String, Object>>)data.get("data");
            int row = datas.size() % 5 > 0 ? datas.size() / 5 + 1 : datas.size() / 5;
            List<List<Map<String, Object>>> pool = new ArrayList<>();
            int k = 0;
            for (int i = 0; i < row; i++) {
                List<Map<String, Object>> rowList = new ArrayList<>();
                for (int j = 0; j < 5 && k < datas.size(); j++) {
                    rowList.add(((Map<String, Object>)datas.get(k)));
                    k++;
                }
                pool.add(rowList);
            }

            for (int i = 0; i < pool.size(); i++) {
                for (int j = 0; j < pool.get(i).size(); j++) {
                    Map<String, Object> o = pool.get(i).get(j);
                    Label label = new Label(String.valueOf(o.get("name")));
                    label.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            Boolean b = ParsResult.confirmation("确定删除吗?");
                            if (b){
                                Map<String, Object> result = typeService.delete(Integer.valueOf(String.valueOf(o.get("id"))));
                                if (ParsResult.isOk(data)){
                                    initData();
                                }
                            }
                        }
                    });
                    gridPane.add(label, j, i);
                }
            }
        }
    }

}

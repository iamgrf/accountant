package com.accountant.controller.impl;

import com.accountant.controller.Controller;
import com.accountant.service.TypeService;
import com.accountant.util.ParsResult;
import com.accountant.util.StringUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
                    Label label = new Label(String.valueOf(pool.get(i).get(j).get("name")));
                    gridPane.add(label, j, i);
                }
            }
        }
    }

}

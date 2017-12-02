package com.accountant.controller.impl;

import com.accountant.controller.Controller;
import com.accountant.pojo.model.ConsumeListModel;
import com.accountant.service.ConsumeService;
import com.accountant.ui.*;
import com.accountant.util.PageUtil;
import com.accountant.util.ParsResult;
import com.accountant.util.StringUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConsumeListController implements Controller {

    private ConsumeService consumeService = new ConsumeService();

    @FXML
    private DatePicker startDateDatePicker;
    @FXML
    private DatePicker endDateDatePicker;
    @FXML
    private ChoiceBox typeChoiceBox;
    @FXML
    private TableView<ConsumeListModel> tableView;
    @FXML
    private Pagination pagination;

    @FXML
    public void openTypeUI(){
        try {
            new TypeUI();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openAddConsumeUI(){
        try {
            new AddConsumeUI();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openPieChartUI(){
        new PieChartUI();
    }

    @FXML
    public void openLineChartUI(){
        new LineChartUI();
    }

    @Override
    public void initUI(){

        typeChoiceBox.setItems(FXCollections.observableArrayList("所有", "必须", "非必须"));

        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer param) {
                PageUtil pageUtil = new PageUtil();
                pageUtil.setPage(param);
                pageUtil.setPageSize(ConstantUtil.PAGESIZE);
                setTableDate(pageUtil);
                Label label = new Label();
                return label;
            }
        });
    }

    @Override
    public void initData() {
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPage(0);
        pageUtil.setPageSize(ConstantUtil.PAGESIZE);
        setTableDate(pageUtil);
    }

    /**
     * 填充表数据
     */
    public void setTableDate(PageUtil pageUtil){
        String startDate = null;
        String endDate = null;
        String type = null;
        if (startDateDatePicker.getValue() != null){
            startDate = startDateDatePicker.getValue().toString();
        }
        if (endDateDatePicker.getValue() != null){
            endDate = endDateDatePicker.getValue().toString();
        }
        if (typeChoiceBox.getValue() != null){
            if ("必须".equals(typeChoiceBox.getValue().toString())){
                type = "0";
            }else if("非必须".equals(typeChoiceBox.getValue().toString())){
                type = "1";
            }
        }
        Map<String, Object> data = consumeService.list(startDate, endDate, type, pageUtil);
        if (ParsResult.isOk(data)){
            pageUtil = (PageUtil)data.get("data");
            pagination.setPageCount(pageUtil.getPages());
            List<Map<String, Object>> datas = pageUtil.getData();
            List<ConsumeListModel> consumeListModels = new ArrayList<>(datas.size());
            ConsumeListModel consumeListModel = null;
            for (int i = 0; i < datas.size(); i++) {
                consumeListModel = new ConsumeListModel();
                consumeListModel.setNum("" + (i + 1));
                consumeListModel.setV("0".equals(StringUtils.objTOstr(datas.get(i).get("v"))) ? "必须" : "非必须");
                consumeListModel.setTypeName(StringUtils.objTOstr(datas.get(i).get("type_name")));
                consumeListModel.setItem(StringUtils.objTOstr(datas.get(i).get("item")));
                consumeListModel.setRealName(StringUtils.objTOstr(datas.get(i).get("real_name")));
                consumeListModel.setNumber(StringUtils.objTOstr(datas.get(i).get("number")));
                consumeListModel.setPrice(StringUtils.objTOstr(datas.get(i).get("price")));
                consumeListModel.setAmount(StringUtils.objTOstr(datas.get(i).get("amount")));
                consumeListModel.setConsumer(StringUtils.objTOstr(datas.get(i).get("consumer")));
                consumeListModel.setConsumeDate(StringUtils.objTOstr(datas.get(i).get("consume_date")));
                consumeListModel.setConsumeAddress(StringUtils.objTOstr(datas.get(i).get("consume_address")));
                consumeListModel.setRemark(StringUtils.objTOstr(datas.get(i).get("remark")));
                consumeListModel.setCreateDate(StringUtils.objTOstr(datas.get(i).get("create_date")));
                consumeListModels.add(consumeListModel);
            }
            tableView.getItems().clear();
            tableView.getItems().addAll(consumeListModels);
        }
    }

}

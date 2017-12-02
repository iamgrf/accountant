package com.accountant.ui;

import com.accountant.service.PieChartService;
import com.accountant.util.UIManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

public class PieChartUI {

    private DatePicker startDatePicker;
    private DatePicker endDatePicker;
    private PieChart pieChart;
    private PieChart mustPieChart;
    private PieChart notMustPieChart;
    private PieChartService pieChartService = new PieChartService();

    public PieChartUI() {
        Stage primaryStage = new Stage();
        UIManager.addUI(UIManager.PIECHART_UI, primaryStage);
        primaryStage.setResizable(false);
        initUI(primaryStage);
        initData();
    }

    private void initData(){
        query();
    }

    private void query(){
        String startDate = startDatePicker.getValue().toString();
        String endDate = endDatePicker.getValue().toString();

        //-----------------------
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        List<Map<String, Object>> data = pieChartService.typeStatistics(startDate, endDate);
        for (int i = 0; i < data.size(); i++) {
            String name = String.valueOf(data.get(i).get("name"));
            if ("0".equals(name)){
                name = "必须:" + String.valueOf(data.get(i).get("totalAmount"))+"元";
            }else{
                name = "非必须:" + String.valueOf(data.get(i).get("totalAmount"))+"元";
            }
            pieChartData.add(new PieChart.Data(name, Float.valueOf(String.valueOf(data.get(i).get("totalAmount")))));
        }
        pieChart.setData(pieChartData);

        //-----------------------
        ObservableList<PieChart.Data> mustPieChartData = FXCollections.observableArrayList();
        data = pieChartService.mustStatistics(startDate, endDate);
        for (int i = 0; i < data.size(); i++) {
            String name = String.valueOf(data.get(i).get("name")) +":"+ String.valueOf(data.get(i).get("totalAmount"))+"元";
            mustPieChartData.add(new PieChart.Data(name, Float.valueOf(String.valueOf(data.get(i).get("totalAmount")))));
        }
        mustPieChart.setData(mustPieChartData);

        //-----------------------
        ObservableList<PieChart.Data> notMustPieChartData = FXCollections.observableArrayList();
        data = pieChartService.notMustStatistics(startDate, endDate);
        for (int i = 0; i < data.size(); i++) {
            String name = String.valueOf(data.get(i).get("name")) +":"+ String.valueOf(data.get(i).get("totalAmount"))+"元";
            notMustPieChartData.add(new PieChart.Data(name, Float.valueOf(String.valueOf(data.get(i).get("totalAmount")))));
        }
        notMustPieChart.setData(notMustPieChartData);
    }

    private void initUI(Stage primaryStage){
        VBox vBox = new VBox();

        startDatePicker = new DatePicker();
        startDatePicker.setPromptText("开始日期");
        startDatePicker.setValue(LocalDate.now().minus(1, ChronoUnit.MONTHS));
        endDatePicker = new DatePicker();
        endDatePicker.setPromptText("结束日期");
        endDatePicker.setValue(LocalDate.now());

        Button queryButton = new Button("查询");
        queryButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                query();
            }
        });

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.BASELINE_CENTER);
        hBox.setPadding(new Insets(8));
        hBox.setSpacing(8);
        hBox.getChildren().addAll(startDatePicker, endDatePicker, queryButton);

        vBox.getChildren().add(hBox);

        /////////////////图/////////////////

        pieChart = new PieChart();
        pieChart.setTitle("类型统计");
        pieChart.setLabelLineLength(10);
        pieChart.setLegendSide(Side.LEFT);
        vBox.getChildren().add(pieChart);

        mustPieChart = new PieChart();
        mustPieChart.setTitle("必须统计");
        mustPieChart.setLabelLineLength(10);
        mustPieChart.setLegendSide(Side.LEFT);
        vBox.getChildren().add(mustPieChart);

        notMustPieChart = new PieChart();
        notMustPieChart.setTitle("非必须统计");
        notMustPieChart.setLabelLineLength(10);
        notMustPieChart.setLegendSide(Side.LEFT);
        vBox.getChildren().add(notMustPieChart);

        Scene scene  = new Scene(vBox,800,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

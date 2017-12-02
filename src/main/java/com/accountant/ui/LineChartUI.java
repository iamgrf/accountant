package com.accountant.ui;

import com.accountant.service.LineChartService;
import com.accountant.util.UIManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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

public class LineChartUI {

    private DatePicker startDatePicker;
    private DatePicker endDatePicker;
    private ToggleGroup group;
    private LineChart<String,Number> lineChart;
    private LineChartService lineChartService = new LineChartService();

    public LineChartUI() {
        Stage primaryStage = new Stage();
        UIManager.addUI(UIManager.LINE_CHART_UI, primaryStage);
        primaryStage.setResizable(false);
        initUI(primaryStage);
        initData();
    }

    private void initData() {
        query();
    }

    private void query(){
        String toggle = String.valueOf(group.getSelectedToggle().getUserData());
        String startDate = startDatePicker.getValue().toString();
        String endDate = endDatePicker.getValue().toString();
        List<Map<String, Object>> data = null;
        switch (toggle){
            case "d":
                data = lineChartService.dStatistics(startDate, endDate);
                break;
            case "m":
                data = lineChartService.mStatistics(startDate, endDate);
                break;
            case "y":
                data = lineChartService.yStatistics(startDate, endDate);
                break;
        }

        XYChart.Series series = new XYChart.Series();
        series.setName("消费");
        lineChart.getData().clear();
        for (int i = 0; i < data.size(); i++) {
            series.getData().add(new XYChart.Data(String.valueOf(data.get(i).get("consumeDate"))+" "+String.valueOf(data.get(i).get("totalAmount"))+"元", Float.valueOf(String.valueOf(data.get(i).get("totalAmount")))));
        }
        lineChart.getData().add(series);

    }

    private void initUI(Stage primaryStage){
        VBox vBox = new VBox();

        startDatePicker = new DatePicker();
        startDatePicker.setPromptText("开始日期");
        startDatePicker.setValue(LocalDate.now().minus(1, ChronoUnit.MONTHS));
        endDatePicker = new DatePicker();
        endDatePicker.setPromptText("结束日期");
        endDatePicker.setValue(LocalDate.now());

        group = new ToggleGroup();
        RadioButton dRadioButton = new RadioButton("按日");
        dRadioButton.setUserData("d");
        dRadioButton.setSelected(true);
        dRadioButton.setToggleGroup(group);
        RadioButton mRadioButton = new RadioButton("按月");
        mRadioButton.setUserData("m");
        mRadioButton.setToggleGroup(group);
        RadioButton yRadioButton = new RadioButton("按年");
        yRadioButton.setUserData("y");
        yRadioButton.setToggleGroup(group);

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
        hBox.getChildren().addAll(startDatePicker, endDatePicker, dRadioButton, mRadioButton, yRadioButton, queryButton);

        vBox.getChildren().add(hBox);

        /////////////////图/////////////////

        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("时间");
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("金额");
        lineChart = new LineChart<String, Number>(xAxis,yAxis);
        lineChart.setTitle("折线图");
        vBox.getChildren().add(lineChart);

        Scene scene  = new Scene(vBox,800,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

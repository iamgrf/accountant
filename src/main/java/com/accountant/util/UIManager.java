package com.accountant.util;

import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class UIManager {

    public static final String LOGIN_UI = "loginUI";
    public static final String CONSUMELIST_UI = "consumeListUI";
    public static final String ADDCONSUME_UI = "addConsumeUI";
    public static final String TYPE_UI = "typeUI";
    public static final String LINE_CHART_UI = "lineChartUI";
    public static final String PIECHART_UI = "pieChartUI";

    private static Map<String, Stage> stageMap = new HashMap<>();

    public static void addUI(String uiKey, Stage stage){
        stageMap.put(uiKey, stage);
    }

    public static void closeUI(String uiKey){
        Stage stage = stageMap.get(uiKey);
        if (stage != null){
            stageMap.remove(uiKey);
            stage.close();
        }
    }

}

package com.accountant.util;

import com.accountant.controller.Controller;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class ControllerManager {

    public static final String LOGIN_CONTROLLER = "loginController";
    public static final String CONSUMELIST_CONTROLLER = "consumeListController";
    public static final String ADDCONSUME_CONTROLLER = "addConsumeController";
    public static final String TYPE_CONTROLLER = "typeController";
    public static final String LINE_CHART_CONTROLLER = "lineChartController";

    private static Map<String, Controller> controllerMap = new HashMap<>();

    public static void addController(String controllerKey, Controller controller){
        controllerMap.put(controllerKey, controller);
    }

    public static Controller getController(String controllerKey){
        return controllerMap.get(controllerKey);
    }

}

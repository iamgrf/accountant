package com.accountant.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Map;
import java.util.Optional;

public class ParsResult {

    public static Boolean isOk(Map<String, Object> args){
        if ("1".equals(String.valueOf(args.get("code")))){
            return true;
        }else{
            toast(String.valueOf(args.get("msg")));
            return false;
        }
    }

    public static void toast(String msg){
        Alert information = new Alert(Alert.AlertType.INFORMATION, msg);
        information.setTitle("系统提示");
        information.setHeaderText("");
        information.show();
    }

    public static Boolean confirmation(String msg){
        Alert information = new Alert(Alert.AlertType.CONFIRMATION, msg);
        information.setTitle("系统提示");
        information.setHeaderText("");
        Optional<ButtonType> result = information.showAndWait();
        if (result.get() == ButtonType.OK){
            return true;
        }
        return false;
    }

}

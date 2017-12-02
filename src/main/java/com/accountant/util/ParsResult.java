package com.accountant.util;

import javafx.scene.control.Alert;

import java.util.Map;

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

}

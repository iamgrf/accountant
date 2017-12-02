package com.accountant.controller.impl;

import com.accountant.controller.Controller;
import com.accountant.service.UserService;
import com.accountant.ui.ConsumeListUI;
import com.accountant.ui.LoginUI;
import com.accountant.util.LoginEr;
import com.accountant.util.ParsResult;
import com.accountant.util.StringUtils;
import com.accountant.util.UIManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.util.Map;

public class LoginController implements Controller {

    @FXML
    private TextField accountTextField;
    @FXML
    private TextField pwdPasswordField;

    private UserService userService = new UserService();

    @Override
    public void initUI(){
        pwdPasswordField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if ("Enter".equals(event.getCode().getName())){
                    login();
                }
            }
        });
    }

    @Override
    public void initData() {

    }

    @FXML
    public void login(){
        if (StringUtils.isAnyEmpty(accountTextField.getText(), pwdPasswordField.getText())){
            ParsResult.toast("请录入信息");
            return;
        }
        Map<String, Object> result = userService.login(accountTextField.getText(), pwdPasswordField.getText());
        Map<String, String> data = (Map<String, String>)result.get("data");
        if (ParsResult.isOk(result)){
            try {
                LoginEr.setId(data.get("id"));
                LoginEr.setAccount(data.get("account"));
                LoginEr.setRealName(data.get("real_name"));
                new ConsumeListUI();
                UIManager.closeUI(UIManager.LOGIN_UI);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

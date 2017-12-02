package com.accountant.ui;

import com.accountant.controller.impl.LoginController;
import com.accountant.util.UIManager;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginUI{

    public LoginUI(Stage primaryStage) throws IOException {
        UIManager.addUI(UIManager.LOGIN_UI, primaryStage);
        primaryStage.setResizable(false);
        primaryStage.setTitle("记帐本");
        URL url = getClass().getResource("/login_view.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(url);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        javafx.scene.Parent pane = (javafx.scene.Parent) fxmlLoader.load(url.openStream());
        LoginController loginController=(LoginController)fxmlLoader.getController();
        loginController.initUI();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

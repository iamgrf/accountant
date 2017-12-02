package com.accountant.ui;

import com.accountant.controller.impl.AddConsumeController;
import com.accountant.util.UIManager;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * 添加消息信息界面
 */
public class AddConsumeUI {

    public AddConsumeUI() throws IOException {
        Stage primaryStage = new Stage();
        UIManager.addUI(UIManager.ADDCONSUME_UI, primaryStage);
        primaryStage.setResizable(false);
        primaryStage.setTitle("记帐本");
        URL url = getClass().getResource("/add_consume_view.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(url);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        javafx.scene.Parent pane = (javafx.scene.Parent) fxmlLoader.load(url.openStream());
        AddConsumeController addConsumeController=(AddConsumeController)fxmlLoader.getController();
        addConsumeController.initUI();
        addConsumeController.initData();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}

package com.accountant.ui;

import com.accountant.controller.impl.ConsumeListController;
import com.accountant.util.ControllerManager;
import com.accountant.util.PageUtil;
import com.accountant.util.UIManager;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


public class ConsumeListUI {

    public ConsumeListUI() throws IOException {
        Stage primaryStage = new Stage();
        UIManager.addUI(UIManager.CONSUMELIST_UI, primaryStage);
        primaryStage.setResizable(false);
        primaryStage.setTitle("记帐本");
        URL url = getClass().getResource("/consume_list_view.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(url);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        javafx.scene.Parent pane = (javafx.scene.Parent) fxmlLoader.load(url.openStream());
        ConsumeListController consumeListController=(ConsumeListController)fxmlLoader.getController();
        ControllerManager.addController(ControllerManager.CONSUMELIST_CONTROLLER, consumeListController);
        consumeListController.initUI();
        consumeListController.initData();
        Scene scene = new Scene(pane, 1230, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}

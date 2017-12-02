package com.accountant.ui;

import com.accountant.controller.impl.TypeController;
import com.accountant.util.UIManager;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class TypeUI {

    public TypeUI() throws IOException {
        Stage primaryStage = new Stage();
        UIManager.addUI(UIManager.TYPE_UI, primaryStage);
        primaryStage.setResizable(false);
        primaryStage.setTitle("账本");
        URL url = getClass().getResource("/type_view.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(url);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        javafx.scene.Parent pane = (javafx.scene.Parent) fxmlLoader.load(url.openStream());
        TypeController typeController=(TypeController)fxmlLoader.getController();
        typeController.setData();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

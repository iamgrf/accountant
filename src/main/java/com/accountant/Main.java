package com.accountant;

import com.accountant.ui.ConsumeListUI;
import com.accountant.ui.LineChartUI;
import com.accountant.ui.LoginUI;
import com.accountant.ui.PieChartUI;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by xy on 2017/11/9.
 */
public class Main extends Application{

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new LoginUI(primaryStage);
    }
}

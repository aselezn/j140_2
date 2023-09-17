package application;

import application.views.LoginView;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;

        primaryStage.setTitle("JavaFX Application 1.0");
        primaryStage.setScene(LoginView.getLoginScene(primaryStage));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Called method stop()");
    }

    public static void main(String[] args) {
        launch(args);
    }

}

package application.views;

import database.queries.AuthQueries;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LoginView {

    public static Scene getLoginScene(Stage primaryStage){

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));

        Font customFont = Font.font("Arial", 16);

        Label welcomeLabel = new Label("Welcome!");
        welcomeLabel.setFont(customFont);

        Label usernameLabel = new Label("Имя пользователя:");
        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Пароль:");
        PasswordField passwordField = new PasswordField();

        Button authenticateButton = new Button("Войти");

        Text resultText = new Text();
        resultText.setFill(Color.RED);

        authenticateButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (AuthQueries.authenticateUser(username, password)) {
                primaryStage.setScene(PersonsView.getPersonScene(primaryStage));
            } else {
                resultText.setFill(Color.RED);
                resultText.setText("Ошибка аутентификации. Попробуйте снова.");
            }
        });

        root.add(welcomeLabel, 0, 0, 2, 1);
        root.add(usernameLabel, 0, 1);
        root.add(usernameField, 1, 1);
        root.add(passwordLabel, 0, 2);
        root.add(passwordField, 1, 2);
        root.add(authenticateButton, 0, 3, 2, 1);
        root.add(resultText, 0, 4, 2, 1);

        return new Scene(root, 400, 300);

    }
}

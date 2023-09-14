package app;

import DataBase.models.Person;
import DataBase.queries.Auth;
import DataBase.queries.PersonData;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class App extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;

        primaryStage.setTitle("JavaFX Application 1.0");
        primaryStage.setScene(getAuthorizationScene());
        primaryStage.show();
    }

    private Scene getAuthorizationScene(){

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

            if (Auth.authenticateUser(username, password)) {
                primaryStage.setScene(getPersonScene());
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

        Scene scene = new Scene(root, 400, 300);

        return scene;

    }

    private Scene getPersonScene() {

        List<Person> persons = PersonData.getPersons();

        TableView<Person> tableView = new TableView<>();

        ObservableList<Person> data = FXCollections.observableArrayList(persons);
        tableView.setItems(data);

        TableColumn<Person, Integer> idColumn = new TableColumn<Person, Integer>("id");
        idColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("id"));
        tableView.getColumns().add(idColumn);

        TableColumn<Person, String> jobTitleColumn = new TableColumn<Person, String>("jobTitle");
        jobTitleColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("jobTitle"));
        tableView.getColumns().add(jobTitleColumn);

        TableColumn<Person, String> firstNameLastNameColumn = new TableColumn<Person, String>("firstNameLastName");
        firstNameLastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstNameLastName"));
        tableView.getColumns().add(firstNameLastNameColumn);

        TableColumn<Person, String> phoneColumn = new TableColumn<Person, String>("phone");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));
        tableView.getColumns().add(phoneColumn);

        TableColumn<Person, String> emailColumn = new TableColumn<Person, String>("email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
        tableView.getColumns().add(emailColumn);

        TableColumn<Person, String> numDomainsColumn = new TableColumn<Person, String>("numDomains");
        numDomainsColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("numDomains"));
        tableView.getColumns().add(numDomainsColumn);

        FlowPane root = new FlowPane(10, 10, tableView);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Persons Data");

        return scene;
    }

    @Override
    public void init() throws Exception {
        System.out.println("Called method init()");
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Called method stop()");
    }

    public static void main(String[] args) {
        launch(args);
    }

}

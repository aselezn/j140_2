package application.views;

import database.dto.PersonCountDomainsDto;
import database.queries.PersonQueries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.List;

public class PersonsView {

    public static Scene getPersonScene(Stage primaryStage) {

        List<PersonCountDomainsDto> persons = PersonQueries.getPersons();

        TableView<PersonCountDomainsDto> tableView = new TableView<>();
        tableView.setPrefWidth(780);
        tableView.setPrefHeight(600);

        ObservableList<PersonCountDomainsDto> data = FXCollections.observableArrayList(persons);
        tableView.setItems(data);

        TableColumn<PersonCountDomainsDto, Integer> idColumn = new TableColumn<>("id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableView.getColumns().add(idColumn);

        TableColumn<PersonCountDomainsDto, String> jobTitleColumn = new TableColumn<>("Job Title");
        jobTitleColumn.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
        tableView.getColumns().add(jobTitleColumn);

        TableColumn<PersonCountDomainsDto, String> firstNameLastNameColumn = new TableColumn<>("FirstName LastName");
        firstNameLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstNameLastName"));
        tableView.getColumns().add(firstNameLastNameColumn);

        TableColumn<PersonCountDomainsDto, String> phoneColumn = new TableColumn<>("Phone");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tableView.getColumns().add(phoneColumn);

        TableColumn<PersonCountDomainsDto, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableView.getColumns().add(emailColumn);

        TableColumn<PersonCountDomainsDto, String> numDomainsColumn = new TableColumn<>("Num domains");
        numDomainsColumn.setCellValueFactory(new PropertyValueFactory<>("numDomains"));
        tableView.getColumns().add(numDomainsColumn);

        tableView.setOnMouseClicked(mouseEvent -> handleTableClick(mouseEvent, tableView, primaryStage));

        FlowPane root = new FlowPane(10, 10, tableView);

        Scene scene = new Scene(root, 780, 600);

        primaryStage.setTitle("Persons Data");

        return scene;
    }

    private static void handleTableClick(MouseEvent mouseEvent, TableView<PersonCountDomainsDto> tableView, Stage primaryStage) {
        int countClicks = mouseEvent.getClickCount();

        if (countClicks == 2 && mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
            PersonCountDomainsDto person = tableView.getSelectionModel().getSelectedItem();
            if (person != null) {
                primaryStage.setScene(DomainView.getDomainsScene(person.getId(), primaryStage));
            }
        }
    }
}

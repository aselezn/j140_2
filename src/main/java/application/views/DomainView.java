package application.views;

import database.models.Domain;
import database.models.Person;
import database.queries.DomainQueries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.util.List;

public class DomainView {

    private Stage primaryStage;

    public static Scene getDomainsScene(Integer personId, Stage primaryStage) {

        List<Domain> domains = DomainQueries.getDomains(personId);

        TableView<Domain> tableView = new TableView<>();
        tableView.setPrefWidth(700);
        tableView.setPrefHeight(600);

        ObservableList<Domain> data = FXCollections.observableArrayList(domains);
        tableView.setItems(data);

        TableColumn<Domain, Integer> idColumn = new TableColumn<>("id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableView.getColumns().add(idColumn);

        TableColumn<Domain, String> webNameColumn = new TableColumn<>("webName");
        webNameColumn.setCellValueFactory(new PropertyValueFactory<>("webName"));
        tableView.getColumns().add(webNameColumn);

        TableColumn<Domain, String> domainNameColumn = new TableColumn<>("domainName");
        domainNameColumn.setCellValueFactory(new PropertyValueFactory<>("domainName"));
        tableView.getColumns().add(domainNameColumn);

        TableColumn<Domain, String> ipColumn = new TableColumn<>("ip");
        ipColumn.setCellValueFactory(new PropertyValueFactory<>("ip"));
        tableView.getColumns().add(ipColumn);

        TableColumn<Domain, LocalDateTime> dateRegColumn = new TableColumn<>("dateReg");
        dateRegColumn.setCellValueFactory(new PropertyValueFactory<>("dateReg"));
        tableView.getColumns().add(dateRegColumn);

        TableColumn<Domain, String> countryRegColumn = new TableColumn<>("countryReg");
        countryRegColumn.setCellValueFactory(new PropertyValueFactory<>("countryReg"));
        tableView.getColumns().add(countryRegColumn);

        TableColumn<Domain, Person> personColumn = new TableColumn<>("personId");
        personColumn.setCellValueFactory(new PropertyValueFactory<>("personId"));
        tableView.getColumns().add(personColumn);

        Button comeBackButton = new Button("Назад");
        comeBackButton.setOnAction(e -> primaryStage.setScene(PersonsView.getPersonScene(primaryStage)));

        VBox root = new VBox(10);

        root.getChildren().add(comeBackButton);
        root.getChildren().add(tableView);

        Scene scene = new Scene(root, 700, 600);

        primaryStage.setTitle("Persons Data");

        return scene;
    }

}

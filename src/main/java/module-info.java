module app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens DataBase.models;


    opens app to javafx.fxml;
    exports app;
}
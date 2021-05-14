module Etereo {
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires javafx.controls;
    opens Ui.employeeFx;
    opens mainLand;
}
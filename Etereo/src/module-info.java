module Etereo {
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires javafx.controls;
    opens Ui.employeeFx;
    opens Ui.occupationFx;
    opens Ui.expenseFx;
    opens Ui.configurationFx;
    opens Ui.financialFx;
    opens Ui.historyFinancial;
    opens image;
    opens mainLand;
    opens controller;
    opens model.bean;

}
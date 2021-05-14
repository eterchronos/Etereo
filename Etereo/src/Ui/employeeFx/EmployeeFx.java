package Ui.employeeFx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeFx extends Application {

    public void start(Stage primaryStage) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("employee.fxml"));

        primaryStage.setTitle("Gerenciador de Funcionarios");
        primaryStage.setScene(new Scene(pane, 600, 300));

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}

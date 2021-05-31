package Ui.employeeFx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeFx extends Application {

    public void start(Stage primaryStage) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("employee.fxml"));

        primaryStage.setTitle("Gerenciador de Funcionarios");
        primaryStage.setScene(new Scene(pane, 600, 384));
        primaryStage.setResizable(false);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}

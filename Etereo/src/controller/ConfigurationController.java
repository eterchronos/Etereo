package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mainLand.Main;
import model.DAO.ConfigurationDAO;
import model.bean.Configuration;


import java.net.URL;
import java.util.ResourceBundle;

public class ConfigurationController extends MainController implements Initializable {

    ConfigurationDAO configurationDAO = new ConfigurationDAO();


    @FXML
    private TextField jtfNameCompany;
    @FXML
    private Button saveConfiguration;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadNameCompany();
    }

    private void loadNameCompany(){
        jtfNameCompany.setText(configurationDAO.select());
    }

    @FXML
    public void saveConfiguration(ActionEvent actionEvent) {
        Configuration configuration = new Configuration();
        configuration.setCompanyName(jtfNameCompany.getText());
        configurationDAO.update(configuration);
        loadNameCompany();
        alertMessage();
    }

    private void alertMessage(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Configuração Salva");
        alert.setHeaderText("Nome da Empresa: "+jtfNameCompany.getText());
        alert.setContentText("Salvo com sucesso!");
        alert.show();
    }
}

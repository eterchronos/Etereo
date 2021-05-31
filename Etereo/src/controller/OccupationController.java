package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.DAO.OccupationDAO;
import model.bean.Occupation;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class OccupationController implements Initializable {
    @FXML
    private TableView<Occupation> table;
    @FXML
    private TableColumn<Occupation, String> tableOccupation;
    @FXML
    private TextField jtfOccupation;

    OccupationDAO                   occupationDAO = new OccupationDAO();
    List<Occupation>                occupationList = new ArrayList<>();
    ObservableList<Occupation>      observableList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      loadTable();
    }

    private void loadTable(){
        tableOccupation.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        occupationList.clear();
        for(Occupation getOccupation : occupationDAO.select()){
            Occupation occupation    = new Occupation();
            occupation.setCargo(getOccupation.getCargo());
            occupation.setId(getOccupation.getId());
            occupationList.add(occupation);
        }

        observableList = FXCollections.observableList(occupationList);
        table.setItems(observableList);

    }

    @FXML
    public void tableMouseClick(MouseEvent mouseEvent) {
        jtfOccupation.setText(table.getSelectionModel().getSelectedItem().getCargo());
    }
    @FXML
    public void InsertItemTableButton(ActionEvent actionEvent) {
        if(jtfOccupation.getText().isEmpty()  ){
            alertIfSelectionIsEmpty();
        }else {
            Occupation occupation = new Occupation();
            occupation.setCargo(jtfOccupation.getText());
            occupationDAO.insert(occupation);
            refreshTable();
        }
    }

    @FXML
    public void DeleteItemTableButton(ActionEvent actionEvent) {
        if(jtfOccupation.getText().isEmpty()  ){
            alertIfSelectionIsEmpty();
        }else {
            occupationDAO.statusChanger(table.getSelectionModel().getSelectedItem().getId(), 0);
            refreshTable();
        }
    }

    public void refreshTable(){
        loadTable();
        table.refresh();
        jtfOccupation.clear();
    }
    private void alertIfSelectionIsEmpty(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Atenção!");
        alert.setHeaderText("Nada selecionado.");
        alert.setContentText("Para que esta ação funcione primeiro selecione algum elemento na lista, ou preencha os campos necessários *.");
        alert.show();
    }
}

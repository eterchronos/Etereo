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
import model.DAO.ExpenseDAO;
import model.bean.Expense;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ExpenseController implements Initializable {
    @FXML
    private TableView<Expense> table;
    @FXML
    private TableColumn<Expense, String> tableName;
    @FXML
    private TableColumn<Expense, String> tableValue;
    @FXML
    private TableColumn<Expense, String> tableData;
    @FXML
    private TextField jtfExpense;
    @FXML
    private TextField jtfExpenseValue;

    List<Expense> expenseList = new ArrayList<>();
    ObservableList<Expense> observableList;
    ExpenseDAO expenseDAO = new ExpenseDAO();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    loadTable();
    }

   private void loadTable(){
            expenseList.clear();
        for(Expense getExpense : expenseDAO.select()){
            Expense expense = new Expense();
            expense.setId(getExpense.getId());
            expense.setExpenseName(getExpense.getExpenseName());
            expense.setValue(getExpense.getValue());
            expense.setDataOfCreation(getExpense.getDataOfCreation());
            expenseList.add(expense);
        }

        tableValue.setCellValueFactory(new PropertyValueFactory<>("value"));
        tableName.setCellValueFactory(new PropertyValueFactory<>("expenseName"));
        tableData.setCellValueFactory(new PropertyValueFactory<>("dataOfCreation"));
        observableList = FXCollections.observableList(expenseList);
        table.setItems(observableList);
   }

    public void addItemListExpense(ActionEvent actionEvent) {
        if(jtfExpense.getText().isEmpty() ||jtfExpenseValue.getText().isEmpty() ){
            alertIfSelectionIsEmpty();
        }else {
            expenseDAO.insert(jtfExpense.getText(), Double.parseDouble(jtfExpenseValue.getText()));
            refreshTable();
        }
    }

    public void RemoveItemListExpense(ActionEvent actionEvent) {
        if(jtfExpense.getText().isEmpty() ||jtfExpenseValue.getText().isEmpty() ){
            alertIfSelectionIsEmpty();
        }else {
            expenseDAO.statusChanger(table.getSelectionModel().getSelectedItem().getId(), 0);
            refreshTable();
        }
    }

    public void tableItemClick(MouseEvent mouseEvent) {
        jtfExpense.setText(table.getSelectionModel().getSelectedItem().getExpenseName());
        jtfExpenseValue.setText(String.valueOf(table.getSelectionModel().getSelectedItem().getValue()));
    }
    private void refreshTable(){
        loadTable();
        table.refresh();
        jtfExpenseValue.clear();
        jtfExpense.clear();
    }
    private void alertIfSelectionIsEmpty(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Atenção!");
        alert.setHeaderText("Nada selecionado.");
        alert.setContentText("Para que esta ação funcione primeiro selecione algum elemento na lista, ou preencha os campos necessários *.");
        alert.show();
    }


}

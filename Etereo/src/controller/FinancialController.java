package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DAO.EmployeeDAO;
import model.DAO.ExpenseDAO;
import model.DAO.FinancialDAO;
import model.bean.Employee;
import model.bean.Financial;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FinancialController implements Initializable {

    FinancialDAO    financialDAO    = new FinancialDAO();
    ExpenseDAO      expenseDAO      = new ExpenseDAO();
    EmployeeDAO     employeeDAO     = new EmployeeDAO();

    Financial financial = new Financial();

    Alert alert = new Alert(Alert.AlertType.WARNING,"Você precisa inserir um valor.");

    @FXML
    private Label lblCredit;
    @FXML
    private Label lblExpenseLarge;
    @FXML
    private Label lblEmployeeLarge;
    @FXML
    private TextField jtfAddRemoveCash;
    @FXML
    private Button btnAddCash;
    @FXML
    private Button btnRemoveCash;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadLabelCreditDebit();
    }

    private void loadLabelCreditDebit(){
        lblCredit.setText(financialDAO.select().toString());
        lblExpenseLarge.setText(expenseDAO.getTotalExpense().toString());
        lblEmployeeLarge.setText(employeeDAO.getTotalEmployeeSalary().toString());
    }

    @FXML
    public void addCash(ActionEvent actionEvent) {
        if(jtfAddRemoveCash.getText().isEmpty()){
            alert.show();
        }else {
            financial.setCash(Double.valueOf(jtfAddRemoveCash.getText()));
            financialDAO.insert(financial);
            jtfAddRemoveCash.clear();
            loadLabelCreditDebit();
        }
    }
    @FXML
    public void removeCash(ActionEvent actionEvent) {
        if(jtfAddRemoveCash.getText().isEmpty()){
            alert.show();
        }else {
            financial.setCash(Double.valueOf(jtfAddRemoveCash.getText()));
            financialDAO.delete(financial);
            jtfAddRemoveCash.clear();
            loadLabelCreditDebit();
        }
    }
    @FXML
    public void openHistoryWindow(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Ui/historyFinancial/historyFinancial.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Historico de caixa");
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.setScene(new Scene(root));
        stage.show();
    }
}

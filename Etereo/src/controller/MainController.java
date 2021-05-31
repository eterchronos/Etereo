package controller;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mainLand.Main;
import model.DAO.*;


import java.io.IOException;
import java.net.URL;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Currency;
import java.util.ResourceBundle;


public class MainController implements Initializable {

   Main main = new Main();

   private ConfigurationDAO     configurationDAO        = new ConfigurationDAO();
   private FinancialDAO         financialDAO            = new FinancialDAO();
   private ConnectionFactory    connectionFactory       = new ConnectionFactory();
   private EmployeeDAO          employeeDAO             = new EmployeeDAO();
   private ExpenseDAO           expenseDAO              = new ExpenseDAO();

    @FXML
    private Label lblCompanyName;
    @FXML
    private Label lblCashValue;
    @FXML
    private ImageView imageViewLogo;
    @FXML
    private Label lblServerStatus;
    @FXML
    private Button btnEmployee;
    @FXML
    private Button btnOccupation;
    @FXML
    private Button btnExpense;
    @FXML
    private Button btnFinancial;
    @FXML
    private Button btnOptions;
    @FXML
    private Label lblEmployeeAmountByHour;
    @FXML
    private Label lblEmployeeAmountByDay;
    @FXML
    private Label lblEmployeeAmountByMonth;
    @FXML
    private Label lblEmployeeAmountByYear;
    @FXML
    private Label lblEmployeeAmountByWeak;
    @FXML
    private Label lblExpenseAmountByHour;
    @FXML
    private Label lblExpenseAmountByDay;
    @FXML
    private Label lblExpenseAmountByMonth;
    @FXML
    private Label lblExpenseAmountByYear;
    @FXML
    private Label lblExpenseAmountByWeak;

    private Image getImageFile = new Image(getClass().getResourceAsStream("/image/company.png"));



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String nome = "lucas";

        if(connectionFactory.getConnectionStatus()){
            loadResumeOfDashboard();
            loadCompanyNameDashboard();
            lblServerStatus.setText("Online.");
        }else{
            lblServerStatus.setText("Offline.");
        }


    }

    @FXML
    public void openEmployeeManager(ActionEvent actionEvent) {
        try {
            Parent pane = FXMLLoader.load(getClass().getResource("/Ui/employeeFx/employee.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Gerenciador de Funcionarios");
            stage.initStyle(StageStyle.DECORATED);
            stage.setScene(new Scene(pane, 600, 384));
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
            stage.show();

            System.out.println("Employee Opened");
        }catch(IOException e){
            System.out.println("Erro Window   "+e);
        }
    }
    @FXML
    public void openOccupationManager(ActionEvent actionEvent) {
        try {
            Parent pane = FXMLLoader.load(getClass().getResource("/Ui/occupationFx/occupation.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Gerenciador de Cargos");
            stage.initStyle(StageStyle.DECORATED);
            stage.setScene(new Scene(pane, 309, 471));
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
            stage.show();

            System.out.println("Occupation Opened");
        }catch(IOException e){
            System.out.println("Erro Window   "+e);
        }
    }
    @FXML
    public void openExpenseManager(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Ui/expenseFx/expense.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Gerenciador de despesas");
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
            stage.setScene(new Scene(root, 620, 508));
            stage.show();

            System.out.println("Expense Opened");
        }catch(IOException e){
            System.out.println("Erro Window   "+e);
        }
    }


    public void openCashManager(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Ui/financialFx/financial.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Caixa");
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void openConfiguration(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Ui/configurationFx/configuration.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Configuração");
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();


        }

    private void loadCompanyNameDashboard(){
        btnEmployee.setDisable(false);
        btnOccupation.setDisable(false);
        btnExpense.setDisable(false);
        btnFinancial.setDisable(false);
        btnOptions.setDisable(false);
        lblCompanyName.setText(configurationDAO.select());
        lblCashValue.setText(financialDAO.select().toString());
        imageViewLogo.setImage(getImageFile);
    }

    private void loadResumeOfDashboard(){
        NumberFormat format = NumberFormat.getCurrencyInstance();
        //format values of employee
        String hourEmployee = format.format(employeeDAO.getTotalEmployeeSalaryByHour());
        String dayEmployee = format.format(employeeDAO.getTotalEmployeeSalaryByDay());
        String weakEmployee = format.format(employeeDAO.getTotalEmployeeSalaryByWeak());
        String monhEmployee = format.format(employeeDAO.getTotalEmployeeSalaryByMounth());
        String yearEmployee = format.format(employeeDAO.getTotalEmployeeSalaryByYear());

        lblEmployeeAmountByHour.setText ("Hora     "+hourEmployee);
        lblEmployeeAmountByDay.setText  ("Dia      "+dayEmployee);
        lblEmployeeAmountByWeak.setText ("Semana   "+weakEmployee);
        lblEmployeeAmountByMonth.setText("Mês      "+monhEmployee);
        lblEmployeeAmountByYear.setText ("Ano      "+yearEmployee);

        //format values of expense
        String hourExpense = format.format(expenseDAO.getTotalExpenseByHour());
        String dayExpense  = format.format(expenseDAO.getTotalExpenseByDay());
        String weakExpense  = format.format(expenseDAO.getTotalExpenseByWeak());
        String monthExpense  = format.format(expenseDAO.getTotalExpenseByMonth());
        String yearExpense  = format.format(expenseDAO.getTotalExpenseByYear());

        lblExpenseAmountByHour.setText ("Hora     "+hourExpense);
        lblExpenseAmountByDay.setText  ("Dia      "+dayExpense);
        lblExpenseAmountByWeak.setText ("Semana   "+weakExpense);
        lblExpenseAmountByMonth.setText("Mês      "+monthExpense);
        lblExpenseAmountByYear.setText ("Ano      "+yearExpense);
    }

}




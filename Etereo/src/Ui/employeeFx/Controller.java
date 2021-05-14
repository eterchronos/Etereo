package Ui.employeeFx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import model.DAO.EmployeeDAO;
import model.DAO.OccupationDAO;
import model.bean.Employee;
import model.bean.Occupation;

import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TableView<Employee> tableEmployee;
    @FXML
    private TableColumn<Employee, String> tableName;
    @FXML
    private TableColumn<Employee, Integer> tableYear;
    @FXML
    private TableColumn<Employee, Double> tableSalary;
    @FXML
    private TableColumn<Employee, String> tableOccupation;
    @FXML
    private TableColumn<Employee, String> tableData;
    @FXML
    private TableColumn<Employee, Integer> tableId;
    @FXML
    Occupation occupation = new Occupation();
    @FXML
    private ComboBox<String> cbOccupation;

    private final List<String> listOccupation = new ArrayList<>();
    private final List<Integer> idListOccupation = new ArrayList<>();
    private ObservableList<String> obsOccupation;
    private List<Employee> listEmployee = new ArrayList<>();
    private ObservableList<Employee> obsEmployeeList;
    private int idOfComboBoxItem;

    public Controller() throws SQLException {
    }


    public void deleteEmployee(ActionEvent actionEvent) {
    }

    public void insertEmployee(ActionEvent actionEvent) {
    }

    public void updateEmployee(ActionEvent actionEvent) {
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadComboBox();
        loadTableView();
    }

    private void loadComboBox() {
        OccupationDAO occupationDAO = new OccupationDAO();
        occupationDAO.select();
        for (Occupation occupationTable : occupationDAO.select()) {
            listOccupation.add(occupationTable.getCargo());
            idListOccupation.add(occupationTable.getId());
        }

        obsOccupation = FXCollections.observableArrayList(listOccupation);
        cbOccupation.setItems(obsOccupation);
    }


    public void getItemCombo(ActionEvent actionEvent) {
        this.idOfComboBoxItem = idListOccupation.get(cbOccupation.getSelectionModel().getSelectedIndex());
    }

    public void loadTableView(){
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = new Employee();

        for(Employee getEmployee : employeeDAO.select()){

           employee.setNome(getEmployee.getNome());
           employee.setIdade(getEmployee.getIdade());
           employee.setSalario(getEmployee.getSalario());
           employee.setCargo_key(getEmployee.getCargo_key());
           employee.setData(getEmployee.getData());
           employee.setIdade(getEmployee.getId());
           listEmployee.add(employee);

            tableName.setCellValueFactory(new PropertyValueFactory<>("nome"));
            tableYear.setCellValueFactory(new PropertyValueFactory<>("idade"));
            tableSalary.setCellValueFactory(new PropertyValueFactory<>("salario"));
            tableOccupation.setCellValueFactory(new PropertyValueFactory<>("cargo_key"));
            tableData.setCellValueFactory(new PropertyValueFactory<>("data"));
            tableId.setCellValueFactory(new PropertyValueFactory<>("id"));
       }


        obsEmployeeList = FXCollections.observableArrayList(listEmployee);
        tableEmployee.setItems(obsEmployeeList);
    }
}

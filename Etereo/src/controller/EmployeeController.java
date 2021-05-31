package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.DAO.EmployeeDAO;
import model.DAO.OccupationDAO;
import model.bean.Employee;
import model.bean.Occupation;


import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {

    @FXML
    private TextField jtfName;
    @FXML
    private TextField jtfYear;
    @FXML
    private TextField jtfSalary;
    @FXML
    private TextArea  jtfExtra;
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
    private ComboBox<Occupation> cbOccupation;

    private EmployeeDAO                     employeeDAO = new EmployeeDAO();
    private Occupation                      occupation = new Occupation();
    private int                             idItemClickedTable;

    private final List<Occupation>          listOccupation = new ArrayList<>();
    private final List<Integer>             idListOccupation = new ArrayList<>();
    private ObservableList<Occupation>      obsOccupation;
    private List<Employee>                  listEmployee = new ArrayList<>();
    private ObservableList<Employee>        obsEmployeeList;
    //private int idOfComboBoxItem;

    OccupationDAO occupationDAO = new OccupationDAO();

    public EmployeeController() throws SQLException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadComboBox();
        loadTableView();

    }
    //Method to delete an item.
    @FXML
    public void deleteEmployee(ActionEvent actionEvent) {
        if(jtfName.getText().isEmpty() ||jtfSalary.getText().isEmpty() || jtfYear.getText().isEmpty()){
            alertIfSelectionIsEmpty();
        }else {
            Employee employee = tableEmployee.getSelectionModel().getSelectedItem();
            employeeDAO.statusChanger(employee.getId(), 0);
            refrashTable();
        }
    }
    //Method to insert an item.
    @FXML
    public void insertEmployee(ActionEvent actionEvent) {
        if(jtfName.getText().isEmpty() ||jtfSalary.getText().isEmpty() || jtfYear.getText().isEmpty()){
            alertIfSelectionIsEmpty();
        }else {
            Employee employee = new Employee();
            Occupation occupation = cbOccupation.getSelectionModel().getSelectedItem();
            employee.setNome(jtfName.getText());
            employee.setCargo(occupation.getId());
            employee.setIdade(Integer.valueOf(jtfYear.getText()));
            employee.setSalario(Double.valueOf(jtfSalary.getText()));
            employee.setExtra(jtfExtra.getText());
            employeeDAO.insert(employee);
            refrashTable();
        }
    }
    //Method to update an item.
    @FXML
    public void updateEmployee(ActionEvent actionEvent) {
        if(jtfName.getText().isEmpty() ||jtfSalary.getText().isEmpty() || jtfYear.getText().isEmpty()){
            alertIfSelectionIsEmpty();
        }else {
            Employee employeeUpdate = new Employee();
            Occupation occupation = cbOccupation.getSelectionModel().getSelectedItem();

            employeeUpdate.setId(idItemClickedTable);
            employeeUpdate.setNome(jtfName.getText());
            employeeUpdate.setCargo(occupation.getId());
            employeeUpdate.setIdade(Integer.valueOf(jtfYear.getText()));
            employeeUpdate.setSalario(Double.valueOf(jtfSalary.getText()));
            employeeUpdate.setExtra(jtfExtra.getText());
            employeeDAO.update(employeeUpdate);

            refrashTable();
        }
    }
    //Populate comboBox.
    private void loadComboBox() {

        occupationDAO.select();
        for (Occupation occupationTable : occupationDAO.select()) {
            listOccupation.add(occupationTable);
            idListOccupation.add(occupationTable.getId());
        }

        obsOccupation = FXCollections.observableArrayList(listOccupation);
        cbOccupation.setItems(obsOccupation);
    }
    //Poplate tableView.
    public void loadTableView(){
        listEmployee.clear();
        for(Employee getEmployee : employeeDAO.select()){
            Employee employee = new Employee();
           employee.setNome(getEmployee.getNome());
           employee.setIdade(getEmployee.getIdade());
           employee.setSalario(getEmployee.getSalario());
           employee.setCargo_key(getEmployee.getCargo_key());
           employee.setCargo(getEmployee.getCargo());
           employee.setData(getEmployee.getData());
           employee.setIdade(getEmployee.getIdade());
           employee.setId(getEmployee.getId());
           employee.setExtra(getEmployee.getExtra());
           listEmployee.add(employee);

       }

        tableName.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableYear.setCellValueFactory(new PropertyValueFactory<>("idade"));
        tableSalary.setCellValueFactory(new PropertyValueFactory<>("salario"));
        tableOccupation.setCellValueFactory(new PropertyValueFactory<>("cargo_key"));
        tableData.setCellValueFactory(new PropertyValueFactory<>("data"));

        obsEmployeeList = FXCollections.observableArrayList(listEmployee);
        tableEmployee.setItems(obsEmployeeList);

    }
    //Listener of tableView.
    @FXML
    public void tableItemClicked(MouseEvent mouseEvent) {
        Employee employee = tableEmployee.getSelectionModel().getSelectedItem();
        jtfName.setText(employee.getNome());
        jtfYear.setText(String.valueOf(employee.getIdade()));
        jtfSalary.setText(String.valueOf(employee.getSalario()));
        jtfExtra.setText(employee.getExtra());
        idItemClickedTable = employee.getId();
        Employee i = tableEmployee.getSelectionModel().getSelectedItem();
        //cbOccupation.getSelectionModel().select(i.getCargo_key()); //arrumar esta linha.
       // idOfComboBoxItem = tableEmployee.getSelectionModel().getSelectedItem().getCargo();
        System.out.println(i);

    }
    //After click any action here refrash components and refrash lists.
    private void refrashTable(){
        loadTableView();
        tableEmployee.refresh();
        cbOccupation.getSelectionModel().select(-1);
        jtfName.clear();
        jtfExtra.clear();
        jtfSalary.clear();
        jtfYear.clear();
    }
    //If will appear in case of empty elements.
    private void alertIfSelectionIsEmpty(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Atenção!");
        alert.setHeaderText("Nada selecionado.");
        alert.setContentText("Para que esta ação funcione primeiro selecione algum elemento na lista, ou preencha os campos necessários *.");
        alert.show();
    }
}


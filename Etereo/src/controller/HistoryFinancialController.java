package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DAO.FinancialDAO;
import model.bean.Financial;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HistoryFinancialController implements Initializable {

    @FXML
    private TableView<Financial> tableViewHistory;
    @FXML
    private TableColumn<Financial, String> tableCredit;
    @FXML
    private TableColumn<Financial, String> tableDebit;
    @FXML
    private TableColumn<Financial, String> tableData;

    private List<Financial> listOfContent = new ArrayList<>();
    private ObservableList<Financial> observableList;

    private FinancialDAO financialDAO = new FinancialDAO();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAllContents();
    }

    private void loadAllContents(){
        System.out.println(financialDAO.selectAllContents());
        for(Financial getFinancial : financialDAO.selectAllContents()){
            Financial financial = new Financial();
            financial.setCash(getFinancial.getCash());
            financial.setDebit(getFinancial.getDebit());
            financial.setData(getFinancial.getData());
            listOfContent.add(financial);
        }

        tableCredit.setCellValueFactory(new PropertyValueFactory<>("cash"));
        tableDebit.setCellValueFactory(new PropertyValueFactory<>("debit"));
        tableData.setCellValueFactory(new PropertyValueFactory<>("data"));

        observableList = FXCollections.observableList(listOfContent);
        tableViewHistory.setItems(observableList);


    }}

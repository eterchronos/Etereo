package test;

import Ui.EmployeeUi;
import model.DAO.EmployeeDAO;
import model.bean.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee e = new Employee();
		EmployeeDAO eDAO = new EmployeeDAO();
		EmployeeUi eUi = new EmployeeUi();
		eUi.windowUi();
	}

}

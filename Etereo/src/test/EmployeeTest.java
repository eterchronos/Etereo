package test;

import model.DAO.EmployeeDAO;
import model.bean.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee e = new Employee();
		EmployeeDAO eDAO = new EmployeeDAO();

		System.out.println("Employee Salary ->"+eDAO.getTotalEmployeeSalary());
		System.out.println("Employee Count -> "+eDAO.getTotalEmployee());
		System.out.println(eDAO.getTotalEmployeeSalaryByMounth());
	}

}

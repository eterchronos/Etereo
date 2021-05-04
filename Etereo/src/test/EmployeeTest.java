package test;

import model.DAO.EmployeeDAO;
import model.bean.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee e = new Employee();
		EmployeeDAO eDAO = new EmployeeDAO();
		e.setEmpresa(1);
		e.setNome("Paulo");
		e.setCargo("Malabarista");
		e.setSalario(900);
		e.setId(12);
		
		eDAO.update(e);
		
	}

}

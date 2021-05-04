package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.Employee;

public class EmployeeDAO {
	
	private Connection connection;
	
	public EmployeeDAO() {
		try {
			
			final String DATABASE_URL = "jdbc:mysql://localhost:3306/circos";
			String usr = "root";
			String pw = "123";
			this.connection = DriverManager.getConnection(DATABASE_URL,usr,pw);
			System.out.println("Sql Connected.");			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public List<Employee> select(){
		String sql = "SELECT * FROM funcionarios";
		List<Employee>listEmployee = new ArrayList<Employee>();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet setResult = stmt.executeQuery();
			while(setResult.next()) {
				Employee employee = new Employee();
				employee.setId(setResult.getInt("id"));
				employee.setEmpresa(setResult.getInt("empresa_id"));
				employee.setNome(setResult.getString("nome"));
				employee.setStatus(setResult.getInt("status"));
				employee.setIdade(setResult.getInt("idade"));
				employee.setSalario(setResult.getDouble("salario"));
				listEmployee.add(employee);
			}
		
		}catch(Exception e) {
			System.out.println(e);}
		return listEmployee;
	}
	
	public boolean insert(Employee employee) {
		String sql = "INSERT INTO `funcionarios`(`empresa_id`,`cargo_cargo`,`nome`,`status`,`idade`,`salario`) VALUES(?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, employee.getEmpresa());
			stmt.setString(2, employee.getCargo());
			stmt.setString(3, employee.getNome());
			stmt.setInt(4, employee.getStatus());
			stmt.setInt(5, employee.getIdade());
			stmt.setDouble(6, employee.getSalario());
			stmt.execute();
			System.out.println("person added.");
			return true;
		}catch(Exception e) {
			System.out.println(e);}
		return false;
	}
	
	public boolean statusChanger(int id, int status) {
		String sql="UPDATE `funcionarios` SET `status`=? WHERE `id`=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, status);
			stmt.setInt(2, id);
			stmt.execute();
			System.out.println("status of: "+id+" changed to: "+status);
			return true;
		}catch(Exception e) {
			System.out.println(e);}
		return false;
	}
	
	public boolean update(Employee employee) {
		String sql ="UPDATE `funcionarios` SET `empresa_id`=?,`cargo_cargo`=?,`nome`=?,`idade`=?,`salario`=? WHERE `id`=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, employee.getEmpresa());
			stmt.setString(2, employee.getCargo());
			stmt.setString(3, employee.getNome());
			stmt.setInt(4, employee.getIdade());
			stmt.setDouble(5, employee.getSalario());
			stmt.setInt(6, employee.getId());
			stmt.execute();
			return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

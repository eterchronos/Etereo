package model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.bean.Employee;

public class EmployeeDAO {
	

	private ConnectionFactory connectionFactory = new ConnectionFactory();
	Employee employee = new Employee();

	
	public List<Employee> select(){
		String sql = "SELECT * FROM funcionarios as f INNER JOIN cargo ON f.cargo_cargo = cargo.id WHERE f.status=1";
		List<Employee>listEmployee = new ArrayList<Employee>();
		
		try {
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			ResultSet setResult = stmt.executeQuery();
			while(setResult.next()) {
				Employee employee = new Employee();
				employee.setId(setResult.getInt("id"));
				employee.setCargo(setResult.getInt("cargo_cargo"));
			    employee.setCargo_key(setResult.getString("cargo"));
				employee.setNome(setResult.getString("nome"));
				employee.setStatus(setResult.getInt("status"));
				employee.setIdade(setResult.getInt("idade"));
				employee.setSalario(setResult.getDouble("salario"));
				employee.setData(setResult.getString("dataCriacao"));
				employee.setExtra(setResult.getString("funcaoExtra"));
				listEmployee.add(employee);
			}
		
		}catch(Exception e) {
			System.out.println(e);}
		return listEmployee;
	}
	
	public boolean insert(Employee employee) {
		String sql = "INSERT INTO `funcionarios`(`cargo_cargo`,`nome`,`idade`,`salario`,`funcaoExtra`) VALUES(?,?,?,?,?)";
		
		try {
			
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
		
			stmt.setInt(1, employee.getCargo());
			stmt.setString(2, employee.getNome());
			stmt.setInt(3, employee.getIdade());
			stmt.setDouble(4, employee.getSalario());
			stmt.setString(5,employee.getExtra());

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
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
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
		String sql ="UPDATE `funcionarios` SET `cargo_cargo`=?,`nome`=?,`idade`=?,`salario`=?,`funcaoExtra`=? WHERE `id`=?";
		
		try {
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			stmt.setInt(1, employee.getCargo());
			stmt.setString(2, employee.getNome());
			stmt.setInt(3, employee.getIdade());
			stmt.setDouble(4, employee.getSalario());
			stmt.setString(5,employee.getExtra());
			stmt.setInt(6, employee.getId());

			stmt.execute();
			System.out.println("status of: "+employee.getNome()+" Updated: ");
			return true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public Double getTotalEmployeeSalary(){
		String sql = "SELECT SUM(salario) AS totalEmDinheiro FROM funcionarios";

		try {
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			ResultSet setResult = stmt.executeQuery();
			while(setResult.next()){
				employee.setSalario(setResult.getDouble("totalEmDinheiro"));
				return employee.getSalario();
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return employee.getSalario();
	}
	public Double getTotalEmployeeSalaryByYear(){
		String sql = "SELECT SUM(salario) *12 AS totalEmDinheiroMes FROM funcionarios";

		try {
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			ResultSet setResult = stmt.executeQuery();
			while(setResult.next()){
				employee.setSalario(setResult.getDouble("totalEmDinheiroMes"));
				return employee.getSalario();
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return employee.getSalario();
	}

	public Double getTotalEmployeeSalaryByMounth(){
		String sql = "SELECT SUM(salario) AS totalEmDinheiroMes FROM funcionarios";

		try {
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			ResultSet setResult = stmt.executeQuery();
			while(setResult.next()){
				employee.setSalario(setResult.getDouble("totalEmDinheiroMes"));
				return employee.getSalario();
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return employee.getSalario();
	}

	public Double getTotalEmployeeSalaryByWeak(){
		String sql = "SELECT SUM(salario) /4 AS totalEmDinheiroSemana FROM funcionarios";

		try {
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			ResultSet setResult = stmt.executeQuery();
			while(setResult.next()){
				employee.setSalario(setResult.getDouble("totalEmDinheiroSemana"));
				return employee.getSalario();
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return employee.getSalario();
	}

	public Double getTotalEmployeeSalaryByHour(){
		String sql = "SELECT SUM(salario) /30/24 AS totalEmDinheiroHoras FROM funcionarios";

		try {
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			ResultSet setResult = stmt.executeQuery();
			while(setResult.next()){
				employee.setSalario(setResult.getDouble("totalEmDinheiroHoras"));
				return employee.getSalario();
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return employee.getSalario();
	}

	public Double getTotalEmployeeSalaryByDay(){
		String sql = "SELECT SUM(salario) /30 AS totalEmDinheiroDia FROM funcionarios";

		try {
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			ResultSet setResult = stmt.executeQuery();
			while(setResult.next()){
				employee.setSalario(setResult.getDouble("totalEmDinheiroDia"));
				return employee.getSalario();
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return employee.getSalario();
	}
	
	public int getTotalEmployee(){
		String sql = "SELECT COUNT(nome) AS totalEmFuncionarios FROM funcionarios";

		try {
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			ResultSet setResult = stmt.executeQuery();
			while(setResult.next()){
				employee.setAmountEmployee(setResult.getInt("totalEmFuncionarios"));
				return employee.getAmountEmployee();
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
			return employee.getAmountEmployee();
	}
	
	
	
	
	
	
	
	

}

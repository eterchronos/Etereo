package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Expense;
import model.DAO.ConnectionFactory;

public class ExpenseDAO {

	
	ConnectionFactory connectionFactory = new ConnectionFactory();
	Expense expense = new Expense();

	public ExpenseDAO() {
	
		
	}
			
		
	
	public List<Expense> select(){
			String url="SELECT * FROM despesa WHERE status=1";
			List<Expense> listExpenseItems =new  ArrayList<Expense>();
			try {
				PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(url);
				ResultSet resultExpense = stmt.executeQuery();
				while(resultExpense.next()) {
					Expense expense = new Expense();
					expense.setId(resultExpense.getInt("id"));
					expense.setExpenseName(resultExpense.getString("despesa"));
					expense.setStatus(resultExpense.getInt("status"));
					expense.setValue(resultExpense.getDouble("valor"));
					expense.setDataOfCreation(resultExpense.getString("data_presente"));
					listExpenseItems.add(expense);
				}
				
			}catch(Exception e) {System.out.println(e);}
			
			return listExpenseItems;
	}
	public boolean insert(String expenseName,double value) {
		String url ="INSERT INTO `despesa`(`despesa`, `valor`) VALUES (?,?)";
		try {
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(url);
			stmt.setString(1, expenseName);
			stmt.setDouble(2, value);
			stmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean statusChanger(int id, int status) {
		String sql="UPDATE `despesa` SET `status`=? WHERE `id`=?";
		try {
		PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
		stmt.setInt(1, status);
		stmt.setInt(2, id);
		stmt.execute();
		System.out.println("status of: "+id+" changed to: "+status);
		return true;
		}catch(SQLException e) {System.out.println(e);}
		return false;
	}
	public boolean update(Expense expense) {
		String sql="UPDATE `despesa` SET `despesa`=?,`valor`=? WHERE `id`=?";
		try {
		PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);	
		stmt.setString(1, expense.getExpenseName());
		stmt.setDouble(2, expense.getValue());
		stmt.setInt(3, expense.getId());
		stmt.execute();
		return true;
		}catch(SQLException e) {System.out.println(e);}
		return false;
	}
	
	public Double getTotalExpense(){
		String sql = "SELECT SUM(valor) AS totalEmDespesa FROM despesa";

		try {
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			ResultSet setResult = stmt.executeQuery();
			while(setResult.next()){
				expense.setValue(setResult.getDouble("totalEmDespesa"));
				return expense.getValue();
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return expense.getValue();
	}

	public Double getTotalExpenseByDay(){
		String sql = "SELECT SUM(valor) /30 AS totalEmDespesa FROM despesa";

		try {
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			ResultSet setResult = stmt.executeQuery();
			while(setResult.next()){
				expense.setValue(setResult.getDouble("totalEmDespesa"));
				return expense.getValue();
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return expense.getValue();
	}

	public Double getTotalExpenseByWeak(){
		String sql = "SELECT SUM(valor) /4 AS totalEmDespesa FROM despesa";

		try {
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			ResultSet setResult = stmt.executeQuery();
			while(setResult.next()){
				expense.setValue(setResult.getDouble("totalEmDespesa"));
				return expense.getValue();
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return expense.getValue();
	}

	public Double getTotalExpenseByMonth(){
		String sql = "SELECT SUM(valor) AS totalEmDespesa FROM despesa";

		try {
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			ResultSet setResult = stmt.executeQuery();
			while(setResult.next()){
				expense.setValue(setResult.getDouble("totalEmDespesa"));
				return expense.getValue();
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return expense.getValue();
	}


	public Double getTotalExpenseByHour(){
		String sql = "SELECT SUM(valor) /30/24 AS totalEmDespesa FROM despesa";

		try {
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			ResultSet setResult = stmt.executeQuery();
			while(setResult.next()){
				expense.setValue(setResult.getDouble("totalEmDespesa"));
				return expense.getValue();
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return expense.getValue();
	}

	public Double getTotalExpenseByYear(){
		String sql = "SELECT SUM(valor) *12 AS totalEmDespesa FROM despesa";

		try {
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			ResultSet setResult = stmt.executeQuery();
			while(setResult.next()){
				expense.setValue(setResult.getDouble("totalEmDespesa"));
				return expense.getValue();
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return expense.getValue();
	}
	
	
	
	
	
	
	
}

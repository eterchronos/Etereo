package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Company;;

public class CompanyDAO {

	private Connection connection;
	
	public CompanyDAO() {
		try {
		final String DATABASE_URL = "jdbc:mysql://localhost:3306/circos";
		String usr = "root";
		String pw="123";
		this.connection = DriverManager.getConnection(DATABASE_URL,usr,pw);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public List<Company> select(){
		String sql = "SELECT * FROM empresa WHERE status=1";
		List<Company>listCompany =new ArrayList<Company>();
		
		try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet setResult = stmt.executeQuery();
		while(setResult.next()) {
			Company company = new Company();
			company.setRazaoSocial(setResult.getString("razao_social"));
			company.setCidade(setResult.getString("cidade"));
			company.setUf(setResult.getString("uf"));
			company.setId(setResult.getInt("id"));
			listCompany.add(company);
		}
		}catch(SQLException e) {
			System.out.println(e);
		}
		return listCompany;
	}

	public boolean insert(String razaoSocial,String cidade,String uf) {
		String sql = "INSERT INTO `empresa`(`razao_social`,`cidade`,`uf`) VALUES(?,?,?)";
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, razaoSocial);
			stmt.setString(2, cidade);
			stmt.setString(3, uf);
			stmt.execute();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public boolean statusChanger(int id, int status) {
		String sql = "UPDATE `empresa` SET `status`=? WHERE `id`=?";
		 try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, status);
			stmt.setInt(2, id);
			stmt.execute();
			System.out.println("status of: "+id+" changed to: "+status);
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		 return false;
	}
	
	public boolean update(Company company) {
		String sql ="UPDATE `empresa` SET `razao_social`=?,`cidade`=?,`uf`=? WHERE `id`=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, company.getRazaoSocial());
			stmt.setString(2, company.getCidade());
			stmt.setString(3, company.getUf());
			stmt.setInt(4, company.getId());
			stmt.execute();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	
	
	
	
	
	
}

package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.Occupation;

public class OccupationDAO {

	private Connection connection;
	ConnectionFactory connectionFactory = new ConnectionFactory();

	public OccupationDAO() {
		
	}
	public List<Occupation> select(){
		String sql="SELECT * FROM cargo WHERE status=1";
		List<Occupation>occupationList = new ArrayList<Occupation>();
		try {
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			ResultSet setResult = stmt.executeQuery();
			while(setResult.next()) {
				Occupation occupation = new Occupation();
				occupation.setId(setResult.getInt("id"));
				occupation.setCargo(setResult.getString("cargo"));
				occupationList.add(occupation);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return occupationList;
	}
	public boolean insert(Occupation cargo) {
		String sql= "INSERT INTO `cargo`(`cargo`) VALUES (?)";
		try {
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			stmt.setString(1, cargo.getCargo());
			stmt.execute();
			System.out.println("person added.");
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public boolean statusChanger(int id,int status) {
		String sql="UPDATE `cargo` SET `status`=? WHERE `id`=?";
		try {
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
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
	
	public boolean update(Occupation occupation) {
		String sql="UPDATE `cargo` SET `cargo`=? WHERE `id`=?";
		try {
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			stmt.setString(1, occupation.getCargo());
			stmt.setInt(2, occupation.getId());
			stmt.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

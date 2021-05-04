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
	
	public OccupationDAO() {
		try {
			final String DATABASE_URL = "jdbc:mysql://localhost:3306/circos";
			String usr ="root";
			String pw = "123";
			this.connection = DriverManager.getConnection(DATABASE_URL,usr,pw);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public List<Occupation> select(){
		String sql="SELECT * FROM cargo";
		List<Occupation>occupationList = new ArrayList<Occupation>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet setResult = stmt.executeQuery();
			while(setResult.next()) {
				Occupation occupation = new Occupation();
				occupation.setCargo(setResult.getString("cargo"));
				occupationList.add(occupation);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return occupationList;
	}
	public boolean insert(String cargo) {
		String sql= "INSERT INTO `cargo`(`cargo`) VALUES (?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cargo);
			stmt.execute();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public boolean statusChanger(int id,int status) {
		String sql="UPDATE `cargo` SET `status`=? WHERE `id`=?";
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
	
	public boolean update(Occupation occupation) {
		String sql="UPDATE `cargo` SET `cargo`=? WHERE `id`=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, occupation.getCargo());
			stmt.setInt(2, occupation.getId());
			stmt.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

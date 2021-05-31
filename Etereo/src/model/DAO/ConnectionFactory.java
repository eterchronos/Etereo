package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private Connection connection;
	
	public ConnectionFactory() {
		connectToDb();
	}
	
	public Connection getConnection() {
		return connection;
	}

	private boolean connectToDb(){
		final String DATABASE_URL = "jdbc:mysql://localhost:3306/circos";
		String usr = "root";
		String pw = "123";
		try {
			this.connection = DriverManager.getConnection(DATABASE_URL,usr,pw);
			return true;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}

	public boolean getConnectionStatus(){
		if(connectToDb()){
			return true;
		}else{
			return false;
		}
	}
}

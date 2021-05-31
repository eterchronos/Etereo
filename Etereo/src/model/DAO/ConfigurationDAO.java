package model.DAO;

import model.bean.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfigurationDAO {

    ConnectionFactory connectionFactory = new ConnectionFactory();
    Configuration configuration = new Configuration();
    public String select(){
        String sql = "SELECT * FROM configuracao";

        try {
            PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
           ResultSet setResult = stmt.executeQuery();
            while (setResult.next()){
                configuration.setCompanyName(setResult.getString("nomeEmpresa"));
            }
            System.out.println(configuration.getCompanyName()+" loaded.");
                return configuration.getCompanyName();

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return configuration.getCompanyName();
    }

    public boolean update(Configuration configuration){
        String sql = "UPDATE `configuracao` SET `nomeEmpresa`=? WHERE `id`=1";

        try {
            PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
            stmt.setString(1,configuration.getCompanyName());
            stmt.execute();
            System.out.println(configuration.getCompanyName()+" Changed!");
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

    }
}

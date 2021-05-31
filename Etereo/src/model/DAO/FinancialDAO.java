package model.DAO;


import model.bean.Financial;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FinancialDAO {


    ConnectionFactory connectionFactory = new ConnectionFactory();
    Financial financial = new Financial();



    public Double select(){
            String sql = "SELECT SUM(credito) - SUM(debito) AS totalEmDinheiro FROM caixa";
    try {
        PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();
        while(resultSet.next()){
            financial.setCash(resultSet.getDouble("totalEmDinheiro"));
            return financial.getCash();
        }


    }catch(SQLException e){e.printStackTrace();}
        return financial.getCash();
    }

    public List<Financial> selectAllContents(){
        String sql = "SELECT * FROM caixa";
        List<Financial> list = new ArrayList<>();
        try {
            PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
            ResultSet setResult = stmt.executeQuery();
            while(setResult.next()){
                Financial financialList = new Financial();
                financialList.setCash(setResult.getDouble("credito"));
                financialList.setDebit(setResult.getDouble("debito"));
                financialList.setData(setResult.getString("data"));
                list.add(financialList);
            }
            return list;
        } catch (SQLException throwables) {   throwables.printStackTrace(); }
        return list;
    }



    public boolean insert(Financial financial) {
        String sql = "INSERT INTO `caixa` (`credito`) VALUES (?)";
        try {
            PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
            stmt.setDouble(1, financial.getCash());
            stmt.execute();
            System.out.println(financial.getCash() + " was added.");
            return true;
        } catch (SQLException e) {e.printStackTrace();}
        return false;
        }

    public boolean delete (Financial financial) {
            String sql = "INSERT INTO `caixa` (`debito`) VALUES(?)";
            try {
                PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
                stmt.setDouble(1, financial.getCash());
                stmt.execute();
                System.out.println(financial.getCash() + " was deleted.");
                return true;
            } catch (SQLException e) {e.printStackTrace();}
            return false;

    }

}


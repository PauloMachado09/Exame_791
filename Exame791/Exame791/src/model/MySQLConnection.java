package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class MySQLConnection {
    private Properties p;
    private Connection connection;

    public MySQLConnection(){
        setConnection();
    }

    public void setConnection(){
        p = new Properties();
        try{
            InputStream input = new FileInputStream("dbconfig.properties");
            p.load(input);
            connection = DriverManager.getConnection(
                    p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
            System.out.println("LIGADO À BD");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("OCORREU UM ERRO");
        }
    }



    public ResultSet getDetalhe(String id){
        ResultSet result = null;
        String sql = "SELECT OD.ProductID, P.ProductName, Od.UnitPrice, OD.Quantity\n" +
            "FROM orderdetails OD, products P\n" +
            "WHERE OD.ProductID = P.ProductID\n+" +
            "AND OD.OrderID =" + id;
        try{
            Statement stm = connection.createStatement();
            result = stm.executeQuery(sql);
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return result;
        }
    }
}
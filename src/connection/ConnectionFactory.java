/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mgrac
 */
public class ConnectionFactory {
     private static Connection conn = null;
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String USER = "user_mary";
    public static final String PASS = "admin";

    public static Connection getConnection()  {        
        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } 
        catch(Exception e){
           e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            conn.setAutoCommit(false);
            return conn;
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    public static void closeConnection(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void commitTransaction(Connection con){
        try{
            if(con != null && !con.getAutoCommit()){
                con.commit();
                System.out.println("Transaction committed successfully!");
            }
        }catch(SQLException ex){
            System.out.println("Error occurred while committing the transaction");
        }      
    }
}

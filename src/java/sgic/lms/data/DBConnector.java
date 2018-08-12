package sgic.lms.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thanan Pathman
 */
public class DBConnector {
    static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost/web_library?useSSL=false";
    static String USER_NAME = "root";
    static String PASSWORD = "manager";
    static Connection connection = null;    
    
    public static Connection connect() {
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("Success on connection...");
        }
        catch(ClassNotFoundException exception){
            System.out.println("Error1: " + exception);
        }
        catch(SQLException exception){
            System.out.println("Error2: " + exception);
        } 
        
        return connection; 
    }
    
    public static void disconnect() {
        if(connection != null){
            try{
            connection.close();
            System.out.println("DB Connection closed...!");
            }
            catch(SQLException e){
                System.out.println(e);
            }
        }
    }
           
}

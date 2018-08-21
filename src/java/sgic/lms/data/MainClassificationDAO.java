/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgic.lms.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sgic.lms.model.MainClassification;

/**
 *
 * @author Keerththanan
 */
public class MainClassificationDAO {
    
    static Connection connection = null;
    static PreparedStatement pStatement = null; 
    static Statement statement = null;
    static ResultSet resultSet = null;
    
    public static void SaveMainClassification(MainClassification mClassification){
        String ID = mClassification.getmClassificationID();
        String Name = mClassification.getmClassificationName();
        
        String insertQuery = "INSERT INTO main_classification (mainId, mClassificationName) VALUES(?, ?)"; //This is how the query should be written for PREPAREDSTATEMENT
        
        try{
            connection = DBConnector.connect();
            pStatement = connection.prepareStatement(insertQuery);
            pStatement.setString(1, ID);
            pStatement.setString(2, Name);

            
            pStatement.executeUpdate();
            System.out.println();

        }
        catch(Exception e){
            System.out.println("Error... " + e);
        }
    }
   
    public static ArrayList loadMainClassification(){
        String sql = "SELECT * FROM main_classification";
        ArrayList<MainClassification> mainClassificationList = new ArrayList<>();
        try{
            connection = DBConnector.connect();
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sql);
            
            while(resultSet.next()){
                MainClassification mainClassification = new MainClassification();
                mainClassification.setmClassificationID(resultSet.getString(1));
                mainClassification.setmClassificationName(resultSet.getString(2));
                mainClassificationList.add(mainClassification);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MainClassificationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mainClassificationList;
    }
    
    public ArrayList<MainClassification> SearchMainClassification(String type, String value){
        String coloumn = null;
        if("MainClassification ID".equals(type)){
            coloumn = "mainId";
        }
        else if("MainClassification Name".equals(type)){
            coloumn = "mClassificationName";
        }

        
        ArrayList<MainClassification> searchResult = new ArrayList<>();
        String searchQuery = "SELECT * FROM main_classification "
                + "WHERE " + coloumn + " LIKE '" + value + "%'";
        try{
            connection = DBConnector.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(searchQuery);
            while(resultSet.next()){
                MainClassification MC = new MainClassification();
                
                MC.setmClassificationID(resultSet.getString(1));
                MC.setmClassificationName(resultSet.getString(2));
                
                searchResult.add(MC);
            }
        }
        catch(Exception e){
            System.out.println("Error on Searching: " + e);
        }
        
        return searchResult;
    }
 
//    public void DeleteMC(String mcId){
//        String deleteQuery = "DELETE FROM book_detail WHERE bookId = '" + bookId + "'";
//        try{
//            connection = DBConnector.connect();
//            pStatement = connection.prepareStatement(deleteQuery);
//            pStatement.executeUpdate();
//        }catch(Exception e){  
//            System.out.println("Error on delete :" + e);
//        }
//    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgic.lms.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
    
}

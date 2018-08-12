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
import sgic.lms.model.SubClassification;

/**
 *
 * @author Keerththanan
 */
public class SubClassificationDAO {
    static Connection connection = null;
    static PreparedStatement pStatement = null; 
    static Statement statement = null;
    static ResultSet resultSet = null;
    
    public static void SaveSubClassification(SubClassification sClassification){
        String sID = sClassification.getsClassificationID();
        String Name = sClassification.getsClassificationName();
        String mName = sClassification.getmClassificationName();
        String mId = null;
        
        
        String insertQuery = "INSERT INTO sub_classification (subId, sClassificationName, mClassificationId) VALUES(?, ?, ?)"; //This is how the query should be written for PREPAREDSTATEMENT
        
        try{
            connection = DBConnector.connect();
            pStatement = connection.prepareStatement(insertQuery);
            pStatement.setString(1, sID);
            pStatement.setString(2, Name);
            mID = getMCID(mName);
            pStatement.setString(3, mID);

            
            pStatement.executeUpdate();
            System.out.println();

        }
        catch(Exception e){
            System.out.println("Error... " + e);
        }   
    }
    
    public static String getMCID(String mcName){
        String mcID = null;
        String query;
        query = "SELECT mainId FROM main_classification as mc WHERE mc.mClassificationName = '"+mcName+"';";
        try{
            connection = DBConnector.connect();
            resultSet = statement.executeQuery(query);

            mcID = resultSet.getString("mainId");
        }
        catch(Exception e){
            System.out.println("Error on Searching: " + e);
        }
        return mcID;
    }
    
}

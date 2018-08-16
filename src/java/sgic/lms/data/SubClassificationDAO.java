/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgic.lms.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        String mID = null;
        
        
        String insertQuery = "INSERT INTO sub_classification (subId, sClassificationName, mClassificationId) VALUES(?, ?, ?)"; //This is how the query should be written for PREPAREDSTATEMENT
        
        try{
            connection = DBConnector.connect();
            pStatement = connection.prepareStatement(insertQuery);
            pStatement.setString(1, sID);
            pStatement.setString(2, Name);
            mID = getMCID(mName);
            pStatement.setString(3, mID);
            pStatement.executeUpdate();

        }
        catch(SQLException e){
            System.out.println("Error... " + e);
        }   
    }
    
    public static String getMCID(String mcName){
        String mcID = null;
        String query = "SELECT mainId FROM main_classification as mc WHERE mc.mClassificationName = '"+mcName+"';";
        try{
            connection = DBConnector.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
      
            while(resultSet.next()){
                mcID = resultSet.getString("mainId");
            }    
        }
        catch(Exception e){
            System.out.println("Error on Searching: " + e);
        }
        return mcID;
    }
    
    public ArrayList viewSubClassificationByMainClassificationid(String mainClassificationId){
        String sql = "SELECT * FROM sub_classification "
                + "WHERE mClassificationId='"+mainClassificationId+"'";
        ArrayList<SubClassification> subClassificationList = new ArrayList<>();
        try{
            connection = DBConnector.connect();
            statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                SubClassification subClassification = new SubClassification();
                subClassification.setsClassificationID(rs.getString(1));
                subClassification.setsClassificationName(rs.getString(2));
                subClassification.setmClassificationId(rs.getString(3));
                subClassificationList.add(subClassification);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SubClassificationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subClassificationList;
    }
}

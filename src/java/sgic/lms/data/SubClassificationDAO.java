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
    
    public static ArrayList loadSubClassificationForMainClassification(String mainClassification){
        String sql = "SELECT * FROM sub_classification WHERE mClassificationId = '" + mainClassification + "'";
        ArrayList<SubClassification> subClassificationList = new ArrayList<>();
        try{
            connection = DBConnector.connect();
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sql);
            
            while(resultSet.next()){
                SubClassification subClassification = new SubClassification();
                subClassification.setsClassificationID(resultSet.getString(1));
                subClassification.setsClassificationName(resultSet.getString(2));
                subClassification.setmClassificationName(resultSet.getString(3));
                subClassificationList.add(subClassification);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SubClassificationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subClassificationList;
    }
    
    public static ArrayList loadSubClassification(){
        String sql = "SELECT * FROM sub_classification sc JOIN main_classification mc "
                + "ON sc.mClassificationId = mc.mainId";
        ArrayList<SubClassification> subClassificationList = new ArrayList<>();
        try{
            connection = DBConnector.connect();
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sql);
            
            while(resultSet.next()){
                SubClassification subClassification = new SubClassification();
                subClassification.setsClassificationID(resultSet.getString(1));
                subClassification.setsClassificationName(resultSet.getString(2));
                subClassification.setmClassificationId(resultSet.getString(3));
                subClassification.setmClassificationName(resultSet.getString(5));
                
                subClassificationList.add(subClassification);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MainClassificationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subClassificationList;
    }
    
    public ArrayList<SubClassification> SearchSubClassification(String type, String value){
        String coloumn = null;
        if("SubClassification ID".equals(type)){
            coloumn = "subId";
        }
        else if("SubClassification Name".equals(type)){
            coloumn = "sClassificationName";
        }
        else if("MainClassification ID".equals(type)){
            coloumn = "mainId";
        }
        else if("MainClassification Name".equals(type)){
            coloumn = "mClassificationName";
        }
     
        ArrayList<SubClassification> searchResult = new ArrayList<>();
        String searchQuery = "SELECT * FROM sub_classification sc "
                + "JOIN main_classification mc ON sc.mClassificationId = mc.mainId "
                + "WHERE " + coloumn + " LIKE '" + value + "%'";
        try{
            connection = DBConnector.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(searchQuery);
            while(resultSet.next()){
                SubClassification SC = new SubClassification();
                
                SC.setsClassificationID(resultSet.getString("subId"));
                SC.setsClassificationName(resultSet.getString("sClassificationName"));
                SC.setmClassificationId(resultSet.getString("mainId"));
                SC.setmClassificationName(resultSet.getString("mClassificationName"));

                searchResult.add(SC);
            }
        }
        catch(Exception e){
            System.out.println("Error on Searching: " + e);
        }
        
        return searchResult;
    }
    
    //OverLoaded method
    public SubClassification SearchSubClassification(String value){
        SubClassification searchResult = new SubClassification();
        String searchQuery = "SELECT * FROM sub_classification sc "
                + "JOIN main_classification mc ON sc.mClassificationId = mc.mainId "
                + "WHERE sc.subId = '" + value + "'";
        try{
            connection = DBConnector.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(searchQuery);
            while(resultSet.next()){
                
                searchResult.setsClassificationID(resultSet.getString("subId"));
                searchResult.setsClassificationName(resultSet.getString("sClassificationName"));
                searchResult.setmClassificationId(resultSet.getString("mainId"));
                searchResult.setmClassificationName(resultSet.getString("mClassificationName"));

            }
        }
        catch(Exception e){
            System.out.println("Error on Searching: " + e);
        }
        
        return searchResult;
    }
    
    public static void DeleteSC(String scId){
        String query = "SELECT * from book_detail bd "
                + "JOIN sub_classification sc ON sc.subId = bd.subClassification "
                + "WHERE bd.subClassification = '" + scId + "'";
        try{
            connection = DBConnector.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            Integer count = 0;
            while(resultSet.next()){
                count++;
            }
            
            if(count == 0){
                String deleteQuery = "DELETE FROM sub_classification WHERE subId = '" + scId + "'";
                connection = DBConnector.connect();
                pStatement = connection.prepareStatement(deleteQuery);
                pStatement.executeUpdate();
            }
        }
        catch(Exception e){
            System.out.println("Delete exception: " + e);
        }
    }
    
    public static void updateSubClassification(SubClassification sClassification){
        String sID = sClassification.getsClassificationID();
        String Name = sClassification.getsClassificationName();
        String mID = sClassification.getmClassificationId();
        
        
        String updateQuery = "UPDATE sub_classification SET sClassificationName = '" + Name + "', mClassificationId = '" + mID + "' "
                + "WHERE subId = '" + sID + "'"; //This is how the query should be written for PREPAREDSTATEMENT
        
        try{
            connection = DBConnector.connect();
            statement = connection.createStatement();
            statement.executeUpdate(updateQuery);
        }
        catch(SQLException e){
            System.out.println("Error... " + e);
        }   
    }
    
}
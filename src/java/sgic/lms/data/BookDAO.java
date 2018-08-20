/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgic.lms.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import sgic.lms.model.Book;

/**
 *
 * @author Thanan Pathman
 */
public class BookDAO {
    static Connection connection = null;
    static PreparedStatement pStatement = null; 
    static Statement statement = null;
    static ResultSet resultSet = null;
    
    public static void SaveBook(Book book) throws SQLException{
        String bookId = book.getBookId();
        String title = book.getTitle();
        String author = book.getAuthor();
        String mClassifi = book.getmClassification();
        String sClassifi = book.getsClassification();
        String yop = book.getYop();
        String lpy = book.getLpy();
        String isbn = book.getIsbn();
        String nop = book.getNop();  
        
        //String insertQuery = "INSERT INTO book_detail(bookId, title, author) VALUES('"+bookId+"', '"+title+"','"+author+"')"; //This is how the query should be written for STATEMENT
        String insertQuery = "INSERT INTO book_detail (bookId, title, author, mainClassification, subClassification, yop, lpy, isbn, nop) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)"; //This is how the query should be written for PREPAREDSTATEMENT
        
        try{
            connection = DBConnector.connect();
            pStatement = connection.prepareStatement(insertQuery);
            pStatement.setString(1, bookId);
            pStatement.setString(2, title);
            pStatement.setString(3, author);
            pStatement.setString(4, mClassifi);
            pStatement.setString(5, sClassifi);
            pStatement.setString(6, yop);
            pStatement.setString(7, lpy);
            pStatement.setString(8, isbn);
            pStatement.setString(9, nop);
            
            pStatement.executeUpdate();
            System.out.println();
            //DBConnector.disconnect();
//          statement = connection.prepareStatement(insertQuery);
//          statement.executeQuery(insertQuery);
        }
        catch(Exception e){
            System.out.println("Error... " + e);
        }
    }
    
    public ArrayList<Book> SearchBook (String type, String value){
        String coloumn = null;
        if("Book ID".equals(type)){
            coloumn = "bookId";
        }
        else if("Title".equals(type)){
            coloumn = "title";
        }
        else if("Author".equals(type)){
            coloumn = "author";
        }
        else if("Main Classification".equals(type)){
            coloumn = "mClassificationName";
        }
        else if("Sub Classification".equals(type)){
            coloumn = "sClassificationName";
        }
        
        ArrayList<Book> searchResult = new ArrayList<>();
        String searchQuery = "SELECT * FROM book_detail bd "
                + "JOIN main_classification mc ON bd.mainClassification = mc.mainId "
                + "JOIN sub_classification sc ON bd.subClassification = sc.subId "
                + "WHERE " + coloumn + " LIKE '" + value + "%'";
        try{
            connection = DBConnector.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(searchQuery);
            while(resultSet.next()){
                Book book = new Book();
                book.setBookId(resultSet.getString(1));
                book.setTitle(resultSet.getString(2));
                book.setAuthor(resultSet.getString(3));
                book.setmClassification(resultSet.getString("mClassificationName"));
                book.setsClassification(resultSet.getString("sClassificationName"));
                book.setYop(resultSet.getString(6));
                book.setLpy(resultSet.getString(7));
                book.setIsbn(resultSet.getString(8));
                book.setNop(resultSet.getString(9));
                
                searchResult.add(book);
            }
        }
        catch(Exception e){
            System.out.println("Error on Searching: " + e);
        }
        
        return searchResult;
    }
    
    public ResultSet GetResultSet(String query) throws SQLException{
        Connection connection = DBConnector.connect();
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(query); 
        return resultset;
    }
    
    public ArrayList<Book> ViewAllBooks(){
        
        ArrayList<Book> searchResult = new ArrayList<>();
        String searchQuery = "SELECT * FROM book_detail bd "
                + "JOIN main_classification mc ON bd.mainClassification = mc.mainId "
                + "JOIN sub_classification sc ON bd.subClassification = sc.subId";
        try{
            connection = DBConnector.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(searchQuery);
            while(resultSet.next()){
                Book book = new Book();
                book.setBookId(resultSet.getString(1));
                book.setTitle(resultSet.getString(2));
                book.setAuthor(resultSet.getString(3));
                book.setmClassification(resultSet.getString("mClassificationName"));
                book.setsClassification(resultSet.getString("sClassificationName"));
                book.setYop(resultSet.getString(6));
                book.setLpy(resultSet.getString(7));
                book.setIsbn(resultSet.getString(8));
                book.setNop(resultSet.getString(9));
                
                searchResult.add(book);
            }
        
        }
        catch(Exception e){
            System.out.println("Error on Searching: " + e);
        }
        
        return searchResult;
    }
    
    public void DeleteBook(String bookId){
        String deleteQuery = "DELETE FROM book_detail WHERE bookId = '" + bookId + "'";
        try{
            connection = DBConnector.connect();
            pStatement = connection.prepareStatement(deleteQuery);
            pStatement.executeUpdate();
        }catch(Exception e){  
            System.out.println("Error on delete :" + e);
        }
    }
    
    public boolean updateBook(Book book) {
        String bookId = book.getBookId();
        String title = book.getTitle();
        String author = book.getAuthor();
        String mClassifi = book.getmClassification();
        String sClassifi = book.getsClassification();
        String yop = book.getYop();
        String lpy = book.getLpy();
        String isbn = book.getIsbn();
        String nop = book.getNop();  
        
        //String insertQuery = "INSERT INTO book_detail(bookId, title, author) VALUES('"+bookId+"', '"+title+"','"+author+"')"; //This is how the query should be written for STATEMENT
        String insertQuery = "INSERT INTO book_detail (bookId, title, author, mainClassification, subClassification, yop, lpy, isbn, nop) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)"; //This is how the query should be written for PREPAREDSTATEMENT

        
        try {
            connection = DBConnector.connect();
            pStatement = connection.prepareStatement(insertQuery);
            pStatement.setString(1, bookId);
            pStatement.setString(2, title);
            pStatement.setString(3, author);
            pStatement.setString(4, mClassifi);
            pStatement.setString(5, sClassifi);
            pStatement.setString(6, yop);
            pStatement.setString(7, lpy);
            pStatement.setString(8, isbn);
            pStatement.setString(9, nop);
            
            int i = pStatement.executeUpdate();
            System.out.println();

            if (i == 1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public ArrayList<Book> SearchBookByID (String type, String value){
        String coloumn = null;
        if("Book ID".equals(type)){
            coloumn = "bookId";
        }
       
        ArrayList<Book> searchResult = new ArrayList<>();
        String searchQuery = "SELECT * FROM book_detail WHERE " + coloumn + " = '" + value + "'";
        try{
            connection = DBConnector.connect();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(searchQuery);
            while(resultSet.next()){
                Book book = new Book();
                book.setBookId(resultSet.getString(1));
                book.setTitle(resultSet.getString(2));
                book.setAuthor(resultSet.getString(3));
                book.setmClassification(resultSet.getString(4));
                book.setsClassification(resultSet.getString(5));
                book.setYop(resultSet.getString(6));
                book.setLpy(resultSet.getString(7));
                book.setIsbn(resultSet.getString(8));
                book.setNop(resultSet.getString(9));
                
                searchResult.add(book);
            }
        }
        catch(Exception e){
            System.out.println("Error on Searching: " + e);
        }
        
        return searchResult;
    }
}

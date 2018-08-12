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
    
    public List<Book> SearchBook (String bookId){
        Book book = new Book();
        List<Book> searchResult = new ArrayList<>();
        String searchQuery = "SELECT * FROM book_detail WHERE bookId = '"+bookId+"';";
        try{
            connection = DBConnector.connect();
            resultSet = statement.executeQuery(searchQuery);
            while(resultSet.next()){
                book.setBookId(bookId);
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
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
}

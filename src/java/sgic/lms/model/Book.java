/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgic.lms.model;

/**
 *
 * @author Thanan Pathman
 */
public class Book {
    
    String bookId;
    String title;
    String author;
    String mClassification;
    String sClassification;
    String yop;
    String lpy;
    String isbn;
    String nop;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getmClassification() {
        return mClassification;
    }

    public void setmClassification(String mClassification) {
        this.mClassification = mClassification;
    }

    public String getsClassification() {
        return sClassification;
    }

    public void setsClassification(String sClassification) {
        this.sClassification = sClassification;
    }

    public String getYop() {
        return yop;
    }

    public void setYop(String yop) {
        this.yop = yop;
    }

    public String getLpy() {
        return lpy;
    }

    public void setLpy(String lpy) {
        this.lpy = lpy;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNop() {
        return nop;
    }

    public void setNop(String nop) {
        this.nop = nop;
    }

    
}

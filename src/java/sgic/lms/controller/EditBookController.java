/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgic.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sgic.lms.data.BookDAO;
import sgic.lms.data.MainClassificationDAO;
import sgic.lms.data.SubClassificationDAO;
import sgic.lms.model.Book;
import sgic.lms.model.MainClassification;
import sgic.lms.model.SubClassification;

/**
 *
 * @author Thanan Pathman
 */
@WebServlet(name = "EditBookController", urlPatterns = {"/EditBookController"})
public class EditBookController extends HttpServlet {
        Book book = new Book();
        BookDAO bookDAO = new BookDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditBookController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditBookController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        String bookId = request.getParameter("edit");
        List<Book> bookList = bookDAO.SearchBookByID("Book ID", bookId);                  

        MainClassificationDAO mcDAO = new MainClassificationDAO();
        ArrayList<MainClassification> mcList = new ArrayList<>();
        mcList = mcDAO.loadMainClassification();
        SubClassificationDAO scDAO = new SubClassificationDAO();
        ArrayList<SubClassification> scList = new ArrayList<>();
        
        String mcId = null;
        for(Book book: bookList){
            mcId = book.getmClassification();
        }

        scList = scDAO.loadSubClassificationForMainClassification(mcId);
            
        request.setAttribute("book", bookList);
        request.setAttribute("SetMainClass", mcList);
        request.setAttribute("SetSubClass", scList);
        
        request.getRequestDispatcher("EditBook.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        book.setBookId(request.getParameter("bookId"));        
        book.setTitle(request.getParameter("title"));
        book.setAuthor(request.getParameter("author"));
        book.setmClassification(request.getParameter("mClassification"));
        book.setsClassification(request.getParameter("sClassification"));
        book.setYop(request.getParameter("yop"));
        book.setLpy(request.getParameter("lpy"));        
        book.setIsbn(request.getParameter("isbn"));
        if(request.getParameter("nop")!="")
            book.setNop(request.getParameter("nop"));
        try{

            boolean success = bookDAO.updateBook(book);
            if (success)
            {   
                String message = "The selected book is successfully updated!";
                request.getRequestDispatcher("SearchBook.jsp").forward(request, response);                
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
            
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgic.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sgic.lms.data.DBConnector;
import sgic.lms.data.SubClassificationDAO;
import sgic.lms.model.SubClassification;

/**
 *
 * @author Keerththanan
 * Test Comment
 */
@WebServlet(name = "SubClassificationController", urlPatterns = {"/SubClassificationController"})
public class SubClassificationController extends HttpServlet {

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
            out.println("<title>Servlet SubClassificationController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SubClassificationController at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        if(request.getParameter("ADD") != null){
            SubClassification sClassification = new SubClassification();
            sClassification.setsClassificationID(request.getParameter("sClassificationID"));
            sClassification.setsClassificationName(request.getParameter("sClassificationName"));
            sClassification.setmClassificationName(request.getParameter("mainClassification"));

            try {
                SubClassificationDAO.SaveSubClassification(sClassification);
                System.out.println("Done sClassification saving");
                //processRequest(request, response);
                request.getRequestDispatcher("AddSubClassification.jsp").forward(request, response);
                DBConnector.disconnect();
            }catch (Exception ex) {
                    //Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Test Exception: " + ex.getMessage());
            }
        }
        else if(request.getParameter("viewAllSC") != null){
            //Book book = new Book();
            SubClassificationDAO scDAO = new SubClassificationDAO();  
            ArrayList<SubClassification> SCList = new ArrayList<>();
            SCList = scDAO.loadSubClassification();
            request.setAttribute("SCList", SCList);
            RequestDispatcher view = request.getRequestDispatcher("SearchSubClassification.jsp");
            view.forward(request, response);
        }
//        else if(request.getParameter("Search") != null){
//            String type = request.getParameter("searchBy");
//            String value = request.getParameter("value");
//            MainClassificationDAO mcDAO = new MainClassificationDAO();  
//            ArrayList<MainClassification> SearchedMCList = new ArrayList<>();
//            SearchedMCList = mcDAO.SearchMainClassification(type, value);
//            request.setAttribute("MCList", SearchedMCList);
//            request.getRequestDispatcher("SearchMainClassification.jsp").forward(request, response);
//        }
        else if(request.getParameter("CANCEL") != null){
            request.getRequestDispatcher("AddSubClassification.jsp").forward(request, response);
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

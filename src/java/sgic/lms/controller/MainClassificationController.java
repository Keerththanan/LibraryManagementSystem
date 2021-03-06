/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgic.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sgic.lms.data.DBConnector;
import sgic.lms.data.MainClassificationDAO;
import sgic.lms.model.MainClassification;

/**
 *
 * @author Keerththanan
 */
@WebServlet(name = "MainClassificationController", urlPatterns = {"/MainClassificationController"})
public class MainClassificationController extends HttpServlet {

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
            out.println("<title>Servlet MainClassificationController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MainClassificationController at " + request.getContextPath() + "</h1>");
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
        if(request.getParameter("edit") != null){
            String mcId = request.getParameter("edit");
            MainClassificationDAO mcDAO = new MainClassificationDAO();
            List<MainClassification> mcList = mcDAO.SearchMainClassification("MainClassification ID", mcId);
            
            request.setAttribute("mcList", mcList);
            request.getRequestDispatcher("EditMainClassification.jsp").forward(request, response);
        }
        else if(request.getParameter("delete") != null){
            MainClassificationDAO mcDAO = new MainClassificationDAO();
            String mcId = request.getParameter("delete");
            mcDAO.DeleteMC(mcId);
            request.getRequestDispatcher("SearchMainClassification.jsp").forward(request, response);
        }
        else{
        List<MainClassification> mainClassificationList = new ArrayList<>();
        MainClassificationDAO mainDao = new MainClassificationDAO();
        
        mainClassificationList = mainDao.loadMainClassification();
        
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        
        JsonObjectBuilder rootBuilder = Json.createObjectBuilder();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        JsonObject subClassificationJson = null;
        
        for(MainClassification mainClassification : mainClassificationList){
            JsonObjectBuilder subClassificationBuilder = Json.createObjectBuilder();
            
            subClassificationJson = subClassificationBuilder
                    .add("MainClassificationId", mainClassification.getmClassificationID() != null ? mainClassification.getmClassificationID() : "" )
                    .add("MainClassificationName", mainClassification.getmClassificationName() != null ? mainClassification.getmClassificationName() : "")
                    .build();
            arrayBuilder.add(subClassificationJson);
        }
        
        JsonObject root = rootBuilder.add("MainClassification", arrayBuilder).build();
        writer.print(root);
        writer.flush();
        writer.close();
    }

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
        //processRequest(request, response);
        if((request.getParameter("ADD") != null)){
            MainClassification mClassification = new MainClassification();
            mClassification.setmClassificationID(request.getParameter("mClassificationID"));
            mClassification.setmClassificationName(request.getParameter("mClassificationName"));

            try {
                MainClassificationDAO.SaveMainClassification(mClassification);
                System.out.println("Done mCLassification saving");
                //processRequest(request, response);
                request.getRequestDispatcher("AddMainClassification.jsp").forward(request, response);
                    DBConnector.disconnect();
            }catch (Exception ex) {
                    //Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Test Exception: " + ex.getMessage());
            }
        }
        else if(request.getParameter("viewAllMC") != null){
            //Book book = new Book();
            MainClassificationDAO mcDAO = new MainClassificationDAO();  
            ArrayList<MainClassification> MCList = new ArrayList<>();
            MCList = mcDAO.loadMainClassification();
            request.setAttribute("MCList", MCList);
            request.getRequestDispatcher("SearchMainClassification.jsp").forward(request, response);
        }
        else if(request.getParameter("edit") != null){
            MainClassification mClassification = new MainClassification();
            mClassification.setmClassificationID(request.getParameter("mClassificationID"));
            mClassification.setmClassificationName(request.getParameter("mClassificationName"));

            try {
                MainClassificationDAO.UpdateMainClassification(mClassification);
                System.out.println("Main Classification Updated");
                //processRequest(request, response);
                request.getRequestDispatcher("SearchMainClassification.jsp").forward(request, response);
                    DBConnector.disconnect();
            }catch (Exception ex) {
                    //Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Test Exception: " + ex.getMessage());
            }
            
        }
        else if(request.getParameter("Search") != null){
            String type = request.getParameter("searchBy");
            String value = request.getParameter("value");
            MainClassificationDAO mcDAO = new MainClassificationDAO();  
            ArrayList<MainClassification> SearchedMCList = new ArrayList<>();
            SearchedMCList = mcDAO.SearchMainClassification(type, value);
            request.setAttribute("MCList", SearchedMCList);
            request.getRequestDispatcher("SearchMainClassification.jsp").forward(request, response);
        }
        else if(request.getParameter("CANCEL") != null){
            request.getRequestDispatcher("SearchMainClassification.jsp").forward(request, response);
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

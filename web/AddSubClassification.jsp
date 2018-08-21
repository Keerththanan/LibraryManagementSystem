<%-- 
    Document   : AddSubClassification
    Created on : 12/08/2018, 1:52:01 PM
    Author     : Keerththanan
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="sgic.lms.data.MainClassificationDAO"%>
<%@page import="sgic.lms.data.BookDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AddSubClassification</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="Shared/header.jsp" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <jsp:useBean id="date" class="java.util.Date" />
   

        <form action="SubClassificationController" method="post">
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-6">
                
                <div class="form-group">
                    <label for="classificationID">Classification ID</label>
                    <input type="text" name="sClassificationID" id="sClassificationID" placeholder="Classification ID should be like SC789" class="form-control">
                </div>
                <div class="form-group">
                    <label for="scName">Sub Classification Name</label>
                    <input type="text" name="sClassificationName" id="sClassificationName" placeholder="Enter Sub Classification name" class="form-control">
                </div>
                <%  MainClassificationDAO MC_DAO = new MainClassificationDAO();
                    BookDAO B_DAO = new BookDAO();
                    ResultSet resultsetMC = B_DAO.GetResultSet("select * from main_classification");
                    %>                
                <div class="form-group">
                    <label name="MainClassifiacation">Main CLassification</label>
                    <select name="mainClassification" class="form-control">
                        <%  while(resultsetMC.next()){ %>
                            <option><%= resultsetMC.getString(2)%></option>
                            <% } %></select> 
                </div>               
            </div>
        </div>
            
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-3">
                <input type = "submit" name="ADD" value = "ADD" class="text-center btn btn-success">
            </div>
            <div class="col-md-4">
            <input type = "submit" name="CANCEL" value = "CANCEL" class="btn btn-danger">
        </div>
        </div>
        </form>
    </body>
</html>

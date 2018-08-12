<%-- 
    Document   : AddBook
    Created on : Jul 29, 2018, 5:49:56 AM
    Author     : Thanan Pathman
--%>

<%@page import="sgic.lms.data.BookDAO"%>
<%@page import="sgic.lms.data.DBConnector"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>AddBook page</title>
               
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        

    </head>
    <body>
        <%@include file="Shared/header.jsp" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <jsp:useBean id="date" class="java.util.Date" />
   

        <form action="BookController" method="post">
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-4">
                
                <div class="form-group">
                    <label for="BookID">BookID</label>
                    <input type="text" name="bookId" id="bookId" placeholder="Enter Book ID" class="form-control">
                </div>
                <div class="form-group">
                    <label for="Title">Title</label>
                    <input type="text" name="title" id="title" placeholder="Enter Book Title" class="form-control">
                </div>
                <div class="form-group">
                    <label for="Author">Author</label>
                    <input type="text" name="author" id="author" placeholder="Enter Author name" class="form-control">
                </div>
                
                <%  BookDAO BookDAO = new BookDAO(); 
                    ResultSet resultsetMC = BookDAO.GetResultSet("select * from main_classification");
                    ResultSet resultsetSC = BookDAO.GetResultSet("select * from sub_classification");
                    %>                
                <div class="form-group">
                    <label name="MainClassifiacation">Main CLassification</label>
                    <select name="mainClassification" class="form-control">
                        <%  while(resultsetMC.next()){ %>
                            <option><%= resultsetMC.getString(2)%></option>
                            <% } %></select> 
                </div>
                <div class="form-group">
                    <label name="SubClassification">Sub CLassification</label>
                    <select name="subClassification" class="form-control"   >
                        <%  while(resultsetSC.next()){ %>
                            <option><%= resultsetSC.getString(2)%></option>
                            <% } %></select>
                </div>
            </div>
            <div class="col-md-4">
                <div class="form-group">
                    <label name="yop"> Year of Published</label>
                    <input id="yop" name="yop" type="number" min="1700" max="<fmt:formatDate value="${date}" pattern="yyyy"/>" value="<fmt:formatDate value="${date}" pattern="yyyy"/>" class="form-control">
                </div>
                <div class="form-group">
                    <label name="lpy">Last Printed Year</label>
                    <input id="lpy" name="lpy" type="number" min="1700" max="<fmt:formatDate value="${date}" pattern="yyyy"/>" value="<fmt:formatDate value="${date}" pattern="yyyy"/>" class="form-control">
                </div>
                <div class="form-group">
                    <label for="isbn">ISBN Number</label>
                    <input type="text" name="isbn" id="isbn" placeholder="Enter Book Title" class="form-control">
                </div>
                <div class="form-group">
                    <label for="nop">Number of Pages</label>
                    <input type="text" name="nop" id="nop" placeholder="Enter NOP" class="form-control">
                </div>   
               
            </div>
        </div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-5">
                <input type = "submit" value = "ADD" class="text-center btn btn-success">
            </div>
            <div class="col-md-4">
            <input type = "submit" value = "CANCEL" class="btn btn-danger">
        </div>
        </div>
        </form>   

    </body>
</html>
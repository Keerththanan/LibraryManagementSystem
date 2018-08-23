<%-- 
    Document   : EditMainClassification
    Created on : Aug 22, 2018, 3:22:02 PM
    Author     : Thanan Pathman
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EditMainClassification</title>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="Shared/header.jsp" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <jsp:useBean id="date" class="java.util.Date" />
   

        <form action="MainClassificationController" method="post">
            <c:forEach items="${mcList}" var="data">
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-6">
                
                <div class="form-group">
                    <label for="classificationID">Classification ID</label>
                    <input type="text" name="mClassificationID" id="mClassificationID" value="${data.getmClassificationID()}" class="form-control" readonly>
                </div>
                <div class="form-group">
                    <label for="Title">Classification Name</label>
                    <input type="text" name="mClassificationName" id="mClassificationName" value="${data.getmClassificationName()}" class="form-control">
                </div>
            </div>
        </div>
            </c:forEach>
            
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-3">
                <input type = "submit" name="edit" value="EDIT" class="text-center btn btn-success">
            </div>
            <div class="col-md-4">
            <input type = "submit" name="CANCEL" value="CANCEL" class="btn btn-danger">
        </div>
        </div>
            
        </form>
    </body>
</html>


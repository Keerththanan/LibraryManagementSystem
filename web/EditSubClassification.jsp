<%-- 
    Document   : EditSubClassification
    Created on : Aug 23, 2018, 5:57:21 PM
    Author     : Thanan Pathman
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EditSubClassification</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="Shared/header.jsp" %>
        <form action="SubClassificationController" method="post">
        <div class="row">
            
            <div class="col-md-2"></div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="classificationID">Classification ID</label>
                    <input type="text" name="sClassificationID" id="sClassificationID" value="${scObj.getsClassificationID()}" readonly class="form-control">
                </div>
                <div class="form-group">
                    <label for="scName">Sub Classification Name</label>
                    <input type="text" name="sClassificationName" id="sClassificationName" value="${scObj.getsClassificationName()}" class="form-control">
                </div>
                            
                <div class="form-group">
                    <label name="MainClassifiacation">Main CLassification</label>
                    
                        <select name="mClassification" class="form-control">
                            <c:forEach items="${mcList}" var="mc">
                            <option value="${mc.getmClassificationID()}"> ${mc.getmClassificationName()}</option>
                            </c:forEach>
                        </select> 
                    
                </div>               
            </div>
            
        </div>
            
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-3">
                <input type = "submit" name="update" value = "UPDATE" class="text-center btn btn-success">
            </div>
            <div class="col-md-4">
            <input type = "submit" name="cancel" value = "CANCEL" class="btn btn-danger">
        </div>
        </div>
        </form>
    </body>
</html>

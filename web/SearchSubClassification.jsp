<%-- 
    Document   : SearchSubClassification
    Created on : Aug 21, 2018, 6:16:05 AM
    Author     : Thanan Pathman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SearchSubClassification</title>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        
        <script type="text/javascript">
            function confirmDelete()
            {
                var txt;
                var r = confirm("Do you want to delete this record?");
                if (r != true) {
                    return false;
                }
            }
        </script>
    </head>
    <body>
    <%@include file="Shared/header.jsp" %>
        <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
        <form action="SubClassificationController" method="post">

            <div class="row">
                
                <div class="row col-md-12">
                <div class="form-group col-md-3">
                    <label for="searchType" >SearchType</label>
                    <select class="selectpicker form-control" name="searchBy">
                        <option>SubClassification ID</option>
                        <option>SubClassification Name</option>
                        <option>MainClassification ID</option>
                        <option>MainClassification Name</option>
                    </select>
                </div>
 
                <div class="col-md-3 form-group">
                    <label>&nbsp;</label>
                    <input type="text" name="value" id="value" class="form-control">
                </div>
                <div class="col-md-3 form-group">
                    <label class="col-md-12">&nbsp;</label>
                    <input type="submit" name="Search" value="Search" class="text-center btn">
                </div>
                <div class="col-md-3 form-group">
                    <label class="col-md-12">&nbsp;</label>
                    <input type="submit" name="viewAllSC" value="View All Sub Classifications" class="text-center btn " >
                </div>
                </div>
      
            </div>
        </form>
        <table style="width: 90%"> 
            <tr>
            <th>Sub Classification ID</th>
            <th>Sub Classification Name</th>
            <th>Main Classification ID</th>
            <th>Main CLassification Name</th>
            </tr>
            <tbody>
            <c:forEach items="${SCList}" var="SCList">
                <tr>
                    <td>${SCList.getsClassificationID()}</td>
                    <td>${SCList.getsClassificationName()}</td>
                    <td>${SCList.getmClassificationId()}</td>
                    <td>${SCList.getmClassificationName()}</td>
                    <td><a href="SubClassificationController?edit=${SCList.getsClassificationID()}"<i name="edit" value="${SCList.getsClassificationID()}" class="fa fa-edit" style="color: #14ca3d; font-size: 25px"></i></a>
                        <a href="SubClassificationController?delete=${SCList.getsClassificationID()}" onclick="return confirmDelete()" <i name="delete" value="${SCList.getsClassificationID()}" class="fa fa-trash" style="color: #ff0000; font-size: 25px; margin-left: 10px;" ></i></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>       
    </div>
    </div>
    </body>
</html>

<%-- 
    Document   : SearchBook
    Created on : 11/08/2018, 5:16:47 PM
    Author     : Keerththanan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="Shared/header.jsp" %>
        <div class="row">
            <div class="col-md-6">

                <label for="searchType1">Search Type 1</label>
                <select class="selectpicker">
                    <option>Book ID</option>
                    <option>Book Name</option>
                    <option>Author Name</option>
                    <option>Main Classification</option>
                    <option>Sub Classification</option>
                </select>

            </div>
            <div class="col-md-6">
            
            </div>
        </div>
        

    </body>
</html>

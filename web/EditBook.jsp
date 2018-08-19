<%-- 
    Document   : EditBook
    Created on : Aug 19, 2018, 5:44:22 AM
    Author     : Thanan Pathman
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>


        <script>
            $(document).ready(function () {

                $("#mainClassification").change(function () {
                    //alert(this.value);
                    var mainClassificationId = this.value;

                    $.ajax({
                        url: 'SubClassificationByMainClassificationController?mainClassificationId=' + mainClassificationId,

                        complete: function (response) {
                            var json = JSON.parse(response.responseText);
                            var noOfRecords = Object.keys(json.SubClassification).length;

                            option = "";
                            for (var x = 0; x < noOfRecords; x++) {
                                option += "<option value='" + json.SubClassification[x].SubClassificationId + "'>" + json.SubClassification[x].SubClassificationName + "</option>";
                            }

                            $("#subClassification")
                                    .find('option').remove().end().append(option);

//                           $("#bookId").val(json.SubClassification[0].SubClassificationId);
                        },
                    });
                });
            });

            function formValidation() {
                var id = $("#bookId").val();
                var mC = $("#mainClassification").val();
                var sC = $("#subClassification").val();
                if (!id) {
                    $("#errorMessage").text("Book ID can not be empty");
                    return false;
                }
                if (!mC) {
                    $("#errorMessage").text("Main CLassification can not be empty");
                    return false;
                }
                if (!isC) {
                    $("#errorMessage").text("Sub Classification can not be empty");
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <%@include file="Shared/header.jsp" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <jsp:useBean id="date" class="java.util.Date" />

        <form action="EditBookController" method="post" onsubmit="return formValidation()">
            <c:forEach items="${book}" var="data">
                <label id="errorMessage"></label>
                <div class="row">
                    <div class="col-md-2"></div>
                    <div class="col-md-4">

                        <div class="form-group">
                            <label for="BookID">BookID</label>
                            <input type="text" name="bookId" id="bookId" value="${data.getBookId()}" placeholder="Enter Book ID" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="Title">Title</label>
                            <input type="text" name="title" id="title" value="${data.getTitle()}"placeholder="Enter Book Title" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="Author">Author</label>
                            <input type="text" name="author" id="author" value="${data.getAuthor()}"placeholder="Enter Author name" class="form-control">
                        </div>

                        <div class="form-group">
                            <label name="MainClassifiacation">Main CLassification</label>
                            <select id="mainClassification" name="mainClassification" class="form-control">
                                <c:forEach items="${SetMainClass}" var="item">
                                    <option value="${item.getmClassificationID()}">
                                        ${item.getmClassificationName()}
                                    </option>
                                </c:forEach>
                            </select> 
                        </div>
                        <div class="form-group">
                            <label name="SubClassification">Sub CLassification</label>
                            <select id="subClassification" value="" name="subClassification" class="form-control">
                                <c:forEach items="${SetSubClass}" var="item">
                                    <option value="${item.getsClassificationID()}">
                                        ${item.getsClassificationName()}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label name="yop"> Year of Published</label>
                            <input id="yop" name="yop" value="${data.getYop()}" type="number" min="1700" max="<fmt:formatDate value="${date}" pattern="yyyy"/>" value="<fmt:formatDate value="${date}" pattern="yyyy"/>" class="form-control">
                        </div>
                        <div class="form-group">
                            <label name="lpy">Last Printed Year</label>
                            <input id="lpy" name="lpy" value="${data.getLpy()}" type="number" min="1700" max="<fmt:formatDate value="${date}" pattern="yyyy"/>" value="<fmt:formatDate value="${date}" pattern="yyyy"/>" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="isbn">ISBN Number</label>
                            <input type="text" name="isbn" value="${data.getIsbn()}" id="isbn" placeholder="Enter ISBN" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="nop">Number of Pages</label>
                            <input type="text" name="nop" value="${data.getNop()}" id="nop" placeholder="Enter NOP" class="form-control">
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
                <script>
                    $("#mainClassification").val("${data.getmClassification()}");
                    $("#subClassification").val("${data.getsClassification()}");
                </script>
            </c:forEach>
        </form>   

    </body>
</html>
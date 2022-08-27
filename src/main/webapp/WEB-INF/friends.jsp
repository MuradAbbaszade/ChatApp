<%-- 
    Document   : friends
    Created on : Aug 27, 2022, 7:24:03 PM
    Author     : roma-cervice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            <%@ include file="assets/friends.css"%>
        </style>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/main.css">
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <title>Friends</title>
    </head>
    <body>
        <div class="container">
            <div id="container">
                <div style="margin-bottom:30px">
                    <h5>Who do you want to talk to ? </h5>
                </div>
                <div>
                    <c:forEach items="${friends}" var="f">
                        <div class="friendlist">
                            <span>#${f.user.id}</span>
                            <span class="name">${f.user.name} </span>
                            <i class='fas fa-user-friends'></i>
                            <form action="privateChat/${f.id}" method="POST" class="button" style="display:inline">
                                <button type="submit" name="select" value="select" class="btn btn-success">Select</button>
                            </form>
                        </div>
                        <br>
                    </c:forEach>
                </div>
                <div>
                    <a style="margin-right:500px;margin-bottom:15px" href="main" class="btn btn-danger">Back</a>
                </div>
            </div>
        </div>
    </body>
</html>

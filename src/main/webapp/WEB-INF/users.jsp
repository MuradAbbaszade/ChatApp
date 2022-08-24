<%-- 
    Document   : users
    Created on : Aug 23, 2022, 8:59:12 PM
    Author     : roma-cervice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.lang.Exception"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Users</title>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/users.css">
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container center" style="">
            <div class="search">        
                <form method="GET" action="searchuser">
                    <input class="input" type="text" name="name" id="name" value="" placeholder="Enter name..">
                    <button style="background-color:transparent;border:0" title="Search" class="operations_button" type="submit">
                        <i class="fas fa-search"></i>
                    </button>
                </form>
            </div>
            <br>
            <div>            
                <c:forEach items="${users}" var="u">
                    <tr>
                        <td>#${u.id}</td>
                    </tr>
                    <tr>
                        <td>${u.name}</td>
                    </tr>
                    <c:choose>
                        <c:when test="${remoteUserId==u.id}">
                            <tr>
                            <span id="${u.id}"><button class="btn btn-primary" >Send Friend Request</button></span>
                            </tr>
                        </c:when>
                    </c:choose>
                    <br><br>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
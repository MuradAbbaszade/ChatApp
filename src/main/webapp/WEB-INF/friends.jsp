<%-- 
    Document   : friends
    Created on : Aug 27, 2022, 7:24:03 PM
    Author     : roma-cervice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            <%@ include file="assets/friends.css"%>
        </style>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Friends</title>
    </head>
    <body>
        <div id="exampleModal">
            <div role="document">
                <div id="modal-content" class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Who do you want to talk to ? </h5>
                    </div>
                    <div class="modal-body">
                        <c:forEach items="${friends}" var="f">
                            <div class="friendlist">
                                <span>#${f.user.id}</span>
                                <span class="name">${f.user.name}</span>
                                <form action="privateChat/${f.id}" method="POST" class="button" style="display:inline">
                                    <button type="submit" name="select" value="select" class="btn btn-success">Select</button>
                                </form>
                            </div>
                            <br>
                        </c:forEach>
                    </div>
                    <div class="modal-footer">
                        <a style="margin-right:410px" href="main" class="btn btn-danger">Back</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

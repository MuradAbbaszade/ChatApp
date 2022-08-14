<%-- 
    Document   : messages
    Created on : Aug 14, 2022, 8:28:09 AM
    Author     : roma-cervice
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.company.ChatApp.form.LoggedInUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.0/jquery.min.js"></script>
    </head>
    <body>
        <% response.setHeader("Refresh", "3"); %>
        <%
            ArrayList<LoggedInUser> messages = (ArrayList<LoggedInUser>) request.getSession().getAttribute("messages");
            if (messages != null) {
                for (LoggedInUser loggedInUser : messages) {
        %>
        <div class="card">
            <div class="card-header d-flex justify-content-between p-3">
                <p class="fw-bold mb-0"><%=loggedInUser.getName()%></p>
                <p class="text-muted small mb-0"><i class="far fa-clock"></i><%=loggedInUser.getDate()%></p>
            </div>
            <div class="card-body">
                <p class="mb-0">
                    <%=loggedInUser.getMessage()%>
                </p>
            </div>
        </div>
        <br>
        <%}
            }
        %>
    </body>
</html>

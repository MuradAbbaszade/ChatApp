<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.company.entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.validation.OverridesAttribute.List"%>
<%@page import="org.springframework.web.servlet.view.RedirectView"%>
<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            <%@ include file="assets/globalchat.css"%>
        </style>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <title>ChatApp</title>
        <script>

            var j = 0;
            setInterval(loadDoc, 1000);
            function loadDoc() {
                const xhttp = new XMLHttpRequest();
                xhttp.onload = function () {
                    var response = JSON.parse(this.responseText);
                    var list = response;
                    for (var i = j; i < list.length; i++) {
                        var message = list[i];
                        printMessage(message);
                    }
                    j = list.length;
                }
                xhttp.open("GET", "http://localhost:8081/ChatAppWeb/messages");
                xhttp.send();
            }
            function printMessage(message) {
                var obj = message;
                var element = document.getElementById('messages');
                element.insertAdjacentHTML(
                        'beforeend',
                        `<div class="d-flex justify-content-between">
                                  <p class="small mb-1">` + obj.name + `</p>
                                  <p class="small mb-1 text-muted">` + obj.date + `</p>
                             </div>
                             <div class="d-flex flex-row justify-content-start">
                             <div>
                             <p class="small p-2 ms-3 mb-3 rounded-3" style="background-color: #f5f6f7">` + obj.message + `</p>
                             </div>
                             </div>
                             <br>`,
                        );
            }
        </script>
    </head>
    <%
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy:HH:mm");
        String strDate = sdf.format(d);
    %>
    <body onload="loadDoc()" >
        <div class="bg-image">
            <div class="filter-blur"></div>
        </div>
        <div id="container">
            <div class="container" style="overflow:scroll;overflow-x: hidden">
                <div id="messages" class="container" style="height:620px">

                </div>
            </div>
            <form class="form-outline container" action="messages" method="POST">
                <input type="hidden" name="email" id="email" value=<%=request.getRemoteUser()%> />
                <input type="hidden" name="date" id="date" value=<%=strDate%> />
                <input maxlength="125" style="border:2px solid black" placeholder="Type message.." class="form-control" name="message" id="message"/>
                <br>
                <a class="btn btn-danger" href="main">Back</a>
                <button style="margin-left:985px" name="send" type="submit"  value="Send" class="btn btn-success">Send</button>
            </form>
        </div>
    </body>
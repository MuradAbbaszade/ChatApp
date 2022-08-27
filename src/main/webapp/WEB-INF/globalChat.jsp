<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.company.entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.validation.OverridesAttribute.List"%>
<%@page import="org.springframework.web.servlet.view.RedirectView"%>
<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <title>Global Chat</title>
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
                        if(message.name=="${name}")
                        printMessageInRight(message);
                        else printMessageInLeft(message);
                    }
                    j = list.length;
                }
                xhttp.open("GET", "http://localhost:8081/ChatAppWeb/messages");
                xhttp.send();
            }
            function printMessageInLeft(message) {
                var obj = message;
                var element = document.getElementById('messages');
                element.insertAdjacentHTML(
                        'beforeend',
                        `
              <div class="d-flex flex-row justify-content-start mb-4">
                    <p style="margin-top:20px" class="small mb-1">` + obj.name + `</p>&nbsp
              <div class="p-3 ms-3" style="border-radius: 15px;background-color: rgba(230, 280, 220,.4)">
                    <p class="small mb-0">`+obj.message+`</p>
              </div>
               &nbsp<p class="small mb-0">`+obj.date+`</p>
            </div>`,
                        );
            }
            function printMessageInRight(message) {
                var obj = message;
                var element = document.getElementById('messages');
                element.insertAdjacentHTML(
                        'beforeend',
                        `            
              <div class="d-flex flex-row justify-content-end mb-4">
                    <p class="small mb-0">`+obj.date+`</p>&nbsp
              <div class="p-3 me-3 border" style="border-radius: 15px; background-color: rgba(57, 192, 237,.2)">
                    <p class="small mb-0">`+obj.message+`</p>
              </div>&nbsp
                 <p style="margin-top:20px" class="small mb-1">` + obj.name + `</p>
            </div>`,
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
                <input type="hidden" name="email" id="email" value="${email}" />
                <input type="hidden" name="date" id="date" value=<%=strDate%> />
                <input maxlength="125" style="border-radius: 8px ;background:rgba(200,220,240,0.8);" placeholder="Type message.." class="form-control" name="message" id="message"/>
                <br>
                <a class="btn btn-danger" href="main">Back</a>
                <button style="margin-left:695px" name="send" type="submit"  value="Send" class="btn btn-success">Send</button>
            </form>
        </div>
    </body>
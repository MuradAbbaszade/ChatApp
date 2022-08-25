<%-- 
    Document   : messages
    Created on : Aug 23, 2022, 12:51:19 PM
    Author     : roma-cervice
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        System.out.println(request.getAttribute("userDto"));
    %>
    <body class="container " onload="loadDoc()" style="background-image: url('https://img.wallpapersafari.com/desktop/728/410/1/80/8DYndB.png')">
                <div id="messages" class="container" style="height:500px">
                </div>
                <br>
                <form class="form-outline container" action="messages" method="POST">
                    <input type="hidden" name="email" id="email" value=<%=request.getRemoteUser()%> />
                    <input type="hidden" name="date" id="date" value=<%=strDate%> />
                    <input maxlength="125" style="border:2px solid black" placeholder="Type message.." class="form-control" name="message" id="message"/>
                    <br>
                    <button name="send" type="submit"  value="Send" class="btn btn-success btn-rounded float-end">Send</button>
                </form>
    </body>
</html>
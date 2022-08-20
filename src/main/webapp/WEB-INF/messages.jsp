<%-- 
    Document   : messages
    Created on : Aug 14, 2022, 8:28:09 AM
    Author     : roma-cervice
--%>

<%@page import="com.company.ChatApp.form.UserForm"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.company.ChatApp.form.LoggedInUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <script>
            function loadDoc() {
                const xhttp = new XMLHttpRequest();
                xhttp.onload = function () {
                    var response =  JSON.parse(this.responseText);
                    var list = response;
                    printMessages(list);
                }
                xhttp.open("GET", "http://localhost:8081/ChatAppWeb/message");
                xhttp.send();
            }
            function printMessages(arr) {
                for (var i = 0; i < arr.length; i++) {
                    var obj = arr[i];
                    document.getElementById('container').innerHTML += obj.date+" "+obj.name+" "+obj.message;
                }
            }
        </script>
    </head>
    <body onload="loadDoc()">
        <div id="container"></div>
    </body>
</html>


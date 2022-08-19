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
            var arr =[{"id":6,"name":"murad",surname:"abbaszade"},{"id":7,"name":"darum",surname:"abbaszade"}];
            function getUsers(){
                for(var i=0;i<arr.length;i++){
                    var obj = arr[i];
                    var str = obj.id+" "+obj.name+" "+obj.surname;
                    document.getElementById('container').innerHTML+=str;
                }
            }
        </script>
    </head>
    <body onload="getUsers()">
        <div id="container"></div>
    </body>
</html>


<%-- 
    Document   : users
    Created on : Aug 23, 2022, 8:59:12 PM
    Author     : roma-cervice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <script>
            function loadDoc() {
                const xhttp = new XMLHttpRequest();
                xhttp.onload = function () {
                    var response = JSON.parse(this.responseText);
                    var list = response;
                    for (var i = 0; i < list.length; i++) {
                        var user = list[i];
                        printUser(user);
                    }
                }
                xhttp.open("GET", "http://localhost:8081/ChatAppWeb/userslist");
                xhttp.send();
            }
            function printUser(user) {
                var obj = user;
                var element = document.getElementById('users');
                element.insertAdjacentHTML(
                        'beforeend',
                        `<div class="d-flex justify-content-between">
                          <p class="small mb-1">` + obj.name + `</p>
                     </div>
                     <br>`,
                        );
            }
        </script>
    </head>
    <body onload="loadDoc()">
        <div class="search">        
            <form method="GET" action="users">
                <input class="input" type="text" name="name" id="name" value="" placeholder="Name">
                <button title="Search" class="operations_button" type="submit" name="search" id="search" value="Search">
                    <i class="fas fa-search"></i>
                </button>
            </form>
        </div>
        <div id="users">burda:</div>
    </body>
</html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Welcome to Chat</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style>
            <%@ include file="assets/main.css"%>
        </style>
    </head>
    <body class="bg-image">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="#">Chat</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="main">Home</a></li>
                        <li><a href="edit">Edit Profile</a></li>
                        <li><a href="users">Search Users</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div>
            <div class="container-fluid text-center">    
                <div class="row content">
                    <div class="col-sm-8 text-left"> 
                    </div>
                </div>
            </div>
        </div>

        <footer style="margin-top: 70px" class="container-fluid text-center">
            <a href="globalChat" class="global-chat">Global Chat</a>
            <a href="friends" class="private-chat" >Private Chat</a>
        </footer>
    </body>
</html>

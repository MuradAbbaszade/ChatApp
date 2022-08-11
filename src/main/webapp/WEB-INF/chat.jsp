<%-- 
    Document   : chat.jsp
    Created on : Aug 5, 2022, 11:09:05 AM
    Author     : roma-cervice
--%>

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
    </head>
    <body>
        <div class="profile-menu">
            <ul class="menu-bar">
                <li><a class="menu-item fa fa-user" style="font-size:20px;" href="#"> Profile</a>
                    <ul class="sub-menu menu-bar">
                        <li><a class="menu-item fa fa-pencil" style="font-size:20px"> Edit</a></li>
                        <li><a class="menu-item fa fa-cog" style="font-size:20px"> Settings</a></li>
                        <li><a class="menu-item fa fa-sign-out" style="font-size:20px"> Logout</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="center">
            <div class="container">

                <ul class="list-unstyled">
                    <li class="d-flex justify-content-between mb-4">
                        <img src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-6.webp" alt="avatar"
                             class="rounded-circle d-flex align-self-start me-3 shadow-1-strong" width="60">
                        <div class="card">
                            <div class="card-header d-flex justify-content-between p-3">
                                <p class="fw-bold mb-0">Brad Pitt</p>
                                <p class="text-muted small mb-0"><i class="far fa-clock"></i> 12 mins ago</p>
                            </div>
                            <div class="card-body">
                                <p class="mb-0">
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
                                    labore et dolore magna aliqua.
                                </p>
                            </div>
                        </div>
                    </li>
                    <li class="d-flex justify-content-between mb-4">
                        <div class="card w-100">
                            <div class="card-header d-flex justify-content-between p-3">
                                <p class="fw-bold mb-0">Lara Croft</p>
                                <p class="text-muted small mb-0"><i class="far fa-clock"></i> 13 mins ago</p>
                            </div>
                            <div class="card-body">
                                <p class="mb-0">
                                    Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                                    laudantium.
                                </p>
                            </div>
                        </div>
                        <img src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-5.webp" alt="avatar"
                             class="rounded-circle d-flex align-self-start ms-3 shadow-1-strong" width="60">
                    </li>
                    <li class="d-flex justify-content-between mb-4">
                        <img src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-6.webp" alt="avatar"
                             class="rounded-circle d-flex align-self-start me-3 shadow-1-strong" width="60">
                        <div class="card">
                            <div class="card-header d-flex justify-content-between p-3">
                                <p class="fw-bold mb-0">Brad Pitt</p>
                                <p class="text-muted small mb-0"><i class="far fa-clock"></i> 10 mins ago</p>
                            </div>
                            <div class="card-body">
                                <p class="mb-0">
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
                                    labore et dolore magna aliqua.
                                </p>
                            </div>
                        </div>
                    </li>
                    <li class="bg-white mb-3">
                        <div class="form-outline">
                            <input class="form-control" id="textAreaExample2" rows="4"/>
                        </div>
                    </li>
                    <button type="button" class="btn btn-info btn-rounded float-end">Send</button>
                </ul>

            </div>
        </div>
    </body>
</html>

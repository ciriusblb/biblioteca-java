<%-- 
    Document   : login
    Created on : 29-nov-2018, 10:27:56
    Author     : Ciriusblb
--%>

<%@page import="java.util.List"%>
<%@page import="model.Login"%>
<%@page import="dao.main"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="./bootstrap/css/bootstrap-theme.min.css"/>
        <link rel="stylesheet" href="./content/css/estilos.css"/>
    </head>
    <body>
        <!--<div class="container">
            <div class="row main">
                <div class="panel-heading">
	            <div class="panel-title text-center">
                        <h1 class="title">Biblioteca Virtual</h1><hr />
	            </div>
	        </div> 
                <div class="main-login main-center">
                    <form class="form-horizontal" method="POST" action="CLogin">
                        <div class="form-group">
                            <label for="username" class="cols-sm-2 control-label">Código de estudiante</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="codigo" id="codigo"  placeholder="Código de estudiante"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="password" class="cols-sm-2 control-label">Contraseña</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                    <input type="password" class="form-control" name="contrasena" id="contrasena"  placeholder="Contraseña"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group ">
                            <input type="submit" name="Sesion" id="Sesion" value="Iniciar Sesión" class="btn btn-primary btn-lg btn-block login-button">
                        </div>

                    </form>
                </div>
            </div>
        </div>-->
       <div class="container">
           <h1 class="text-center"> Biblioteca Virtual </h1>
	<div class="login-container">
            <div id="output"></div>
            <div class="avatar">
                 <img style="width:100px"
                         src="http://icons.iconarchive.com/icons/graphicloads/colorful-long-shadow/256/Book-icon.png">
            </div>
            <div class="form-box">
                <form method="POST" action="CLogin">
                    <input name="codigo" id="codigo" type="text" placeholder="username">
                    <input type="password" name="contrasena" id="contrasena" placeholder="password">
                    <button class="btn btn-info btn-block login" type="submit" name="Sesion" id="Sesion">Login</button>
                </form>
            </div>
        </div>
        
</div>
    </body>
    <script src="./bootstrap/js/jquery.min.js"></script>
    <script src="./bootstrap/js/bootstrap.min.js"></script>
    <script>
        localStorage.setItem("contador", 1);
        console.log(localStorage.getItem("contador"));
    </script>
</html>

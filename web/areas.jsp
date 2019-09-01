<%-- 
    Document   : areas
    Created on : 29-nov-2018, 10:39:44
    Author     : Ciriusblb
--%>
<%@page import="dao.main"%>
<%@page import="java.util.List"%>
<%@page import="model.Areas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="./content/css/estilosarea.css"/>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    </head>
        <%
            HttpSession sesion = request.getSession(); 
            if(sesion.getAttribute("codigo") == null){
                response.sendRedirect("CLogin");
            }
            List<Areas> datos = (List<Areas>) request.getAttribute("respuesta");
        %>
    <body>
    <div class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" rel="home" href="#" title="Buy Sell Rent Everyting">
                    <img style="max-width:40px; margin-top: -7px;"
                         src="http://icons.iconarchive.com/icons/graphicloads/colorful-long-shadow/256/Book-icon.png">
                </a>
            </div>
            <div id="navbar" class="collapse navbar-collapse navbar-responsive-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="CAreas">Áreas</a></li>
                    <li><a href="CUsuario">Perfil</a></li>
                </ul>
                    <form class="navbar-form navbar-right" method="POST" action="CAreas">
                        <input class="btn btn-info" type="submit" value="Cerrar Sesión" name="salir">
                    </form>
                </div>

        </div>
    </div>
    <br>
    <br>
    <br>
    <div class="container">
        <div class="row">
       <%
                for(Areas c :datos){               
            %>
            <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
                <div class="offer offer-warning">
                    <div class="shape">
                        <div class="shape-text">
                            <i class="fa fa-book"></i>						
                        </div>
                    </div>
		    <div class="offer-content">
                            <h3 class="lead">
                                Libros de:
                            </h3>                                   
                            <form method="GET" action="CLibros"> 
                                <input  class="btn <%= c.getClase() %>" style="outline: none" type="submit" name="Area" value="<%=c.getNombre_area()%>">
                            </form>
                            <br>
                                <div class="progress">
                                    <div class="progress-bar progress-bar-striped" 
                                            role="progressbar" aria-valuenow="100" 
                                            aria-valuemin="0" aria-valuemax="100" style="width: 100%" >
                                        </div>
                             
                                </div>
                            </p> 

		    </div>
		</div>
	    </div>
            <%
                }
            %>

       </div>
    </div>
       
    </body>
    <script src="./bootstrap/js/jquery.min.js"></script>
    <script src="./bootstrap/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script>
        if(localStorage.getItem("contador")==1){
            swal("Buen Día!", "<%= sesion.getAttribute("nombre").toString()%>");
            localStorage.setItem("contador", 0);
        }
    </script>
</html>

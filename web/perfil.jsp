<%-- 
    Document   : perfil.jsp
    Created on : 18-dic-2018, 21:18:43
    Author     : Ciriusblb
--%>

<%@page import="dao.main"%>
<%@page import="model.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="model.Reservas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css"/>
    </head>
        <%
            HttpSession sesion = request.getSession(); 
            if(sesion.getAttribute("codigo") == null){
                response.sendRedirect("CLogin");
            }
            List<Reservas> datos = (List<Reservas>) request.getAttribute("respuesta");
            List<Usuario> user = (List<Usuario>) request.getAttribute("miUsuario");
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
                    <li><a href="CAreas">Áreas</a></li>
                    <li class="active"><a href="CUsuario">Perfil</a></li>
                </ul>
                    <form class="navbar-form navbar-right" method="GET" action="CUsuario">
                        <input class="btn btn-info" type="submit" value="Cerrar Sesión" name="salir">
                    </form>
                </div>
        </div>
    </div>
    <br>
    <br>
    <br>
    <div class="container bootstrap snippet">
        <div class="row">
            <div class="col-sm-12"><h1>Perfil del Usuario</h1></div>
             
        </div>
        <div class="row">
            <div class="col-sm-3">
                <div class="text-center">
                  <img src="http://localhost:10813/Biblioteca_Virtual/archivos/usersimg/<%= user.get(0).getFoto()%>" 
                       class="avatar img-circle img-thumbnail" alt="avatar">
                </div></hr><br>
                <div class="panel panel-default">
                  <div class="panel-heading">Código <i class="fa fa-link fa-1x"></i></div>
                  <div class="panel-body"><strong><%= user.get(0).getUsuario_general_codigo()%></strong></div>
                </div>
                <ul class="list-group">
                  <li class="list-group-item text-muted">Nombre <i class="fa fa-dashboard fa-1x"></i></li>
                  <li class="list-group-item">
                      <span class=""><strong><%=user.get(0).getNombre()%></strong></span>
                  </li>
                </ul> 
            </div>
            <div class="col-sm-9">
                <ul class="nav nav-tabs">
                    <li class="active"><a data-toggle="tab" href="#home">Reservas</a></li>
                </ul>   
                <div class="tab-content">
                    <div class="tab-pane active" id="home">
                        <hr>
                        <table class="table table-hover table-bordered">
                            <thead>
                              <tr>
                                <th class="text-center"> Id de reserva </th>
                                <th class="text-center"> Id de libro </th>
                                <th class="text-center"> Nombre de libro. </th>
                                <th class="text-center"> Autor de libro </th>
                                <th class="text-center"> fecha de reserva </th>
                                <th class="text-center"> Acción </th>
                              </tr>
                            </thead>
                            <tbody>
                            <%
                                for(Reservas c :datos){               
                            %>
                            <tr class="edit" id="detail">
                                <td > <%=c.getId_reserva()%> </td>
                                <td > <%=c.getLibros_id()%> </td>
                                <td > <%=c.getNombre()%> </td>
                                <td > <%=c.getAutor()%> </td>
                                <td > <%=c.getFecha()%> </td>
                                <td class="text-center"> 
                                    <a class='btn btn-warning btn-xs' id="cancelar">
                                        Cancelar Reserva
                                    </a>
                                </td>
                            </tr>
                            <%
                                }              
                            %>                         
                            </tbody>
                        </table>
                        <hr>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
    <script src="./bootstrap/js/jquery.min.js"></script>
    <script src="./bootstrap/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script>
        $("a[id^=cancelar]").click(function() {
            swal({
              title: "¿Está seguro?",
              text: "¿Desea continuar con la cancelación de su reserva?",
              icon: "warning",
              buttons: true,
              dangerMode: true,
            })
            .then((willDelete) => {
              if (willDelete) {
                  id_reserva = $(this).closest('tr').find('td:eq(0)').text();
                $(this).closest('tr').remove();
                $.ajax({
                    type:'POST',
                    data: {id_reserva : id_reserva},
                    url:'CUsuario',
                    success: function(result){
                        console.log(result);
                    }
                });
                swal("¡Poof! Su Reserva imaginario ha sido Cancelada!", {
                  icon: "success",
                });
              } else {
                swal("Tu reserva imaginaria esta a salvo!");
              }
            });
                /*id_reserva = $(this).closest('tr').find('td:eq(0)').text();
                $(this).closest('tr').remove();
                $.ajax({
                    type:'POST',
                    data: {id_reserva : id_reserva},
                    url:'CUsuario',
                    success: function(result){
                        console.log(result);
                    }
                });*/
            });
    </script>
</html>

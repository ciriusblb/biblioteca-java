<%-- 
    Document   : libro
    Created on : 29-nov-2018, 10:45:19
    Author     : Ciriusblb
--%>

<%@page import="model.Libros"%>
<%@page import="java.util.List"%>
<%@page import="dao.main"%>
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
            List<Libros> datos = (List<Libros>) request.getAttribute("respuesta");
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
                    <li><a href="CUsuario">Perfil</a></li>
                </ul>
                    <form class="navbar-form navbar-right" method="GET" action="CLibros">
                        <input class="btn btn-info" type="submit" value="Cerrar Sesión" name="salir">
                    </form>
                </div>

        </div>
    </div>
    <br>
    <br>
    <br>
        
    <div class="container">
    <div class="panel panel-warning">
      <div class="panel-heading">
        <div class="row">
          <div class=" col-xs-12 col-sm-12 col-md-4">
            <h2 class="text-center pull-left" style="padding-left: 30px;"><%=request.getParameter("Area")%> </h2>
          </div>
          <div class="input-group col-xs-12 col-sm-12 col-md-4">
            <span class="input-group-addon">Buscar</span>
            <input id="filtrar" type="text" class="form-control" 
                   placeholder="Ingrese algun dato del libro...">
          </div>
        </div>
      </div>

      <div class="panel-body">
          <table id="table1" class="table table-hover table-bordered">
          <thead>
            <tr>
              <th class="text-center"> Nro. </th>
              <th class="text-center"> Título </th>
              <th class="text-center"> Autor. </th>
              <th class="text-center"> Volumen </th>
              <th class="text-center"> acción </th>
            </tr>
          </thead>

          <tbody class="buscar">
            <%
                for(Libros c :datos){               
            %>
            <tr class="edit" id="detail">
              <td  scope="row" class="text-center"> <%=c.getId()%> </td>
              <td  class="text-center"> <%=c.getNombre()%> </td>
              <td  class="text-center"> <%=c.getAutor()%> </td>
              <td class="text-center"> <%=c.getVolumen()%> </td>
              <%
                  if(c.getPdf().length()>0){
              %>
                <td  class="text-center"> 
                    <a href="http://localhost:10813/Biblioteca_Virtual/archivos/librospdf/<%=c.getPdf()%>" class='btn btn-info btn-xs' >
                        Leer
                    </a>
                </td>
              <%
                  } else if(c.getReservado().length()>0){
              %>
              <td class="text-center"> 
                <a class='btn btn-warning btn-xs'>
                    <%=c.getReservado()%>
                </a>
              </td>
              <%
              } else{%>
                <td class="text-center"> 
                <a class='btn btn-info btn-xs' id="bEditarC" data-toggle="modal" data-target="#exampleModal">
                    Reservar
                </a>
              </td>

                <%}

              %>
            </tr>
            <%
                }              
            %>
          </tbody>
        </table>
      </div>

      <div class="panel-footer">
        <div class="row">
          <div class="col-lg-12">
            <div class="col-md-8">
              </div>
              <div class="col-md-4">
              <p class="muted pull-right">
                  <%
                      if(datos.size()>0){
                       %> 
                       <strong> :) </strong>
                       <%
                      }else{%>
                        <strong> Aún no suben libros de esta área :'C </strong>
                      <%}
                  %>
                  
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="">
      <div class="modal-body">
        <div class="container" >
            <div class="row" >
                <div class="modal-body" >
                    <div class="receipt-main col-xs-10 col-sm-10 col-md-6" >
                        <button type="button" class="close" id="borrar" click-Book data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <div class="row">
                            <div class="receipt-header">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="receipt-left">
                                        <img class="img-responsive" alt="iamgurdeeposahan" 
                                             src="http://www.unamad.edu.pe/images/logo_unamad.png" style="width: 171px; border-radius: 43px;">
                                    </div>
                                </div>
                                <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                                    <div class="receipt-right">
                                        <h5>Universidad Nacional Amazónica de Madre de Dios</h5>
                                        <p>personaladministrativo@gmail.com <i class="fa fa-envelope-o"></i></p>
                                        <p>Biblioteca Central <i class="fa fa-location-arrow"></i></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="receipt-header receipt-header-mid">
                                <div class="col-xs-8 col-sm-8 col-md-8 text-left">
                                    <div class="receipt-right">
                                        <h5>Nueva reserva <small> &nbsp;&nbsp;</small></h5>
                                        <p><b>Código de estudiante :</b>&nbsp; <%= sesion.getAttribute("codigo") %></p>
                                        <p><b>Nombre de Estudiante :</b>&nbsp;<%= sesion.getAttribute("nombre") %></p>
                                        <p><b>Fecha :</b>&nbsp;
                                            <script>
                                            var f = new Date();
                                            document.write(f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getFullYear());
                                            </script>
                                        </p>
                                    </div>
                                </div>
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <div class="receipt">
                                        <h1>Reserva</h1>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div>
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>Descripcion</th>
                                        <th>Cuentas</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="col-md-4">Código de libro</td>
                                        <td class="col-md-8"><i class="fa fa-inr"></i> &nbsp;
                                            <input type="text" id="idLibro" name="idLibro" class="input">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-md-4">Título de libro</td>
                                        <td class="col-md-8"><i class="fa fa-inr"></i> &nbsp;
                                            <input type="text" id="nombreLibro" name="nombreLibro" class="input">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-md-4">Aturo de libro</td>
                                        <td class="col-md-8"><i class="fa fa-inr"></i> &nbsp;
                                            <input type="text" id="autorLibro" name="autorLibro" class="input">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-md-4">Volumen de libro</td>
                                        <td class="col-md-8"><i class="fa fa-inr"></i> &nbsp;
                                            <input type="text" id="volumenLibro" name="volumenLibro" class="input">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-md-4">Código de usuario</td>
                                        <td class="col-md-8"><i class="fa fa-inr"></i> &nbsp;
                                            <input type="text" id="codigoUsuario" name="codigoUsuario" class="input">
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <input type="button" data-dismiss="modal" id="submit" value="Confirmar" class="btn btn-default">
                        </div>  
                    </div> 
                </div>     
            </div>
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
        $(document).ready(function() {
            $("a[id^=bEditarC]").click(function() {
                value0 = $(this).closest('tr').find('td:eq(0)').text();
                value1 = $(this).closest('tr').find('td:eq(1)').text();
                value2 = $(this).closest('tr').find('td:eq(2)').text();
                value3 = $(this).closest('tr').find('td:eq(3)').text();
                value4 = '<%= session.getAttribute("codigo") %>';
                $("#idLibro").val(value0);
                $("#nombreLibro").val(value1);
                $("#autorLibro").val(value2);
                $("#volumenLibro").val(value3);
                $("#codigoUsuario").val(value4);
            });
            $('#submit').click(function() {
                    var idLibro = $('#idLibro').val();
                    var codigoUsuario = $('#codigoUsuario').val();
                    $.ajax({
                        type:'POST',
                        data: {idLibro : idLibro,
                            codigoUsuario: codigoUsuario
                        },
                        url:'CLibros',
                        success: function(result){
                            console.log(result);
                            location.reload();
                           }

                       });
            }); 

            $(document).ready(function () {
                (function ($) {
                    $('#filtrar').keyup(function () {
                        var rex = new RegExp($(this).val(), 'i');
                        $('.buscar tr').hide();
                        $('.buscar tr').filter(function () {
                            return rex.test($(this).text());
                        }).show();
                    })
                }(jQuery));
            });
        });
    </script>
    <style>
            .text-danger strong {
            color: #9f181c;
        }
        .receipt-main {
            background: #ffffff none repeat scroll 0 0;
            border-bottom: 12px solid #333333;
            border-top: 12px solid #9f181c;
            /*margin-top: 50px;*/
            margin-bottom: 50px;
            padding: 40px 30px !important;
            position: relative;
            box-shadow: 0 1px 21px #acacac;
            color: #333333;
            /*font-family: open sans;*/
        }
        .receipt-main p {
            color: #333333;
            /*font-family: open sans;*/
            line-height: 1.42857;
        }
        .receipt-footer h1 {
            font-size: 15px;
            font-weight: 400 !important;
            margin: 0 !important;
        }
        .receipt-main::after {
            background: #414143 none repeat scroll 0 0;
            content: "";
            height: 5px;
            left: 0;
            position: absolute;
            right: 0;
            top: -13px;
        }
        .receipt-main thead {
            background: #414143 none repeat scroll 0 0;
        }
        .receipt-main thead th {
            color:#fff;
        }
        .receipt-right h5 {
            font-size: 16px;
            font-weight: bold;
            margin: 0 0 7px 0;
        }
        .receipt-right p {
            font-size: 12px;
            margin: 0px;
        }
        .receipt-right p i {
            text-align: center;
            width: 18px;
        }
        .receipt-main td {
            padding: 9px 20px !important;
        }
        .receipt-main th {
            padding: 13px 20px !important;
        }
        .receipt-main td {
            font-size: 13px;
            font-weight: initial !important;
        }
        .receipt-main td p:last-child {
            margin: 0;
            padding: 0;
        }   
        .receipt-main td h2 {
            font-size: 20px;
            font-weight: 900;
            margin: 0;
            text-transform: uppercase;
        }
        .receipt-header-mid .receipt-left h1 {
            font-weight: 100;
            margin: 34px 0 0;
            text-align: right;
            text-transform: uppercase;
        }
        .receipt-header-mid {
            margin: 24px 0;
            overflow: hidden;
        }
        
        #container {
            background-color: #dcdcdc;
        }
        .input {
            border: 0;
        }

    </style>
</html>

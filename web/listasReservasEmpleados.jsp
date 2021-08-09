<%@page import="Logica.Reserva"%>
<%@page import="Logica.Huesped"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>GestSys</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="css/estilos.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
             <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.jsp">GestSys</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>         
            <!-- Navbar Search-->
            <div class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">                   
                </div>
            </div>
            <!-- Navbar-->
            <ul class="navbar-nav text-right">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                         <li><a class="dropdown-item" href="#!">Usuario : user</a></li>
                        <li><a class="dropdown-item" href="#!">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            
                            
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fa fa-user"></i></div>
                                Reserva
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cargarReserva.jsp">Nuevo Huesped</a>
                                    <a class="nav-link" href="listaReservas.jsp">Lista huespedes</a>
                                </nav>
                            </div>                            
                            
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Usuario : user
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">                        
                        <div class="table-responsive">
                            <div class="buscador">
                            <div class="col-md-3">
                                  <div class="col-auto">
                                    <label for="searchTerm" class="visually-hidden">Empleado</label>
                                    <input type="text" class="form-control" id="searchTerm" placeholder="Buscar reservas por empleado" onkeyup="doSearch()">
                                  </div>  
                              </div>
                            </div>
                         <table  id="datos" class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>Empleado</th>                                            
                                            <th>Habitacion</th>
                                            <th>Cant Personas</th>
                                            <th>Fecha CheckIn</th> 
                                            <th>Fecha CheckOut</th>
                                            <th>Observaciones</th>                                             
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% Controladora control = new Controladora();
                                        List<Reserva> listaReservas = control.traerReservas(); 
                                        for(Reserva reserva : listaReservas){%> 
                                        <tr>
                                            <%String empleado =reserva.getEmpleado().getApellido();%>
                                            <td><%=empleado%></td>                                           
                                            <%int habitacion = reserva.getHabitacion().getNumero_habitacion();%>
                                            <td><%=habitacion%></td>
                                            <%int cantPersonas = reserva.getCantPersonas();%>
                                            <td><%=cantPersonas%></td>
                                            <%  String fecha = control.convertDateToString(reserva.getFecha_checkIn());%>
                                            <td><%=fecha%></td>
                                            <%  String fecha2 = control.convertDateToString(reserva.getFecha_checkOut());%>
                                            <td><%=fecha2%></td>
                                            <%  String observaciones = reserva.getObservaciones();%>
                                            <td><%=observaciones%></td>
                                             <%long id = reserva.getId_reserva();%>                                           
                                        </tr>
                                    </tbody>
                                    <%}; %>
                                </table> 
                        </div>                   
                         
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2021</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script type="text/javascript" src="js/app.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
</html>


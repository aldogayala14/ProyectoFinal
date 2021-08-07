<%@page import="java.util.List"%>
<%@page import="Logica.Usuario"%>
<%@page import="Logica.Habitacion"%>
<%@page import="Logica.Huesped"%>
<%@page import="Logica.Empleado"%>
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
        <%HttpSession mi_session = request.getSession();
          //Aca compruebo que exista un usuario que haya iniciado sesion, sino voy al login
          String usuario = (String) mi_session.getAttribute("usuario");
         
         
          Controladora control = new Controladora();
          if(usuario == null){
              response.sendRedirect("login.jsp");
          }else{
             
           %>
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
                                    <a class="nav-link" href="cargaReserva.jsp">Nueva Reserva</a>
                                    <a class="nav-link" href="layout-sidenav-light.html">Lista empleados</a>
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
                    <div class="container-fluid px-4">
                        <h2 class="mt-4">Nueva Reserva/Habitacion</h2>
                             <%
                                       List<Empleado> listaEmpleados = control.traerEmpleados(); 
                                       String nombreEmpleado="";                                      
                                        for(Empleado empleado : listaEmpleados){
                                            if(empleado.getUsuario().getNombre().equals(usuario)){
                                                nombreEmpleado = empleado.getApellido() + " " + empleado.getNombre();
                                               
                                            }
                                        
                                           
                             %>
                         <div class="row g-3">                            
                              <div class="col-md-6">                                                            
                                <label for="usario_empleado">Reserva realizada por el usuario</label>
                                <input type="text"  class="form-control" name="usuario_empleado" id="usario_empleado" placeholder="Nombre usuario" value="<%=request.getSession().getAttribute("usuario")%>"readonly>           
                              </div>
                              <div class="col-md-6">
                                <label for="nombre_empleado">Empleado</label>
                                <input type="text" class="form-control" name="nombre_empleado" id="nombre_empleado" placeholder="Nombre empleado" value="<%=nombreEmpleado%>" readonly>
                              </div> 
                              <div  action="SvModificarHuesped" method="GET" class="col-md-6">
                                  <div class="col-auto">
                                    <label for="searchTerm" class="visually-hidden">Habitacion</label>
                                    <input type="text" class="form-control" id="searchTerm" placeholder="Buscar habitacion" onkeyup="doSearch()">
                                  </div>  
                              </div>
                         </div>
                              <% }%>
                                 <div class="table-responsive">
                         <table id="datos" class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>Nº Habitacion</th>
                                            <th>Nº Piso</th>
                                            <th>Tipo tematica</th>
                                            <th>Tipo Habitacion</th>                                            
                                            <th>Precio por noche</th> 
                                            <th>Seleccion</th>                                                                                    
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                        List<Habitacion> listaHabitaciones = control.traerHabitaciones(); 
                                        for(Habitacion habitacion : listaHabitaciones){%> 
                                        <tr>
                                             <%int numeroHabitacion = habitacion.getNumero_habitacion();%>
                                            <td><%=numeroHabitacion%></td>
                                            <%int piso = habitacion.getPiso();%>
                                            <td><%=piso%></td>
                                            <%String tipoTematica = habitacion.getTipoTematica();%>
                                            <td><%=tipoTematica%></td>
                                            <%String tipoHabitacion = habitacion.getTipoHabitacion();%>
                                            <td><%=tipoHabitacion%></td>                                            
                                            <%double precioPorNoche = habitacion.getPrecioNoche();%>
                                            <td><%=precioPorNoche%></td>
                                             <%long id = habitacion.getId_habitacion();%>
                                            <td>
                                                 
                                                <form name="formReservaHuesped" action="SvReserva" method="GET">                                                    
                                                <input type="text" name="id_habitacionReservaConfirm" value="<%=id%>">
                                                <% String idReservaHab = (String) mi_session.getAttribute("id_huespedReservaHab");%>
                                                <input type="text" name="id_huespedReservaConfirm" value="<%=idReservaHab%>">
                                                <% String idEmpleadoRes = (String) mi_session.getAttribute("id_empleadoReservaHab");%>
                                                <input type="text" name="id_empleadoReservaConfirm" value="<%=idEmpleadoRes%>">
                                                <button type="submit" class="btn btn-success" name="reservaHuesped">Seleccionar</button>
                                                </form>                                                
                                            </td>     
                                            
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
        <%}%>
    </body>
</html>

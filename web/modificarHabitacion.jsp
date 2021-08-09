<%@page import="Logica.Habitacion"%>
<%@page import="Logica.Controladora"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>RSVATION</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="css/estilos.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <!--Verifica si existe una sesion-->
       <%  HttpSession mi_session = request.getSession();
          //Aca compruebo que exista un usuario que haya iniciado sesion, sino voy al login
          String usuario = (String) mi_session.getAttribute("usuario");
          if(usuario == null){
              response.sendRedirect("login.jsp");
          }else{
             
           %>
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
             <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.jsp">RSVATION</a>
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
                        <li><a class="dropdown-item" href="#!"><%=request.getSession().getAttribute("usuario") %></a></li>                        
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="SvLogout">Logout</a></li>
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
                                Empleado
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cargaEmpleado.jsp">Nuevo Empleado</a>
                                    <a class="nav-link" href="listaEmpleados.jsp">Lista empleados</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fa fa-users"></i></div>
                                Huesped
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                 <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cargaHuesped.jsp">Nuevo Huesped</a>
                                    <a class="nav-link" href="listaHuespedes.jsp">Lista huespedes</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages2" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fa fa-bed"></i></div>
                                Habitacion
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages2" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cargaHabitacion.jsp">Nuevo Habitacion</a>
                                    <a class="nav-link" href="listaHabitaciones.jsp">Lista Habitaciones</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages3" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fa fa-calendar"></i></div>
                                Reserva
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages3" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cargaReserva.jsp">Nuevo Reserva</a>
                                    <a class="nav-link" href="listaReservas.jsp">Lista Reservas</a>
                                    <a class="nav-link" href="listaReservasFechas.jsp">Lista por fecha</a>
                                    <a class="nav-link" href="listasReservasEmpleados.jsp">Lista por empleado</a>
                                    <a class="nav-link" href="listaReservasPeriodo.jsp">Lista huesped periodo</a>
                                </nav>
                            </div>

                            
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logueado como:</div>
                        <p><%=request.getSession().getAttribute("usuario") %></p>
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Bienvenido</h1>
                                             
                         <form action="SvModificarHabitacion" method="GET" class="row g-3">
                              <% HttpSession miSession = request.getSession();
                             Controladora control = new Controladora();
                                Habitacion habitacion = (Habitacion) miSession.getAttribute("habitacion");
                                {%>
                                <div class="col-md-6">
                                <label for="numero_habitacion">Numero de Habitacion</label>
                                <input type="number"  class="form-control" name="numero_habitacion" id="numero_habitacion" placeholder="Ingrese numero habitacion" max="15" value="<%=habitacion.getNumero_habitacion()%>" required>           
                              </div>
                              <div class="col-md-6">
                                <label for="numero_piso">Numero de Piso</label>
                                <input type="number"  class="form-control" name="numero_piso" id="numero_piso" placeholder="Ingrese numero de piso" max="15" value="<%=habitacion.getPiso()%>" required>           
                              </div>
                              <div class="col-md-6">
                                <label for="tipo_tematica">Tipo tematica</label>
                                <input type="text" class="form-control" name="tipo_tematica" id="tipo_tematica" placeholder="Ingrese tematica de habitacion" maxlength="35" value="<%=habitacion.getTipoTematica()%>" required>
                              </div> 
                              <div class="col-md-6">
                                <label for="precio_noche">Precio por noche</label>
                                <input type="number" class="form-control" name="precio_noche" id="precio_noche" placeholder="Ingrese precio por noche" min="1" max="1000000" value="<%=habitacion.getPrecioNoche()%>" required>
                              </div>                                  
                              <div class="col-12">                                 
                                <label for="tipo_habitacion">Tipo Habitacion</label>
                                <select name="tipo_habitacion" id="tipo_habitacion" required>
                                      <option value="single" 
                                              <%if(habitacion.getTipoHabitacion().equals("single"))
                                      {%> selected 
                                      <%}%>
                                      >Single</option>
                                      <option value="doble"
                                              <%if(habitacion.getTipoHabitacion().equals("doble"))
                                      {%> selected 
                                      <%}%>
                                      >Doble</option>
                                      <option value="triple"
                                              <%if(habitacion.getTipoHabitacion().equals("triple"))
                                      {%> selected 
                                      <%}%>
                                      >Triple</option>
                                      <option value="multiple"
                                              <%if(habitacion.getTipoHabitacion().equals("multiple"))
                                      {%> selected 
                                      <%}%>
                                      >Multiple</option>
                                </select>
                              </div>                                                         
                              <br> 
                              <div class="col-12">
                                <input type="hidden" name="id_habitacion" value="<%=habitacion.getId_habitacion()%>"
                              </div>
                              <div class="col text-center">       
                              <button type="submit" class="btn btn-primary btn-guardar" onclick="isEmptyCargaHabitacion()">Guardar</button>
                              </div>
                              <%}%>
                         </form>
                        
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; RSVATION 2021</div> 
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


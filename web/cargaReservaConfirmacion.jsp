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
        <title>RSVATION</title>
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
                        <h2 class="mt-4">Nueva Reserva/Confirmacion</h2>
                             <%
                                       List<Empleado> listaEmpleados = control.traerEmpleados(); 
                                       String nombreEmpleado="";                                      
                                        for(Empleado empleado : listaEmpleados){
                                            if(empleado.getUsuario().getNombre().equals(usuario)){
                                                nombreEmpleado = empleado.getApellido() + " " + empleado.getNombre();
                                               
                                            }
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
                         </div>                        
                         <hr>
                         <h3>Datos huesped</h3>                         
                        <div class="row g-3"> 
                         <% HttpSession miSession = request.getSession();                            
                                Huesped huesped = (Huesped) miSession.getAttribute("huespedFinal");
                                {%>
                              <div class="col-md-6">
                                <label for="nombre_huesped">Nombre Huesped</label>
                                <input type="text"  class="form-control" name="nombre_huesped" id="nombre_huesped" placeholder="Ingrese nombre" maxlength="35" value="<%=huesped.getNombre()%>" readonly>           
                              </div>
                              <div class="col-md-6">
                                <label for="apellido_huesped">Apellido</label>
                                <input type="text" class="form-control" name="apellido_huesped" id="apellido_huesped" placeholder="Ingrese apellido" maxlength="35" value="<%=huesped.getApellido()%>"readonly>
                              </div> 
                              <div class="col-md-6">
                                <label for="dni_huesped">DNI</label>
                                <input type="number" class="form-control" name="dni_huesped" id="dni_huesped" placeholder="Ingrese DNI" min="10000" max="100000000" value="<%=huesped.getDni()%>" readonly>
                              </div>
                              <div class="col-md-6">
                                <label for="direccion_huesped">Direccion</label>
                                <input type="text" class="form-control" name="direccion_huesped" id="direccion_huesped" placeholder="Ingrese direccion" maxlength="30" value="<%=huesped.getDireccion()%>"readonly>
                              </div>  
                        </div>
                         <%}%>
                         <hr>
                         <h3>Datos habitacion</h3>
                         <div class="row g-3">
                             <%                             
                                Habitacion habitacion = (Habitacion) miSession.getAttribute("habitacionFinal");
                                {%>
                                <div class="col-md-6">
                                <label for="numero_habitacion">Numero de Habitacion</label>
                                <input type="number"  class="form-control" name="numero_habitacion" id="numero_habitacion" placeholder="Ingrese numero habitacion" max="15" value="<%=habitacion.getNumero_habitacion()%>" readonly>           
                              </div>
                              <div class="col-md-6">
                                <label for="numero_piso">Numero de Piso</label>
                                <input type="number"  class="form-control" name="numero_piso" id="numero_piso" placeholder="Ingrese numero de piso" max="15" value="<%=habitacion.getPiso()%>" readonly>           
                              </div>
                              <div class="col-md-6">
                                <label for="tipo_tematica">Tipo tematica</label>
                                <input type="text" class="form-control" name="tipo_tematica" id="tipo_tematica" placeholder="Ingrese tematica de habitacion" maxlength="35" value="<%=habitacion.getTipoTematica()%>" readonly>
                              </div> 
                              <div class="col-md-6">
                                <label for="precio_noche">Precio por noche</label>
                                <input type="number" class="form-control" name="precio_noche" id="precio_noche" placeholder="Ingrese precio por noche" min="1" max="1000000" value="<%=habitacion.getPrecioNoche()%>" readonly>
                              </div>                                  
                              <div class="col-6">                                 
                                 <label for="tipo_habitacion">Tipo Habitacion</label>
                                <input type="text" class="form-control" name="tipo_habitacion" id="tipo_habitacion" placeholder="Ingrese precio por noche" min="1"  value="<%=habitacion.getTipoHabitacion()%>" readonly>            
                              <%}%>
                         </div>
                         <hr>
                         <form class="" method="POST" action="SvReservaFinal">
                         <div class="row g-3">
                               <div class="col-md-6">
                                <label for="fecha_ingreso">Fecha Check-in</label>
                                <input type="date" class="form-control" name="fecha_ingreso" id="fecha_ingreso" placeholder="Ingrese fecha de ingreso" required>
                              </div>                                  
                               <div class="col-md-6">
                                <label for="fecha_egreso">Fecha Check-out</label>
                                <input type="date" class="form-control" name="fecha_egreso" id="fecha_egreso" placeholder="Ingrese fecha de egreso" oninput="ingresoEgreso(this)" required>
                              </div> 
                              <div class="col-md-6">
                                <label for="cantidad_personas">Cantidad de personas</label>
                                <input type="number" class="form-control" name="cantidad_personas" id="cantidad_personas" placeholder="Ingrese cantidad personas" min="1" max="8" oninput="cantidad(this)" required>
                              </div>    
                              <div class="col-md-6"></div>
                              <div class="col-md-6">                                
                                <textarea class="form-control" placeholder="Observaciones" id="observaciones_reserva" name="observaciones_reserva" maxlength="60"></textarea>
                              </div>

                         </div>
                         <hr>
                         <div class="row g-3">
                                <div class="col-md-12">
                                  <%  boolean bandera =(Boolean) miSession.getAttribute("banderaFinal");%>
                                     <% String res=" ";

                                      if(bandera == false){
                                        res ="LA HABITACION NO ESTA DISPONIBLE EN ESTAS FECHAS. INTENTE DE NUEVO.";
                                      }
                                      
                                      
                                  %>
                                  <p class="col- 12 text-center p-footer-reserva"><%=res%></p>
                              </div>
                          </div>

                         <div class="row g-3">
                            <div class="col-md-6 text-center" >
                              <a class="btn btn-danger" href="index.jsp">Cancelar</a>                              
                            </div>
                            <div class="col-md-6 text-center">
                                <input type="hidden" name="idHuespedFinal" value="<%=huesped.getId_persona()%>">
                                <input type="hidden" name="idHabitacionFinal" value="<%=habitacion. getId_habitacion()%>">
                                <%  Empleado empleado = (Empleado) miSession.getAttribute("empleadoFinal");%>
                                <input type="hidden" name="idEmpleadoFinal" value="<%=empleado.getId_persona()%>">
                                <button type="submit" class="btn btn-success" onClick="isEmptyCargaReserva()">Reservar</button>
                            </div>                            
                         </div>
                         </form>
                         <br>
                         <div class="row g-3">
                         </div>

                              
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

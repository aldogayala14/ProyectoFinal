<%@page import="Logica.Controladora"%>
<%@page import="Logica.Empleado"%>
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
                                Empleado
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cargaEmpleado.jsp">Nuevo Empleado</a>
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
                        <h2 class="mt-4">Carga Empleados</h2>
                                             
                         <form action="SvModificarEmpleado" method="GET" class="row g-3">
                             <% HttpSession miSession = request.getSession();
                             Controladora control = new Controladora();
                                Empleado empleado = (Empleado) miSession.getAttribute("empleado");
                                {%>
                              <div class="col-md-6">
                                <label for="nombre_empleado">Nombre</label>
                                <input type="text"  class="form-control" name="nombre_empleado" id="nombre_empleado" placeholder="Ingrese nombre" maxlength="35" value="<%=empleado.getNombre()%>" required>           
                              </div>
                              <div class="col-md-6">
                                <label for="apellido_empleado">Apellido</label>
                                <input type="text" class="form-control" name="apellido_empleado" id="apellido_empleado" placeholder="Ingrese apellido" maxlength="35" value="<%=empleado.getApellido()%>" required>
                              </div> 
                              <div class="col-md-6">
                                <label for="dni_empleado">DNI</label>
                                <input type="number" class="form-control" name="dni_empleado" id="dni_empleado" placeholder="Ingrese DNI" min="10000" max="100000000" value="<%=empleado.getDni()%>"required>
                              </div>
                              <div class="col-md-6">
                                <label for="direccion_empleado">Direccion</label>
                                <input type="text" class="form-control" name="direccion_empleado" id="direccion_empleado" placeholder="Ingrese direccion" maxlength="30"  value="<%=empleado.getDireccion()%>" required>
                              </div>  
                              <div class="col-md-6">
                                <label for="fechaNac_empleado">Fecha Nacimiento</label>
                                <input type="date" class="form-control" name="fechaNac_empleado" id="fechaNac_empleado" placeholder="Ingrese fecha nacimiento" value="<%=control.convertDateToStringCalendar(empleado.getFechaNac())%>" required>
                              </div>
                              <div class="col-md-6">
                                <label for="cargo_empleado">Cargo</label>
                                <input type="text" class="form-control" name="cargo_empleado" id="cargo_empleado" placeholder="Ingrese cargo del empleado" maxlength="20"  value="<%=empleado.getCargo()%>"required>
                              </div>   
                              <div class="col-12">
                                <input type="hidden" name="id_empleado" value="<%=empleado.getId_persona()%>"
                              </div>                             
                              <div class="col-12 text-center">       
                              <button type="submit" class="btn btn-primary btn-guardar">Modificar</button>
                              </div>
                              <%}%>
                         </form>

                         
                        
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
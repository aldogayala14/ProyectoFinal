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
                                <div class="sb-nav-link-icon"><i class="fa fa-bed"></i></div>
                                Habitacion
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="cargaHabitacion.jsp">Nueva Habitacion</a> 
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
                        <h1 class="mt-4">Bienvenido</h1>
                                             
                         <form action="SvHabitacion" method="POST">
                              <div class="form-group">
                                <label for="numero_piso">Numero de Piso</label>
                                <input type="number"  class="form-control" name="numero_piso" id="numero_piso" placeholder="Ingrese numero de piso" max="15" required>           
                              </div>
                              <div class="form-group">
                                <label for="tipo_tematica">Tipo tematica</label>
                                <input type="text" class="form-control" name="tipo_tematica" id="tipo_tematica" placeholder="Ingrese tematica de habitacion" maxlength="35" required>
                              </div> 
                              <div class="form-group">
                                <label for="precio_noche">Precio por noche</label>
                                <input type="number" class="form-control" name="precio_noche" id="precio_noche" placeholder="Ingrese precio por noche" min="1" max="1000000" required>
                              </div>
                              <div class="form-group">
                                <label for="tipo_habitacion">Tipo Habitacion</label>
                                <select name="tipo_habitacion" id="tipo_habitacion" required>
                                      <option value="single" selected>Single</option>
                                      <option value="doble">Doble</option>
                                      <option value="triple">Triple</option>
                                      <option value="multiple">Multiple</option>
                                </select>
                              </div>  
                              <div class="form-group">
                                <label for="cantidad_personas">Cantidad Personas</label>
                                <input type="number" class="form-control" name="cantidad_personas" id="cantidad_personas" placeholder="Ingrese cantidad de personas" max="8" required>
                              </div>                              
                              <br> 
                              <div class="col text-center">       
                              <button type="submit" class="btn btn-primary btn-guardar">Guardar</button>
                              </div>
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


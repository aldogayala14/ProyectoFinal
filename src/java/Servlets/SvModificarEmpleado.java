package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvModificarEmpleado", urlPatterns = {"/SvModificarEmpleado"})
public class SvModificarEmpleado extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        long id = Long.parseLong(request.getParameter("id_empleado"));
        
        String nombre=request.getParameter("nombre_empleado");
        String apellido=request.getParameter("apellido_empleado");
        String dni =  request.getParameter("dni_empleado");
        String direccion = request.getParameter("direccion_empleado");
        String fechaNacimiento = request.getParameter("fechaNac_empleado");
        String cargo = request.getParameter("cargo_empleado");
        
                
        //traigo la sesion y asigno los atributos para abrir en caulquier JSP
        request.getSession().setAttribute("nombre_empleado", nombre);
        request.getSession().setAttribute("apellido_empleado", apellido);
        request.getSession().setAttribute("dni_empleado", dni);
        request.getSession().setAttribute("direccion_empleado", direccion);
        request.getSession().setAttribute("fechaNac_empleado", fechaNacimiento);
        request.getSession().setAttribute("cargo_empleado", cargo);
        
        
        //conecto con la logica
        Controladora control = new Controladora();   
        
        Empleado empleado = control.buscarEmpleado(id);
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDni(dni);
        empleado.setDireccion(direccion);
        Date fecha = control.convertStringToDate(fechaNacimiento);
        empleado.setFechaNac(fecha);
        empleado.setCargo(cargo);
        
        
        control.modificarEmpleado(empleado);
        
        //Actualizo la losta de personas
        request.getSession().setAttribute("listaEmpleados",control.traerEmpleados());
        response.sendRedirect("listaEmpleados.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long id= Long.parseLong(request.getParameter("id_empleado"));
        Controladora control = new Controladora();
        Empleado empleado = control.buscarEmpleado(id);
        
        HttpSession miSession = request.getSession();
        miSession.setAttribute("empleado", empleado);
        response.sendRedirect("modificarEmpleado.jsp");
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

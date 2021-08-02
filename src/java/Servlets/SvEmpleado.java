package Servlets;

import Logica.Controladora;
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvEmpleado", urlPatterns = {"/SvEmpleado"})
public class SvEmpleado extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
        }
    }

 
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        //Traigo los datos del JSP
        String nombre=request.getParameter("nombre_empleado");
        String apellido=request.getParameter("apellido_empleado");
        String dni =  request.getParameter("dni_empleado");
        String direccion = request.getParameter("direccion_empleado");
        String fechaNacimiento = request.getParameter("fechaNac_empleado");
        String cargo = request.getParameter("cargo_empleado");
        
        String usuario = request.getParameter("usuario_empleado");
        String password = request.getParameter("password_empleado");
        
        //traigo la sesion y asigno los atributos para abrir en caulquier JSP
        request.getSession().setAttribute("nombre_empleado", nombre);
        request.getSession().setAttribute("apellido_empleado", apellido);
        request.getSession().setAttribute("dni_empleado", dni);
        request.getSession().setAttribute("direccion_empleado", direccion);
        request.getSession().setAttribute("fechaNac_empleado", fechaNacimiento);
        request.getSession().setAttribute("cargo_empleado", cargo);
        
        request.getSession().setAttribute("usuario_empleado", usuario);
        request.getSession().setAttribute("password_empleado", password);
        
        //conecto con la logica
        Controladora control = new Controladora();        
        //Creo un empleado a traves de la controladora        
      
         control.crearUsuario(nombre,apellido, dni, direccion, Date.valueOf(fechaNacimiento), cargo, usuario,password);
       
        
        
        
        //armar la respuesta
        response.sendRedirect("index.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

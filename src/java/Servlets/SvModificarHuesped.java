package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Huesped;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvModificarHuesped", urlPatterns = {"/SvModificarHuesped"})
public class SvModificarHuesped extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
        }
    }

   
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        long id = Long.parseLong(request.getParameter("id_huesped"));
        
        String nombre=request.getParameter("nombre_huesped");
        String apellido=request.getParameter("apellido_huesped");
        String dni =  request.getParameter("dni_huesped");
        String direccion = request.getParameter("direccion_huesped");
        String fechaNacimiento = request.getParameter("fechaNac_huesped");
        String profesion = request.getParameter("profesion_huesped");
        
                
        //traigo la sesion y asigno los atributos para abrir en caulquier JSP
        request.getSession().setAttribute("nombre_huesped", nombre);
        request.getSession().setAttribute("apellido_huesped", apellido);
        request.getSession().setAttribute("dni_huesped", dni);
        request.getSession().setAttribute("direccion_huesped", direccion);
        request.getSession().setAttribute("fechaNac_huesped", fechaNacimiento);
        request.getSession().setAttribute("profesion_huesped", profesion);
        
        
        //conecto con la logica
        Controladora control = new Controladora();   
        
       Huesped huesped = control.buscarHuesped(id);
        huesped.setNombre(nombre);
        huesped.setApellido(apellido);
        huesped.setDni(dni);
        huesped.setDireccion(direccion);
        Date fecha = control.convertStringToDate(fechaNacimiento);
        huesped.setFechaNac(fecha);
        huesped.setProfesion(profesion);
        
        
        control.modificarHuesped(huesped);
        
        //Actualizo la losta de personas
        request.getSession().setAttribute("listaHuespedes",control.traerHuespedes());
        response.sendRedirect("listaHuespedes.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long id= Long.parseLong(request.getParameter("id_huesped"));
        Controladora control = new Controladora();
        Huesped huesped = control.buscarHuesped(id);
        
        HttpSession miSession = request.getSession();
        miSession.setAttribute("huesped", huesped);
        response.sendRedirect("modificarHuesped.jsp");
       
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

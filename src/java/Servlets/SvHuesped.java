package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvHuesped", urlPatterns = {"/SvHuesped"})
public class SvHuesped extends HttpServlet {

   
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
        
        //Creo un alumno a traves de la controladora
       control.crearHuesped(profesion, dni, nombre, apellido, Date.valueOf(fechaNacimiento), direccion);
        
        //armar la respuestaS
        response.sendRedirect("index.jsp");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

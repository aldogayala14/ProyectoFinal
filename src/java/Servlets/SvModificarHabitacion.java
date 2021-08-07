package Servlets;

import Logica.Controladora;
import Logica.Habitacion;
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


@WebServlet(name = "SvModificarHabitacion", urlPatterns = {"/SvModificarHabitacion"})
public class SvModificarHabitacion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        long id = Long.parseLong(request.getParameter("id_habitacion"));
        
        int numeroHabitacion =Integer.parseInt(request.getParameter("numero_habitacion"));
        int numeroPiso =Integer.parseInt(request.getParameter("numero_piso"));
        String tipoTematica=request.getParameter("tipo_tematica");
        String tipoHabitacion =  request.getParameter("tipo_habitacion");       
        double precioNoche = Double.parseDouble(request.getParameter("precio_noche"));
       
        
                
        //traigo la sesion y asigno los atributos para abrir en caulquier JSP
        request.getSession().setAttribute("numero_habitacion", numeroHabitacion);
        request.getSession().setAttribute("numero_piso", numeroPiso);
        request.getSession().setAttribute("tipo_tematica", tipoTematica);
        request.getSession().setAttribute("tipo_habitacion", tipoHabitacion);        
        request.getSession().setAttribute("precio_noche", precioNoche);
        
        
        //conecto con la logica
        Controladora control = new Controladora();   
        
       Habitacion habitacion = control.buscarHabitacion(id);
       habitacion.setNumero_habitacion(numeroHabitacion);
       habitacion.setPiso(numeroPiso);
       habitacion.setTipoTematica(tipoTematica);
       habitacion.setTipoHabitacion(tipoHabitacion);      
       habitacion.setPrecioNoche(precioNoche);
        
        
        control.modificarHabitacion(habitacion);
        
        //Actualizo la losta de personas
        request.getSession().setAttribute("listaHabitaciones",control.traerHabitaciones());
        response.sendRedirect("listaHabitaciones.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         long id= Long.parseLong(request.getParameter("id_habitacion"));
        Controladora control = new Controladora();
       Habitacion habitacion = control.buscarHabitacion(id);
        
        HttpSession miSession = request.getSession();
        miSession.setAttribute("habitacion", habitacion);
        response.sendRedirect("modificarHabitacion.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

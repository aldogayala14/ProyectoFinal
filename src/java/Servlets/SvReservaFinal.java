package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvReservaFinal", urlPatterns = {"/SvReservaFinal"})
public class SvReservaFinal extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         
       
         long idHuesped= Long.parseLong(request.getParameter("idHuespedFinal"));
         long idHabitacion= Long.parseLong(request.getParameter("idHabitacionFinal"));
         long idEmpleado= Long.parseLong(request.getParameter("idEmpleadoFinal"));
         String fecha_ingreso = request.getParameter("fecha_ingreso");
         String fecha_egreso = request.getParameter("fecha_egreso");
         int cantPersonas = Integer.parseInt(request.getParameter("cantidad_personas"));         
         String observaciones = request.getParameter("observaciones_reserva");
         
                  
        Controladora control = new Controladora();
                  
         control.crearReserva(idHuesped,idHabitacion,idEmpleado,fecha_ingreso,fecha_egreso, cantPersonas,observaciones);
         
         //armar la respuestaS
        response.sendRedirect("index.jsp");
        
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

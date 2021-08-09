package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvModificarReserva", urlPatterns = {"/SvModificarReserva"})
public class SvModificarReserva extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
        long idReserva = Long.parseLong(request.getParameter("idReservaModificar"));
        long idEmpleado = Long.parseLong(request.getParameter("idEmpleadoModificar"));
        long idHuesped = Long.parseLong(request.getParameter("idHuespedModificar"));
        long idHabitacion = Long.parseLong(request.getParameter("idHabitacionModificar"));
         
        String fecha_ingreso = request.getParameter("fecha_ingreso");
        String fecha_egreso = request.getParameter("fecha_egreso");
        int cantPersonas = Integer.parseInt(request.getParameter("cantidad_personas"));
        String observaciones = request.getParameter("observaciones_reserva");
        
                
        Controladora control = new Controladora();
        
        Reserva reserva = control.buscarReserva(idReserva);
        Empleado empleado = control.buscarEmpleado(idEmpleado);
        Huesped huesped = control.buscarHuesped(idHuesped);
        Habitacion habitacion = control.buscarHabitacion(idHabitacion);
        
        reserva.setEmpleado(empleado);
        reserva.setHuesped(huesped);
        reserva.setHabitacion(habitacion);
        reserva.setCantPersonas(cantPersonas);
        reserva.setObservaciones(observaciones);
        reserva.setFecha_checkIn(control.convertStringToDate(fecha_ingreso));
        reserva.setFecha_checkOut(control.convertStringToDate(fecha_egreso));

        
       
        control.modificarReserva(reserva);
        
        //Actualizo la lista de reservas
        request.getSession().setAttribute("listaReservas",control.traerReservas());
        response.sendRedirect("listaReservas.jsp");
       
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         long id= Long.parseLong(request.getParameter("id_reserva"));
        Controladora control = new Controladora();
        Reserva reserva = control.buscarReserva(id);
        
        HttpSession miSession = request.getSession();
        miSession.setAttribute("reserva", reserva);
        response.sendRedirect("modificarReserva.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

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
import javax.servlet.http.HttpSession;

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

        long idHuesped = Long.parseLong(request.getParameter("idHuespedFinal"));
        long idHabitacion = Long.parseLong(request.getParameter("idHabitacionFinal"));
        long idEmpleado = Long.parseLong(request.getParameter("idEmpleadoFinal"));
        String fecha_ingreso = request.getParameter("fecha_ingreso");
        String fecha_egreso = request.getParameter("fecha_egreso");
        int cantPersonas = Integer.parseInt(request.getParameter("cantidad_personas"));
        String observaciones = request.getParameter("observaciones_reserva");

        Controladora control = new Controladora();

        boolean bandera = control.fechaReserva(idHabitacion, fecha_ingreso, fecha_egreso);
        if (bandera == true) {

            control.crearReserva(idHuesped, idHabitacion, idEmpleado, fecha_ingreso, fecha_egreso, cantPersonas, observaciones);
            //armar la respuestaS
             HttpSession miSession = request.getSession();
            request.getSession().setAttribute("id_huesped_com", idHuesped);
            request.getSession().setAttribute("id_habitacion_com", idHabitacion);
            request.getSession().setAttribute("id_empleado_com", idEmpleado);
            request.getSession().setAttribute("fecha_ingreso_com",fecha_ingreso);
            request.getSession().setAttribute("fecha_egreso_com", fecha_egreso);
            request.getSession().setAttribute("cantidad_personas_com", cantPersonas);
            
            response.sendRedirect("comprobante.jsp");
            System.out.println("true");

        } else {
            System.out.println("false");
            boolean banderaParametro = false;
            HttpSession miSession = request.getSession();
            request.getSession().setAttribute("banderaFinal", banderaParametro);

            response.sendRedirect("cargaReservaConfirmacion.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

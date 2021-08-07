package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvReserva", urlPatterns = {"/SvReserva"})
public class SvReserva extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long idHuesped = Long.parseLong(request.getParameter("id_huespedReservaConfirm"));
        long idHabitacion = Long.parseLong(request.getParameter("id_habitacionReservaConfirm"));
        long idEmpleado = Long.parseLong(request.getParameter("id_empleadoReservaConfirm"));
        Controladora control = new Controladora();
        Huesped huesped = control.buscarHuesped(idHuesped);
        Habitacion habitacion = control.buscarHabitacion(idHabitacion);
        Empleado empleado = control.buscarEmpleado(idEmpleado);

        HttpSession miSession = request.getSession();
        miSession.setAttribute("huespedFinal", huesped);
        miSession.setAttribute("habitacionFinal", habitacion);
         miSession.setAttribute("empleadoFinal", empleado);
        response.sendRedirect("cargaReservaConfirmacion.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idReservaHuesped = request.getParameter("id_huespedReserva");
        String idReservaEmpleado = request.getParameter("id_empleadoReserva");
        HttpSession miSession = request.getSession();
        miSession.setAttribute("id_huespedReservaHab", idReservaHuesped);
        miSession.setAttribute("id_empleadoReservaHab", idReservaEmpleado);
        response.sendRedirect("cargaReservaHabitacion.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


package Servlets;

import Logica.Controladora;
import Logica.Huesped;
import Logica.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvListaPeriodo", urlPatterns = {"/SvListaPeriodo"})
public class SvListaPeriodo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         long idHuesped = Long.parseLong(request.getParameter("id_huesped_periodo_final"));
         String fechaInicio = request.getParameter("fecha_inicio");
         String fechaFin = request.getParameter("fecha_fin");
         
         
         Controladora control = new Controladora();
         
         List<Reserva> listaReservas = control.isInPeriodo(idHuesped, fechaInicio, fechaFin);
         
         HttpSession miSession = request.getSession();       
        miSession.setAttribute("listaReservasPeriodo", listaReservas);
        response.sendRedirect("listaReservasPeriodoFinal.jsp");
         
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         long idHuesped = Long.parseLong(request.getParameter("id_huesped_periodo"));
        //Actualizar la lista
        
        Controladora control =new Controladora();
        
        Huesped huesped = control.buscarHuesped(idHuesped);
        HttpSession miSession = request.getSession();       
        miSession.setAttribute("huesped_periodo", huesped);
        response.sendRedirect("listaReservasPeriodoDos.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

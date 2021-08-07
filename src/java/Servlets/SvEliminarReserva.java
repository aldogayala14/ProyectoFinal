package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvEliminarReserva", urlPatterns = {"/SvEliminarReserva"})
public class SvEliminarReserva extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           //Traigo las id
        long id = Long.parseLong(request.getParameter("id_reserva"));
       
                
        //conecto con la logica
        Controladora control = new Controladora();
        
        //Elimino a traves de la controladora
        control.borrarReserva(id);
        
        //Actualizar la lista
        request.setAttribute("listaReservas", control.traerReservas());
        response.sendRedirect("listaReservas.jsp");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

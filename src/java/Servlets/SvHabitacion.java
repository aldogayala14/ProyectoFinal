package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvHabitacion", urlPatterns = {"/SvHabitacion"})
public class SvHabitacion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        }
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int numeroPiso= Integer.parseInt(request.getParameter("numero_piso"));
        String tipoTematica=request.getParameter("tipo_tematica");
        double precioPorNoche = Double.parseDouble(request.getParameter("precio_noche"));
        String tipoHabitacion = request.getParameter("tipo_habitacion");
        int cantPersonas = Integer.parseInt(request.getParameter("cantidad_personas"));
       
        
        //traigo la sesion y asigno los atributos para abrir en caulquier JSP
        request.getSession().setAttribute("numero_piso", numeroPiso);
        request.getSession().setAttribute("tipo_tematica", tipoTematica);
        request.getSession().setAttribute("precio_noche", precioPorNoche);
        request.getSession().setAttribute("tipo_habitacion", tipoHabitacion);
        request.getSession().setAttribute("cantidad_personas", cantPersonas);
        
        //conecto con la logica
        Controladora control = new Controladora();
        
        //Creo una habitacion a traves de la controladora
        control.crearHabitacion(numeroPiso, tipoTematica, precioPorNoche, tipoHabitacion, cantPersonas);
        
        //armar la respuestaS
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

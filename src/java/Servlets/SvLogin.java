package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

       protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
        }
    }

    
  
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       String usuario = request.getParameter("usuario");
       String password= request.getParameter("password");
       
       Controladora control = new Controladora();
       
       boolean autorizado = control.verificarUsuario(usuario,password);
       
       if(autorizado == true){
           //obtengo la sesion y la asigno el usario y contraseña para validar
           HttpSession miSession = request.getSession(true);
           miSession.setAttribute("usuario", usuario);
           miSession.setAttribute("password", password);
           
           response.sendRedirect("index.jsp");
       }else{
           response.sendRedirect("login.jsp");
       }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

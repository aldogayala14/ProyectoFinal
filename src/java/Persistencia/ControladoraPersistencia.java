package Persistencia;

import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    
    
    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();
    HabitacionJpaController habitacionJpa = new HabitacionJpaController();
    HuespedJpaController huespedJpa = new HuespedJpaController();   
    ReservaJpaController reservaJpa = new ReservaJpaController();    
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    
   
  

    public void crearHuesped(Huesped huesped) {
       
        try {
           huespedJpa.create(huesped);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void crearEmpleado(Empleado empleado) {
        try {
            
            empleadoJpa.create(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void crearHabitacion(Habitacion habitacion) {
         try {
            habitacionJpa.create(habitacion);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public List<Empleado> traerEmpleados() {
        List<Empleado> listaEmpleados;
        listaEmpleados = empleadoJpa.findEmpleadoEntities();
        return listaEmpleados;
    }

    public List<Usuario> traerUsuarios() {
        List<Usuario> listaUsuarios;
        listaUsuarios = usuarioJpa.findUsuarioEntities();
        return listaUsuarios;
    }

   

    

   
   
}

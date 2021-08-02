package Logica;

import Persistencia.ControladoraPersistencia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Controladora {

    ControladoraPersistencia controlPersi = new ControladoraPersistencia();
    

    

    public void crearHuesped(String profesion, String dni, String nombre, String apellido, Date fechaNac, String direccion) {
        Huesped huesped = new Huesped();
        huesped.setProfesion(profesion);
        huesped.setDni(dni);
        huesped.setNombre(nombre);
        huesped.setApellido(apellido);
        huesped.setFechaNac(fechaNac);
        huesped.setDireccion(direccion);      
       
        

        controlPersi.crearHuesped(huesped);
    }


    public void crearHabitacion(int numeroPiso, String tipoTematica, double precioPorNoche, String tipoHabitacion, int cantPersonas) {
       Habitacion habitacion = new Habitacion();
       habitacion.setPiso(numeroPiso);
       habitacion.setTipoTematica(tipoTematica);
       habitacion.setPrecioNoche(precioPorNoche);
       habitacion.setTipoHabitacion(tipoHabitacion);
       habitacion.setCantPersonas(cantPersonas);
       
       controlPersi.crearHabitacion(habitacion);
    }

       
    public List<Empleado> traerEmpleados(){
        return controlPersi.traerEmpleados();
    }

    public boolean verificarUsuario(String usuario, String password) {
        List<Usuario> listaUsuarios = controlPersi.traerUsuarios();
        
        if(listaUsuarios !=null){
            
            for(Usuario user : listaUsuarios){
                
                if(user.getNombre().equals(usuario) && user.getPassword().equals(password)){
                    return true;
                }
            }
            
            
        }
        
        return false;
    }

    public void crearUsuario(String nombre, String apellido, String dni, String direccion, Date fechaNacimiento, String cargo, String usuario, String password){
        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDni(dni);
        empleado.setDireccion(direccion);          
        empleado.setFechaNac(fechaNacimiento);
        empleado.setCargo(cargo);
        Usuario user = new Usuario();
        user.setNombre(usuario);
        user.setPassword(password);
        
       
        empleado.setUsuario(user);
        user.setEmpleado(empleado);
        
        
        
        controlPersi.crearEmpleado(empleado);
        
    }

  

}

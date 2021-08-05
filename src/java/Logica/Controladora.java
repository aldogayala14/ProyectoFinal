package Logica;

import Persistencia.ControladoraPersistencia;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controladora {

    ControladoraPersistencia controlPersi = new ControladoraPersistencia();

    public void crearUsuario(String nombre, String apellido, String dni, String direccion, String fechaNacimiento, String cargo, String usuario, String password) {
        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDni(dni);
        empleado.setDireccion(direccion);
        empleado.setFechaNac(convertStringToDate(fechaNacimiento));
        empleado.setCargo(cargo);
        Usuario user = new Usuario();
        user.setNombre(usuario);
        user.setPassword(password);

        empleado.setUsuario(user);
        user.setEmpleado(empleado);

        controlPersi.crearEmpleado(empleado);

    }

    public void crearHuesped(String profesion, String dni, String nombre, String apellido, String fechaNac, String direccion) {
        Huesped huesped = new Huesped();
        huesped.setProfesion(profesion);
        huesped.setDni(dni);
        huesped.setNombre(nombre);
        huesped.setApellido(apellido);
        huesped.setFechaNac(convertStringToDate(fechaNac));
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

    public List<Empleado> traerEmpleados() {
        return controlPersi.traerEmpleados();
    }

    public List<Huesped> traerHuespedes() {
        return controlPersi.traerHuespedes();
    }

    public List<Habitacion> traerHabitaciones() {
        return controlPersi.traerHabitaciones();
    }

    public boolean verificarUsuario(String usuario, String password) {
        List<Usuario> listaUsuarios = controlPersi.traerUsuarios();

        if (listaUsuarios != null) {

            for (Usuario user : listaUsuarios) {

                if (user.getNombre().equals(usuario) && user.getPassword().equals(password)) {
                    return true;
                }
            }

        }

        return false;
    }

    public void borrarEmpleado(long id) {
        controlPersi.borrarEmpleado(id);
    }

    public void borrarHuesped(long id) {
        controlPersi.borrarHuesped(id);
    }

    public void borrarHabitacion(long id) {
        controlPersi.borrarHabitaciones(id);
    }

    public Empleado buscarEmpleado(long id) {
        return controlPersi.buscarEmpleado(id);
    }

    public Huesped buscarHuesped(long id) {
        return controlPersi.buscarHuesped(id);
    }

    public Habitacion buscarHabitacion(long id) {
        return controlPersi.buscarHabitacion(id);
    }

    public void modificarEmpleado(Empleado empleado) {
        controlPersi.modificarEmpleado(empleado);
    }

    public void modificarHuesped(Huesped huesped) {
        controlPersi.modificarHuesped(huesped);
    }

    public void modificarHabitacion(Habitacion habitacion) {
        controlPersi.modificarHabitacion(habitacion);
    }

    /*Metodos de parseo de fechas*/
    public String convertDateToString(Date fecha) {
        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        String sfecha = df.format(fecha);

        return sfecha;
    }

    public String convertDateToStringCalendar(Date fecha) {
        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        String sfecha = df.format(fecha);

        return sfecha;
    }

    public Date convertStringToDate(String fecha) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = df.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        String newDateString = df.format(date);

        return date;
    }

    public String selectedValue(String res) {
        String value = "";
        switch (res) {
            case "single":
                value = "0";
                break;
            case "doble":
                value = "1";
                break;
            case "triple":
                value="2";
                break;
            case "multiple":
                value="3";
                break;
            default:
                value="0";
                break;                
        }
        
        return value;
    }

}

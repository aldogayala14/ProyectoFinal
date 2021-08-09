package Logica;

import Persistencia.ControladoraPersistencia;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controladora {

    ControladoraPersistencia controlPersi = new ControladoraPersistencia();
    ArrayList<Reserva> listaReserva = new ArrayList<Reserva>();

    public void cargarDatos() {

        //Cargo mi usuario predeterminado        
        Date date = new Date();

        Empleado empleado = new Empleado();
        empleado.setNombre("Admin");
        empleado.setApellido("Admin");
        empleado.setDni("none");
        empleado.setDireccion("none");

        empleado.setFechaNac(date);
        empleado.setCargo("none");
        Usuario user = new Usuario();
        user.setNombre("admin");
        user.setPassword("123");

        empleado.setUsuario(user);
        user.setEmpleado(empleado);

        controlPersi.crearEmpleado(empleado);

        //Cargo huespedes
        Huesped huesped = new Huesped();
        huesped.setProfesion("Estudiante");
        huesped.setDni("35741789");
        huesped.setNombre("Juan");
        huesped.setApellido("Comino");
        huesped.setFechaNac(date);
        huesped.setDireccion("Paravachasca 123");

        controlPersi.crearHuesped(huesped);

        Huesped huesped2 = new Huesped();
        huesped2.setProfesion("Abogada");
        huesped2.setDni("35254789");
        huesped2.setNombre("Lucia");
        huesped2.setApellido("Martinez");
        huesped2.setFechaNac(date);
        huesped2.setDireccion("Liniers 444");

        controlPersi.crearHuesped(huesped2);

        Huesped huesped3 = new Huesped();
        huesped3.setProfesion("Ingerniero");
        huesped3.setDni("27254789");
        huesped3.setNombre("Roberto");
        huesped3.setApellido("Gomez");
        huesped3.setFechaNac(date);
        huesped3.setDireccion("Aconcagua 555");

        controlPersi.crearHuesped(huesped3);

        //Cargo habitaciones
        Habitacion habitacion1 = new Habitacion();
        habitacion1.setNumero_habitacion(1);
        habitacion1.setPiso(1);
        habitacion1.setTipoTematica("Clasica");
        habitacion1.setPrecioNoche(1200);
        habitacion1.setTipoHabitacion("single");

        controlPersi.crearHabitacion(habitacion1);

        Habitacion habitacion2 = new Habitacion();
        habitacion2.setNumero_habitacion(2);
        habitacion2.setPiso(1);
        habitacion2.setTipoTematica("Infantil");
        habitacion2.setPrecioNoche(1800);
        habitacion2.setTipoHabitacion("doble");

        controlPersi.crearHabitacion(habitacion2);

        Habitacion habitacion3 = new Habitacion();
        habitacion3.setNumero_habitacion(1);
        habitacion3.setPiso(1);
        habitacion3.setTipoTematica("Moderna");
        habitacion3.setPrecioNoche(2500);
        habitacion3.setTipoHabitacion("triple");

        controlPersi.crearHabitacion(habitacion1);

        //Creo una reserva
        Reserva reserva = new Reserva();
        reserva.setFecha_checkIn(date);
        reserva.setFecha_checkOut(date);
        reserva.setCantPersonas(1);
        reserva.setObservaciones("Agua mineral");
        reserva.setEmpleado(empleado);
        reserva.setHuesped(huesped);
        reserva.setHabitacion(habitacion1);

        controlPersi.crearReserva(reserva);

    }

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

    public void crearHabitacion(int numeroHabitacion, int numeroPiso, String tipoTematica, double precioPorNoche, String tipoHabitacion) {
        Habitacion habitacion = new Habitacion();
        habitacion.setNumero_habitacion(numeroHabitacion);
        habitacion.setPiso(numeroPiso);
        habitacion.setTipoTematica(tipoTematica);
        habitacion.setPrecioNoche(precioPorNoche);
        habitacion.setTipoHabitacion(tipoHabitacion);

        controlPersi.crearHabitacion(habitacion);
    }

    public void crearReserva(long idHuesped, long idHabitacion, long idEmpleado, String fecha_ingreso, String fecha_egreso, int cantidadPersonas, String observaciones) {

        //Instancio mis clases Empleado, Huesped y habitacion
        Empleado empl = (Empleado) buscarEmpleado(idEmpleado);

        Huesped hues = (Huesped) buscarHuesped(idHuesped);

        Habitacion hab = (Habitacion) buscarHabitacion(idHabitacion);

        //Aigno los atributos de reserva
        Reserva reserva = new Reserva();
        reserva.setFecha_checkIn(convertStringToDate(fecha_ingreso));
        reserva.setFecha_checkOut(convertStringToDate(fecha_egreso));
        reserva.setCantPersonas(cantidadPersonas);
        reserva.setObservaciones(observaciones);
        reserva.setEmpleado(empl);
        reserva.setHuesped(hues);
        reserva.setHabitacion(hab);

        //Guardo mi reserva
        controlPersi.crearReserva(reserva);

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

    public List<Reserva> traerReservas() {
        return controlPersi.traerReservas();
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

    public void borrarReserva(long id) {
        controlPersi.borrarReservas(id);
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
    
    public Reserva buscarReserva(long id) {
       return controlPersi.buscarReserva(id);
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
    
    public void modificarReserva(Reserva reserva) {
       controlPersi.modificarReserva(reserva);
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
                value = "2";
                break;
            case "multiple":
                value = "3";
                break;
            default:
                value = "0";
                break;
        }

        return value;
    }

    public boolean fechaReserva(long idHabitacion, String fechaNuevoIngreso, String fechaNuevoEgreso) {
        boolean flag = true;
        System.out.println("Id HABITACION RESERVA" + idHabitacion);
        Date dateIngreso = convertStringToDate(fechaNuevoIngreso);
        Date dateEgreso = convertStringToDate(fechaNuevoEgreso);
        List<Reserva> listaReservas = traerReservas();

        for (Reserva reserva : listaReservas) {

            if (reserva.getHabitacion().getId_habitacion() == idHabitacion) {
                if ((dateIngreso.after(reserva.getFecha_checkIn()) && dateIngreso.before(reserva.getFecha_checkOut())) || (dateEgreso.after(reserva.getFecha_checkIn()) && dateEgreso.before(reserva.getFecha_checkOut()))) {
                    flag = false;
                } else if (dateIngreso.equals(reserva.getFecha_checkIn())) {
                    flag = false;
                } else if (dateIngreso.equals(reserva.getFecha_checkOut())) {
                    flag = false;
                }
            }

        }

        return flag;
    }
    
    public int cantDias(String fecha_ingreso, String fecha_egreso){
        int cant;
        Date fechaIngreso = convertStringToDate(fecha_ingreso);
        Date fechaEgreso = convertStringToDate(fecha_egreso);
        int milisecondsByDay = 86400000;
        cant = (int) ((fechaEgreso.getTime()-fechaIngreso.getTime()) / milisecondsByDay);
        
        
        return cant;
    }
    
    public List<Reserva> isInPeriodo(long id_huesped, String fecha_inicio, String fecha_fin){
        List<Reserva> listaReservas = traerReservas();
        List<Reserva> listaReservasHuesped = new ArrayList();
        Date fechaInicio = convertStringToDate(fecha_inicio);
        Date fechaFin = convertStringToDate(fecha_fin);
        
        for(Reserva reserva : listaReservas){
            if(reserva.getHuesped().getId_persona() == id_huesped){
                if(reserva.getFecha_checkIn().equals(fechaInicio) || reserva.getFecha_checkOut().equals(fecha_fin)){
                    listaReservasHuesped.add(reserva);
                }else if(reserva.getFecha_checkIn().after(fechaInicio) && reserva.getFecha_checkIn().before(fechaFin)){
                    listaReservasHuesped.add(reserva);
                }
            }
            
        }
        
        return listaReservasHuesped;
        
    }

    

    

}

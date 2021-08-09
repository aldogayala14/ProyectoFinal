package Persistencia;

import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;
import Logica.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
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

    public void crearReserva(Reserva reserva) {
        try {
            reservaJpa.create(reserva);
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

    public List<Huesped> traerHuespedes() {
        List<Huesped> listaHuespedes;
        listaHuespedes = huespedJpa.findHuespedEntities();
        return listaHuespedes;
    }

    public List<Habitacion> traerHabitaciones() {
        List<Habitacion> listaHabitaciones;
        listaHabitaciones = habitacionJpa.findHabitacionEntities();
        return listaHabitaciones;
    }

    public List<Reserva> traerReservas() {
        List<Reserva> listaReservas;
        listaReservas = reservaJpa.findReservaEntities();
        return listaReservas;
    }

    public void borrarEmpleado(long id) {
        try {
            empleadoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarHuesped(long id) {
        try {
            huespedJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarHabitaciones(long id) {
        try {
            habitacionJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarReservas(long id) {
        try {
            reservaJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Empleado buscarEmpleado(long id) {
        return empleadoJpa.findEmpleado(id);
    }

    public Huesped buscarHuesped(long id) {
        return huespedJpa.findHuesped(id);
    }

    public Habitacion buscarHabitacion(long id) {
        return habitacionJpa.findHabitacion(id);
    }

    public Reserva buscarReserva(long id) {
        return reservaJpa.findReserva(id);
    }

    public void modificarEmpleado(Empleado empleado) {
        try {
            empleadoJpa.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarHuesped(Huesped huesped) {
        try {
            huespedJpa.edit(huesped);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarHabitacion(Habitacion habitacion) {

        try {
            habitacionJpa.edit(habitacion);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public void modificarReserva(Reserva reserva) {
        try {
            reservaJpa.edit(reserva);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}

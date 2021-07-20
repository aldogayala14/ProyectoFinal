package Logica;

import java.util.Date;


public class Reserva {
    
    private int id_reserva;
    private Habitacion habitacion;
    private Huesped huesped;
    private Empleado empleado;
    private Date fecha_checkIn;
    private Date fecha_checkOut;

    public Reserva() {
    }

    public Reserva(int id_reserva, Habitacion habitacion, Huesped huesped, Empleado empleado, Date fecha_checkIn, Date fecha_checkOut) {
        this.id_reserva = id_reserva;
        this.habitacion = habitacion;
        this.huesped = huesped;
        this.empleado = empleado;
        this.fecha_checkIn = fecha_checkIn;
        this.fecha_checkOut = fecha_checkOut;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Date getFecha_checkIn() {
        return fecha_checkIn;
    }

    public void setFecha_checkIn(Date fecha_checkIn) {
        this.fecha_checkIn = fecha_checkIn;
    }

    public Date getFecha_checkOut() {
        return fecha_checkOut;
    }

    public void setFecha_checkOut(Date fecha_checkOut) {
        this.fecha_checkOut = fecha_checkOut;
    }
    
    
    
    
}

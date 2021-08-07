package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_reserva;

    @Temporal(TemporalType.DATE)
    private Date fecha_checkIn;
    @Temporal(TemporalType.DATE)
    private Date fecha_checkOut;

    @Basic
    private int cantPersonas;
    private String observaciones;
    
    @ManyToOne
    @JoinColumn(name = "id_empleado")    
    private Empleado empleado;
    @ManyToOne
    @JoinColumn(name = "id_huesped")
    private Huesped huesped;
    @ManyToOne
    @JoinColumn(name = "id_habitacion")
    private Habitacion habitacion;

    public Reserva() {
    }

    public Reserva(long id_reserva, Date fecha_checkIn, Date fecha_checkOut, int cantPersonas, String observaciones, Empleado empleado, Huesped huesped, Habitacion habitacion) {
        this.id_reserva = id_reserva;
        this.fecha_checkIn = fecha_checkIn;
        this.fecha_checkOut = fecha_checkOut;
        this.cantPersonas = cantPersonas;
        this.observaciones = observaciones;
        this.empleado = empleado;
        this.huesped = huesped;
        this.habitacion = habitacion;
    }

   

    public long getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(long id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
    

}

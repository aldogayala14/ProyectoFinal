package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private String observaciones;

    public Reserva() {
    }

    public Reserva(long id_reserva, String observaciones, Date fecha_checkIn, Date fecha_checkOut) {
        this.id_reserva = id_reserva;
        this.observaciones = observaciones;
        this.fecha_checkIn = fecha_checkIn;
        this.fecha_checkOut = fecha_checkOut;
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

}

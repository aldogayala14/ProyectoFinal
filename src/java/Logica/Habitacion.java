package Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Habitacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_habitacion;
    @Basic
    private int numero_habitacion;
    private int piso;
    private String tipoTematica;
    private double precioNoche;
    private String tipoHabitacion;
    
    @OneToMany(mappedBy = "habitacion")
    private List<Reserva> listaReservas;

    public Habitacion() {
    }

    public Habitacion(long id_habitacion, int numero_habitacion, int piso, String tipoTematica, double precioNoche, String tipoHabitacion, List<Reserva> listaReservas) {
        this.id_habitacion = id_habitacion;
        this.numero_habitacion = numero_habitacion;
        this.piso = piso;
        this.tipoTematica = tipoTematica;
        this.precioNoche = precioNoche;
        this.tipoHabitacion = tipoHabitacion;
        this.listaReservas = listaReservas;
    }

   

    public long getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(long id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public int getNumero_habitacion() {
        return numero_habitacion;
    }

    public void setNumero_habitacion(int numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getTipoTematica() {
        return tipoTematica;
    }

    public void setTipoTematica(String tipoTematica) {
        this.tipoTematica = tipoTematica;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }
    

}

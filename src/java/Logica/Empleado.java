package Logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Empleado extends Persona implements Serializable {

    @Basic
    private String cargo;
    @OneToOne(targetEntity=Usuario.class,cascade=CascadeType.ALL) 
    private Usuario usuario;
    @OneToMany
    private List<Reserva> listaReservas;

    public Empleado() {
    }

    public Empleado(String cargo, Usuario usuario, List<Reserva> listaReservas, long id_persona, String dni, String nombre, String apellido, String direccion, Date fechaNac) {
        super(id_persona, dni, nombre, apellido, direccion, fechaNac);
        this.cargo = cargo;
        this.usuario = usuario;
        this.listaReservas = listaReservas;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}

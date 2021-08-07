package Logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Huesped extends Persona implements Serializable {

    @Basic
    private String profesion;

    public Huesped() {
    }

    public Huesped(String profesion, long id_persona, String dni, String nombre, String apellido, String direccion, Date fechaNac) {
        super(id_persona, dni, nombre, apellido, direccion, fechaNac);
        this.profesion = profesion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

}

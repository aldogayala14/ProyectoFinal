package Logica;

import java.util.Date;


public class Huesped extends Persona{
    
    private String profesion;

    public Huesped() {
    }

    public Huesped(String profesion, int id_persona, String dni, String nombre, String apellido, Date fechaNac, String direccion) {
        super(id_persona, dni, nombre, apellido, fechaNac, direccion);
        this.profesion = profesion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    
    
}

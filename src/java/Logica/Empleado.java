
package Logica;

import java.util.Date;


public class Empleado extends Persona {
    private String cargo;

    public Empleado() {
    }

    public Empleado(String cargo, int id_persona, String dni, String nombre, String apellido, Date fechaNac, String direccion) {
        super(id_persona, dni, nombre, apellido, fechaNac, direccion);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    

   
    
    
}

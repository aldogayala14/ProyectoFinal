package Logica;


public class TipoHabitacion {
    private int id_tipo;
    private String nombre;
    private int cantPersonas;

    public TipoHabitacion() {
    }

    public TipoHabitacion(int id_tipo, String nombre, int cantPersonas) {
        this.id_tipo = id_tipo;
        this.nombre = nombre;
        this.cantPersonas = cantPersonas;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }
    
    
    
}

package proyecto;
/*
 * Clase que determina como funciona el seguimiento.
 * 
 * @author Alberto Zamora Landete
 * @version 21/02/2024.
 */
import java.util.*;
public class Seguimiento extends SistemaSeguridad {
    private String nombre, direccion;
    private ArrayList<Seguimiento> seguir = new ArrayList<Seguimiento>();
    //Contructor.
    public Seguimiento(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
    //Funcion para introducir seguimientos al ArrayList.
    public boolean add (Seguimiento s) {
        return seguir.add(s);
    }
    //Funcion para mostrar el registro de seguimientos.
    public String toString() {
        String informe = "";
        for (Seguimiento s: seguir) {
            informe += "Nombre: " + s.getNombre() + "." + "\n" + "Direccion: " + s.getdireccion() + "." + "\n"; //Almacenar el seguimiento.
        }
        System.out.println();
        return informe;
    }
    //Getters.
    public String getNombre() {
        return nombre;
    }
    public String getdireccion() {
        return direccion;
    }
}

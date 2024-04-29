package proyecto;
/**
 * Clase que determina como funciona el seguimiento.
 * @author Alberto Zamora Landete
 * @version 2
 * @since 21/02/2024.
 */
import java.util.*;
public class Seguimiento implements EsComparable<Seguimiento> {
    private int id = 0;
    private int cont = 0;
    private String nombre, direccion;
    /**
     * Constructor Seguimiento.
     * @param nombre Nombre del paciente.
     * @param direccion Direccion del paciente.
     */
    public Seguimiento(String nombre, String direccion) {
        this.id = cont;
        cont++;
        this.nombre = nombre;
        this.direccion = direccion;
    }
    /**
     * Metodo toString, devuelve la informacion del Seguimiento.
     * @return Informacion del Seguimiento en forma de cadena.
     */
    public String toString() {
        return "Nombre: " + getNombre() + "." + "\n" + "Direccion: " + getdireccion() + "." + "\n";
    }
    /**
     * Metodo get de Nombre.
     * @return Nombre del paciente.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Metodo get de la direccion.
     * @return Direccion del paciente.
     */
    public String getdireccion() {
        return direccion;
    }
    /**
     * Metodo que compara Alarmas.
     * @param a Alarma a comparar.
     * @return Resultado de comparar las id de las Alarmas. 
     */
    public int comparar(Seguimiento a) {
        return id - a.id;
    }
    /**
     * Metodo get de la ID.
     * @return ID de la alarma.
     */
    public int getID() {
        return id;
    }
}

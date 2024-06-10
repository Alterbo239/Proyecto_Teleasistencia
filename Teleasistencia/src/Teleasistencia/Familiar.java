
package Teleasistencia;

import java.util.*;
import TeleasistenciaDAO.*;
/**
 * La clase Familiar 
 * Esta clase lo que hace es almacenar a los Familiares 
 * @author Carla Navarro Gómez con ayuda de Alberto 
 * @version 1.0  25/04/2024
 * 
 */
/**Creamos la variables correspondeintes a los datos del familiar  que queremos almacenar  */

public class Familiar implements EsComparable<Familiar>{
    private String nombre,apellido1,apellido2;
    private String telefono;
    private String correo;
    private String dni;
    private int codigo;
    /**
     * Constructor de la clase Familiar  
     * Los datos que alamcenamos de los Familiares  
     * @param nombre 
     * @param apellido1
     * @param apellido2
     * @param telefono
     * @param correo
     * @param dni
     * @param codigo 
     
     */
    public Familiar(String nombre,String apellido1,String apellido2,String telefono,String correo,String dni, int codigo){
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;  
        this.telefono = telefono;
        this.correo = correo;
        this.dni = dni;
        this.codigo=codigo;
    }   

    /**
     * obtener  la información del Familiar 
     * @return la información del Familiar
     */
  
    
    public String obtenerInformacion() {
        return "Nombre completo: " + nombre + " " + apellido1 + " " + apellido2 +", Edad: " + ", Teléfono: " + telefono +", Correo: " + correo +", DNI: " + dni +", Direccion" +codigo+", codigo ";
    }
    
  /**
   * Obtener el nombre  del Familiar 
   * @return el nombre del Familiar
   */
    public String getnombre(){
        return nombre;
    }
    /**
     * Obtener el 1º apellido  del Familiar
     * @return el 1º apellido  del Familiar
     */
    public String getapellido1(){
        return apellido1;
    }
    /**
     * Obtener el 2º apellido  del Familiar
     * @return el 2º apellido del Familiar 
     */
    public String getapellido2(){
        return apellido2;
    }
  
    /**
     * Obtener el telefono  del Familiar
     * @return el telefono  del Familiar
     */
    public String gettelefono(){
        return telefono;
    }
    /**
     * Obtener el correo del Familiar
     * @return el correo  del Familiar
     */
    public String getcoreo(){
        return correo;
    }
   
   /**
     * Obtener el codigo  del Cliente asociado 
     * @return el codigo  del Cliente asociado 
     */
    public int getID(){
        return codigo;
    }
    /**
     * Funcio que compara dos codigos +
     * @param f
     */
    public int comparar(Familiar f){
        return codigo-f.codigo;
    }
}
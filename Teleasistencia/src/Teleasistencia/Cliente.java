package Teleasistencia;

import java.util.*;
import TeleasistenciaDAO.*;
/**
 * La clase cliente 
 * Esta clase lo que hace es almacenar los clientes 
 * @author Carla Navarro Gómez con ayuda de Alberto 
 * @version 1.0  25/04/2024
 * 
 */
/**Creamos la variables correspondeintes a los datos del cliente que queremos almacenar  */

public class Cliente {
    private String nombre,apellido1,apellido2;
    private int edad;
    private String telefono;
    private String correo;
    private String dni;
    private int codigo;
    private ArrayList alarma=new ArrayList();
    /**
     * Constructor de la clase cliente 
     * Los datos que alamcenamos delo cliente 
     * @param nombre 
     * @param apellido1
     * @param apellido2
     * @param edad
     * @param telefono
     * @param correo
     * @param dni
     * @param codigo
     * @param a
     */
    public Cliente(String nombre,String apellido1,String apellido2,int edad,String telefono,String correo,String dni,int codigo){
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
        this.dni = dni;
        this.codigo=codigo;
    }   

    /**
     * obtener  la información del cliente
     * @return la información del cliente
     */
  
    
    public String obtenerInformacion() {
        return "Nombre completo: " + nombre + " " + apellido1 + " " + apellido2 +", Edad: " + edad +", Teléfono: " + telefono +", Correo: " + correo +", DNI: " + dni+codigo+", codigo";
    }
    
  /**
   * Obtener el nombre  del cliente 
   * @return el nombre del cliente 
   */
    public String getnombre(){
        return nombre;
    }
    /**
     * Obtener el 1º apellido  del cliente 
     * @return el 1º apellido  del cliente 
     */
    public String getapellido1(){
        return apellido1;
    }
    /**
     * Obtener el 2º apellido  del cliente 
     * @return el 2º apellido del cliennte 
     */
    public String getapellido2(){
        return apellido2;
    }
    /**
     * obtrner la edad  del cliente 
     * @return la edad del cliente
     */
    public int getedad(){
        return edad;
    }
    /**
     * Obtener el telefono  del cliente 
     * @return el telefono  del cliente 
     */
    public String gettelefono(){
        return telefono;
    }
    /**
     * Obtener el correo del cliente 
     * @return el correo  del cliente 
     */
    public String getcoreo(){
        return correo;
    }
    /**
     * Obtener el DNI 
     * @return el DNI del cliente 
     */
    public String getdni(){
        return dni;
    }
    /**
     * Obtener el codigo
     * @return el codigo del cliente 
     */
    public int codigo(){
        return codigo;
    }
    /**
     * Inseertar una alarma   
     */
    public void insertarAlarma(Alarma a) {
        alarma.add(a);
    }
    /**
     * Mostrar la alarma 
     * Función hecha por Alberto 
     */
    public void mostrarAlarma() {
        Iterator it = alarma.iterator();
        Alarma a = null;
        
        while (it.hasNext()) {
            a = (Alarma) it.next();
            System.out.println("Alarma " + a.toString());
            System.out.println("");
        }
    }
}
import java.util.*;
// autor: Carla Navarro Gómez
/*Crea una clase de tu parte del proyecto y crea un programa de prueba que la utilice, para ver que funcionan bien los métodos creados. */
public class Cliente {
    private String nombre,apellido1,apellido2;
    private int edad;
    private String telefono;
    private String correo;
    private String dni;
    //constructor
    public Cliente(String nombre,String apellido1,String apellido2,int edad,String telefono,String correo,String dni){
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
        this.dni = dni;
    }   
  
    // Método para obtener información del cliente
    public String obtenerInformacion() {
        return "Nombre completo: " + nombre + " " + apellido1 + " " + apellido2 +", Edad: " + edad +", Teléfono: " + telefono +", Correo: " + correo +", DNI: " + dni;
    }
    
   
    public String getnombre(){
        return nombre;
    }
    public String getapellido1(){
        return apellido1;
    }
    public String getapellido2(){
        return apellido2;
    }
    public int getedad(){
        return edad;
    }
    public String gettelefono(){
        return telefono;
    }

    public String getcoreo(){
        return correo;
    }
    public String getdni(){
        return dni;
    }
    
}
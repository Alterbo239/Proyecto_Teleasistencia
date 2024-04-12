//marc alcover
import java.util.ArrayList;
import java.util.Scanner;

public class Familiar {
protected Scanner tecc = new Scanner(System.in);
protected String nombre;
protected String apellido;
protected String telefono;
protected String direccion;
protected String correo;

// ARRAYLIST PARA ALMACNEAR A LOS FAMILIARES
protected static ArrayList<Familiar> listaFamiliares = new ArrayList<>();

public Familiar(String nombre, String apellido, String telefono, String direccion, String correo) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.telefono = telefono;
    this.direccion = direccion;
    this.correo = correo;
}

// para registrar un nuevo familiar
public static void agregarFamiliar(Familiar familiar) {
    listaFamiliares.add(familiar);
}


public String toString() {
    return "Nombre: " + nombre + "\nApellido: " + apellido + "\nTeléfono: " + telefono +
    "\nDirección: " + direccion + "\nCorreo: " + correo;
}

// get y set
public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getApellido() {
    return apellido;
}

public void setApellido(String apellido) {
    this.apellido = apellido;
}

public String getTelefono() {
    return telefono;
}

public void setTelefono(String telefono) {
    this.telefono = telefono;
}

public String getDireccion() {
    return direccion;
}

public void setDireccion(String direccion) {
    this.direccion = direccion;
}

public String getCorreo() {
    return correo;
}

public void setCorreo(String correo) {
    this.correo = correo;
}

}

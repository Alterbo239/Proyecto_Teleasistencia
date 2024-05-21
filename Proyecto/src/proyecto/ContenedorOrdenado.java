package proyecto;
/**
 * Contenedor Ordenado para introducir a una lista las alarmas y seguimientos.
 * @author Alberto Zamora Landete
 * @version 1
 * @since 29/04/2024
 */
import java.time.*;
import java.util.*;

public class ContenedorOrdenado<A extends EsComparable<A>> {
    private A datos[];
    private int numero = 0;
    protected LocalDate fecha;
    protected Date hora;
    protected GregorianCalendar cal = new GregorianCalendar();
    
    public ContenedorOrdenado() {
        this.datos = (A[]) new EsComparable[10];
    }

    public void insertar(A dato) {
        boolean ordenado = false;
        int contador = numero;
        datos[contador] = dato;
        while((contador > 0) && !ordenado) {
            if (datos[contador].getID() < datos[contador-1].getID()) {
                A guardar = datos[contador];
                datos[contador] = datos[contador-1];
                datos[contador-1] = guardar;
            } else {
                ordenado = true;
            }
            contador--;
        }
        numero++;
    }
    
    public void comprobarIncidencia(ArrayList<Alarma> lista, int id) {
        Iterator it = lista.iterator();
        Alarma a = null;
        boolean esta = false;
        
        while(it.hasNext() && !esta) {
            a = (Alarma) it.next();
            if (a.getID() == id) {
                esta = true;
            }
        }
        if (esta) {
            System.out.println(a.toString());
        } else {
            System.out.println("Es alarma no esta.");
        }
    }
    
    public void mostrar() {
        for (int i = 0; i < numero; i++) {
            System.out.println(datos[i].toString());
        }
    }
}
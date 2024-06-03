
package TeleasistenciaDAO;
/**
 * Contenedor Ordenado para introducir a una lista las alarmas y seguimientos.
 * @author Alberto Zamora Landete
 * @version 2
 * @since 29/04/2024
 */
import java.time.*;
import java.util.*;
import Teleasistencia.*;

public class ContenedorOrdenado<A extends EsComparable<A>> {
    private A datos[];
    private int numero = 0;
    protected LocalDate fecha;
    protected Date hora;
    protected GregorianCalendar cal = new GregorianCalendar();
    
    public ContenedorOrdenado() {
        this.datos = (A[]) new EsComparable[10];
    }
    /**
     * Funcion que inserta un dato a un contenedor ordenado.
     * @param dato Objeto del que quieres almacenar.
     */
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
    /**
     * Funcion que comprueba alguna Alarma registrada.
     * @param lista Lista de Alarmas.
     * @param id ID de la Alarma a comprobar.
     */
    public void comprobarIncidencia(ArrayList<Alarma> lista, int id) {
        Iterator it = lista.iterator();
        Alarma a = null;
        boolean esta = false;
        
        while(it.hasNext() && !esta) { //Mientras pueda leer o no haya encontrado la Alarma, seguira leyendo.
            a = (Alarma) it.next(); // Guardamos la Alarma.
            if (a.getID() == id) { //Comprobamos la Alarma.
                esta = true;
            }
        }
        if (esta) {
            System.out.println(a.toString()); // Si esta, la mostramos.
        } else {
            System.out.println("Es alarma no esta."); //Si no esta, se lo hacemos saber.
        }
    }
    /**
     * Funcion que muestra los objetos almacenados.
     */
    public void mostrar() {
        for (int i = 0; i < numero; i++) {
            System.out.println(datos[i].toString());
        }
    }
}
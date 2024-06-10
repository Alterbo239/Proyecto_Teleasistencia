package TeleasistenciaDAO;

import java.util.*;
import org.junit.Test;
import org.junit.After;
import Teleasistencia.*;
import TeleasistenciaDAO.*;

/**
 *
 * @author Alberto Zamora Landete
 * @param <A>
 */
public class ContenedorOrdenadoTest <A extends EsComparable<A>> {
    @After
    public void espacio() {
        System.out.println("");
    }
    
    /**
     * Test del metodo Insertar.
     */
    @Test
    public void testInsertar() {
        System.out.println("Insertar.");
        Object dato[] = (A[]) new EsComparable[10];
        ContenedorOrdenado instance = new ContenedorOrdenado();
        instance.insertar((A) dato[0]);
        System.out.println("Insertado.");
    }
    /**
     * Test del metodo Comprobar Incidencia.
     */
    @Test
    public void testComprobarIncidencia() {
        System.out.println("ComprobarIncidencia.");
        ArrayList<Alarma> lista = new ArrayList();
        int id = 0;
        ContenedorOrdenado instance = new ContenedorOrdenado();
        instance.comprobarIncidencia(lista, id);
        System.out.println("Comprobado.");
    }
    /**
     * Test del metodo Mostrar.
     */
    @Test
    public void testMostrar() {
        System.out.println("Mostrar.");
        ContenedorOrdenado instance = new ContenedorOrdenado();
        instance.mostrar();
        System.out.println("Mostrado.");
    }
}
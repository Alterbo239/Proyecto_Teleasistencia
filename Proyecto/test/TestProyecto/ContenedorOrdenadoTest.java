package TestProyecto;

import java.util.*;
import org.junit.Test;
import org.junit.After;
import proyecto.Alarma;
import proyecto.ContenedorOrdenado;
import proyecto.*;

/**
 *
 * @author Alberto Zamora Landete
 * @param <A>
 */
public class ContenedorOrdenadoTest <A extends EsComparable<A>> {
    /**
     * Test of insertar method, of class ContenedorOrdenado.
     */
    @After
    public void espacio() {
        System.out.println("");
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        Object dato[] = (A[]) new EsComparable[10];
        ContenedorOrdenado instance = new ContenedorOrdenado();
        instance.insertar((A) dato[0]);
        System.out.println("Insertado");
    }

    /**
     * Test of comprobarIncidencia method, of class ContenedorOrdenado.
     */
    @Test
    public void testComprobarIncidencia() {
        System.out.println("comprobarIncidencia");
        ArrayList<Alarma> lista = new ArrayList();
        int id = 0;
        ContenedorOrdenado instance = new ContenedorOrdenado();
        instance.comprobarIncidencia(lista, id);
        System.out.println("Comprobado");
    }

    /**
     * Test of mostrar method, of class ContenedorOrdenado.
     */
    @Test
    public void testMostrar() {
        System.out.println("mostrar");
        ContenedorOrdenado instance = new ContenedorOrdenado();
        instance.mostrar();
        System.out.println("Mostrado");
    }
    
}

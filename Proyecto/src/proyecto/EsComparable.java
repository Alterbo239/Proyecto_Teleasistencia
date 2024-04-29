package proyecto;
/**
 * Interfaz que intenta comparar Objetos entre si.
 * @author Alberto Zamora Landete
 * @version 1
 * @since 29/04/2024
 */
public interface EsComparable<A> {
    public int comparar(A a);
    public int getID();
}
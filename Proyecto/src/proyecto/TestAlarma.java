package proyecto;
/**
 * Test para comprobar que funciona la clase "Alarma".
 * 
 * @author Alberto Zamora Landete
 * @version 13/12/2023
 */
import java.util.*;

public class TestAlarma {
    public static void main(String[] args) {
        int al;
        Alarma a = new Alarma();
        Seguimiento s = new Seguimiento("", "");
        Scanner esc = new Scanner(System.in);
        
        do {
            System.out.println("Que quieres hacer?");
            System.out.println("1) Registrar incidencia. 2) Comprobar incidencia. 3) Iniciar seguimiento. 4) Mostrar seguimientos. -1) Salir.");
            al = esc.nextInt();
            switch (al) {
                case 1:
                    boolean t = true;
                    a.setAlarma(t); //Llamada a la funcion de registrar una incidencia.
                    break;
                case 2:
                    System.out.println("Que numero de incidencia quieres comprobar?");
                    a.comprobarIncidencia(); //Llamada a la funcion para comprobar una incidencia.
                    break;
                case 3:
                    String nombre = "", direccion = "";
                    System.out.println("Introduce tu nombre.");
                    while (nombre.equals("")) {
                        nombre = esc.next();
                    }
                    System.out.println("Introduzca su direccion:");
                    while (direccion.equals("")) {
                        direccion = esc.next();
                    }
                    s.add(new Seguimiento(nombre, direccion)); //Llamada a la funcion para guardar un seguimiento.
                    break;
                case 4:
                    System.out.println(s.toString()); //Llamada a la funcion de mostrar seguimientos.
                    break;
                default:
                    break;
            }
        } while (al != -1);
        System.out.println("Fin.");
    }
}
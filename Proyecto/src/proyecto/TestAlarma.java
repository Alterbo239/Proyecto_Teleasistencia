package proyecto;
/**
 * Test para comprobar que funciona el Programa.
 * 
 * @author Alberto Zamora Landete
 * @version 3
 * @since 13/12/2023
 */
import java.time.LocalDate;
import java.util.*;

public class TestAlarma {
    public static void main(String[] args) {
        int al;
        ContenedorOrdenado alarma = new ContenedorOrdenado<Alarma>();
        ContenedorOrdenado seguimiento = new ContenedorOrdenado<Alarma>();
        Scanner esc = new Scanner(System.in);
        
        do {
            System.out.println("Que quieres hacer?");
            System.out.println("1) Registrar incidencia. 2) Comprobar incidencia. 3) Iniciar seguimiento. 4) Mostrar seguimientos. -1) Salir.");
            al = esc.nextInt();
            switch (al) {
                case 1:
                    LocalDate fecha = LocalDate.now(); //Instanciamos la fehca de hoy.
                    Date hora = new Date(); //Instanciamos la hora de hoy.
                    GregorianCalendar cal = new GregorianCalendar();
                    cal.setTime(hora); //Guardamos la hora en Calendario.
                    alarma.insertar(new Alarma(fecha, cal));
                    break;
                case 2:
                    System.out.println("Que numero de incidencia quieres comprobar?");
                    int id = esc.nextInt();
                    alarma.comprobarIncidencia(id); //Llamada a la funcion para comprobar una incidencia.
                    break;
                case 3:
                    String nombre = "", direccion = "";
                    System.out.println("Introduce tu nombre.");
                    while (nombre.equals("")) {
                        nombre = esc.nextLine();
                    }
                    System.out.println("Introduzca su direccion:");
                    while (direccion.equals("")) {
                        direccion = esc.nextLine();
                    }
                    seguimiento.insertar(new Seguimiento(nombre, direccion)); //Llamada a la funcion para guardar un seguimiento.
                    break;
                case 4:
                    seguimiento.mostrar(); //Llamada a la funcion de mostrar seguimientos.
                    break;
                default:
                    break;
            }
        } while (al != -1);
        System.out.println("Fin.");
    }
}
package proyecto;

import java.util.*;

/**
 *
 * @author Alberto Zamora Landete
 * Descripcion: Clase padre que tiene los metodos para la hija.
 * Aclaracion ArrayList de objetos: Como alarma no tiene muchos atributos, hice el ArrayList de un Integer en vez de un objeto.
 * Fecha: 22/02/2024.
 */
public class SistemaSeguridad {
    protected Scanner esc = new Scanner(System.in);
    protected ArrayList<Integer> numAlarma = new ArrayList<Integer>();
    protected int hora[][] = new int[500][2]; //Matriz que guarda Hora y Minutos.
    protected int fecha[][] = new int[500][3]; //Matriz que guarda Dia, Mes y Any.
    protected int contador = 0;
    
    //Set y get de fecha y hora.
    public void setFecha(int fecha[][]) {
        System.out.println("Introduce la hora: (por separado)");
        setHora(hora, contador);
        for (int i = contador; i < contador+1; i++) {
        System.out.println("Introduce la fecha: (por separado)");
            for (int j = 0; j < fecha[i].length; j++) {
                fecha[i][j] = esc.nextInt(); //Se introduce el dia, el mes y el 'any'.
            }
        }
        contador++; //Numero que ira aumentando cada vez que introduces una alarma.
        numAlarma.add(contador); //Se guarda el numero de la alarma en el ArrayList.
    }
    public void setHora(int hora[][], int num) {
        for (int i = num; i < num+1; i++) {
            for (int j = 0; j < hora[i].length; j++) {
                hora[i][j] = esc.nextInt(); //Se introduce la hora y los minutos.
            }
        }
    }
    //Funcion mostrar.
    public void mostrarFecha(int fecha[][], int num) {
        System.out.println("La alarma " + numAlarma.get(num) + " fue registrada: "); //Mostramos numero de la alarma.
        for (int i = num; i < num+1; i++) {
            System.out.print("El dia: "); //Mostramos la fecha.
            for (int j = 0; j < fecha[i].length; j++) {
                if (j < 2) {
                    System.out.print(fecha[i][j] + "/"); //Separamos la fecha por '/'.
                } else {
                    System.out.print(fecha[i][j] + "."); //Terminamos con un '.'.
                }
            }
            String horas = hora[i][0] + ":";
            String minutos = hora[i][1] + ".";
            String horario = horas.concat(minutos); //Tratamiento de cadenas porque no se me ocurria que utilizar de cadenas.
            System.out.println();
            System.out.print("A las: ");
            System.out.print(horario); //Mostramos la hora.
            System.out.println();
        }
    }
}

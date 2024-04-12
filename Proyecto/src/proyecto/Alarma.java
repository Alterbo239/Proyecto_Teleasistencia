package proyecto;
/**
 * Una clase que indica si hay una alarma, si la hay, se guardara la hora y
 * la fecha del incidente.
 * 
 * @author Alberto Zamora Landete
 * @version 13/12/2023
 */
import java.util.*;
public class Alarma extends SistemaSeguridad {
    private boolean alarm = false;
    private ArrayList<Alarma> alarmas = new ArrayList<Alarma>();
    public Alarma() {
        alarm = false;
    }
    
    //Metodo que comprueba si hay alguna alarma activada.
    public void setAlarma(boolean alarm) {
        this.alarm = alarm;
        if (alarm) {
            setFecha(fecha); //Llamamos a la funcion del padre.
        }
    }
    //Funcion que comprueba y muestra una incidencia pasada.
    public void comprobarIncidencia() {
        int num = esc.nextInt();
        if (num < numAlarma.size() && num > -1) {
            mostrarFecha(fecha, num); //Si la alarma esta registrada, entramos a comprobar.
        } else {
            System.out.println("Esa alarma no esta registrada aun"); //Si el numero de alarma introducida no esta, no entramos a comprobar.
        }
    }
}
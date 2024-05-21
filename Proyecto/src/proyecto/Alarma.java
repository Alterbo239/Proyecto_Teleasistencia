package proyecto;
/**
 * Una clase que indica si hay una alarma, si la hay, se guardara la hora y la fecha del incidente.
 * @author Alberto Zamora Landete
 * @version 5
 * @since 13/12/2023
 */
import java.time.LocalDate;
import java.util.*;
import java.io.*;

public class Alarma implements EsComparable<Alarma>, Serializable {
    private boolean alarm = false;
    private int id = 0, fechaInt;
    private LocalDate fecha;
    private GregorianCalendar cal;
    /**
     * Constructor de Alarma.
     * @param fecha Fecha de hoy.
     * @param cal Calendario para coger la hora y minutos.
     */
    public Alarma(int id, LocalDate fecha, GregorianCalendar cal) {
        alarm = false;
        this.id = id;
        this.fecha = fecha;
        this.cal = cal;
    }
    /**
     * Metodo toString, devuelve la informacion de la alarma.
     * @return Informacion de la alarma en forma de cadena.
     */
    public String toString() {
        String minuto = cal.get(Calendar.MINUTE) + "";
        if (cal.get(Calendar.MINUTE) < 10) {
            minuto = "0" + cal.get(Calendar.MINUTE);
        }
        return id + ". Fecha: " + fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear() + "\n" + "Hora: " + cal.get(Calendar.HOUR) + ":" + minuto;
    }
    /**
     * Metodo que compara Alarmas.
     * @param a Alarma a comparar.
     * @return Resultado de comparar las id de las Alarmas. 
     */
    public int comparar(Alarma a) {
        return id - a.id;
    }
    /**
     * Metodo get de la ID.
     * @return ID de la alarma.
     */
    public int getID() {
        return id;
    }
    public String getFecha() {
        return fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear();
    }
    public String getHora() {
        String minuto = cal.get(Calendar.MINUTE) + "";
        if (cal.get(Calendar.MINUTE) < 10) {
            minuto = "0" + cal.get(Calendar.MINUTE);
        }
        return cal.get(Calendar.HOUR) + ":" + minuto;
    }
    public boolean getAlarma() {
        return alarm;
    }
}
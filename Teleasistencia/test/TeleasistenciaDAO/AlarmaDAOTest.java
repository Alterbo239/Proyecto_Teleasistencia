package TeleasistenciaDAO;

import Teleasistencia.Alarma;
import java.sql.*;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import org.junit.*;
import static org.junit.Assert.*;
/**
 *
 * @author Alberto Zamora Landete.
 */
public class AlarmaDAOTest {
    public AlarmaDAOTest() {
    }
    /**
     * Final de las pruebas.
     */
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin de la prueba.");
    }
    /**
     * Espacio entre prueba y prueba.
     */
    @After
    public void tearDown() {
        System.out.println("Test realizado.");
        System.out.println("");
    }
    /**
     * Test del metodo insertarAlarma.
     */
    @Test
    public void testInsertarAlarma() throws Exception {
        System.out.println("InsertarAlarma");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teleasistencia_definitiva", "root", "0239");
        
        LocalDate fecha = LocalDate.now(); //Instanciamos la fehca de hoy.
        java.util.Date hora = new java.util.Date(); //Instanciamos la hora de hoy.
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(hora); //Guardamos la hora en Calendario.
        
        Alarma a = new Alarma(12, fecha, cal);
        AlarmaDAO instance = new AlarmaDAO();
        instance.insertarAlarma(con, a);
    }
    /**
     * Test del metodod eliminarAlarma.
     */
    @Test
    public void testEliminarAlarma() throws Exception {
        System.out.println("EliminarAlarma");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teleasistencia_definitiva", "root", "0239");
        int id = 12;
        AlarmaDAO instance = new AlarmaDAO();
        instance.eliminarAlarma(con, id);
    }
}
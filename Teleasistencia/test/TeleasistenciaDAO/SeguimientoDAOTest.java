package TeleasistenciaDAO;

import Teleasistencia.Seguimiento;
import java.sql.*;
import org.junit.*;
import static org.junit.Assert.*;
/**
 * Test de SeguimientoDAO.
 * @author Alberto Zamora Landete
 */
public class SeguimientoDAOTest {
    public SeguimientoDAOTest() {
    }
    /**
     * Final de las pruebas.
     */
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin del test.");
    }
    /**
     * Entre test y test se separa por un espacio para tener claro luego cual es cual.
     */
    @After
    public void tearDown() {
        System.out.println("Test realizado.");
        System.out.println("");
    }
    /**
     * Test del metodo insertarSeguimiento.
     */
    @Test
    public void testInsertarSeguimiento() throws Exception {
        System.out.println("InsertarSeguimiento");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teleasistencia_definitiva", "root", "0239");
        Seguimiento s = new Seguimiento();
        SeguimientoDAO instance = new SeguimientoDAO(1);
        instance.insertarSeguimiento(con, s);
    }
    /**
     * Test del metodo eliminarAlarma.
     */
    @Test
    public void testEliminarAlarma() throws Exception {
        System.out.println("EliminarAlarma");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teleasistencia_definitiva", "root", "0239");
        int id = 1;
        SeguimientoDAO instance = new SeguimientoDAO(id);
        instance.eliminarAlarma(con, id);
    }
}
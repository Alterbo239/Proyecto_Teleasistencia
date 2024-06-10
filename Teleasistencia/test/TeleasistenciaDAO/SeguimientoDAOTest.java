package TeleasistenciaDAO;

import Teleasistencia.Seguimiento;
import java.sql.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author lliurex
 */
public class SeguimientoDAOTest {
    
    public SeguimientoDAOTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Fin del test.");
    }
    
    @After
    public void tearDown() {
        System.out.println("");
    }

    /**
     * Test of insertarSeguimiento method, of class SeguimientoDAO.
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
     * Test of eliminarAlarma method, of class SeguimientoDAO.
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

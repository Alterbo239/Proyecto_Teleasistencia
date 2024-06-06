package TeleasistenciaDAO;
/**
 *
 * @author Alberto Zamora Landete
 */

import Teleasistencia.Seguimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SeguimientoDAO {
    private int idSeguimiento = 0;
    public SeguimientoDAO(int id) {
        this.idSeguimiento = id;
    }
    /**
     * Funcion que manda almacena un Seguimiento en la BD.
     * @param con Conexion con la BD.
     * @param s Seguimiento a almacenar.
     * @throws SQLException Error del tipo SQL.
     */
    public void insertarSeguimiento(Connection con, Seguimiento s) throws SQLException {
        PreparedStatement pst = null;
         try {
             pst = con.prepareStatement("INSERT INTO seguimiento VALUES (" + idSeguimiento + ", ?, ?)");
             pst.setString(1, s.getNombre());
             pst.setString(2, s.getDireccion());
             
             pst.executeUpdate();
             
             if (pst != null) {
                pst.close();
             }
         } catch (SQLException sql) {
             sql.printStackTrace();
         }
    }
}

package TeleasistenciaDAO;
/**
 *
 * @author Alberto Zamora Landete
 */

import Teleasistencia.Seguimiento;
import java.sql.*;

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
    /**
     * Funcion que elimina una alarma.
     * @param con Conexion con MySQL (Base de Datos).
     * @param id ID de la alarma a eliminar.
     * @throws SQLException Error de tipo SQL.
     */
    public void eliminarAlarma(Connection con, int id) throws SQLException {
        Statement st = con.createStatement();
        String eliminar = "DELETE FROM seguimiento WHERE id = " + id;
        try {
            st.executeUpdate(eliminar);
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        if (st != null) {
            st.close();
        }
    }
}
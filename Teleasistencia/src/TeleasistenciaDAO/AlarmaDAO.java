package TeleasistenciaDAO;
/**
 * 
 * @author Alberto Zamora Landete
 */
import Teleasistencia.Alarma;
import java.sql.*;

public class AlarmaDAO {
    public AlarmaDAO() {
        
    }
    /**
     * Funcion que inserta una Alarma en la Base de Datos.
     * @param con Conexion con MySQL (Base de Datos).
     * @param a Objeto de tipo Alarma para sacer su informacion e introducirla en la Base de Datos.
     * @throws SQLException Error de tipo SQL.
     */
    public void insertarAlarma(Connection con, Alarma a) throws SQLException {
        PreparedStatement pst = null;
        int intensidad = (int) Math.floor(Math.random()*5+1); //Elige una intensidad entre 1 y 5. (Rango de intensidad).
        int idCliente = (int) Math.floor(Math.random()*12+1); //Lo mismo pero entre Clientes.
         try {
             pst = con.prepareStatement("INSERT INTO alarma VALUES (?, ?, ?, ?)");
             pst.setInt(1, a.getID());
             pst.setInt(2, intensidad);
             pst.setString(3, a.getFecha());
             pst.setInt(4, idCliente);
             
             pst.executeUpdate();
             
             if (pst != null) {
                pst.close();
             }
         } catch (SQLException sql) {
             sql.printStackTrace();
         }
    }
}
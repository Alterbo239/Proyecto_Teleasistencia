package Main;
/**
 *
 * @author Alberto Zamora Landete
 */
import java.util.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Scanner esc = new Scanner(System.in);
        int comprobar;
        
        do {
            System.out.println("Que quieres realizar?");
            System.out.println("1) Comprobar Servicios. \n 2) Comprobar Clientes. \n 3) Comprobar Incidencias. \n 0) Salir");
            comprobar = esc.nextInt();
            
            switch(comprobar) {
                case 1:
                    
                    break;
                case 2:
                    Testcliente.main(args);
                    break;
                case 3:
                    try {
                        TestAlarma.main(args);
                    } catch (SQLException sql) {
                        sql.printStackTrace();
                    }
                    break;
                default:
                    
                    break;
            }
        } while (comprobar > 0);
    }
}
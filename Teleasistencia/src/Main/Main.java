package Main;
/**
 * Programa principal que llamara al resto de "mains".
 * @author Alberto Zamora Landete
 * @version 1
 * @since 2024/05/24
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
                    System.out.println("Esta funcion no esta disponible en esta version. Disculpe las molestias :)");
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
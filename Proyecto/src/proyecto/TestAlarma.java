package proyecto;
/**
 * Test para comprobar que funciona el Programa.
 * 
 * @author Alberto Zamora Landete
 * @version 3
 * @since 13/12/2023
 */
import java.time.LocalDate;
import java.util.*;
import java.util.Date;
import java.io.*;
import java.sql.*;

public class TestAlarma {
    static int idAlarma = 1;
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teleasistencia", "root", "0239");
        final String FICHERO = "Alarmas.txt";
        ArrayList<Alarma> lista = new ArrayList();
        
        try {
            cargarArray(FICHERO, lista);
        } catch (IOException io) {
            io.printStackTrace();
        }
        
        Alarma ala = null;
        int al;
        ContenedorOrdenado alarma = new ContenedorOrdenado<Alarma>();
        ContenedorOrdenado seguimiento = new ContenedorOrdenado<Alarma>();
        Scanner esc = new Scanner(System.in);
        
        do {
            System.out.println("Que quieres hacer?");
            System.out.println("1) Registrar incidencia. 2) Comprobar incidencia. 3) Iniciar seguimiento. 4) Mostrar seguimientos. -1) Salir.");
            al = esc.nextInt();
            switch (al) {
                case 1:
                    LocalDate fecha = LocalDate.now(); //Instanciamos la fehca de hoy.
                    Date hora = new Date(); //Instanciamos la hora de hoy.
                    GregorianCalendar cal = new GregorianCalendar();
                    cal.setTime(hora); //Guardamos la hora en Calendario.
                    
                    ala = new Alarma(idAlarma, fecha, cal);
        
                    lista.add(ala); //Insertamos la alarma en la lista.
                    try {
                        escribirFichero(FICHERO, ala); //Llamada a la funcion que escribe sobre el archivo.
                        insertarAlarma(con, ala);
                        idAlarma++;
                    } catch (IOException io) {
                        io.printStackTrace();
                    } catch (SQLException sql) {
                        sql.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Que numero de incidencia quieres comprobar?");
                    int id = esc.nextInt();
                    alarma.comprobarIncidencia(lista, id); //Llamada a la funcion para comprobar una incidencia.
                    break;
                case 3:
                    String nombre = "", direccion = "";
                    System.out.println("Introduce tu nombre.");
                    while (nombre.equals("")) {
                        nombre = esc.nextLine();
                    }
                    System.out.println("Introduzca su direccion:");
                    while (direccion.equals("")) {
                        direccion = esc.nextLine();
                    }
                    seguimiento.insertar(new Seguimiento(nombre, direccion)); //Llamada a la funcion para guardar un seguimiento.
                    break;
                case 4:
                    seguimiento.mostrar(); //Llamada a la funcion de mostrar seguimientos.
                    break;
                case 239: //Funcion "oculta" para comprobar que todo se lee bien.
                    try {
                        leer(FICHERO); //Llamada a la funcion de mostrar fichero.
                    } catch (IOException io) {
                        io.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        } while (al != -1);
        System.out.println("Fin.");
    }
    ////////////////////////////FICHEROS/////////////////////////////////////////
    /**
     * Funcion que escribe sobre el archivo.
     * @param nom Nombre del archivo.
     * @param a Alarma a registrar.
     * @throws IOException Error de tipo IO.
     */
    public static void escribirFichero(String nom, Alarma a) throws IOException {
        try {
            File f = new File(nom);
            
            if (f.exists()) {
                FileOutputStream fo = new FileOutputStream(f, true);
                MiObjectOutputStream moos = new MiObjectOutputStream(fo);
                
                moos.writeObject(a);
                
                if (moos != null) {
                    moos.close();
                    fo.close();
                }
            } else {
                FileOutputStream fo = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fo);
                
                oos.writeObject(a);
                
                if (oos != null) {
                    oos.close();
                    fo.close();
                }
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
    /**
     * Funcion que carga la informacion del fichero en un ArrayList.
     * @param nom Nombre del fichero.
     * @param a Lista de Alarmas.
     * @return Lista cargada de Alarmas.
     * @throws IOException Error de tipo IO.
     */
    public static ArrayList cargarArray(String nom, ArrayList<Alarma> a) throws IOException {
        File f = null;
        FileInputStream fi = null;
        ObjectInputStream ois = null;
        try {
            f = new File(nom);
            
            if (f.exists()) {
                fi = new FileInputStream(f);
                ois = new ObjectInputStream(fi);
                
                Alarma al;
                
                while(true) {
                    al = (Alarma) ois.readObject();
                    a.add(al);
                    idAlarma++;
                }
            }
        } catch (EOFException end) {
                System.out.println("----------");
            } catch (FileNotFoundException fnf) {
                System.out.println("Fichero no encontrado " + fnf);
            } catch (Throwable t) {
                System.out.println("Error de programa " + t);
                t.printStackTrace();
            } finally {
                if (ois != null) {
                    ois.close();
                    fi.close();
                }
            }
        return a;
    }
    /**
     * 
     * Funcion que lee el archivo.
     * @param nom Nombre del archivo.
     * @throws IOException Error de tipo IO.
     */
    public static void leer(String nom) throws IOException {
        try {
            File f = null;
            FileInputStream fe = null;
            ObjectInputStream ois = null;
            try {
                f = new File(nom);
                if (f.exists()) {
                    fe = new FileInputStream(f);
                    ois = new ObjectInputStream(fe);
                    
                    while(true) {
                        Alarma a = null;
                        a = (Alarma) ois.readObject();
                        System.out.println(a.toString());
                    }
                }
            } catch (EOFException end) {
                System.out.println("----------");
            } catch (FileNotFoundException fnf) {
                System.out.println("Fichero no encontrado " + fnf);
            } catch (Throwable t) {
                System.out.println("Error de programa " + t);
                t.printStackTrace();
            } finally {
                if (ois != null) {
                    ois.close();
                    fe.close();
                }
            }
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    ////////////////////////////BaseDeDatos/////////////////////////////////////
    public static void insertarAlarma(Connection con, Alarma a) throws SQLException {
        PreparedStatement pst = null;
        int intensidad = (int) Math.floor(Math.random()*5+1);
        int idCliente = (int) Math.floor(Math.random()*3+1);
         try {
             pst = con.prepareStatement("INSERT INTO alarmaJava VALUES (?, ?, ?, ?)");
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
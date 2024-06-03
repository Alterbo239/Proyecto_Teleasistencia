package Main;
/**
 * Test para comprobar que funciona el Programa.
 * 
 * @author Alberto Zamora Landete
 * @version 4
 * @since 13/12/2023
 */
import java.time.LocalDate;
import java.util.*;
import java.util.Date;
import java.io.*;
import java.sql.*;

import Teleasistencia.*;
import TeleasistenciaDAO.*;

public class TestAlarma {
    static int idAlarma = 1;
    static int idSeguimiento = 1;
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teleasistencia_definitiva", "root", "0239");
        final String FICHERO = "Alarmas.txt";
        final String FICHERO2 = "Seguimiento.txt";
        ArrayList<Alarma> lista = new ArrayList();
        
        try {
            cargarArray(FICHERO, lista);
            sumarIDSeguimiento(FICHERO2);
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
                    Seguimiento s = new Seguimiento(nombre, direccion);
                    seguimiento.insertar(s); //Llamada a la funcion para guardar un seguimiento.
                    try {
                        escribirFichero2(FICHERO2, s); //Llamada a la funcion que escribe sobre el archivo.
                        insertarSeguimiento(con, s);
                        idSeguimiento++;
                    } catch (IOException io) {
                        io.printStackTrace();
                    } catch (SQLException sql) {
                        sql.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        mostrarSeguimiento(FICHERO2);
                    } catch (IOException io) {
                        io.printStackTrace();
                    }//Llamada a la funcion de mostrar seguimientos.
                    break;
                case 239: //Funcion "oculta" para comprobar que todo se lee bien.
                    try {
                        leerAlarma(FICHERO); //Llamada a la funcion de mostrar fichero.
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
                FileOutputStream fo = new FileOutputStream(f, true); //Fichero que le dice donde escribir -> True para que pueda escribir sin debajo de los ya existentes.
                MiObjectOutputStream moos = new MiObjectOutputStream(fo); //No escribe "header".
                
                moos.writeObject(a);
                
                if (moos != null) {
                    moos.close();
                    fo.close();
                }
            } else {
                FileOutputStream fo = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fo); //Escribe "header".
                
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
            
            if (f.exists()) { //Si el fichero existe:
                fi = new FileInputStream(f);
                ois = new ObjectInputStream(fi);
                
                Alarma al;
                
                while(true) {
                    al = (Alarma) ois.readObject(); //Guardamos la informacion de la Alarma.
                    a.add(al); //Introducimos la Alarma en la lista.
                    idAlarma++; //El numero de Alarma sera siempre 1 mayor a la cantidad de objetos almacenados. (Para almacenar la siguiente).
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
     * Funcion que suma el ID del Seguimiento.
     * @param nom Nombre del fichero.
     * @throws IOException Error de tipo IO.
     */
    public static void sumarIDSeguimiento(String nom) throws IOException {
        File f = null;
        FileInputStream fi = null;
        ObjectInputStream ois = null;
        try {
            f = new File(nom);
            
            if (f.exists()) { //Si el fichero existe:
                fi = new FileInputStream(f);
                ois = new ObjectInputStream(fi);
                
                while(true) {
                    idSeguimiento++; //El numero de Seguimiento sera siempre 1 mayor a la cantidad de objetos almacenados. (Para almacenar la siguiente).
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
    }
    /**
     * 
     * Funcion que lee el archivo.
     * @param nom Nombre del archivo.
     * @throws IOException Error de tipo IO.
     */
    public static void leerAlarma(String nom) throws IOException {
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
                        System.out.println(a.toString()); //Muestra la informacion de cada Alarma registrada.
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
    /**
     * Funcion que inserta una Alarma en la Base de Datos.
     * @param con Conexion con MySQL (Base de Datos).
     * @param a Objeto de tipo Alarma para sacer su informacion e introducirla en la Base de Datos.
     * @throws SQLException Error de tipo SQL.
     */
    public static void insertarAlarma(Connection con, Alarma a) throws SQLException {
        PreparedStatement pst = null;
        int intensidad = (int) Math.floor(Math.random()*5+1); //Elige una intensidad entre 1 y 5. (Rango de intensidad).
        int idCliente = (int) Math.floor(Math.random()*3+1); //Lo mismo pero entre Clientes.
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
    /**
     * Funcion que escribe sobre el archivo.
     * @param nom Nombre del archivo.
     * @param s Seguimiento a registrar.
     * @throws IOException Error de tipo IO.
     */
    public static void escribirFichero2(String nom, Seguimiento s) throws IOException {
        try {
            File f = new File(nom);
            
            if (f.exists()) {
                FileOutputStream fo = new FileOutputStream(f, true); //Fichero que le dice donde escribir -> True para que pueda escribir sin debajo de los ya existentes.
                MiObjectOutputStream moos = new MiObjectOutputStream(fo); //No escribe "header".
                
                moos.writeObject(s);
                
                if (moos != null) {
                    moos.close();
                    fo.close();
                }
            } else {
                FileOutputStream fo = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fo); //Escribe "header".
                
                oos.writeObject(s);
                
                if (oos != null) {
                    oos.close();
                    fo.close();
                }
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
    
    public static void mostrarSeguimiento(String nom) throws IOException {
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
                        Seguimiento s = null;
                        s = (Seguimiento) ois.readObject();
                        System.out.println(s.toString()); //Muestra la informacion de cada Seguimiento registrado.
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
    
    public static void insertarSeguimiento(Connection con, Seguimiento s) throws SQLException {
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
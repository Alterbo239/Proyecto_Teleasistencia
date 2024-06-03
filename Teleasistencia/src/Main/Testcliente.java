package Main;

import static Main.TestAlarma.idAlarma;
import java.util.*;
import TeleasistenciaDAO.*;
import Teleasistencia.*;
import java.time.LocalDate;
/**
 * La clase Testcliente
 *  se encarga de probar lo que hemos hecho en la clase CleinteAlmacenar para almacnear los datos del cliente 
 * @author Carla Navarro Gómez con ayuda de Alberto 
 * @version 1.0  25/04/2024
 * 
 */

public class Testcliente {
   /**
    * Metodo principal que inicia la ejecución del programa
    * Permite al usuario registrar y mostrar clientes hasta que decide salir.
    * @param args 
    */
  public static void main(String[] args) {
     int n = 0, al = 1;
    Scanner cng=new Scanner(System.in);
    ClienteAlmacenar almacenar =new ClienteAlmacenar(); 
    ArrayList familiar =new ArrayList<Familiar>();
     do{
      System.out.println("Que quieres hacer?");
      System.out.println("1 Registrar cliente. 2 Mostrar cliente. 3 Familiar. 4. Comprobar Cliente.  -1 salir.");
      n=cng.nextInt();
      
      switch (n) {
        case 1:
          String nombre ="",apellido1 ="",apellido2 ="";
          int edad = 0, codigo = 0;
          String telefono ="";
          String correo ="";
          String dni ="";
          
          System.out.println( "Dime nombre");
          while (nombre.equals("")) {
            nombre=cng.nextLine();
          }
          System.out.println( "Dime el primer apellido");
          while (apellido1.equals("")) {
            apellido1=cng.nextLine();
          }
          System.out.println( "Dime el segundo apellido");
          while (apellido2.equals("")) {
            apellido2=cng.nextLine();
          }
          System.out.println( "Dime el edad");
          while (edad == 0) {
            edad=cng.nextInt();
          }
          System.out.println( "Dime el telefono");
          while (telefono.equals("")) {
            telefono=cng.nextLine();
          }
          System.out.println( "Dime el correo");
          while (correo.equals("")) {
            correo=cng.nextLine();
          }
          System.out.println( "Dime el dni");
          while (dni.equals("")) {
            dni=cng.nextLine();
          }
           System.out.println( "Dime el codigo del cliente del familiar ");
          while (codigo == 0) {
            codigo=cng.nextInt();
          }
                    
          almacenar.daralta(new Cliente(nombre, apellido1, apellido2, edad,telefono,correo,dni, codigo));
          break;
        case 2:
          System.out.println(almacenar.toString());
          break;
        case 3:
            String nombref ="",apellido1f ="",apellido2f ="";
         String telefonof ="";
          String correof ="";
          String dnif ="";
          int codigof=0;
          System.out.println( "Dime nombre del familiar");
          while (nombref.equals("")) {
            nombref=cng.nextLine();
          }
          System.out.println( "Dime el primer apellido del familiar");
          while (apellido1f.equals("")) {
            apellido1f=cng.nextLine();
          }
          System.out.println( "Dime el segundo apellido del familiar ");
          while (apellido2f.equals("")) {
            apellido2f=cng.nextLine();
          }
         
    
          System.out.println( "Dime el telefono del familiar");
          while (telefonof.equals("")) {
            telefonof=cng.nextLine();
          }
          System.out.println( "Dime el correo del familiar");
          while (correof.equals("")) {
            correof=cng.nextLine();
          }
          System.out.println( "Dime el dni del familiar");
          while (dnif.equals("")) {
            dnif=cng.nextLine();
          }
           System.out.println( "Dime el codigo del cliente del familiar ");
          while (codigof == 0) {
            codigof=cng.nextInt();
          }
          Familiar f = new Familiar (nombref, apellido1f, apellido2f, telefonof,correof,dnif,codigof);
          familiar.add(f);
          break;
        case 4:
            int cod = 0;
           System.out.println( "Dime el codigo del cliente del familiar ");
          while (cod == 0) {
            cod=cng.nextInt();
          }
          FamiliarDAO fam = new FamiliarDAO();
          fam.comprobarcliente(cod, almacenar, familiar);
          break;
        default:
          break;
      }
     } while (n!=-1);
       
  }
}
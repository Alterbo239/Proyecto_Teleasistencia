import java.util.*;
//Carla Navarro Gómez y Alberto
/*Crea una clase con arraylist */
public class Testcliente {
   
  public static void main(String[] args) {
     int n = 0;
    Scanner cng=new Scanner(System.in);
    ClienteAlmacenar almacenar =new ClienteAlmacenar();
     do{
      System.out.println("Que quieres hacer?");
      System.out.println("1 Registrar cliente. 2 Mostrar cliente. -1 salir.");
      n=cng.nextInt();
      switch (n) {
        case 1:
          String nombre ="",apellido1 ="",apellido2 ="";
          int edad = 0;
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
          almacenar.daralta(new Cliente(nombre, apellido1, apellido2, edad,telefono,correo,dni));
          break;
        case 2:
          System.out.println(almacenar.toString());
          break;
        default:
          break;
      }
     } while (n!=-1);
       
  }
}
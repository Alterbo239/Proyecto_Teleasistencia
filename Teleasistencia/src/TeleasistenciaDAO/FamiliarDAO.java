/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TeleasistenciaDAO;
import Teleasistencia.*;
import java.util.*;
/**
 *
 * @author Carla y Alberto 
 */
public class FamiliarDAO {
    
    /**
     * Funcio que compureba si un cliente tien asignado un familiar 
     * @param cod
     * @param cliente
     * @param f 
     */
    public void comprobarcliente(int cod,ClienteAlmacenar cliente,ArrayList<Familiar> f){
        Familiar fa=null;
        Cliente cli =null;
                
        Iterator clienteIt = cliente.registro.iterator();
        Iterator familiarIt = f.iterator();
        boolean esta=false;
    
        while(clienteIt.hasNext() && !esta) {
            cli = (Cliente) clienteIt.next();
            if (cli.codigo() == cod) {
                while(familiarIt.hasNext() && !esta) {
                    fa =(Familiar) familiarIt.next();
                    if (fa.getID()==cod){
                        System.out.println(cli.obtenerInformacion());
                        esta=true;
                    }
                }
            }
        }
        
        if (!esta) {
            System.out.println("No hay un familiar relacionado a ese cliente.");
        }
    }
}

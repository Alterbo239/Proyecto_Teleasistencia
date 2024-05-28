package TeleasistenciaDAO;

import java.util.*;
import Teleasistencia.*;


public class ClienteAlmacenar {
    ArrayList<Cliente>registro;
    
    public ClienteAlmacenar() {
        registro=new ArrayList<Cliente>();
    }
/**
 * 
 * @param cliente añadir al cliente 
 * @return verdad si el cliente se registra correctamente 
 */
    public boolean daralta(Cliente cliente) {
        return registro.add(cliente);
    }
/**
 * Devuleve una representación en formato cadena de texto 
 * @return una cadena de texto con  la información del cliente 
 */
    public String toString() {
        String a ="";
        for(Cliente yoQueSe: registro) {
            a+="nombre:" +yoQueSe.getnombre()+"\n"+"primerapellido:" +yoQueSe.getapellido1()+"\n"+"segundo apellido:" +yoQueSe.getapellido2()+"\n"+"edad:" +yoQueSe.getedad()+"\n"+ "telefono:" +yoQueSe.gettelefono()+"\n"+ "correo:" +yoQueSe.getcoreo()+"\n"+"dni:" +yoQueSe.getdni();
            yoQueSe.mostrarAlarma();
        }
        return a;
    }
}

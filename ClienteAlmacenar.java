import java.util.*;
public class ClienteAlmacenar {
    ArrayList<Cliente>registro;
    
    public ClienteAlmacenar() {
        registro=new ArrayList<Cliente>();
    }

    public boolean daralta(Cliente cliente) {
        return registro.add(cliente);
    }

    public String toString() {
        String a ="";
        for(Cliente yoQueSe: registro) {
            a+="nombre:" +yoQueSe.getnombre()+"\n"+"primerapellido:" +yoQueSe.getapellido1()+"\n"+"segundo apellido:" +yoQueSe.getapellido2()+"\n"+"edad:" +yoQueSe.getedad()+"\n"+ "telefono:" +yoQueSe.gettelefono()+"\n"+ "correo:" +yoQueSe.getcoreo()+"\n"+"dni:" +yoQueSe.getdni();
        }
        return a;
    }
}

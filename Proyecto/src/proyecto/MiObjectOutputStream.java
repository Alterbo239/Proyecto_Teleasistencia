package proyecto;
/**
 *
 * @author Alberto Zamora Landete
 */
import java.io.*;

public class MiObjectOutputStream extends ObjectOutputStream {
    MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
    
    protected void writeStreamHeader() throws IOException {
        
    }
}

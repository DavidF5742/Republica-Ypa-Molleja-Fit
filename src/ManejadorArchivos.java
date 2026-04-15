import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ManejadorArchivos {
    private String nombreArchivo;

    public ManejadorArchivos(String nombre) {
        this.nombreArchivo = nombre;
    }

    public void registrarEvento(String datos) {
        try (FileWriter fw = new FileWriter(nombreArchivo, true);
             PrintWriter out = new PrintWriter(fw)) {
            out.println(System.currentTimeMillis() + " | " + datos);
        } catch (IOException e) {
            System.err.println("Error en la Caja Negra: " + e.getMessage());
        }
    }
    
}
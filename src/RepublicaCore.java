import java.io.File;

public class RepublicaCore {
    // El "cerebro" decide el nombre del archivo, pero no la ruta absoluta
    public static final String LOG_FILENAME = "log_republica.txt";

    public double calcularWatts(double peso, double velocidad) {
        // Tu fórmula de CicloComputador que ya funciona
        return (peso * velocidad * 0.1); 
    }
    
    // Método para normalizar la ruta según el sistema
    public String obtenerRutaLog(String rutaBase) {
        return rutaBase + File.separator + LOG_FILENAME;
    }
}
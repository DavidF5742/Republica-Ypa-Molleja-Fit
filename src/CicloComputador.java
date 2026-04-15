public class CicloComputador {

    /**
     * Calcula calorías quemadas (aproximación por METs)
     * MET para ciclismo moderado/fuerte: 10.0
     */
    public double calcularCalorias(double pesoKg, double tiempoHoras) {
        return 10.0 * pesoKg * tiempoHoras;
    }

    /**
     * Calcula potencia estimada en Watts (Simplificado)
     * P = Kr * M * v + Ka * A * v^3
     */
    public double estimarWatts(double pesoTotal, double velocidadKmh) {
        double vMS = velocidadKmh / 3.6; // Pasar a metros/segundo
        // Resistencia a la rodadura + resistencia aerodinámica simple
        double potencia = (0.1 * pesoTotal * vMS) + (0.5 * 0.5 * vMS * vMS * vMS);
        return potencia;
    }
    
}
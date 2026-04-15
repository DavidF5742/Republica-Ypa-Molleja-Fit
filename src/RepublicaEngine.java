/**
 * PROYECTO: República Ypa Molleja Fit 🚀
 * INSPIRACIÓN: Rossana Valenzuela & El Lago Azul de Ypacaraí.
 */
public class RepublicaEngine {

    public enum EstadoApp {
        IDLE, PREPARANDO, GRABANDO, PAUSADO, FINALIZADO, ERROR_CRITICO
    }

    private EstadoApp estadoActual;
    private long inicioTimestamp;
    private String lang; // Para i18n

    public RepublicaEngine() {
        this.lang = "es";
        this.estadoActual = EstadoApp.IDLE;
        System.out.println("SISTEMA: República Ypa Molleja Fit Iniciada.");
    }

    public RepublicaEngine(String lang) {
        this.lang = lang;
        this.estadoActual = EstadoApp.IDLE;
        System.out.println(IdiomasRepublica.get(lang, "inicio"));
    }

    public void iniciarActividad() {
        if (this.estadoActual == EstadoApp.IDLE) {
            this.estadoActual = EstadoApp.PREPARANDO;
            System.out.println(IdiomasRepublica.get(lang, "calibrando"));
        }
    }

    public void activarMollejaMode() {
        if (this.estadoActual == EstadoApp.PREPARANDO) {
            this.estadoActual = EstadoApp.GRABANDO;
            this.inicioTimestamp = System.currentTimeMillis();
            System.out.println(IdiomasRepublica.get(lang, "grabando"));
        }
    }

    public void pausarActividad() {
        if (this.estadoActual == EstadoApp.GRABANDO) {
            this.estadoActual = EstadoApp.PAUSADO;
            System.out.println(IdiomasRepublica.get(lang, "pausa"));
        }
    }

    public void finalizarActividad() {
        this.estadoActual = EstadoApp.FINALIZADO;
        System.out.println(IdiomasRepublica.get(lang, "final"));
    }

    public EstadoApp getEstadoActual() {
        return estadoActual;
    }
    public void setEstado(EstadoApp nuevoEstado) {
        this.estadoActual = nuevoEstado;
        System.out.println(IdiomasRepublica.get(lang, "estado_actual") + ": " + this.estadoActual);
    }
    
    public void setLenguaje(String lenguaje) {
        this.lang = lenguaje;
    }
    
    public static void main(String[] args) {
        // --- 1. CONFIGURACIÓN INICIAL (Inyección de Idioma) ---
        String lenguaje = "es"; // Cambia a "es", "en", "pt" o "he"
        
        // 1. Instanciamos los motores y calculadoras
        RepublicaEngine motor = new RepublicaEngine(lenguaje);
        CalculadoraRutas calc = new CalculadoraRutas();
        CicloComputador pc = new CicloComputador();
        ManejadorArchivos cajaNegra = new ManejadorArchivos("log_republica.txt");
        MonitorSalud monitor = new MonitorSalud();
        SensorDeporte bandaCardiaca = new SensorCorazon();

        // --- 2. FLUJO DE EJECUCIÓN LÓGICA ---
        motor.iniciarActividad();
        cajaNegra.registrarEvento("LOG: Start GPS Calibration");

        motor.activarMollejaMode();
        
        // Simulación de telemetría
        double km = calc.calcularDistancia(-25.26, -57.48, -25.40, -57.28);
        double watts = pc.estimarWatts(85.0, 30.0);
        double bpm = bandaCardiaca.leerDato();

        // --- 3. PROCESAMIENTO DE DATOS ---
        SesionEntrenamiento miRuta = new SesionEntrenamiento("DavidF5742", km, watts, 450.0, lenguaje);
        String saludMsg = monitor.analizarEsfuerzo(miRuta.wattsPromedio, miRuta.distanciaKm, lenguaje);

        // --- 4. PERSISTENCIA Y SALIDA (OUTPUT) ---
        cajaNegra.registrarEvento("Ruta: " + km + " km | Watts: " + watts + " | BPM: " + bpm);
        cajaNegra.registrarEvento("DATA_JSON: " + miRuta.toJSON());
        cajaNegra.registrarEvento("DIAGNOSTICO: " + saludMsg);

        motor.pausarActividad();
        motor.finalizarActividad();

        System.out.println("\n--- TELEMETRÍA FINAL ---");
        System.out.printf("CORAZÓN: %.0f BPM\n", bpm);
        System.out.println("DIAGNOSTICO: " + saludMsg);
        System.out.println("\n--- PAQUETE JSON ---");
        System.out.println(miRuta.toJSON());
        
        System.out.println("\nSISTEMA: OK. Check log_republica.txt");
    }
}
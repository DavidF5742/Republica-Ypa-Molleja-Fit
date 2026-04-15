interface SensorDeporte {
    double leerDato();
}

class SensorCorazon implements SensorDeporte {
    public double leerDato() {
        // Simula latidos: entre 120 y 160 bpm
        return 120 + (Math.random() * 40);
    }
}

public class SensorHub {
    public static void main(String[] args) {
        SensorDeporte banda = new SensorCorazon();
        System.out.println("BPM: " + banda.leerDato());
    }
}
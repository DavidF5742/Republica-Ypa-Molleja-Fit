import java.util.Date;

public class BiometriaMolleja {
    private double peso;
    private double porcentajeGrasa;
    private double masaMuscular;
    private Date fechaRegistro;

    public BiometriaMolleja(double peso, double grasa, double musculo) {
        this.peso = peso;
        this.porcentajeGrasa = grasa;
        this.masaMuscular = musculo;
        this.fechaRegistro = new Date();
    }

    // Método para calcular el IMC (Índice de Masa Corporal)
    // Usamos la fórmula estándar: peso / (estatura^2)
    public double calcularIMC(double estaturaMetros) {
        return this.peso / (estaturaMetros * estaturaMetros);
    }

    public void imprimirReporte() {
        System.out.println("--- REPORTE BIOMÉTRICO ---");
        System.out.println("Fecha: " + fechaRegistro);
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Grasa: " + porcentajeGrasa + "%");
        System.out.println("Músculo: " + masaMuscular + " kg");
        System.out.println("--------------------------");
    }

    // Método principal para probar el módulo
    public static void main(String[] args) {
        // Ejemplo: David registrando datos
        BiometriaMolleja registro = new BiometriaMolleja(85.5, 18.2, 40.5);
        registro.imprimirReporte();
        
        double imc = registro.calcularIMC(1.80); // Suponiendo 1.80m
        System.out.printf("IMC Calculado: %.2f\n", imc);
    }
}
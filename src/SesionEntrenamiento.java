public class SesionEntrenamiento {
    public String usuario;
    public double distanciaKm;
    public double wattsPromedio;
    public double calorias;
    public String estadoFinal;

    public SesionEntrenamiento(String usuario, double dist, double watts, double cal, String lang) {
        this.usuario = usuario;
        this.distanciaKm = dist;
        this.wattsPromedio = watts;
        this.calorias = cal;
        this.estadoFinal = IdiomasRepublica.get(lang, "sesion_ok");
    }

    // Método para convertir a formato JSON (Manual, para no cargar librerías extra ahora)
    public String toJSON() {
        return String.format(
            "{\n  \"usuario\": \"%s\",\n  \"distancia\": %.2f,\n  \"watts\": %.2f,\n  \"calorias\": %.2f\n}",
            usuario, distanciaKm, wattsPromedio, calorias
        );
    }
}
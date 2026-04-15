public class MonitorSalud {

    public String analizarEsfuerzo(double watts, double km, String lang) {
        
        // 1. Lógica de Fatiga/Inflamación
        if (km > 20 && watts < 150) {
            return IdiomasRepublica.get(lang, "salud_alerta");
        } 
        
        // 2. Lógica de Alto Rendimiento (Molleja-Elite)
        else if (watts > 250) {
            return IdiomasRepublica.get(lang, "salud_elite");
        } 
        
        // 3. Estado Estable
        else {
            return IdiomasRepublica.get(lang, "salud_ok");
        }
        
    }

}
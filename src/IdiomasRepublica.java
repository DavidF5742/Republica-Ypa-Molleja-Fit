import java.util.HashMap;
import java.util.Map;

public class IdiomasRepublica {
    private static final Map<String, Map<String, String>> diccionarios = new HashMap<>();

    static {
        // --- ESPAÑOL ---
        Map<String, String> es = new HashMap<>();
        es.put("inicio", "SISTEMA: República Ypa Molleja Fit Iniciada.");
        es.put("calibrando", "Estado: Calibrando sensores en la República...");
        es.put("grabando", "Estado: ¡Molleja-Mbarete Activo! Grabando...");
        es.put("pausa", "Estado: Pausado. Tomá un tereré, primo.");
        es.put("final", "ESTADO ACTUAL: FINALIZADO");
        es.put("salud_ok", "DIAGNÓSTICO: Ritmo estable. Mente despejada.");
        es.put("salud_alerta", "ALERTA: Cuerpo Inflamado detectado. Bajada de potencia.");
        es.put("salud_elite", "ESTADO: Modo Molleja-Elite. Rendimiento óptimo.");
        es.put("corazon", "CORAZÓN");
        es.put("watts", "POTENCIA (WATTS)");
        es.put("json_gen", "--- PAQUETE JSON GENERADO ---");
        es.put("inicio_btn", "INICIAR");
        es.put("pausa_btn", "PAUSA");
        es.put("fin_btn", "FIN");
		es.put("guardando_log", "Guardando sesión en ");
		es.put("sesion_guardada", "Sesión guardada.");
		es.put("so_windows", "Windows");
		es.put("so_android", "Android");
        diccionarios.put("es", es);

        // --- GUARANÍ 🇵🇾 ---
        Map<String, String> gn = new HashMap<>();
        gn.put("inicio", "SISTEMA: República Ñandutí Oñepyrũ.");
        gn.put("calibrando", "Estado: Ñamba'apo hína GPS rehe...");
        gn.put("grabando", "Estado: ¡Molleja Mbarete! Oguereko hína...");
        gn.put("pausa", "Estado: Pytu'u. E'u peteĩ tereré, kape.");
        gn.put("final", "ESTADO: OPÁMA");
        gn.put("salud_ok", "DIAGNÓSTICO: Hesãi ha ne akã porã.");
        gn.put("salud_alerta", "EKYHYJE: Nande rete oñeñandú vai. Emboyke fatiga.");
        gn.put("salud_elite", "ESTADO: Molleja-Elite. Iporãiterei nde rendimientp!");
        gn.put("corazon", "PY'APYTAKA");
        gn.put("watts", "PU'AKA (WATTS)");
        gn.put("json_gen", "--- JSON ÑEMBOSAKUÃ ---");
        gn.put("inicio_btn", "ÑEPYRŨ");
        gn.put("pausa_btn", "PYTU'U");
        gn.put("fin_btn", "PAHA");
		gn.put("guardando_log", "Ñañongatu hína ko tembiapo peime ");
		gn.put("sesion_guardada", "Ñeñongatu porãma.");
		gn.put("so_windows", "Windows-pe");
		gn.put("so_android", "Android-pe");
        diccionarios.put("gn", gn);

        // --- PORTUGUÉS 🇧🇷 ---
        Map<String, String> pt = new HashMap<>();
        pt.put("inicio", "SISTEMA: República Iniciada. Vamos lá!");
        pt.put("calibrando", "Estado: Calibrando sensores da República...");
        pt.put("grabando", "Estado: ¡Molleja Ativa! Gravando...");
        pt.put("pausa", "Estado: Pausado. Tome um cafezinho.");
        pt.put("final", "ESTADO ATUAL: FINALIZADO");
        pt.put("salud_ok", "DIAGNÓSTICO: Ritmo estável. Mente limpa.");
        pt.put("salud_alerta", "ALERTA: Corpo Inflamado. Perda de potência.");
        pt.put("salud_elite", "ESTADO: Modo Molleja-Elite. Desempenho ideal.");
        pt.put("corazon", "CORAÇÃO");
        pt.put("watts", "POTÊNCIA (WATTS)");
        pt.put("json_gen", "--- PACOTE JSON GERADO ---");
        pt.put("inicio_btn", "COMEÇAR");
        pt.put("pausa_btn", "PAUSAR");
        pt.put("fin_btn", "FIM");
		pt.put("guardando_log", "Salvando sessão em ");
		pt.put("sesion_guardada", "Sessão salva com sucesso.");
		pt.put("so_windows", "Windows");
		pt.put("so_android", "Android");
        diccionarios.put("pt", pt);

        // --- INGLÉS 🇺🇸 ---
        Map<String, String> en = new HashMap<>();
        en.put("inicio", "SYSTEM: Republic Ypa Molleja Fit Started.");
        en.put("calibrando", "Status: Calibrating sensors...");
        en.put("grabando", "Status: Molleja Mode Active! Recording...");
        en.put("pausa", "Status: Paused. Take a break.");
        en.put("final", "CURRENT STATUS: FINISHED");
        en.put("salud_ok", "DIAGNOSIS: Stable pace. Clear mind.");
        en.put("salud_alerta", "WARNING: Inflamed Body detected. Power drop.");
        en.put("salud_elite", "STATUS: Molleja-Elite Mode. Optimal performance.");
        en.put("corazon", "HEART RATE");
        en.put("watts", "POWER (WATTS)");
        en.put("json_gen", "--- JSON PACKAGE GENERATED ---");
        en.put("inicio_btn", "START");
        en.put("pausa_btn", "PAUSE");
        en.put("fin_btn", "FINISH");
		en.put("guardando_log", "Saving session in ");
		en.put("sesion_guardada", "Session saved successfully.");
		en.put("so_windows", "Windows");
		en.put("so_android", "Android");
        diccionarios.put("en", en);

        // --- HEBREO 🇮🇱 ---
        Map<String, String> he = new HashMap<>();
        he.put("inicio", "מערכת: הרפובליקה התחילה");
        he.put("calibrando", "מצב: כיול חיישנים");
        he.put("grabando", "מצב: הקלטה פעילה");
        he.put("pausa", "מצב: מושהה. קח הפסקה");
        he.put("final", "מצב נוכחי: הסתיים");
        he.put("salud_ok", "אבחנה: קצב יציב. מוח צלול");
        he.put("salud_alerta", "אזהרה: גוף דלקתי זוהה");
        he.put("salud_elite", "מצב: מוד מולז'ה-עילית. ביצועים אופטימליים");
        he.put("corazon", "דופק לב");
        he.put("watts", "הספק (וואט)");
        he.put("json_gen", "--- חבילת JSON נוצרה ---");
        he.put("inicio_btn", "התחל");
        he.put("pausa_btn", "השהה");
        he.put("fin_btn", "סיים");
		he.put("guardando_log", "שומר אימון ב");
		he.put("sesion_guardada", "אימון נשמר בהצלחה.");
		he.put("so_windows", "Windows");
		he.put("so_android", "Android");
        diccionarios.put("he", he);
        
        // --- FRANCÉS (fr) 🇫🇷 ---
        Map<String, String> fr = new HashMap<>();
        fr.put("inicio", "SYSTÈME : République Démarrée.");
        fr.put("calibrando", "État : Calibrage des capteurs...");
        fr.put("grabando", "État : Mode Molleja Actif ! Enregistrement...");
        fr.put("pausa", "État : Pause. Prenez un café.");
        fr.put("final", "STATUT ACTUEL : TERMINÉ");
        fr.put("salud_ok", "DIAGNOSTIC : Rythme stable. Esprit clair.");
        fr.put("salud_alerta", "ALERTE : Corps Inflammé détecté.");
        fr.put("salud_elite", "ÉTAT : Mode Molleja-Élite. Performance optimale.");
        fr.put("corazon", "RYTHME CARDIAQUE");
        fr.put("watts", "PUISSANCE (WATTS)");
        fr.put("json_gen", "--- PAQUET JSON GÉNÉRÉ ---");
        fr.put("inicio_btn", "DÉMARRER");
        fr.put("pausa_btn", "PAUSE");
        fr.put("fin_btn", "FIN");
		fr.put("guardando_log", "Enregistrement de la session dans ");
		fr.put("sesion_guardada", "Session enregistrée.");
		fr.put("so_windows", "Windows");
		fr.put("so_android", "Android");
        diccionarios.put("fr", fr);

        // --- ITALIANO (it) 🇮🇹 ---
        Map<String, String> it = new HashMap<>();
        it.put("inicio", "SISTEMA: Repubblica Iniziata.");
        it.put("calibrando", "Stato: Calibrazione sensori...");
        it.put("grabando", "Stato: Modalità Molleja Attiva! Registrazione...");
        it.put("pausa", "Stato: Pausa. Prendi un espresso.");
        it.put("final", "STATO ATTUALE: FINALIZZATO");
        it.put("salud_ok", "DIAGNOSI: Ritmo stabile. Mente lucida.");
        it.put("salud_alerta", "ALLERTA: Corpo Infiammato rilevato.");
        it.put("salud_elite", "STATO: Modalità Molleja-Elite. Ottime prestazioni.");
        it.put("corazon", "BATTITO CARDIACO");
        it.put("watts", "POTENZA (WATTS)");
        it.put("json_gen", "--- PACCHETTO JSON GENERATO ---");
        it.put("inicio_btn", "INIZIA");
        it.put("pausa_btn", "PAUSA");
        it.put("fin_btn", "FINE");
		it.put("guardando_log", "Salvataggio della sessione in ");
		it.put("sesion_guardada", "Sessione salvata.");
		it.put("so_windows", "Windows");
		it.put("so_android", "Android");
        diccionarios.put("it", it);

        // --- ALEMÁN (de) 🇩🇪 ---
        Map<String, String> de = new HashMap<>();
        de.put("inicio", "SYSTEM: Republik Gestartet.");
        de.put("calibrando", "Status: Sensoren werden kalibriert...");
        de.put("grabando", "Status: Molleja-Modus Aktiv! Aufnahme...");
        de.put("pausa", "Status: Pause. Trink ein Bier.");
        de.put("final", "AKTUELLER STATUS: ABGESCHLOSSEN");
        de.put("salud_ok", "DIAGNOSE: Stabiler Rhythmus. Klarer Geist.");
        de.put("salud_alerta", "WARNUNG: Entzündeter Körper erkannt.");
        de.put("salud_elite", "STATUS: Molleja-Elite-Modus. Optimale Leistung.");
        de.put("corazon", "HERZFREQUENZ");
        de.put("watts", "LEISTUNG (WATTS)");
        de.put("json_gen", "--- JSON-PAKET ERZEUGT ---");
        de.put("inicio_btn", "START");
        de.put("pausa_btn", "PAUSE");
        de.put("fin_btn", "ENDE");
		de.put("guardando_log", "Sitzung wird gespeichert in ");
		de.put("sesion_guardada", "Sitzung erfolgreich gespeichert.");
		de.put("so_windows", "Windows");
		de.put("so_android", "Android");
        diccionarios.put("de", de);
    }

    public static String get(String idioma, String clave) {
        return diccionarios.getOrDefault(idioma, diccionarios.get("es")).get(clave);
    }
}
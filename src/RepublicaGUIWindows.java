import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class RepublicaGUIWindows extends JFrame {
    private JLabel lblStatus, lblBpm, lblWatts, lblUsuario;
    private JProgressBar barraPotencia;
    private JComboBox<String> comboPerfil, comboIdioma;
    private JPanel panelBpm, panelWatts;
    private JButton btnStart, btnPausa, btnStop;
	private JLabel lblTituloBpm, lblTituloWatts;
    
    private RepublicaEngine motor;
    private SensorDeporte bandaCardiaca;
    private CicloComputador computador;
    private Timer timerTelemetria;
    private double pesoActual = 85.0;

    // Códigos que coinciden con tu clase IdiomasRepublica
    private String[] codigosIdiomas = {"es", "gn", "en", "pt", "he", "fr", "it", "de"};
    private String rutaApp = System.getProperty("user.dir"); // Ruta de ejecución en Windows

    public RepublicaGUIWindows() {
        motor = new RepublicaEngine("es");
        bandaCardiaca = new SensorCorazon();
        computador = new CicloComputador();

        setTitle("República Ypa Molleja Fit 🚀");
        setSize(480, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(15, 15, 15));
        setLayout(new BorderLayout(10, 10));

        // --- PANEL SUPERIOR: Perfiles e Idiomas ---
        JPanel panelTop = new JPanel(new GridLayout(2, 1));
        panelTop.setOpaque(false);

        // Fila 1: Perfil
        JPanel filaPerfil = new JPanel(new FlowLayout());
        filaPerfil.setOpaque(false);
        String[] perfiles = {"David (85kg)", "Rossana (60kg)"};
        comboPerfil = new JComboBox<>(perfiles);
        lblUsuario = new JLabel("ATLETA: ");
        lblUsuario.setForeground(Color.WHITE);
        filaPerfil.add(lblUsuario);
        filaPerfil.add(comboPerfil);

        // Fila 2: Idioma
        JPanel filaIdioma = new JPanel(new FlowLayout());
        filaIdioma.setOpaque(false);
        String[] idiomasLabels = {"Español", "Guaraní", "English", "Português", "Hebreo", "Français", "Italiano", "Deutsch"};
        comboIdioma = new JComboBox<>(idiomasLabels);
        JLabel lblLang = new JLabel("IDIOMA: ");
        lblLang.setForeground(Color.WHITE);
        filaIdioma.add(lblLang);
        filaIdioma.add(comboIdioma);

        panelTop.add(filaPerfil);
        panelTop.add(filaIdioma);
        add(panelTop, BorderLayout.NORTH);

        // --- PANEL CENTRAL: Telemetría (Igual al anterior) ---
        JPanel panelCentral = new JPanel(new GridLayout(3, 1, 8, 8));
        panelCentral.setOpaque(false);

        panelBpm = crearPanelDato("HEART RATE (BPM)", 90, true);
        lblBpm = (JLabel) panelBpm.getComponent(1);
        
        panelWatts = crearPanelDato("POWER (WATTS)", 70, false);
        lblWatts = (JLabel) panelWatts.getComponent(1);

        barraPotencia = new JProgressBar(0, 500);
        barraPotencia.setForeground(Color.CYAN);
        barraPotencia.setBackground(Color.BLACK);

        panelCentral.add(panelBpm);
        panelCentral.add(panelWatts);
        panelCentral.add(barraPotencia);
        add(panelCentral, BorderLayout.CENTER);

        // --- PANEL INFERIOR: Los 3 Botones ---
        JPanel panelBotones = new JPanel(new GridLayout(1, 3, 5, 5));
        panelBotones.setOpaque(false);
        
        btnStart = new JButton("INICIAR");
        btnPausa = new JButton("PAUSA");
        btnStop = new JButton("FIN");

        EstiloBoton(btnStart, new Color(0, 150, 0));
        EstiloBoton(btnPausa, new Color(200, 150, 0));
        EstiloBoton(btnStop, new Color(150, 0, 0));

        panelBotones.add(btnStart);
        panelBotones.add(btnPausa);
        panelBotones.add(btnStop);
        add(panelBotones, BorderLayout.SOUTH);

        // --- EVENTOS ---
        
        // Cambio de Idioma Dinámico
        comboIdioma.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                actualizarInterfazIdioma();
            }
        });

        btnStart.addActionListener(e -> {
            pesoActual = comboPerfil.getSelectedIndex() == 0 ? 85.0 : 60.0;
            motor.iniciarActividad();
            iniciarRelojTelemetria();
            btnStart.setEnabled(false);
            btnPausa.setEnabled(true);
            comboIdioma.setEnabled(false);
        });

        btnPausa.addActionListener(e -> {
            if (timerTelemetria.isRunning()) {
                timerTelemetria.stop();
                btnPausa.setText("REANUDAR");
            } else {
                timerTelemetria.start();
                actualizarInterfazIdioma(); // Restablece texto según idioma
            }
        });
		
		btnStop.addActionListener(e -> {
			if(timerTelemetria != null) timerTelemetria.stop();
			motor.finalizarActividad();
			alFinalizarActividad();
			System.exit(0);
		});

        actualizarInterfazIdioma(); // Carga inicial
    }
	
	private void actualizarInterfazIdioma() {
		String lang = codigosIdiomas[comboIdioma.getSelectedIndex()];
		motor.setLenguaje(lang); 

		// Botones
		btnStart.setText(IdiomasRepublica.get(lang, "inicio_btn"));
		btnPausa.setText(IdiomasRepublica.get(lang, "pausa_btn"));
		btnStop.setText(IdiomasRepublica.get(lang, "fin_btn"));

		// Etiquetas de Telemetría
		lblTituloBpm.setText("  " + IdiomasRepublica.get(lang, "corazon"));
		lblTituloWatts.setText("  " + IdiomasRepublica.get(lang, "watts"));
		
		revalidate();
		repaint();
	}
	
    private JPanel crearPanelDato(String titulo, int fontSize, boolean esBpm) {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(new Color(30, 30, 30));
        JLabel t = new JLabel("  " + titulo);
        t.setForeground(Color.LIGHT_GRAY);
		
		// Guardamos la referencia según corresponda
		if (esBpm) lblTituloBpm = t; 
		else lblTituloWatts = t;

		JLabel v = new JLabel("--", SwingConstants.CENTER);
        v.setFont(new Font("Monospaced", Font.BOLD, fontSize));
        v.setForeground(Color.WHITE);
        p.add(t, BorderLayout.NORTH);
        p.add(v, BorderLayout.CENTER);
        return p;
    }
	
	private void EstiloBoton(JButton b, Color c) {
		b.setBackground(c);
		b.setForeground(Color.WHITE);
		b.setFont(new Font("Arial", Font.BOLD, 12)); // Bajamos a 12 para que entre "INICIAR ENTRENAMIENTO"
		b.setFocusPainted(false);
		b.setBorder(BorderFactory.createRaisedBevelBorder());
	}
	
    private void iniciarRelojTelemetria() {
        timerTelemetria = new Timer(750, e -> {
            double bpm = bandaCardiaca.leerDato();
            double watts = computador.estimarWatts(pesoActual, 35.0);
            lblBpm.setText(String.format("%.0f", bpm));
            lblWatts.setText(String.format("%.1f W", watts));
            barraPotencia.setValue((int)watts);

            panelBpm.setBackground(bpm > 170 ? new Color(180, 0, 0) : new Color(40, 40, 40));
            if (watts > 250) {
                panelWatts.setBackground(new Color(218, 165, 32));
                lblWatts.setForeground(Color.BLACK);
            } else {
                panelWatts.setBackground(new Color(50, 50, 50));
                lblWatts.setForeground(Color.CYAN);
            }
        });
        timerTelemetria.start();
    }
    
	private void alFinalizarActividad() {
		String lang = codigosIdiomas[comboIdioma.getSelectedIndex()];
		RepublicaCore core = new RepublicaCore();
		String rutaFinal = core.obtenerRutaLog(rutaApp);
		
		// --- LÓGICA DE ESCRITURA REAL ---
		try (java.io.FileWriter fw = new java.io.FileWriter(rutaFinal, true);
			 java.io.PrintWriter pw = new java.io.PrintWriter(fw)) {
			
			pw.println("----------------------------------------");
			pw.println(IdiomasRepublica.get(lang, "guardando_log") + 
					   IdiomasRepublica.get(lang, "so_windows"));
			pw.println("Atleta: " + comboPerfil.getSelectedItem());
			pw.println("BPM: " + lblBpm.getText());
			pw.println("Watts: " + lblWatts.getText());
			pw.println("----------------------------------------\n");
			
			// Mensaje de éxito en consola
			System.out.println("Archivo escrito correctamente en: " + rutaFinal);
			
		} catch (java.io.IOException ex) {
			System.err.println("Error al escribir el archivo: " + ex.getMessage());
		}
		
		// Tu mensaje que ya tenías
		JOptionPane.showMessageDialog(this, IdiomasRepublica.get(lang, "sesion_guardada"));
	}
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RepublicaGUIWindows().setVisible(true));
    }
}
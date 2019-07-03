package ui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.Centralita;
import main.Llamada;
import main.LlamadaLocal;
import main.LlamadaProvincial;

@SuppressWarnings("serial")
public class mainPanel extends JPanel {
	private JComboBox comboTipoLlamada;
	private JLabel lblTipoDeLlamada;
	private JLabel lblFranjaHoraria;
	private JComboBox comboFranjaHoraria;
	private JLabel lblNewLabel;
	private JTextField textFieldNumeroOrigen;
	private JLabel lblNumeroDestino;
	private JTextField textFieldNumeroDestino;
	private JTextField textFieldDuracionLlamada;
	private JLabel lblDuracionLlamada;
	private JButton btnRegistrarLlamada;
	private JTextField textFieldDetalle;
	private JTextArea textAreaRessumen;
	private JButton btnNewButton;

	private String tipoLLamada = "Local";
	private String franja = "Franja 1";
	private Centralita centralita;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public mainPanel() {
		setLayout(null);
		/**
		 * Creamos una centralita en el momento de construcción del panel (si me ve esto
		 * Erich Gamma me lincha fijo)
		 */
		centralita = new Centralita();

		comboTipoLlamada = new JComboBox();
		comboTipoLlamada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoLLamada = (String) comboTipoLlamada.getSelectedItem();
				if (tipoLLamada == "Provincial") {
					comboFranjaHoraria.setEnabled(true);
				}else {
					comboFranjaHoraria.setEnabled(false);
				}
			}
		});
		comboTipoLlamada.setModel(new DefaultComboBoxModel(new String[] { "Local", "Provincial" }));
		comboTipoLlamada.setBounds(147, 6, 148, 27);
		add(comboTipoLlamada);

		lblTipoDeLlamada = new JLabel("Tipo de Llamada");
		lblTipoDeLlamada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeLlamada.setBounds(22, 10, 108, 16);
		add(lblTipoDeLlamada);

		lblFranjaHoraria = new JLabel("Franja horaria");
		lblFranjaHoraria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFranjaHoraria.setBounds(340, 10, 92, 16);
		add(lblFranjaHoraria);

		comboFranjaHoraria = new JComboBox();
		comboFranjaHoraria.setEnabled(false);
		comboFranjaHoraria.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				franja = (String) comboFranjaHoraria.getSelectedItem();
			}
		});
		comboFranjaHoraria.setModel(new DefaultComboBoxModel(new String[] { "Franja 1", "Franja 2", "Franja 3" }));
		comboFranjaHoraria.setBounds(444, 6, 148, 27);
		add(comboFranjaHoraria);

		lblNewLabel = new JLabel("Numero Origen");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 38, 120, 16);
		add(lblNewLabel);

		textFieldNumeroOrigen = new JTextField();
		textFieldNumeroOrigen.setBounds(147, 33, 140, 26);
		add(textFieldNumeroOrigen);
		textFieldNumeroOrigen.setColumns(10);

		lblNumeroDestino = new JLabel("Numero Destino");
		lblNumeroDestino.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroDestino.setBounds(312, 38, 120, 16);
		add(lblNumeroDestino);

		textFieldNumeroDestino = new JTextField();
		textFieldNumeroDestino.setColumns(10);
		textFieldNumeroDestino.setBounds(444, 33, 140, 26);
		add(textFieldNumeroDestino);

		textFieldDuracionLlamada = new JTextField();
		textFieldDuracionLlamada.setColumns(10);
		textFieldDuracionLlamada.setBounds(147, 61, 140, 26);
		add(textFieldDuracionLlamada);

		lblDuracionLlamada = new JLabel("Duracion Llamada");
		lblDuracionLlamada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDuracionLlamada.setBounds(22, 66, 120, 16);
		add(lblDuracionLlamada);

		btnRegistrarLlamada = new JButton("Registrar Llamada");
		
		  btnRegistrarLlamada.addActionListener(new ActionListener() { public void
		  actionPerformed(ActionEvent e) { registraLlamada(tipoLLamada, textFieldNumeroOrigen.getText(),
		  textFieldNumeroDestino.getText(), Integer.valueOf(textFieldDuracionLlamada.getText()), franja); } });
		 
		btnRegistrarLlamada.setBounds(444, 61, 148, 29);
		add(btnRegistrarLlamada);

		textFieldDetalle = new JTextField();
		textFieldDetalle.setBackground(SystemColor.window);
		textFieldDetalle.setBounds(0, 369, 598, 26);
		add(textFieldDetalle);
		textFieldDetalle.setColumns(10);

		textAreaRessumen = new JTextArea();
		textAreaRessumen.setBounds(6, 99, 586, 268);
		add(textAreaRessumen);

		btnNewButton = new JButton("Buscar Llamada");
		btnNewButton.setBounds(299, 61, 148, 29);
		add(btnNewButton);

	}

	private void registraLlamada(String tipo, String numeroOrigen, String numeroDestino, int durac, String franja) {
		if (tipo == "Local") {
			LlamadaLocal llam = new LlamadaLocal(numeroOrigen, numeroDestino, durac);
			centralita.agregarLlamada(llam);
			this.rellenaLista(llam);
		} else {
			int franjaInt = 0;
			switch (franja) {
				case "Franja 1":
					franjaInt = 1;
					break;
				case "Franja 2":
					franjaInt = 2;
					break;
				case "Franja 3":
					franjaInt = 3;
					break;
			}
			LlamadaProvincial llam = new LlamadaProvincial(numeroOrigen, numeroDestino, durac, franjaInt);
			centralita.agregarLlamada(llam);
			this.rellenaLista(llam);
		}
	}
	
	private void rellenaLista(Llamada llam) {
		String llamadaString ="";
		if (llam instanceof LlamadaLocal) {
			llamadaString += String.format("\n        LOCAL Origen: %s    Destino: %s    Duracion: %s    Coste: %.2f", textFieldNumeroOrigen.getText(), textFieldNumeroDestino.getText(), textFieldDuracionLlamada.getText(),centralita.getCosteUltimaLlamada());
		}else {
			llamadaString += String.format("\nPROVINCIAL Origen: %s    Destino: %s    Duracion: %s    Coste: %.2f    Franja: %s", textFieldNumeroOrigen.getText(), textFieldNumeroDestino.getText(), textFieldDuracionLlamada.getText(),centralita.getCosteUltimaLlamada(), comboFranjaHoraria.getSelectedItem());
		}
		textAreaRessumen.setText(textAreaRessumen.getText()+llamadaString);
		this.refrescaDetalle();
	}
	
	private void refrescaDetalle() {
		textFieldDetalle.setText(String.format("Numero de Llamadas: %d Coste Total: %.2f", centralita.getNumeroLlamadas(), centralita.getCosteTotal()));
	}
}

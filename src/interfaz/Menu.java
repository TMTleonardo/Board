package interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu extends JPanel {

	private final String[] menuElementos = { "Agregar", "Eliminar", "Mover", "Editar", "Filtrar", "Guardar", "Cargar",
			"Restablecer" };
	
	static final int PANEL_MENU_WIDTH = 200;

	public Menu() {
		initPanel();
		initLabel();
		botonAgregar();
	}

	private void initPanel() {
		setLayout(null);
		setBackground(new Color(255, 150, 50));
		setBounds(0, 0, PANEL_MENU_WIDTH, MainWindow.SCREEN_HEIGHT);
	}

	private void initLabel() {
		JLabel header = new JLabel("MENU", SwingConstants.CENTER);
		header.setOpaque(true);
		header.setBackground(Color.cyan);
		header.setBounds(0, 0, PANEL_MENU_WIDTH, MainWindow.SCREEN_HEIGHT / 10);
		add(header);
	}

	private void botonAgregar() {
		JButton b1 = new JButton(menuElementos[0]);
		b1.setBounds(0, (1) * (MainWindow.SCREEN_HEIGHT / 10), PANEL_MENU_WIDTH, MainWindow.SCREEN_HEIGHT / 10);
		add(b1);

	ActionListener agregar = new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			Board.c1.agregarTarjeta();
			//new VentanaEdicion();
		}
	};
		b1.addActionListener(agregar);
	}
}

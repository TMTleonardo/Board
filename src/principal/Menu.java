package principal;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu extends JPanel {

	private final String[] menuElementos = { "Agregar", "Eliminar", "Mover", "Editar", "Filtrar", "Guardar", "Cargar", "Restablecer"};
	static final int PANEL_MENU_WIDTH = 200;

	public Menu() {
		initPanel();
		initLabel();
		initBoton();
	}

	private void initPanel() {
		setLayout(null);
		setBackground(new Color(255, 150, 50));
		setBounds(0, 0, PANEL_MENU_WIDTH, Window.SCREEN_HEIGHT);
	}

	private void initLabel() {
		JLabel header = new JLabel("MENU",SwingConstants.CENTER);
		header.setOpaque(true);
		header.setBackground(Color.cyan);
		header.setBounds(0,0,PANEL_MENU_WIDTH,Window.SCREEN_HEIGHT/10);
		add(header);
	}
	
	private void initBoton() {
		for(int i = 0; i < 8; i++) {
			String s = menuElementos[i];
			JButton b1 = new JButton(s);
			b1.setBounds(0,(1+i)*(Window.SCREEN_HEIGHT/10),PANEL_MENU_WIDTH,Window.SCREEN_HEIGHT/10);
			add(b1);
		}
	}

}

package interfaz;

import java.awt.Dimension;

import javax.swing.JFrame;

public class VentanaEdicion extends JFrame{
	
	public VentanaEdicion() {
		this.setPreferredSize(new Dimension(500,500));
		this.setTitle("Edicion");
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}

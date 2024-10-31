package interfaz;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

	//Dimensiones de la ventana
static final int SCREEN_WIDTH = 1200;
static final int SCREEN_HEIGHT = 650;
static final Dimension SCREEN_SIZE = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);

	
	public MainWindow(){
		MainPanel mainPanel = new MainPanel();
		
		this.getContentPane().add(mainPanel);
		iniciarComponentes();
		this.setPreferredSize(SCREEN_SIZE);
		this.setTitle("Board");
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	
	private void iniciarComponentes() {
		
		
		
	}
}

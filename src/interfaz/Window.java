package interfaz;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame {

	//Dimensiones de la ventana
static final int SCREEN_WIDTH = 1200;
static final int SCREEN_HEIGHT = 650;
static final Dimension SCREEN_SIZE = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);

	
	public Window(){
		init();
	}
	
	public void init() {
		//Configuraciones de la ventana
		this.setPreferredSize(SCREEN_SIZE);
		this.setTitle("Board");
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	private void iniciarComponentes() {
		//Crea el panel principal y el panel de menu y el board
		Panel mainPanel = new Panel();
		Menu menu = new Menu();
		Board board = new Board();
		
		//Configuraciones del panel principal
		mainPanel.setBackground(new Color(62,62,66));
		mainPanel.setLayout(null);
		this.getContentPane().add(mainPanel);
		
		//Agrega paneles secundarios al principal
		mainPanel.add(menu);
		mainPanel.add(board);
		
		
	}
}

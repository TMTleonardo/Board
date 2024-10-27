package principal;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class Window extends JFrame {
	
static final int SCREEN_WIDTH = 1100;
static final int SCREEN_HEIGHT = 650;
static final Dimension SCREEN_SIZE = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);

	
	public Window(){
		init();
	}
	
	public void init() {
		
		this.setPreferredSize(SCREEN_SIZE);
		this.setTitle("Dash Board");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	private void iniciarComponentes() {
		Panel mainPanel = new Panel();
		Menu menu = new Menu();
		Board board = new Board();
		
		
		mainPanel.setBackground(new Color(62,62,66));
		mainPanel.setLayout(null);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
	    mainPanel.setPreferredSize(new Dimension(350, 190));
	    
		this.getContentPane().add(mainPanel);
		
		mainPanel.add(menu);
		mainPanel.add(board);
		
		
	}
}

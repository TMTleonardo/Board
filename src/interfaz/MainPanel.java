package interfaz;

import java.awt.Color;

import javax.swing.JPanel;

public class MainPanel extends JPanel{

	
	public MainPanel() {
		Menu menu = new Menu();
		Board board = new Board();
		setBackground(new Color(62,62,66));
		setLayout(null);
		add(menu);
		add(board);
	}
	
	
}

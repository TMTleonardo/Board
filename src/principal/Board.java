package principal;

import java.awt.Color;

import javax.swing.JPanel;

public class Board extends JPanel{
	
	private final int BOARD_WIDTH = Window.SCREEN_WIDTH - Menu.WIDTH;
	private final int BOARD_HEIGHT = Window.SCREEN_HEIGHT;
	
	public Board() {
		initBoard();
		columnasBoard();
	}
	
	private void initBoard() {
		setBounds(Menu.PANEL_MENU_WIDTH,0,BOARD_WIDTH, BOARD_HEIGHT);
		setBackground(new Color(90,150,150));
	}
	
	private void columnasBoard() {
		
	}

}

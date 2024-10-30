package interfaz;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Board extends JPanel{
	
	private final int BOARD_WIDTH = Window.SCREEN_WIDTH - Menu.PANEL_MENU_WIDTH;
	private final int BOARD_HEIGHT = Window.SCREEN_HEIGHT;
	
	public Board() {
		setBounds(Menu.PANEL_MENU_WIDTH,0,BOARD_WIDTH, BOARD_HEIGHT);
		setLayout(new GridLayout(1,3,30,0));
		setBackground(new Color(90,150,150));
		setBorder(BorderFactory.createEmptyBorder(10, 10, 60, 30));
		
		//Crea las columnas y la añade al board
		Columna c1 = new Columna("Columna1");
		Columna c2 = new Columna("Columna2");
		Columna c3 = new Columna("Columna3");
		
		for(int i = 0; i<10;i++) {
			Tarjeta t = new Tarjeta("Tarjeta " + (i+1));
            c1.add(t);
		}
		add(c1);
		add(c2);
		add(c3);
	
	}

}

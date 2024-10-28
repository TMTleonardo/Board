package principal;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;

public class Columna extends JLayeredPane{

	public Columna(String tituloColumna) {
		setLayout(new GridLayout(10,1,30,0));
        setBorder(BorderFactory.createTitledBorder(null, tituloColumna, TitledBorder.CENTER, TitledBorder.TOP)); 
        
        
	}
	
	
}

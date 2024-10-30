package interfaz;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;

public class Tarjeta extends JLayeredPane {
	
	public Tarjeta(String tituloTarjeta) {
        setBorder(BorderFactory.createTitledBorder(null, tituloTarjeta, TitledBorder.CENTER, TitledBorder.CENTER)); 
	}
	

}

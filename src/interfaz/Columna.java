package interfaz;

import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;

public class Columna extends JLayeredPane{

	private LinkedList<Tarjeta> listaTarjetas = new LinkedList<>();
	private String tituloColumna = "Columna";
	private static Scanner scan = new Scanner(System.in);

	public Columna(String tituloColumna) {
		setLayout(new GridLayout(10, 1, 30, 0));
		setBorder(BorderFactory.createTitledBorder(null, tituloColumna, TitledBorder.CENTER, TitledBorder.TOP));

	}

	public void agregarTarjeta() {
		System.out.println("Ingrese el nombre de la tarjeta");
		String nombreTarjeta = scan.nextLine();
		Tarjeta t = new Tarjeta(nombreTarjeta);
		listaTarjetas.add(t);
		add(t);
		//scan.close();
	}
	
	
}

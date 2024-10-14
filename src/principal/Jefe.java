package principal;

import java.util.LinkedList;

public class Jefe extends Empleado {

	private LinkedList<Empleado> equipo = new LinkedList<>();

	public Jefe(String nombre, String apellido, String codigo, String correoElectronico) {
		super(nombre, apellido, codigo, correoElectronico);

	}

}

package principal;

import java.util.LinkedList;

public class Empleado {

	private String nombre;
	private String apellido;
	private String codigo;
	private String correoElectronico;
	private LinkedList<String> tareas = new LinkedList<>();
  
  public Empleado(String nombre, String apellido, String codigo) {
	  this.nombre = nombre;
	  this.apellido = apellido;
	  this.codigo = codigo;
  }
}

package principal;

import java.util.LinkedList;

public class Empleado {

	private String nombre;
    private String apellido;
    private String codigo;
    private String correoElectronico;

    public Empleado(String nombre, String apellido, String codigo, String correoElectronico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
        this.correoElectronico = correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }
}

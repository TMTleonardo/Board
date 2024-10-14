package principal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JefeTest {

	@Test
	void testJefe() {
		Empleado Jefe = new Jefe("Juan", "Pérez", "1234", "juan.perez@example.com");

		assertEquals("Juan", Jefe.getNombre());
		assertEquals("Pérez", Jefe.getApellido());
		assertEquals("1234", Jefe.getCodigo());
		assertEquals("juan.perez@example.com", Jefe.getCorreoElectronico());
	}

}

package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import principal.DatabaseConnection;
import principal.Evento;

class EventoTest {

    private Evento evento;

    @BeforeEach
    void setUp() {
        // Inicializar el objeto Evento antes de cada prueba
        evento = new Evento("Intervalo de Prueba");
    }

    @AfterEach
    void tearDown() {
        // Eliminar el evento de prueba de la base de datos después de cada prueba
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Evento WHERE intervalo = ?")) {
            pstmt.setString(1, evento.getIntervalo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGuardarEventoEnBD() {
        // Llamar al método que se quiere probar
        evento.guardarEventoEnBD();

        // Verificar si el evento fue guardado en la base de datos
        boolean existe = false;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Evento WHERE intervalo = ?")) {
            pstmt.setString(1, evento.getIntervalo());
            ResultSet rs = pstmt.executeQuery();
            existe = rs.next(); // Si hay resultados, el evento existe
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Afirmar que el evento existe en la base de datos
        assertTrue(existe, "El evento debería existir en la base de datos.");
    }
}

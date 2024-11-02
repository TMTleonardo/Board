package principal;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DatabaseConnectionTest {

    private Connection connection;

    @BeforeEach
    void setUp() {
        connection = DatabaseConnection.getConnection();
    }

    @AfterEach
    void tearDown() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void testGetConnection() {
        assertNotNull( connection, "La conexión debería ser establecida correctamente." );
    }

    @Test
    void testMain() {
        assertDoesNotThrow(() -> {
            DatabaseConnection.main(new String[]{});
        }, "El método main debería ejecutarse sin lanzar excepciones." );
    }
}
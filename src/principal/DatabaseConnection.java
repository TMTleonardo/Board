package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // URL de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/ProyectoAgenda";
    private static final String USER = "root"; // Usuario de MySQL
    private static final String PASSWORD = "proyectoalgo2"; // Contraseña de MySQL

    // Método para obtener la conexión
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Carga el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Conecta con la base de datos		
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            e.printStackTrace();
        }
        return connection;
    }
    
    // Método principal para probar la conexión
    public static void main(String[] args) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn != null) {
            System.out.println("Conexión establecida.");
            try {
                conn.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
    }
}

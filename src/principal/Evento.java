package principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Evento {

    private String intervalo;  

    public Evento(String intervalo) {
        this.intervalo = intervalo;
    }

    public void modificarEvento(String nuevoIntervalo) {
        this.intervalo = nuevoIntervalo;
        System.out.println("Evento modificado: " + intervalo);
        actualizarEventoEnBD();
    }

    public void cancelarEvento() {
        System.out.println("Evento cancelado: " + intervalo);
        eliminarEventoEnBD();
        this.intervalo = null;
    }

    public String getIntervalo() {
        return intervalo;
    }

    // Método para guardar el evento en la base de datos
    public void guardarEventoEnBD() {
        System.out.println("Iniciando el proceso de guardar evento en la base de datos...");
        String sql = "INSERT INTO Evento (intervalo) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(true); // Asegura que los cambios se guarden automáticamente
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, intervalo);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Evento guardado en la base de datos.");
                } else {
                    System.out.println("No se insertó ninguna fila.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar el evento en la base de datos.");
            e.printStackTrace();
        }
    }



    // Método para actualizar el evento en la base de datos
    public void actualizarEventoEnBD() {
        String sql = "UPDATE Evento SET intervalo = ? WHERE intervalo = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, intervalo);
            pstmt.setString(2, intervalo); // Asumiendo que 'intervalo' es un identificador único
            pstmt.executeUpdate();
            System.out.println("Evento actualizado en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el evento en la base de datos.");
            e.printStackTrace();
        }
    }

    // Método para eliminar el evento de la base de datos
    public void eliminarEventoEnBD() {
        String sql = "DELETE FROM Evento WHERE intervalo = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, intervalo);
            pstmt.executeUpdate();
            System.out.println("Evento eliminado de la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el evento de la base de datos.");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el intervalo del evento al usuario
        System.out.print("Ingrese el intervalo del evento: ");
        String intervalo = scanner.nextLine();

        // Crear una instancia de Evento y guardar en la base de datos
        Evento evento = new Evento(intervalo);
        evento.guardarEventoEnBD();

        scanner.close();
    }
}


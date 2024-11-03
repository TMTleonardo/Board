package principal;

import javax.swing.*;
import java.sql.*;

public class Jefe {

    public static void verificarYGestionarTareas(JFrame frame) {
        if (!hayJefeRegistrado()) {
            int option = JOptionPane.showConfirmDialog(null, "No hay ningún jefe registrado. ¿Desea registrarse como jefe?", "Registro de Jefe", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                registrarJefe();
            }
        } else {
            Tarea.gestionarTareasPanel();
        }
    }

    private static boolean hayJefeRegistrado() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM Jefe")) {
            if (rs.next()) {
                return rs.getInt("total") > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void registrarJefe() {
        JTextField nombre = new JTextField();
        JTextField apellidoPaterno = new JTextField();
        JTextField apellidoMaterno = new JTextField();
        JTextField edad = new JTextField();
        JTextField correo = new JTextField();
        JTextField ocupacion = new JTextField();
        JPasswordField password = new JPasswordField();

        Object[] fields = {"Nombre:", nombre, "Apellido Paterno:", apellidoPaterno, "Apellido Materno:", apellidoMaterno,
                "Edad:", edad, "Correo Electrónico:", correo, "Ocupación:", ocupacion, "Contraseña:", password};

        int option = JOptionPane.showConfirmDialog(null, fields, "Registrar Jefe", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try (Connection conn = DatabaseConnection.getConnection()) {
                String usuario = Empleado.generarUsuario(nombre.getText(), apellidoPaterno.getText(), apellidoMaterno.getText(), Integer.parseInt(edad.getText()));
                String sqlEmpleado = "INSERT INTO Empleado (nombre, apellidoPaterno, apellidoMaterno, edad, correoElectronico, ocupacion, usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmtEmpleado = conn.prepareStatement(sqlEmpleado, Statement.RETURN_GENERATED_KEYS);
                pstmtEmpleado.setString(1, nombre.getText());
                pstmtEmpleado.setString(2, apellidoPaterno.getText());
                pstmtEmpleado.setString(3, apellidoMaterno.getText());
                pstmtEmpleado.setInt(4, Integer.parseInt(edad.getText()));
                pstmtEmpleado.setString(5, correo.getText());
                pstmtEmpleado.setString(6, ocupacion.getText());
                pstmtEmpleado.setString(7, usuario);
                pstmtEmpleado.executeUpdate();

                ResultSet rs = pstmtEmpleado.getGeneratedKeys();
                if (rs.next()) {
                    int idEmpleado = rs.getInt(1);
                    String sqlJefe = "INSERT INTO Jefe (idEmpleado, contraseña) VALUES (?, ?)";
                    PreparedStatement pstmtJefe = conn.prepareStatement(sqlJefe);
                    pstmtJefe.setInt(1, idEmpleado);
                    pstmtJefe.setString(2, new String(password.getPassword()));
                    pstmtJefe.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Jefe registrado exitosamente. Usuario: " + usuario);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


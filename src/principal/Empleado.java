package principal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Empleado {

    private static JTable empleadosTable;
    private static DefaultTableModel tableModel;

    public static JPanel gestionarEmpleadosPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Gestión de Empleados"), BorderLayout.NORTH);
        tableModel = new DefaultTableModel(new String[]{"ID", "Nombre", "Rol"}, 0);
        empleadosTable = new JTable(tableModel);
        actualizarTablaEmpleados();
        panel.add(new JScrollPane(empleadosTable), BorderLayout.CENTER);
        JPanel botonesPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        JButton btnAddEmployee = new JButton("Agregar Empleado");
        btnAddEmployee.addActionListener(e -> agregarEmpleado());
        JButton btnDeleteEmployee = new JButton("Eliminar Empleado");
        btnDeleteEmployee.addActionListener(e -> eliminarEmpleado());
        JButton btnAddJefe = new JButton("Agregar Jefe");
        btnAddJefe.addActionListener(e -> agregarJefe());
        JButton btnDeleteJefe = new JButton("Eliminar Jefe");
        btnDeleteJefe.addActionListener(e -> eliminarJefe());
        botonesPanel.add(btnAddEmployee);
        botonesPanel.add(btnDeleteEmployee);
        botonesPanel.add(btnAddJefe);
        botonesPanel.add(btnDeleteJefe);
        panel.add(botonesPanel, BorderLayout.SOUTH);
        return panel;
    }

    private static void actualizarTablaEmpleados() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                 "SELECT E.idEmpleado, E.nombre, IF(J.idJefe IS NOT NULL, 'Jefe', 'Empleado') AS rol " +
                 "FROM Empleado E LEFT JOIN Jefe J ON E.idEmpleado = J.idEmpleado")) {

            tableModel.setRowCount(0);
            while (rs.next()) {
                tableModel.addRow(new Object[]{
                        rs.getInt("idEmpleado"),
                        rs.getString("nombre"),
                        rs.getString("rol")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void agregarEmpleado() {
        JTextField nombre = new JTextField();
        JTextField apellidoPaterno = new JTextField();
        JTextField apellidoMaterno = new JTextField();
        JTextField edad = new JTextField();
        JTextField correo = new JTextField();
        JTextField ocupacion = new JTextField();

        Object[] fields = {
            "Nombre:", nombre,
            "Apellido Paterno:", apellidoPaterno,
            "Apellido Materno:", apellidoMaterno,
            "Edad:", edad,
            "Correo:", correo,
            "Ocupación:", ocupacion
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Agregar Empleado", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try (Connection conn = DatabaseConnection.getConnection()) {
                String usuario = generarUsuario(nombre.getText(), apellidoPaterno.getText(), apellidoMaterno.getText(), Integer.parseInt(edad.getText()));
                String sql = "INSERT INTO Empleado (nombre, apellidoPaterno, apellidoMaterno, edad, correoElectronico, ocupacion, usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, nombre.getText());
                pstmt.setString(2, apellidoPaterno.getText());
                pstmt.setString(3, apellidoMaterno.getText());
                pstmt.setInt(4, Integer.parseInt(edad.getText()));
                pstmt.setString(5, correo.getText());
                pstmt.setString(6, ocupacion.getText());
                pstmt.setString(7, usuario);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Empleado agregado exitosamente. Usuario: " + usuario);
                actualizarTablaEmpleados();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static String generarUsuario(String nombre, String apellidoPaterno, String apellidoMaterno, int edad) {
        return nombre.substring(0, 2).toUpperCase() + apellidoPaterno + apellidoMaterno + edad;
    }

    public static void eliminarEmpleado() {
        JTextField idField = new JTextField();
        Object[] message = {"ID del Empleado:", idField};

        int option = JOptionPane.showConfirmDialog(null, message, "Eliminar Empleado", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try (Connection conn = DatabaseConnection.getConnection()) {
                String sql = "DELETE FROM Empleado WHERE idEmpleado = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, Integer.parseInt(idField.getText()));
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Empleado eliminado exitosamente.");
                actualizarTablaEmpleados();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void agregarJefe() {
        JTextField nombre = new JTextField();
        JTextField apellidoPaterno = new JTextField();
        JTextField apellidoMaterno = new JTextField();
        JTextField edad = new JTextField();
        JTextField correo = new JTextField();
        JTextField ocupacion = new JTextField();
        JTextField usuario = new JTextField();
        JPasswordField password = new JPasswordField();

        Object[] fields = {
            "Nombre:", nombre,
            "Apellido Paterno:", apellidoPaterno,
            "Apellido Materno:", apellidoMaterno,
            "Edad:", edad,
            "Correo:", correo,
            "Ocupación:", ocupacion,
            "Usuario:", usuario,
            "Contraseña:", password
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Agregar Jefe", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try (Connection conn = DatabaseConnection.getConnection()) {
                String sqlEmpleado = "INSERT INTO Empleado (nombre, apellidoPaterno, apellidoMaterno, edad, correoElectronico, ocupacion, usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmtEmpleado = conn.prepareStatement(sqlEmpleado, Statement.RETURN_GENERATED_KEYS);
                pstmtEmpleado.setString(1, nombre.getText());
                pstmtEmpleado.setString(2, apellidoPaterno.getText());
                pstmtEmpleado.setString(3, apellidoMaterno.getText());
                pstmtEmpleado.setInt(4, Integer.parseInt(edad.getText()));
                pstmtEmpleado.setString(5, correo.getText());
                pstmtEmpleado.setString(6, ocupacion.getText());
                pstmtEmpleado.setString(7, usuario.getText());
                pstmtEmpleado.executeUpdate();
                ResultSet rs = pstmtEmpleado.getGeneratedKeys();
                if (rs.next()) {
                    int idEmpleado = rs.getInt(1);
                    String sqlJefe = "INSERT INTO Jefe (idEmpleado, contraseña) VALUES (?, ?)";
                    PreparedStatement pstmtJefe = conn.prepareStatement(sqlJefe);
                    pstmtJefe.setInt(1, idEmpleado);
                    pstmtJefe.setString(2, new String(password.getPassword()));
                    pstmtJefe.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Jefe agregado exitosamente.");
                    actualizarTablaEmpleados();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void eliminarJefe() {
        JTextField idEmpleadoField = new JTextField();
        Object[] message = {"ID del Jefe:", idEmpleadoField};
        int option = JOptionPane.showConfirmDialog(null, message, "Eliminar Jefe", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try (Connection conn = DatabaseConnection.getConnection()) {
                String sql = "DELETE FROM Jefe WHERE idEmpleado = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, Integer.parseInt(idEmpleadoField.getText()));
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Jefe eliminado exitosamente.");
                actualizarTablaEmpleados();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
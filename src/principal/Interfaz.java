package principal;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interfaz extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public Interfaz() {
        setTitle("ProyectoAgenda");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(6, 1, 5, 5));
        menuPanel.setBackground(new Color(60, 63, 65));
        JButton btnDashboard = createMenuButton("Dashboard", e -> mostrarSeccion("Dashboard"));
        JButton btnCalendar = createMenuButton("Calendario", e -> mostrarSeccion("Calendario"));
        JButton btnTasks = createMenuButton("Gestión de Tareas", e -> mostrarSeccion("Tareas"));
        JButton btnEmployees = createMenuButton("Gestión de Empleados", e -> mostrarSeccion("Empleados"));
        JButton btnEvents = createMenuButton("Gestión de Eventos", e -> mostrarSeccion("Eventos"));
        JButton btnNotifications = createMenuButton("Notificaciones", e -> mostrarSeccion("Notificaciones"));
        menuPanel.add(btnDashboard);
        menuPanel.add(btnCalendar);
        menuPanel.add(btnTasks);
        menuPanel.add(btnEmployees);
        menuPanel.add(btnEvents);
        menuPanel.add(btnNotifications);
        add(menuPanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
        mainPanel.add(new JLabel("Bienvenido al Dashboard de ProyectoAgenda"), "Dashboard");
        mainPanel.add(Calendario.crearPanelCalendario(), "Calendario");
        mainPanel.add(Tarea.gestionarTareasPanel(), "Tareas");
        mainPanel.add(Empleado.gestionarEmpleadosPanel(), "Empleados");
        mainPanel.add(Evento.gestionarEventosPanel(), "Eventos");
        mainPanel.add(new JLabel("Sección de Notificaciones"), "Notificaciones");

        setVisible(true);
    }
    
    private JButton createMenuButton(String text, ActionListener action) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setBackground(new Color(80, 80, 82));
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.addActionListener(action);
        return button;
    }

    private void mostrarSeccion(String seccion) {
        cardLayout.show(mainPanel, seccion);
    }

    public static void main(String[] args) {
        new Interfaz();
    }
}

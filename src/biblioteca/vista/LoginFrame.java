
package biblioteca.vista;

import biblioteca.controlador.LoginController;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private final JTextField campoUsuario;
    private final JPasswordField campoContrasena;
    private final JButton botonIngresar;
    private final LoginController controlador;

    public LoginFrame() {
        controlador = new LoginController();

        setTitle("Biblioteca Escolar - Inicio de sesión");
        setSize(420, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        panel.add(new JLabel("Usuario:"));
        campoUsuario = new JTextField();
        panel.add(campoUsuario);

        panel.add(new JLabel("Contraseña:"));
        campoContrasena = new JPasswordField();
        panel.add(campoContrasena);

        panel.add(new JLabel(""));
        botonIngresar = new JButton("Ingresar");
        panel.add(botonIngresar);

        JButton salir = new JButton("Salir");
        panel.add(salir);

        add(panel);

        botonIngresar.addActionListener(e -> ingresar());
        campoContrasena.addActionListener(e -> ingresar());
        salir.addActionListener(e -> dispose());
    }

    private void ingresar() {
        String usuario = campoUsuario.getText().trim();
        String clave = new String(campoContrasena.getPassword());

        if (usuario.isEmpty() || clave.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Ingresa usuario y contraseña.");
            return;
        }

        try {
            if (controlador.autenticar(usuario, clave)) {
                JOptionPane.showMessageDialog(this, "Inicio de sesión correcto.");
                new BibliotecaFrame().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Usuario o contraseña incorrectos.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "No se pudo iniciar sesión: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}

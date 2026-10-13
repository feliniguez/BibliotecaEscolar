
package biblioteca.vista;

import javax.swing.*;
import java.awt.*;

public class LibrosFrame extends JFrame {

    public LibrosFrame() {
        setTitle("Gestión de libros");
        setSize(650, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel titulo = new JLabel(
                "Gestión de libros",
                SwingConstants.CENTER
        );
        titulo.setFont(new Font("Arial", Font.BOLD, 22));

        JButton btnCerrar = new JButton("Volver al menú");
        btnCerrar.addActionListener(e -> dispose());

        add(titulo, BorderLayout.NORTH);
        add(new JLabel(
                "Módulo de libros: pendiente de conectar con MySQL",
                SwingConstants.CENTER
        ), BorderLayout.CENTER);
        add(btnCerrar, BorderLayout.SOUTH);
    }
}

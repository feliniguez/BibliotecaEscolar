
package biblioteca.vista;

import biblioteca.controlador.BibliotecaController;
import javax.swing.*;
import java.awt.*;

public class BibliotecaFrame extends JFrame {

    public BibliotecaFrame() {
        setTitle("Biblioteca Escolar");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titulo = new JLabel("Sistema de Biblioteca Escolar", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));

        JButton btnLibros = new JButton("Gestionar libros");
        JButton btnEstudiantes = new JButton("Gestionar estudiantes");
        JButton btnPrestamos = new JButton("Gestionar préstamos");
        JButton btnCategorias = new JButton("Gestionar categorías");
        JButton btnSalir = new JButton("Salir");

        JPanel botones = new JPanel(new GridLayout(5, 1, 10, 10));
        botones.setBorder(BorderFactory.createEmptyBorder(30, 180, 30, 180));
        botones.add(btnLibros);
        botones.add(btnEstudiantes);
        botones.add(btnPrestamos);
        botones.add(btnCategorias);
        botones.add(btnSalir);

        add(titulo, BorderLayout.NORTH);
        add(botones, BorderLayout.CENTER);

        btnSalir.addActionListener(e -> dispose());

        btnLibros.addActionListener(e -> new LibrosFrame().setVisible(true));

        btnEstudiantes.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Módulo de estudiantes")
        );
        btnPrestamos.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Módulo de préstamos")
        );
        btnCategorias.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Módulo de categorías")
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BibliotecaFrame().setVisible(true));
    }
}

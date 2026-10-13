
package biblioteca.dao;

import biblioteca.conexion.DatabaseConnection;
import biblioteca.modelo.Prestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO {

    public List<Prestamo> listar() throws SQLException {
        List<Prestamo> prestamos = new ArrayList<>();

        String sql = "SELECT id_prestamo, id_estudiante, id_libro, "
                + "fecha_prestamo, fecha_devolucion, estado "
                + "FROM prestamos";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Prestamo p = new Prestamo();
                p.setIdPrestamo(rs.getInt("id_prestamo"));
                p.setIdEstudiante(rs.getInt("id_estudiante"));
                p.setIdLibro(rs.getInt("id_libro"));
                p.setFechaPrestamo(rs.getDate("fecha_prestamo"));
                p.setFechaDevolucion(rs.getDate("fecha_devolucion"));
                p.setEstado(rs.getString("estado"));
                prestamos.add(p);
            }
        }

        return prestamos;
    }
}

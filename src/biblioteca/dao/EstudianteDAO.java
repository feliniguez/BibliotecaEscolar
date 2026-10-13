
package biblioteca.dao;

import biblioteca.conexion.DatabaseConnection;
import biblioteca.modelo.Estudiante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {

    public boolean crear(Estudiante estudiante) {
        String sql = "INSERT INTO estudiantes (nombre, apellido, rut, correo) VALUES (?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getRut());
            ps.setString(4, estudiante.getCorreo());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al crear estudiante: " + e.getMessage());
            return false;
        }
    }

    public List<Estudiante> listar() {
        List<Estudiante> estudiantes = new ArrayList<>();
        String sql = "SELECT * FROM estudiantes ORDER BY id_estudiante";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setRut(rs.getString("rut"));
                estudiante.setCorreo(rs.getString("correo"));
                estudiantes.add(estudiante);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar estudiantes: " + e.getMessage());
        }

        return estudiantes;
    }

    public boolean actualizar(Estudiante estudiante) {
        String sql = "UPDATE estudiantes SET nombre = ?, apellido = ?, rut = ?, correo = ? WHERE id_estudiante = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getRut());
            ps.setString(4, estudiante.getCorreo());
            ps.setInt(5, estudiante.getIdEstudiante());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar estudiante: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int idEstudiante) {
        String sql = "DELETE FROM estudiantes WHERE id_estudiante = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idEstudiante);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar estudiante: " + e.getMessage());
            return false;
        }
    }
}

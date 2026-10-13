
package biblioteca.dao;

import biblioteca.conexion.DatabaseConnection;
import biblioteca.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public Usuario autenticar(String usuario, String clave) throws SQLException {
        String sql = "SELECT id_usuario, nombre_usuario, contrasena, rol "
                + "FROM usuario "
                + "WHERE nombre_usuario = ? AND contrasena = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ps.setString(2, clave);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Usuario u = new Usuario();
                    u.setIdUsuario(rs.getInt("id_usuario"));
                    u.setNombreUsuario(rs.getString("nombre_usuario"));
                    u.setContrasena(rs.getString("contrasena"));
                    u.setRol(rs.getString("rol"));
                    return u;
                }
            }
        }

        return null;
    }
}

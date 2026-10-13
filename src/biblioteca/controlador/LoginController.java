
package biblioteca.controlador;

import biblioteca.dao.UsuarioDAO;
import biblioteca.modelo.Usuario;
import java.sql.SQLException;

public class LoginController {

    private final UsuarioDAO usuarioDAO;

    public LoginController() {
        usuarioDAO = new UsuarioDAO();
    }

    public boolean autenticar(String usuario, String clave) throws SQLException {
        Usuario resultado = usuarioDAO.autenticar(usuario, clave);
        return resultado != null;
    }
}

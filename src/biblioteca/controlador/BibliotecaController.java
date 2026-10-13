
package biblioteca.controlador;

import biblioteca.dao.CategoriaDAO;
import biblioteca.dao.EstudianteDAO;
import biblioteca.dao.LibroDAO;
import biblioteca.dao.PrestamoDAO;
import biblioteca.dao.UsuarioDAO;

public class BibliotecaController {

    private final CategoriaDAO categoriaDAO;
    private final EstudianteDAO estudianteDAO;
    private final LibroDAO libroDAO;
    private final PrestamoDAO prestamoDAO;
    private final UsuarioDAO usuarioDAO;

    public BibliotecaController() {
        categoriaDAO = new CategoriaDAO();
        estudianteDAO = new EstudianteDAO();
        libroDAO = new LibroDAO();
        prestamoDAO = new PrestamoDAO();
        usuarioDAO = new UsuarioDAO();
    }

    public CategoriaDAO getCategoriaDAO() {
        return categoriaDAO;
    }

    public EstudianteDAO getEstudianteDAO() {
        return estudianteDAO;
    }

    public LibroDAO getLibroDAO() {
        return libroDAO;
    }

    public PrestamoDAO getPrestamoDAO() {
        return prestamoDAO;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }
}

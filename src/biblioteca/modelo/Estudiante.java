package biblioteca.modelo;

public class Estudiante {
    private int idEstudiante;
    private String rut;
    private String nombre;
    private String apellido;
    private String curso;
    private String correo;

    public Estudiante() {}

    public Estudiante(int idEstudiante, String rut, String nombre,
                      String apellido, String curso, String correo) {
        this.idEstudiante = idEstudiante;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.correo = correo;
    }

    public int getIdEstudiante() { return idEstudiante; }
    public void setIdEstudiante(int idEstudiante) { this.idEstudiante = idEstudiante; }
    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}
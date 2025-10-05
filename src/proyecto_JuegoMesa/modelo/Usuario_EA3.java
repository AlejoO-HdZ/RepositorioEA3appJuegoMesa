package proyecto_JuegoMesa.modelo;

/**CLASE BASE PRINCIPAL USUARIO
 * Clase base que representa a un usuario dentro de la plataforma.
 */
public class Usuario_EA3 {
    protected String nombre_EA3;
    protected String correo_EA3;

    public Usuario_EA3(String nombre_EA3, String correo_EA3) {
        this.nombre_EA3 = nombre_EA3;
        this.correo_EA3 = correo_EA3;
    }

    public String getNombre_EA3() {
        return nombre_EA3;
    }

    public String getCorreo_EA3() {
        return correo_EA3;
    }
}

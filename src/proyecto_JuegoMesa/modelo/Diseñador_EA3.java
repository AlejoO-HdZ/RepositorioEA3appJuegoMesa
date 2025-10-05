package proyecto_JuegoMesa.modelo;
import java.util.ArrayList;
import java.util.List;

/**  SUBCLASE DE CLASE USUARIO
 * Subclase de Usuario que representa a un diseñador de juegos.
 * Contiene una lista de juegos creados por él.
 */
public class Diseñador_EA3 extends Usuario_EA3 {
    private List<Juego_EA3> juegosCreados_EA3;

    public Diseñador_EA3(String nombre_EA3, String correo_EA3) {
        super(nombre_EA3, correo_EA3);
        this.juegosCreados_EA3 = new ArrayList<>();
    }

    public void agregarJuego_EA3(Juego_EA3 juego_EA3) {
        juegosCreados_EA3.add(juego_EA3);
    }

    public List<Juego_EA3> getJuegosCreados_EA3() {
        return juegosCreados_EA3;
    }
}


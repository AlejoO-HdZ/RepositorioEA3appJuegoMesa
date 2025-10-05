package proyecto_JuegoMesa.patrones;

import proyecto_JuegoMesa.modelo.Usuario_EA3;
import proyecto_JuegoMesa.modelo.Juego_EA3;
import java.util.ArrayList;
import java.util.List;

/** * Singleton que gestiona usuarios y juegos registrados. */

public class Gestor_EA3 {
    private static Gestor_EA3 instancia_EA3;
    private List<Usuario_EA3> usuarios_EA3 = new ArrayList<>();
    private List<Juego_EA3> juegos_EA3 = new ArrayList<>();

    private Gestor_EA3() {}

    public static Gestor_EA3 getInstancia_EA3() {
        if (instancia_EA3 == null) instancia_EA3 = new Gestor_EA3();
        return instancia_EA3;
    }

    public void registrarUsuario_EA3(Usuario_EA3 u_EA3) {
        usuarios_EA3.add(u_EA3);
    }

    public void registrarJuego_EA3(Juego_EA3 j_EA3) {
        juegos_EA3.add(j_EA3);
    }

    public List<Juego_EA3> getJuegos_EA3() {
        return juegos_EA3;
    }
}



package proyecto_JuegoMesa.interfaz;

import proyecto_JuegoMesa.modelo.Juego_EA3;
import proyecto_JuegoMesa.modelo.Componente_EA3;

/**
 * Acción que agrega un componente al juego.
 */
public class AccionAgregar_EA3 implements AccionJuego_EA3 {
    private final Juego_EA3 juego_EA3;
    private final Componente_EA3 componente_EA3;

    public AccionAgregar_EA3(Juego_EA3 juego_EA3, Componente_EA3 componente_EA3) {
        this.juego_EA3 = juego_EA3;
        this.componente_EA3 = componente_EA3;
    }

    @Override
    public void ejecutar_EA3() {
        juego_EA3.agregarComponente_EA3(componente_EA3);
    }

    @Override
    public String getDescripcion_EA3() {
        return "Agregar componente: " + componente_EA3.getClass().getSimpleName();
    }
}

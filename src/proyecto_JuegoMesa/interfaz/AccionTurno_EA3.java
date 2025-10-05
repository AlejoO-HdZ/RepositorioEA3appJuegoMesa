package proyecto_JuegoMesa.interfaz;

import proyecto_JuegoMesa.modelo.Juego_EA3;

/**ASOCIACION CLASE ACCION TURNO USA ACCIONJUEGO. Acción que ejecuta la mecánica del juego.
 * Implementa la interfaz AccionJuego_EA3.
 */
public class AccionTurno_EA3 implements AccionJuego_EA3 {
    private final Juego_EA3 juego_EA3;

    public AccionTurno_EA3(Juego_EA3 juego_EA3) {
        this.juego_EA3 = juego_EA3;
    }

    @Override
    public void ejecutar_EA3() {
        juego_EA3.ejecutarTurno_EA3();
    }

    @Override
    public String getDescripcion_EA3() {
        return "Ejecutar turno del juego: " + juego_EA3.getNombre_EA3();
    }
}

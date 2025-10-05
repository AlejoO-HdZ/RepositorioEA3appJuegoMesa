package proyecto_JuegoMesa.patrones;

/** Implementación de la mecánica estrategia por turnos.
 */
public class MecanicaTurnos_EA3 implements MecanicaJuego_EA3 { //Estrategias concretas del patrón Strategy.
    @Override
    public void ejecutarTurno_EA3() {
        System.out.println("🔄 Turno por jugador ejecutado.");
    }
}

/**Nota adicional: El patrón de diseño Strategy se aplica en mecánicas del juego  MecanicaTurnos_EA3
 * y MecanicaPuntos_EA3 para cambiar el comportamiento del flujo sin alterar la clase principal.
 * las mecánicas del juego,*/
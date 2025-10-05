package proyecto_JuegoMesa.patrones;

/** Implementación de la mecánica estrategia por puntos.
 */
public class MecanicaPuntos_EA3 implements MecanicaJuego_EA3 {//Estrategias concretas del patrón Strategy.
    @Override
    public void ejecutarTurno_EA3() {
        System.out.println("📊 Puntos calculados para este turno.");
    }
}

/**Nota adicional: El patrón de diseño Strategy se aplica en mecánicas del juego  MecanicaTurnos_EA3
 * y MecanicaPuntos_EA3 para cambiar el comportamiento del flujo sin alterar la clase principal.
 * las mecánicas del juego, como jugar por turnos o por puntos */
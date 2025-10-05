package proyecto_JuegoMesa.patrones;

/** IMPLEMENTACION DE PATRONES DE DISEÑO: Srategy, Permite cambiar el comportamiento de un objeto en tiempo de ejecución sin modificar su clase.
 * Interfaz para la implementacion del patron Strategy que define el comportamiento de la mecánica del juego.
 */
public interface MecanicaJuego_EA3 {//Patrón Strategy (contrato de comportamiento).
    void ejecutarTurno_EA3();
}

/**Nota adicional: El patrón de diseño Strategy se aplica en mecánicas del juego  MecanicaTurnos_EA3
 *  y MecanicaPuntos_EA3 para cambiar el comportamiento del flujo sin alterar la clase principal.
 * la interfaz implementa, las mecánicas del juego, como jugar por turnos o por puntos */
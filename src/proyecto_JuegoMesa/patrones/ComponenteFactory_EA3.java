package proyecto_JuegoMesa.patrones;

import proyecto_JuegoMesa.modelo.Componente_EA3;
import proyecto_JuegoMesa.modelo.Carta_EA3;
import proyecto_JuegoMesa.modelo.Ficha_EA3;

/** IMPLEMENTACION DE PATRONES DE DISEÑO: FABRICA DE CARTAS Y FICHAS-Factory Method.
 * Implementación en el proyecto de Factory Method para crear componentes del juego según tipo.
 * Centraliza la creación de los objetos sin que el código principal conozca las clases concretas.
 */
public class ComponenteFactory_EA3 { // Patrón Factory Method (creación flexible de componentes).
    public static Componente_EA3 crearComponente_EA3(String tipo_EA3, String descripcion_EA3) {//Metodo crearComponente_EA3(tipo, nombre).
        switch (tipo_EA3.toLowerCase()) { // devuelve la instancia correcta (Carta_EA3, Ficha_EA3, Dado_EA3, Tablero_EA3).
            case "carta": return new Carta_EA3(descripcion_EA3);
            case "ficha": return new Ficha_EA3(descripcion_EA3);
            default: throw new IllegalArgumentException("❌ Tipo de componente inválido.");
        }
    }
}

/** Comentario adicional: En el modelo de componentes, la clase componenteFactory_EA3 crea objetos como
 * Carta_EA3 y FichaEA3, según el tipo indicado, simplificando la lógica de creación
 * y manteniendo el código limpio y flexible.*/

package proyecto_JuegoMesa.modelo;

/** SUBCLASE DE CLASE COMPONENTE
 * PATRONES DE DISEÑO: Factory Method. Representa una carta como componente del juego. */

public class Carta_EA3 extends Componente_EA3 {
    public Carta_EA3(String descripcion_EA3) {
        super(descripcion_EA3);
    }

    @Override
    public void mostrar_EA3() {
        System.out.println("🃏 Carta: " + descripcion_EA3);
    }

    @Override
    public String getTipo_EA3() {
        return "carta";
    }

}

/** Comentario adicional: En el modelo de componentes, la clase componenteFactory_EA3 crea objetos como
 * Carta_EA3 y FichaEA3, según el tipo indicado*/
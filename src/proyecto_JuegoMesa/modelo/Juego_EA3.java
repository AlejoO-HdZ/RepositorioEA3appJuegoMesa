package proyecto_JuegoMesa.modelo;
import proyecto_JuegoMesa.patrones.MecanicaJuego_EA3;
import java.util.ArrayList;
import java.util.List;

/**CLASE BASE PRINCIPAL JUEGO-IMPLEMENTACION DE PATRONES DE DISEÑO: Srategy
 * Representa un juego de mesa con componentes y una mecánica de juego.
 */
public class Juego_EA3 {
    private String nombre_EA3;
    private List<Componente_EA3> componentes_EA3; // AGREGACION DE CLASE JUEGO CONTIENE PERO NO DEPENDE DE LIST<COMPONENTE
    private MecanicaJuego_EA3 mecanica_EA3; // COMPOSICION - Usa Strategy al recibir una mecánica en su constructor.

    public Juego_EA3(String nombre_EA3, MecanicaJuego_EA3 mecanica_EA3) {//Usa Strategy al recibir una mecánica en su constructor.
        this.nombre_EA3 = nombre_EA3;
        this.mecanica_EA3 = mecanica_EA3;
        this.componentes_EA3 = new ArrayList<>();
    }

    public void agregarComponente_EA3(Componente_EA3 componente_EA3) {
        componentes_EA3.add(componente_EA3);
    }

    public List<Componente_EA3> getComponentes_EA3() {
        return componentes_EA3;
    }

    public String getNombre_EA3() {
        return nombre_EA3;
    }

    public void ejecutarTurno_EA3() {
        mecanica_EA3.ejecutarTurno_EA3();
    }

    public void setNombre_EA3(String nombre_EA3) {
        this.nombre_EA3 = nombre_EA3;
    }

}


package proyecto_JuegoMesa.modelo;

/** CLASE BASE PRINCIPAL COMPONENTE
 * Clase abstracta que representa un componente del juego.
 */
public abstract class Componente_EA3 {
    protected String descripcion_EA3;

    public Componente_EA3(String descripcion_EA3) {
        this.descripcion_EA3 = descripcion_EA3;
    }

    public String getDescripcion_EA3() {
        return descripcion_EA3;
    }

    public abstract String getTipo_EA3(); // necesario para saber si es "carta" o "ficha"
    public abstract void mostrar_EA3();   // imprime el componente en consola
}

/**PROGRAMACION ORIENTADA A OBJETOS
 * CONTEXTO PROPUESTO: CREACION DE JUEGOS DE MESA
 * Se propone crear un programa para el registro de diseñadores de juegos de mesa, crear juegos de mesa con mecanicas
 * y con su respectivos componentes.*/

package proyecto_JuegoMesa.app;
import proyecto_JuegoMesa.modelo.*;
import proyecto_JuegoMesa.patrones.*;
import proyecto_JuegoMesa.interfaz.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*** CLASE PRINCIPAL DEL SISTEMA. gestión de diseñadores y juegos de mesa.
 * Funcionalidades:
 *  - Registrar diseñadores
 *  - Crear juegos asociados al diseñador recién creado
 *  - Agregar componentes (con tipo y nombre específico)
 *  - Listar diseñadores, juegos y componentes
 *  - Eliminar juegos o diseñadores con confirmación
 *  - Mostrar toda la información en forma de árbol
 *  - Validación de entradas para evitar caídas del sistema
 */
public class Main_EA3 { //Se define la clase pública Main. Punto de entrada del programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Diseñador_EA3> diseñadores = new ArrayList<>(); // Se declara lista de objetos tipo Diseñador. Se inicializa como una lista vacía usando ArrayList.
        boolean activo = true;

        // Bucle principal del menú
        while (activo) {
            System.out.println("\n======== MENÚ PRINCIPAL =========");
            System.out.println("1. Crear diseñador nuevo (incluye juego y componentes)");
            System.out.println("2. Mostrar diseñadores");
            System.out.println("3. Mostrar/Editar juegos y componentes");
            System.out.println("4. Eliminar juego");
            System.out.println("5. Eliminar diseñador");
            System.out.println("6. Mostrar toda la información");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = leerEntero(scanner);
            if (opcion == -1) continue;

            switch (opcion) {
                case 1:
                    // === CREAR DISEÑADOR ===
                    String nombre;
                    do {
                        System.out.print("Nombre del diseñador (solo letras): ");
                        nombre = scanner.nextLine();
                    } while (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")); //Validaciones de Nombre String
                    String correo;
                    do {
                        System.out.print("Correo del diseñador (formato xxxx@zzzz.com): ");
                        correo = scanner.nextLine();
                    } while (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")); //Validaciones de correo String
                    Diseñador_EA3 diseñador = new Diseñador_EA3(nombre, correo);
                    diseñadores.add(diseñador);
                    System.out.println("\n =>✅ Diseñador '" + nombre + "' creado exitosamente!");
                    // === CREAR JUEGO ===
                    System.out.print("\n * Creando Juego...\n ");
                    System.out.print("Nombre del juego: ");
                    String nombreJuego = scanner.nextLine();
                    // Validar entrada de mecánica
                    String tipo;
                    do {
                        System.out.print("\n✅Uso de Patron de Diseño Strategy:\nMecánica (turnos/puntos): ");
                        tipo = scanner.nextLine().toLowerCase();
                    } while (!tipo.equals("turnos") && !tipo.equals("puntos"));
                    // Crear la mecánica según el tipo
                    MecanicaJuego_EA3 mecanica;
                    String nombreMecanica;
                    if (tipo.equals("puntos")) {
                        mecanica = new MecanicaPuntos_EA3(); // Usa patrón de diseño Strategy
                        nombreMecanica = "Puntos";
                    } else {
                        mecanica = new MecanicaTurnos_EA3(); //Usa patrón de diseño Strategy
                        nombreMecanica = "Turnos";
                    }
                    // Crear y agregar el juego
                    Juego_EA3 juego = new Juego_EA3(nombreJuego, mecanica);
                    diseñador.agregarJuego_EA3(juego);
                    // Confirmación
                    System.out.println(" ");
                    System.out.println("✅ Juego creado exitosamente:");
                    System.out.println("   🎮 Nombre: " + nombreJuego);
                    System.out.println("   ⚙️ Mecánica: " + nombreMecanica + "\n");


                    // === AGREGAR COMPONENTES ===
                    boolean agregar = true;
                    while (agregar) { // Ciclo para agregar los componentes

                        // Validar tipo de componente
                        String tipoComp;
                        do {
                            System.out.print("\n✅Uso de Patron de Diseño Factory:\nTipo de componente (carta/ficha): ");
                            tipoComp = scanner.nextLine().toLowerCase();
                            if (!tipoComp.matches("carta|ficha|")) { //Trae la factory y las clases ficha y carta para crear el componente
                                System.out.println("❌ Ups! Algo paso!!...Tipo de Componenente inválido. Por favor ingresa uno de los siguientes: carta, ficha.");
                            }
                        } while (!tipoComp.matches("carta|ficha|"));

                        // Capturar nombre específico del componente (sin restricciones)
                        System.out.print("Nombre específico del componente (ej: Peón, Torre, As de Espadas, Rey, etc): ");
                        String nombreComp = scanner.nextLine();

                        // Intentar crear y agregar el componente usando patrón Factory
                        try {
                            Componente_EA3 comp = ComponenteFactory_EA3.crearComponente_EA3(tipoComp, nombreComp);
                            new AccionAgregar_EA3(juego, comp).ejecutar_EA3();
                            System.out.println("\n✅ Componente '" + tipoComp + " - " + nombreComp + "' agregado exitosamente!\n");
                        } catch (Exception e) {
                            System.out.println("❌ Error: " + e.getMessage());
                        }

                        // Preguntar si se desea agregar otro componente
                        System.out.print("¿Desea agregar otro componente en juego: '"+ nombreJuego+"'? (s/n): ");
                        agregar = scanner.nextLine().equalsIgnoreCase("s");
                    }
                    break;
                case 2:
                    // === MOSTRAR DISEÑADORES ===
                    if (diseñadores.isEmpty()) {
                        System.out.println(" ");
                        System.out.println("⚠️ No hay diseñadores registrados.");
                        System.out.print(" ");
                    } else {
                        System.out.println(" ");
                        System.out.println("\n👥 Diseñadores registrados:");
                        for (int i = 0; i < diseñadores.size(); i++) {
                            System.out.println((i + 1) + ". " + diseñadores.get(i).getNombre_EA3());
                        }
                    }
                    break;

                case 3:
                    // === MOSTRAR, EDITAR JUEGOS Y COMPONENTES DE UN DISEÑADOR ===
                    Diseñador_EA3 d = seleccionarDiseñador(scanner, diseñadores);
                    if (d == null) break;

                    System.out.println("\n✅ Diseñador: " + d.getNombre_EA3());

                    List<Juego_EA3> juegos = d.getJuegosCreados_EA3();
                    if (juegos.isEmpty()) {
                        System.out.println("⚠️ No tiene juegos creados.");
                        break;
                    }

                    // Mostrar juegos
                    System.out.println("\n🎮 Juegos:");
                    for (int i = 0; i < juegos.size(); i++) {
                        System.out.println((i + 1) + ". " + juegos.get(i).getNombre_EA3());
                    }

                    // Seleccionar juego
                    System.out.print("\nSeleccione el número del juego a editar: ");
                    int sel = leerEntero(scanner);
                    if (sel < 1 || sel > juegos.size()) {
                        System.out.println("❌ Selección inválida.");
                        break;
                    }

                    Juego_EA3 juegoSeleccionado = juegos.get(sel - 1);

                    // Editar nombre del juego
                    System.out.println("✏️ Nombre actual: " + juegoSeleccionado.getNombre_EA3());
                    System.out.print("Nuevo nombre del juego: ");
                    String nuevoNombre = scanner.nextLine();
                    juegoSeleccionado.setNombre_EA3(nuevoNombre);
                    System.out.println("✅ Nombre actualizado: " + juegoSeleccionado.getNombre_EA3());

                    // Mostrar componentes
                    List<Componente_EA3> componentes = juegoSeleccionado.getComponentes_EA3();
                    if (componentes.isEmpty()) {
                        System.out.println("⚠️ Este juego no tiene componentes.");
                        break;
                    }

                    System.out.println("\n📦 Componentes:");
                    for (int i = 0; i < componentes.size(); i++) {
                        System.out.print("  " + (i + 1) + ". ");
                        componentes.get(i).mostrar_EA3();
                    }

                    // Editar componente
                    System.out.print("\n¿Desea editar un componente? (s/n): ");
                    if (scanner.nextLine().equalsIgnoreCase("s")) {
                        System.out.print("Seleccione el número del componente a editar: ");
                        int selComp = leerEntero(scanner);
                        if (selComp < 1 || selComp > componentes.size()) {
                            System.out.println("❌ Componente inválido.");
                            break;
                        }

                        Componente_EA3 compActual = componentes.get(selComp - 1);
                        System.out.println("✏️ Nombre actual del componente:");
                        compActual.mostrar_EA3();

                        System.out.print("Nuevo nombre del componente: ");
                        String nuevoNombreComp = scanner.nextLine();

                        // Crear nuevo componente con el mismo tipo y nuevo nombre
                        String tipoComp = compActual.getTipo_EA3(); // Asegúrate de tener este método
                        Componente_EA3 nuevoComp = ComponenteFactory_EA3.crearComponente_EA3(tipoComp, nuevoNombreComp);
                        componentes.set(selComp - 1, nuevoComp);

                        System.out.println("✅ Componente actualizado:");
                        nuevoComp.mostrar_EA3();
                    }
                    break;
                case 4:
                    // === ELIMINAR JUEGO ===
                    Diseñador_EA3 dElimJuego = seleccionarDiseñador(scanner, diseñadores);
                    if (dElimJuego == null) break;

                    List<Juego_EA3> juegosElim = dElimJuego.getJuegosCreados_EA3();
                    if (juegosElim.isEmpty()) {
                        System.out.println("⚠️ No hay juegos.");
                        break;
                    }

                    // Mostrar con índice usando IntStream para evitar variables fuera de alcance
                    System.out.println("Seleccione juego a eliminar:");
                    IntStream.range(0, juegosElim.size())
                            .forEach(i -> System.out.println((i + 1) + ". " + juegosElim.get(i).getNombre_EA3()));

                    int selJ = leerEntero(scanner);
                    if (selJ < 1 || selJ > juegosElim.size()) {
                        System.out.println("❌ Selección inválida.");
                        break;
                    }

                    Juego_EA3 eliminado = juegosElim.remove(selJ - 1);
                    System.out.println("\n🗑️ Juego '" + eliminado.getNombre_EA3() + "' eliminado completamente!");
                    break;

                case 5:
                    // === ELIMINAR DISEÑADOR ===
                    Diseñador_EA3 dElim = seleccionarDiseñador(scanner, diseñadores);
                    if (dElim == null) break;

                    System.out.print("¿Eliminar diseñador y sus juegos? (s/n): ");
                    String respuesta = scanner.nextLine();

                    if (respuesta.equalsIgnoreCase("s")) {
                        diseñadores.remove(dElim);
                        System.out.println("\n🗑️ Diseñador '" + dElim.getNombre_EA3() + "' eliminado completamente!");
                    } else {
                        System.out.println("✅ Cancelado.");
                    }
                    break;

                case 6:
                    // === MOSTRAR TODA LA INFORMACIÓN ===
                    if (diseñadores.isEmpty()) {
                        System.out.println("⚠️ No hay información.");
                        break;
                    }

                    System.out.println("\n📚 INFORMACIÓN COMPLETA:");
                    // Streams anidados con lambdas
                    diseñadores.stream().forEach(dis -> { // Streams anidados con lambdas
                        System.out.println("👤 DISEÑADOR " + dis.getNombre_EA3());

                        dis.getJuegosCreados_EA3().stream().forEach(jg -> {
                            System.out.println("  🎲 Juego: " + jg.getNombre_EA3());
                            System.out.println("    📦 Componentes:");

                            jg.getComponentes_EA3().forEach(c -> {
                                System.out.print("      - ");
                                c.mostrar_EA3();
                            });
                        });
                    });
                    break;

                case 7:
                    // === SALIR DEL PROGRAMA ===
                    System.out.println("👋 ¡Gracias por usar MesaJuegos_EA3!");
                    activo = false;
                    break;

                default:
                    System.out.println("❌ Opción inválida.");
            }
        }

        scanner.close();
    }

    /**VALIDACION ENTRADAS Y GESTION DE ERRORES
     * Lee un entero desde consola de forma segura.
     * try-catch-finally para validar la entrada sin detener el programa. */
    static int leerEntero(Scanner scanner) {
        try {  // try-catch-finally para validar la entrada sin detener el programa.
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Debe ingresar un número válido.");
            return -1;
        } finally {
            System.out.println(" ");
        }
    }
    /**
     * Muestra la lista de diseñadores y permite seleccionar uno por número.
     * Usa Streams y operaciones intermedias como filter, map, forEach y collect.
     */
    static Diseñador_EA3 seleccionarDiseñador(Scanner scanner, List<Diseñador_EA3> diseñadores) {
        if (diseñadores == null || diseñadores.isEmpty()) {
            System.out.println("⚠️ No hay diseñadores.");
            return null;
        }

        System.out.println("Seleccione diseñador:");

        // Usamos Stream para mapear con índice y mostrar nombres
        IntStream.range(0, diseñadores.size())
                .mapToObj(i -> (i + 1) + ". " + diseñadores.get(i).getNombre_EA3())
                .forEach(System.out::println);

        int sel = leerEntero(scanner);

        // Usamos Stream para filtrar y obtener el diseñador seleccionado
        return IntStream.range(0, diseñadores.size())
                .filter(i -> i == sel - 1) // Streams filter anidados con lambdas
                .mapToObj(diseñadores::get) // Streams map con metodo de referencia
                .findFirst() // Streams  buscar primero
                .orElseGet(() -> {
                    System.out.println("❌ Selección inválida.");
                    return null;
                });
    }

}

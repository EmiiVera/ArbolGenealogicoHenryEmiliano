import Model.Solicitud;
import Model.Persona;

import java.util.*;

import static Model.Persona.ordenarPorEdad;

public class Main {

    public static String rojo = "\u001B[31m";
    public static String azul = "\u001B[34m";
    public static String amarillo = "\u001B[33m";
    public static String verde = "\u001B[32m";
    public static String reset = "\u001B[0m";

    public static Scanner scanner = new Scanner(System.in);
    public static Persona raiz = new Persona();
    public static List<Persona> personaList = new ArrayList<>();

    //Datos de prueba___________________________________________________________________________________________________
    public static Persona p1 = new Persona(1, "Henry", "Gonzalez", "Ramos", "2005-02-15", false, new Solicitud());
    public static Persona p2 = new Persona(2, "Vanessa", "Gonzalez", "Ramos", "1983-02-15", false, new Solicitud());
    public static Persona p3 = new Persona(3, "Nicolas", "Carreras", "Ramos", "1999-05-15", false, new Solicitud());
    public static Persona p4 = new Persona(4, "Alvaro", "Carreras", "Lopez", "1988-02-15", false, new Solicitud());
    public static Persona p5 = new Persona(5, "Miguel", "Gonzalez", "Milico", "1956-02-15", false, new Solicitud());
    public static Persona p6 = new Persona(6, "Maria de los Angeles", "Ramos", "Pedro", "1963-02-15", false, new Solicitud());
    public static Persona p7 = new Persona(7, "Dogomar", "Ramos", "Pedro", "1964-02-15", false, new Solicitud());
    public static Persona p8 = new Persona(8, "Cacho", "Ramos", "Pedro", "1967-02-15", false, new Solicitud());
    public static Persona p9 = new Persona(9, "Raquel", "Gonzalez", "Milico", "1966-02-15", false, new Solicitud());
    public static Persona p10 = new Persona(10, "Darwin", "Gonzalez", "Milico", "1964-02-15", false, new Solicitud());
    public static Persona p11 = new Persona(11, "Mamá de Maria", "Pedro", "Pedro", "1942-02-15", true, new Solicitud());
    public static Persona p12 = new Persona(12, "Papá de Maria", "Ramos", "Ramos", "1939-02-15", true, new Solicitud());
    public static Persona p13 = new Persona(13, "Mamá de Miguel", "Gonzalez", "Gonzalez", "1937-02-15", true, new Solicitud());
    public static Persona p14 = new Persona(14, "Papá de Miguel", "Milico", "Milico", "1935-02-15", true, new Solicitud());
    public static Persona p15 = new Persona(15, "Miguel", "Carreras", "Carreras", "1969-02-15", true, new Solicitud());
    public static Persona p16 = new Persona(16, "Roberto", "Gonzalez", "Perez", "1991-02-15", false, new Solicitud());
    public static Persona p17 = new Persona(17, "Emiliano", "Vera", "Bouvier", "2000-12-01", false, new Solicitud());
    //__________________________________________________________________________________________________________________

    public static void main(String[] args) {

        //Datos de prueba_______________________________________________________________________________________________
        personaList.add(p1);
        personaList.add(p2);
        personaList.add(p3);
        personaList.add(p4);
        personaList.add(p5);
        personaList.add(p6);
        personaList.add(p7);
        personaList.add(p8);
        personaList.add(p9);
        personaList.add(p10);
        personaList.add(p11);
        personaList.add(p12);
        personaList.add(p13);
        personaList.add(p14);
        personaList.add(p15);
        personaList.add(p16);
        personaList.add(p17);

        agregarDatosDePrueba(p1, 0, p5);
        agregarDatosDePrueba(p1, 1, p6);

        agregarDatosDePrueba(p2, 0, p5);
        agregarDatosDePrueba(p2, 1, p6);

        agregarDatosDePrueba(p3, 0, p15);
        agregarDatosDePrueba(p3, 1, p6);

        agregarDatosDePrueba(p4, 0, p15);

        agregarDatosDePrueba(p5, 0, p14);
        agregarDatosDePrueba(p5, 1, p13);
        agregarDatosDePrueba(p9, 0, p14);
        agregarDatosDePrueba(p9, 1, p13);
        agregarDatosDePrueba(p10, 0, p14);
        agregarDatosDePrueba(p10, 1, p13);

        agregarDatosDePrueba(p6, 0, p12);
        agregarDatosDePrueba(p6, 1, p11);

        agregarDatosDePrueba(p7, 0, p12);
        agregarDatosDePrueba(p7, 1, p11);

        agregarDatosDePrueba(p8, 0, p12);
        agregarDatosDePrueba(p8, 1, p11);

        agregarDatosDePrueba(p16, 0, p10);
        //______________________________________________________________________________________________________________
        boolean salir = false;

        while (!salir) {
            boolean login = false;
            while (!login) {
                login = loginIn();
                esperarEnter();
            }

            while (login) {
                System.out.println(verde + "ÁRBOL GENEAÓGICO  🌳 🌳");
                System.out.println(azul + "1 - Ingresar persona.   🧑");
                System.out.println("2 - Buscar persona.     👁️");
                System.out.println("3 - Agregar parentesco. ✔️");
                System.out.println("4 - Ver mi Árbol.       🌳");
                System.out.println("5 - Ver mi Generación.  🌳");
                System.out.println("6 - Confirmar.       🧑");
                System.out.println("7 - Cambiar Usuario.    🧑");
                System.out.println("0 - Salir.  👋👋" + reset);

                String opcion = scanner.nextLine();

                switch (opcion) {
                    case "1":
                        limpiarConsola();
                        ingresarPersona();
                        esperarEnter();
                        break;
                    case "2":
                        System.out.println("Buscar persona: ");
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Apellido paterno: ");
                        String apellido1 = scanner.nextLine();
                        System.out.println(encontrarParentesco(raiz, nombre, apellido1));
                        break;
                    case "3":
                        limpiarConsola();
                        agregarParentesco();
                        esperarEnter();
                        break;
                    case "4":
                        limpiarConsola();
                        System.out.println("Ingrese que grado quiere ver: ");
                        int grado = scanner.nextInt();
                        mostrarArbolGenealogico(raiz, grado);
                        scanner.nextLine();
                        break;
                    case "5":
                        limpiarConsola();
                        obtenerMiGeneracion();
                        esperarEnter();
                        break;
                    case "6":
                        limpiarConsola();
                        confirmarSolicitud(raiz, scanner);
                        esperarEnter();
                        break;
                    case "7":
                        limpiarConsola();
                        login = false;
                        break;
                    case "0":
                        System.out.println(reset + "Saliendo...");
                        login = false;
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
            }
        }
    }

    public static boolean loginIn() {
        System.out.println(verde + "ÁRBOL GENEALÓGICO  🌳 🌳");
        System.out.println(azul + "1 - Ingresar.    🧑");
        System.out.println(azul + "2 - Registrarse. ✅");

        String opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                limpiarConsola();
                return ingresar();
            case "2":
                limpiarConsola();
                return registrarse();
            default:
                System.out.println("Opción invalida.");
                break;
        }
        return false;
    }

    public static boolean ingresar() {

        System.out.println(azul + "INGRESAR" + reset);
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apPaterno = scanner.nextLine();
        limpiarConsola();

        for (Persona persona : personaList) {
            if (persona.getNombre().equalsIgnoreCase(nombre) && persona.getApellido1().equalsIgnoreCase(apPaterno)) {
                System.out.println(verde + "Ingresaste como: " + reset);
                raiz = persona;
                System.out.println(persona);
                return true;
            }
        }

        System.out.println(rojo + "No se encontro usuario." + reset);
        return false;
    }

    public static boolean registrarse() {
        Solicitud solicitud = new Solicitud();

        System.out.println(reset + "Ingrese los datos a continuación:");
        System.out.print("Ingrese el Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido Paterno: ");
        String apPaterno = scanner.nextLine();
        System.out.print("Ingrese apellido Materno: ");
        String apMaterno = scanner.nextLine();
        System.out.print("Ingrese fecha de Nacimiento(aaaa-mm-dd): ");
        String fechaNac = scanner.nextLine();

        String esFallecidoString = null;
        boolean esFallecido = true;

        while (esFallecidoString == null) {
            System.out.print(reset + "Es fallecido (y/n): ");
            esFallecidoString = scanner.nextLine();

            switch (esFallecidoString) {
                case "y":
                    esFallecido = true;
                    break;
                case "n":
                    esFallecido = false;
                    break;
                default:
                    esFallecidoString = null;
                    System.out.println(rojo + "Opción inválida.");
                    System.out.println(azul + "Ingrese una opción válida.");
                    break;
            }
        }

        int id = personaList.size();
        try {
            Persona persona = new Persona(id, nombre, apPaterno, apMaterno, fechaNac, esFallecido, solicitud);
            personaList.add(persona);
            raiz = persona;
            System.out.println(verde + "Persona agregada!");
            System.out.println(verde + "Ingresando como: " + reset);
            System.out.println(persona);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void ingresarPersona()    {
        System.out.println(reset + "Ingrese los datos de la persona a continuación:");
        System.out.print("Ingrese el Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido Paterno: ");
        String apPaterno = scanner.nextLine();
        System.out.print("Ingrese apellido Materno: ");
        String apMaterno = scanner.nextLine();
        System.out.print("Ingrese fecha de Nacimiento (aaaa-mm-dd): ");
        String fechaNac = scanner.nextLine();

        String esFallecidoString = null;
        boolean esFallecido = true;

        // Validar entrada para fallecido
        while (esFallecidoString == null) {
            System.out.print("Es fallecido (y/n): ");
            esFallecidoString = scanner.nextLine();

            switch (esFallecidoString) {
                case "y":
                    esFallecido = true;
                    break;
                case "n":
                    esFallecido = false;
                    break;
                default:
                    esFallecidoString = null;
                    System.out.println(rojo + "Opción inválida.");
                    System.out.println(azul + "Ingrese una opción válida.");
                    break;
            }
        }

        int id = personaList.isEmpty() ? 1 : personaList.get(personaList.size() - 1).getId() + 1;

        Persona persona = new Persona(id, nombre, apPaterno, apMaterno, fechaNac, esFallecido, new Solicitud());
        personaList.add(persona);

        limpiarConsola();
        System.out.println(verde + "Persona agregada!");
        System.out.println(persona);
    }

    public static void agregarParentesco() {
        try {
            System.out.println(reset + "¿Qué parentesco desea agregar?");
            System.out.println("1. Padre");
            System.out.println("2. Madre");
            System.out.println("3. Hijo (como Madre)");
            System.out.println("4. Hijo (como Padre)");

            int opcion = Integer.parseInt(scanner.nextLine());

            for (Persona persona : personaList) {
                System.out.println(persona.getId() + " - " + persona.getNombre());
            }

            System.out.println(reset + "Ingrese el ID de la persona:");
            int idPersona = Integer.parseInt(scanner.nextLine());

            Persona nuevoPariente = personaList.stream()
                    .filter(p -> p.getId() == idPersona)
                    .findFirst()
                    .orElse(null);

            if (nuevoPariente == null) {
                System.out.println(rojo + "No se encontró una persona con el ID proporcionado.");
                return;
            }

            switch (opcion) {
                case 1:
                    raiz.agregarPadre(nuevoPariente);
                    break;
                case 2:
                    raiz.agregarMadre(nuevoPariente);
                    break;
                case 3:
                    nuevoPariente.agregarMadre(raiz);
                    break;
                case 4:
                    nuevoPariente.agregarPadre(raiz);
                    break;
                default:
                    System.out.println(rojo + "Opción inválida.");
                    return;
            }

            enviarSolicitud(nuevoPariente, raiz);

        } catch (NumberFormatException e) {
            System.out.println(rojo + "Entrada inválida. Por favor, ingrese un número.");
        } catch (Exception e) {
            System.out.println(rojo + "Ocurrió un error: " + e.getMessage());
        }
    }

    public static void enviarSolicitud(Persona receptor, Persona emisor) {
        int emisorId = emisor.getId();
        int receptorId = receptor.getId();

        if (!receptor.isEsFallecido()) {
            if (receptor.edad(receptor.getFechaNac()) >= 18) {
                Solicitud solicitudReceptor = new Solicitud(emisorId, receptorId);
                receptor.setSolicitud(solicitudReceptor);
                System.out.println(verde + "Solicitud enviada al receptor.");
                System.out.println("Código confirmación: " + receptor.getSolicitud().getCodigoConfirmacion());

                Solicitud solicitudEmisor = new Solicitud(receptorId, emisorId);
                emisor.setSolicitud(solicitudEmisor);
                System.out.println(verde + "Solicitud enviada al emisor.");
                System.out.println("Código confirmación: " + emisor.getSolicitud().getCodigoConfirmacion());

            } else {
                System.out.println(rojo + "El usuario a agregar es menor.");
                System.out.println(reset + "Se enviará una solicitud a su tutor.");
                Persona nuevoReceptor = tutor(receptor);

                if (nuevoReceptor == null) {
                    System.out.println(rojo + "No se encontró tutor.");
                } else {
                    Solicitud solicitud = new Solicitud(emisorId, nuevoReceptor.getId());
                    nuevoReceptor.setSolicitud(solicitud);
                    System.out.println(verde + "Solicitud enviada.");
                    System.out.println("Código: " + nuevoReceptor.getSolicitud().getCodigoConfirmacion());
                }
            }
        } else {
            List<Persona> familiares = familiaresDeFallecido(new ArrayList<>(), receptor);
            System.out.println(rojo + "El receptor está fallecido. Notificando a familiares cercanos.");
        }
    }

    public static void confirmarSolicitud(Persona persona, Scanner scanner) {
        try {
            if (persona.getSolicitud() == null) {
                System.out.println("No hay ninguna solicitud asociada a esta persona.");
                return;
            }

            if (persona.getSolicitud().isConfirmado()) {
                System.out.println("Usted ya está confirmado.");
                return;
            }

            boolean confirmado = false;

            while (!confirmado) {
                System.out.print("Ingrese el código de confirmación (o 0 para salir, o 1 si no conoce el código): ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Entrada no válida. Ingrese un número.");
                    scanner.nextLine();
                    continue;
                }

                int opcion = scanner.nextInt();
                scanner.nextLine();

                if (opcion == 0) {
                    System.out.println("Ha decidido salir del proceso de confirmación.");
                    break;
                }

                if (opcion == 1) {
                    System.out.print("Ingrese su nombre: ");
                    String nombreIngresado = scanner.nextLine();

                    System.out.print("Ingrese su apellido: ");
                    String apellidoIngresado = scanner.nextLine();

                    if (persona.getNombre().equalsIgnoreCase(nombreIngresado) &&
                            persona.getApellido1().equalsIgnoreCase(apellidoIngresado)) {
                        System.out.println("El código de confirmación es: " + persona.getSolicitud().getCodigoConfirmacion());
                    } else {
                        System.out.println("El nombre o apellido no coinciden. Intente nuevamente.");
                        continue;
                    }
                } else {
                    persona.getSolicitud().confirmar(opcion);
                    String estado = persona.getSolicitud().isConfirmado() ? "Confirmado" : "No confirmado";
                    System.out.println("Estado: " + estado);

                    confirmado = persona.getSolicitud().isConfirmado();

                    if (!confirmado) {
                        System.out.println("Código incorrecto. Intente nuevamente.");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error al procesar el mensaje: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<Persona> familiaresDeFallecido(List<Persona> familiares, Persona persona) {
        if (familiares.size() >= 3) {
            return familiares;
        }

        Persona familiar = new Persona();
        for (Persona hijo : persona.getHijos()) {
            familiar = obtenerUsuarioPorId(hijo.getId());
            if (familiar != null) {
                if (!familiar.isEsFallecido() || familiar.edad(familiar.getFechaNac()) >= 18) {
                    familiares.add(hijo);
                    if (familiares.size() >= 3) {
                        return familiares;
                    }
                }
            }
        }
        for (Persona hijo : persona.getHijos()) {
            familiaresDeFallecido(familiares, hijo);
        }
        return familiares;
    }

    public static Persona tutor(Persona persona) {
        Persona tutor = null;

        for (Persona padre : persona.getPadres()) {
            if (padre != null) {
                if (!padre.isEsFallecido()) {
                    tutor = obtenerUsuarioPorId(padre.getId());
                    if (tutor != null) {
                        return tutor;
                    }
                }
            }
        }
        for (Persona padre : persona.getPadres()) {
            if (padre != null) {
                if (padre.isEsFallecido()) {
                    tutor(padre);
                }
            }
        }
        return tutor;
    }

    private static void mostrarArbolGenealogico(Persona raiz, int grado) {
        System.out.println("Árbol Genealógico de: " + raiz.getNombre() + " " + raiz.getApellido1() + " " + raiz.getApellido2());
        System.out.println("Grado especificado: " + grado);

        // Mostrar la raíz con su estado
        System.out.println("|-- " + mostrarConfirmacionEnArbol(raiz));

        // Mostrar descendentes
        if (grado > 0) {
            mostrarDescendientes(raiz, 1, grado);
        }

        // Mostrar ascendentes
        if (grado > 0) {
            mostrarAscendientes(raiz, 1, grado);
        }
    }

    private static void mostrarDescendientes(Persona persona, int nivelActual, int gradoMaximo) {
        if (nivelActual > gradoMaximo || persona.getHijos() == null) {
            return;
        }
        for (Persona hijo : persona.getHijos()) {
            if (hijo != null) {
                String label = obtenerEtiqueta("descendente", nivelActual);
                String prefix = "|".repeat(nivelActual) + "-- " + label + ": ";
                System.out.println(prefix + mostrarConfirmacionEnArbol(hijo));
                mostrarDescendientes(hijo, nivelActual + 1, gradoMaximo); // Llamada recursiva
            }
        }
    }

    private static void mostrarAscendientes(Persona persona, int nivelActual, int gradoMaximo) {
        if (nivelActual > gradoMaximo || persona.getPadres() == null) {
            return;
        }
        for (Persona padre : persona.getPadres()) {
            if (padre != null) {
                String label = obtenerEtiqueta("ascendente", nivelActual);
                String prefix = "|".repeat(nivelActual) + "-- " + label + ": ";
                System.out.println(prefix + mostrarConfirmacionEnArbol(padre));
                mostrarAscendientes(padre, nivelActual + 1, gradoMaximo); // Llamada recursiva
            }
        }
    }

    private static String mostrarConfirmacionEnArbol(Persona persona) {
        String estado = persona.getSolicitud().isConfirmado() ? "✅" : "❎";
        return persona.getNombre() + " " + persona.getApellido1() + " " + persona.getApellido2() + " " + estado;
    }

    private static String obtenerEtiqueta(String tipo, int nivel) {
        if (tipo.equals("ascendente")) {
            switch (nivel) {
                case 1: return "Padre";
                case 2: return "Abuelo";
                case 3: return "Bisabuelo";
                case 4: return "Tatarabuelo";
                default: return nivel + "° Ascendente";
            }
        } else if (tipo.equals("descendente")) {
            switch (nivel) {
                case 1: return "Hijo";
                case 2: return "Nieto";
                case 3: return "Bisnieto";
                case 4: return "Tataranieto";
                default: return nivel + "° Descendiente";
            }
        }
        return "Pariente";
    }


    public static void obtenerMiGeneracion() {

        List<Persona> hermanos = raiz.obtenerHermanos();
        List<Persona> primos = raiz.obtenerPrimos();

        System.out.println("Hermanos:");
        for (Persona hermano : hermanos) {
            System.out.println(hermano.getNombre() + " " + hermano.getApellido1());
        }

        System.out.println("Primos:");
        for (Persona primo : primos) {
            System.out.println(primo.getNombre() + " " + primo.getApellido1());
        }
    }

    public static String encontrarParentesco(Persona raiz, String nombre, String apellido1) {

        if (raiz.getNombre().equals(nombre) && raiz.getApellido1().equals(apellido1)) {
            return "La persona es la raíz del árbol genealógico.";
        }

        for (Persona hijo : raiz.getHijos()) {
            if (hijo.getNombre().equals(nombre) && hijo.getApellido1().equals(apellido1)) {
                return "La persona es un hijo de la raíz. " + "Confirmado: " + hijo.getSolicitud().isConfirmado();
            }

            for (Persona nieto : hijo.getHijos()) {
                if (nieto.getNombre().equals(nombre) && nieto.getApellido1().equals(apellido1)) {
                    return "La persona es un nieto de la raíz. " + "Confirmado: " + nieto.getSolicitud().isConfirmado();
                }
            }
        }

        for (Persona padre : raiz.getPadres()) {
            if (padre.getNombre().equals(nombre) && padre.getApellido1().equals(apellido1)) {
                return "La persona es un padre de la raíz. " + "Confirmado: " + padre.getSolicitud().isConfirmado();
            }

            for (Persona abuelo : padre.getPadres()) {
                if (abuelo.getNombre().equals(nombre) && abuelo.getApellido1().equals(apellido1)) {
                    return "La persona es un abuelo de la raíz. " + "Confirmado: " + abuelo.getSolicitud().isConfirmado();
                }
            }

            for (Persona hermano : padre.getHijos()) {
                if (hermano.getNombre().equals(nombre) && hermano.getApellido1().equals(apellido1)) {
                    return "La persona es un hermano de la raíz. " + "Confirmado: " + hermano.getSolicitud().isConfirmado();
                }

                for (Persona primo : hermano.getHijos()) {
                    if (primo.getNombre().equals(nombre) && primo.getApellido1().equals(apellido1)) {
                        return "La persona es un primo de la raíz. " + "Confirmado: " + primo.getSolicitud().isConfirmado();
                    }
                }
            }
        }

        for (Persona hermano : raiz.obtenerHermanos()) {
            if (hermano.getNombre().equals(nombre) && hermano.getApellido1().equals(apellido1)) {
                return "La persona es un hermano de la raíz.";
            }
        }

        for (Persona primo : raiz.obtenerPrimos()) {
            if (primo.getNombre().equals(nombre) && primo.getApellido1().equals(apellido1)) {
                return "La persona es un primo de la raíz.";
            }
        }

        return "La persona no tiene parentesco con la raíz.";
    }

    public static Persona obtenerUsuarioPorId(int id) {
        for (Persona persona : personaList) {
            if (persona.getId() == id) {
                return persona;
            }
        }
        return null;
    }

    //Agregar Datos de Prueba___________________________________________________________________________________________
    public static void agregarDatosDePrueba(Persona raiz, int index, Persona padre) {
        switch (index) {
            case 0:
                raiz.agregarPadre(padre);
                break;
            case 1:
                raiz.agregarMadre(padre);
                break;
        }
        padre.agregar(padre.getHijos(), raiz);
    }
    //__________________________________________________________________________________________________________________

    //Esperar Enter_____________________________________________________________________________________________________
    public static void esperarEnter() {
        System.out.println(verde + "Presiona Enter para continuar...");

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        limpiarConsola();

    }

    public static void limpiarConsola() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}
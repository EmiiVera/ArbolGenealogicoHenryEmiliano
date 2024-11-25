import Model.Solicitud;
import Model.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public static Persona p1 = new Persona(1, "Henry", "Gonzalez", "Ramos", "2005-02-15", false);
    public static Persona p2 = new Persona(1, "Vanessa", "Gonzalez", "Ramos", "2005-02-15", false);
    public static Persona p3 = new Persona(1, "Nicolas", "Carreras", "Ramos", "2005-02-15", false);
    public static Persona p4 = new Persona(1, "Alvaro", "Carreras", "Lopez", "2005-02-15", false);
    public static Persona p5 = new Persona(1, "Miguel", "Gonzalez", "Milico", "2005-02-15", false);
    public static Persona p6 = new Persona(1, "Maria de los Angeles", "Ramos", "Pedro", "2005-02-15", false);
    public static Persona p7 = new Persona(1, "Dogomar", "Ramos", "Pedro", "2005-02-15", false);
    public static Persona p8 = new Persona(1, "Cacho", "Ramos", "Pedro", "2005-02-15", false);
    public static Persona p9 = new Persona(1, "Raquel", "Gonzalez", "Milico", "2005-02-15", false);
    public static Persona p10 = new Persona(1, "Darwin", "Gonzalez", "Milico", "2005-02-15", false);
    public static Persona p11 = new Persona(1, "Mamá de Maria", "Pedro", "Pedro", "2005-02-15", true);
    public static Persona p12 = new Persona(1, "Papá de Maria", "Ramos", "Ramos", "2005-02-15", true);
    public static Persona p13 = new Persona(1, "Mamá de Miguel", "Gonzalez", "Gonzalez", "2005-02-15", true);
    public static Persona p14 = new Persona(1, "Papá de Miguel", "Milico", "Milico", "2005-02-15", true);
    public static Persona p15 = new Persona(1, "Miguel", "Carreras", "Carreras", "2005-02-15", true);
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


        //______________________________________________________________________________________________________________
        boolean salir = false;

        while (!salir) {
            boolean login = false;
            while (!login) {
                login = loginIn();
                esperarEnter();
            }
            if (raiz.tieneMensaje()) {
                System.out.println(rojo + "Tienes solicitudes pendiente!!!");
            }

            while (login) {
                System.out.println(verde + "ÁRBOL GENEAÓGICO  🌳 🌳");
                System.out.println(azul + "1 - Ingresar persona.   🧑");
                System.out.println("2 - Buscar persona.     👁️");
                System.out.println("3 - Agregar parentesco. ✔️");
                System.out.println("4 - Ver mi Árbol.       🌳");
                System.out.println("5 - Ver mensajes.    🧑");
                System.out.println("6 - Cambiar Usuario.    🧑");
                System.out.println("0 - Salir.  👋👋" + reset);

                String opcion = scanner.nextLine();

                switch (opcion) {
                    case "1":
                        limpiarConsola();
                        ingresarPersona();
                        esperarEnter();
                        break;
                    case "2":
                        break;
                    case "3":
                        limpiarConsola();
                        agregarParentesco();
                        esperarEnter();
                        break;
                    case "4":
                        limpiarConsola();
                        mostrarArbolGenealogico();
                        esperarEnter();
                        break;
                    case "5":
                        limpiarConsola();
                        verMensajes(raiz.getSolicitud());
                        esperarEnter();
                        break;
                    case "6":
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

        for (Persona persona : personaList) {
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                if (persona.getApellido1().equalsIgnoreCase(apPaterno)) {
                    System.out.println(verde + "Ingresaste como: " + reset);
                    toString(persona);
                    raiz = persona;
                    return true;
                }
            }
        }

        System.out.println(rojo + "No se encontro usuario." + reset);
        return false;
    }

    public static boolean registrarse() {
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
            Persona persona = new Persona(id, nombre, apPaterno, apMaterno, fechaNac, esFallecido);
            personaList.add(persona);
            raiz = persona;
            System.out.println(verde + "Persona agregada!");
            System.out.println(verde + "Ingresando como: " + reset);
            toString(persona);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void ingresarPersona() {
        System.out.println(reset + "Ingrese los datos de la persona a continuación:");
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

        int id = personaList.size();
        Persona persona = new Persona(id, nombre, apPaterno, apMaterno, fechaNac, esFallecido);
        personaList.add(persona);

        System.out.println(verde + "Persona agregada!");
        toString(persona);
    }

    public static void agregarParentesco() {
        try {
            System.out.println(reset + "¿Qué parentesco desea agregar?");
            System.out.println("1. Padre");
            System.out.println("2. Madre");

            int opcion = Integer.parseInt(scanner.nextLine());

            if (opcion < 1 || opcion > 2) {
                System.out.println(rojo + "Opción inválida. if");
                agregarParentesco();
            }
            for (int i = 0; i < personaList.size(); i++) {
                System.out.println((i + 1) + " - " + personaList.get(i).getNombre());
            }

            System.out.println(reset + "Elija una persona persona:");
            int indexPersona = Integer.parseInt(scanner.nextLine()) - 1;

            Persona nuevoPariente = personaList.get(indexPersona);

            switch (opcion) {
                case 1:
                    raiz.agregarPadre(nuevoPariente);
                    break;
                case 2:
                    raiz.agregarMadre(nuevoPariente);
                    break;
                default:
                    System.out.println(rojo + "Opción inválida. default");
                    break;
            }

            nuevoPariente.agregarHijo(nuevoPariente.getHijos(), raiz);
            enviarSolicitud(nuevoPariente);

            System.out.println(verde + "Parentesco agregado con éxito.");
        } catch (Exception e) {
            System.out.println(rojo + "Opción inválida. catch");
            agregarParentesco();
        }
    }

    public static void enviarSolicitud(Persona receptor) {
        int emisorId = raiz.getId();
        int receptorId = receptor.getId();
        String texto = "Solicitud de parentesco.";
        String estado = "Pendiente";

        Solicitud solicitud = new Solicitud(emisorId, receptorId, texto, estado);
        receptor.nuevaSolicitud(solicitud);
        System.out.println(verde + "Solicitud enviada.");
    }

    public static void mostrarArbolGenealogico() {

        System.out.println(amarillo + raiz.getNombre() + " " + raiz.getApellido1() + " " + raiz.getApellido2());
        // Mostrar hermanos
        System.out.println(amarillo + "|   |   L " + verde + "Hermanos:");
        for (Persona padre : raiz.getPadres()) {
            if (padre != null && padre.getHijos() != null) {
                for (Persona hermano : padre.getHijos()) {
                    if (!hermano.equals(raiz)) { // Excluirte a ti mismo
                        System.out.println(amarillo + "|   |   L " + verde + hermano.getNombre() + " " + hermano.getApellido1() + " " + hermano.getApellido2());
                    }
                }
            }
        }

        // Mostrar padres
        System.out.println(amarillo + "|   L " + verde + "Padres:");
        for (Persona padre : raiz.getPadres()) {
            if (padre != null) {
                System.out.println(amarillo + "|   L " + verde + padre.getNombre() + " " + padre.getApellido1() + " " + padre.getApellido2());
            }
        }


        // Mostrar tíos
        System.out.println(amarillo + "|   L " + verde + "Tíos:");
        for (Persona padre : raiz.getPadres()) {
            if (padre != null && padre.getPadres() != null) {
                for (Persona abuelo : padre.getPadres()) {
                    if (abuelo != null && abuelo.getHijos() != null) {
                        for (Persona tio : abuelo.getHijos()) {
                            if (!tio.equals(padre)) { // Excluir al padre o madre
                                System.out.println(amarillo + "|   L " + verde + tio.getNombre() + " " + tio.getApellido1() + " " + tio.getApellido2());
                            }
                        }
                    }
                }
            }
        }

        // Mostrar abuelos
        System.out.println(amarillo + "L " + verde + "Abuelos:");
        for (Persona padre : raiz.getPadres()) {
            if (padre != null && padre.getPadres() != null) {
                for (Persona abuelo : padre.getPadres()) {
                    if (abuelo != null) {
                        System.out.println(amarillo + "L " + verde + abuelo.getNombre() + " " + abuelo.getApellido1() + " " + abuelo.getApellido2());
                    }
                }
            }
        }

        System.out.println(verde + "() () * () *");
        System.out.println(verde + "() ) ()");
        System.out.println(verde + ") (*");
        System.out.println(verde + "*");

    }

    public static void arbolGenealogivoPorNivel(Persona persona, Persona raiz, int nivel) {

        if (persona == null) {
            return;
        }

        // Determinar la relación según el nivel
        String relacion = "";
        switch (nivel) {
            case 0:
                relacion = "Yo";
                break;
            case 1:
                relacion = "Padre/Madre";
                break;
            case 2:
                relacion = "Abuelo/Abuela";
                break;
            case 3:
                relacion = "Tío/Tía";
                break;
            default:
                relacion = "Pariente lejano";
        }

        // Imprimir la relación si corresponde
        if (nivel <= 3) {
            System.out.println("|   ".repeat(nivel) + "L " + relacion + ": "
                    + persona.getNombre() + " "
                    + persona.getApellido1() + " "
                    + persona.getApellido2());
        }

        // Si la persona es la raíz, procesar a los hermanos
        if (nivel == 0 && persona.getPadres() != null) {
            for (Persona padre : persona.getPadres()) {
                if (padre != null && padre.getHijos() != null) {
                    for (Persona hermano : padre.getHijos()) {
                        if (!hermano.equals(raiz)) {
                            System.out.println("|   L Hermano/a: "
                                    + hermano.getNombre() + " "
                                    + hermano.getApellido1() + " "
                                    + hermano.getApellido2());
                        }
                    }
                }
            }
        }

        // Recorrer los padres para continuar con la recursión
        if (persona.getPadres() != null) {
            for (Persona padre : persona.getPadres()) {
                arbolGenealogivoPorNivel(padre, raiz, nivel + 1);
            }
        }

        // Sí estamos en el nivel 2, procesar los tíos (hermanos de los padres)
        if (nivel == 2 && persona.getHijos() != null) {
            for (Persona tio : persona.getHijos()) {
                if (!tio.equals(raiz.getPadres()[0]) && !tio.equals(raiz.getPadres()[1])) {
                    System.out.println("|   ".repeat(nivel) + "L Tío/Tía: "
                            + tio.getNombre() + " "
                            + tio.getApellido1() + " "
                            + tio.getApellido2());
                }
            }
        }

    }

    public static void verMensajes(Solicitud solicitudesPendientes) {

        if (solicitudesPendientes == null) {
            System.out.println(verde + "No tienes mensajes." + reset);
            esperarEnter();
            return;
        }
        try {
            System.out.println(azul + "Mensaje: " + reset);
            System.out.println("- " + solicitudesPendientes.getTexto());

            Persona persona = obtenerUsuarioPorId(solicitudesPendientes.getEmisorId());
            System.out.println("Enviado por: " + persona.getNombre() + " " + persona.getApellido1() + " " + persona.getApellido2());
            System.out.println("Estado: " + solicitudesPendientes.getEstado());

            System.out.print("¿Aceptar? (y/n): ");
            String aceptar = scanner.nextLine();

            switch (aceptar) {
                case "y":
                    solicitudesPendientes.setEstado("Aceptada");
                    break;
                case "n":
                    //Metodo para eliminar mensaje
                    break;
                default:
                    System.out.println(rojo + "Opción inválida.");
                    break;
            }

            verMensajes(solicitudesPendientes.getNext());

        } catch (Exception e) {
            System.out.println("No se encontró emisor.");
        }
    }

    public static Persona obtenerUsuarioPorId(int id) {
        return personaList.get(id);
    }

    public static void toString(Persona persona) {
        System.out.println(azul + "Datos del usuario." + reset);
        System.out.println("Id: " + persona.getId());
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Apellido Paterno: " + persona.getApellido1());
        System.out.println("Apellido Materno: " + persona.getApellido2());
        System.out.println("Edad: " + persona.edad(persona.getFechaNac()) + " años.");
        System.out.println("Fecha de Nacimiento: " + persona.getFechaNac());
    }

    //Agregar Datos de Prueba___________________________________________________________________________________________
    public static void agregarDatosDePrueba(Persona raiz, int index, Persona padre) {
        switch (index){
            case 0:
                raiz.agregarPadre(padre);
                break;
            case 1:
                raiz.agregarMadre(padre);
                break;
        }
        padre.agregarHijo(padre.getHijos(), raiz);
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
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
package Model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Persona {
    int id;
    String nombre;
    String apellido1;
    String apellido2;
    String fechaNac;
    private boolean esFallecido;
    Persona[] padres = new Persona[2];
    Persona[] hijos = new Persona[0];
    Solicitud solicitud;

    public Persona() {
    }

    public Persona(int id, String nombre, String apellido1, String apellido2, String fechaNac, boolean esFallecido, Solicitud solicitud) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNac = fechaNac;
        this.esFallecido = esFallecido;
        this.solicitud = solicitud;
    }

    public Persona(int id, String nombre, String apPaterno, String apMaterno, String fechaNac, boolean esFallecido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apPaterno;
        this.apellido2 = apMaterno;
        this.fechaNac = fechaNac;
        this.esFallecido = esFallecido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCompleto() {
        return this.nombre + " " + this.apellido1 + " " + this.apellido2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Persona[] getPadres() {
        return padres;
    }

    public void setPadres(Persona[] padres) {
        this.padres = padres;
    }

    public Persona[] getHijos() {
        return hijos;
    }

    public void setHijos(Persona[] hijos) {
        this.hijos = hijos;
    }

    public boolean isEsFallecido() {
        return esFallecido;
    }

    public void setEsFallecido(boolean esFallecido) {
        this.esFallecido = esFallecido;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    //Métodos___________________________________________________________________________________________________________

    public int edad(String fechaNac) {
        LocalDate nacimiento = LocalDate.parse(fechaNac);
        LocalDate hoy = LocalDate.now(); // Fecha actual

        long anios = ChronoUnit.YEARS.between(nacimiento, hoy);

        return (int) anios;
    }

    public void agregarPadre(Persona padre) {
        if (tienePadre()) {
            System.out.println("Ya tiene un padre.");
            return;
        }
        if (padres == null) {
            padres = new Persona[2];
        }
        padres[0] = padre;
        padre.agregar(padre.getHijos(), this);
    }

    public void agregarMadre(Persona madre) {
        if (tieneMadre()) {
            System.out.println("Ya tiene una madre.");
            return;
        }
        if (padres == null) {
            padres = new Persona[2];
        }
        padres[1] = madre;
        madre.agregar(madre.getHijos(), this);
    }


    public boolean tienePadre() {
        return padres[0] != null;
    }

    public boolean tieneMadre() {
        return padres[1] != null;
    }

    public void agregar(Persona[] lista, Persona hijo) {
        if (lista == null) {
            lista = new Persona[1];
        }

        Persona[] nuevaLista = new Persona[lista.length + 1];
        System.arraycopy(lista, 0, nuevaLista, 0, lista.length);
        nuevaLista[lista.length] = hijo;
        this.hijos = nuevaLista;
    }


    public static Persona[] ordenarPorEdad(Persona[] listaHijos) {
        if (listaHijos.length == 0) {
            return new Persona[0];
        }
        if (listaHijos.length == 1) {
            return listaHijos;
        }
        Persona medio = listaHijos[listaHijos.length / 2];
        List<Persona> arr1 = new ArrayList<>();
        List<Persona> arr2 = new ArrayList<>();
        for (Persona hijo : listaHijos) {
            if (hijo.edad(hijo.getFechaNac()) < medio.edad(medio.getFechaNac())) {
                arr1.add(hijo);
            } else if (hijo.edad(hijo.getFechaNac()) > medio.edad(medio.getFechaNac())) {
                arr2.add(hijo);
            }
        }
        Persona[] resultado1 = ordenarPorEdad(arr1.toArray(new Persona[0]));
        Persona[] resultado2 = ordenarPorEdad(arr2.toArray(new Persona[0]));
        Persona[] delMedio = new Persona[1];
        delMedio[0] = medio;
        Persona[] nuevaLista = new Persona[resultado1.length + resultado2.length + delMedio.length];
        System.arraycopy(resultado1, 0, nuevaLista, 0, resultado1.length);
        nuevaLista[resultado1.length] = medio;
        System.arraycopy(resultado2, 0, nuevaLista, resultado1.length + 1, resultado2.length);
        return nuevaLista;
    }

    public void obtenerHermanosRecursivo(List<Persona> lista, Persona[] hijos, int index) {
        if (hijos == null || index >= hijos.length) {
            return;
        }
        Persona hijo = hijos[index];
        if (!hijo.equals(this) && !lista.contains(hijo)) { // Excluirse a sí mismo y evitar duplicados
            lista.add(hijo);
        }
        obtenerHermanosRecursivo(lista, hijos, index + 1); // Llamada recursiva al siguiente hijo
    }

    public List<Persona> obtenerHermanos() {
        List<Persona> hermanos = new ArrayList<>();
        for (Persona padre : padres) {
            if (padre != null && padre.hijos != null) {
                obtenerHermanosRecursivo(hermanos, padre.hijos, 0); // Llamada inicial
            }
        }
        return hermanos;
    }

    public void obtenerPrimosRecursivo(List<Persona> lista, Persona[] hermanos, int index) {
        if (hermanos == null || index >= hermanos.length) {
            return;
        }
        Persona tio = hermanos[index];
        if (!tio.equals(this.padres[0]) && !tio.equals(this.padres[1]) && tio.hijos != null) {
            for (Persona primo : tio.hijos) {
                if (!lista.contains(primo)) { // Evitar duplicados
                    lista.add(primo);
                }
            }
        }
        obtenerPrimosRecursivo(lista, hermanos, index + 1);
    }

    public List<Persona> obtenerPrimos() {
        List<Persona> primos = new ArrayList<>();
        for (Persona padre : padres) {
            if (padre != null && padre.padres != null) {
                for (Persona abuelo : padre.padres) {
                    if (abuelo != null && abuelo.hijos != null) {
                        obtenerPrimosRecursivo(primos, abuelo.hijos, 0);
                    }
                }
            }
        }
        return primos;
    }


    @Override
    public String toString() {
        return "Datos del usuario.\n" +
                "Id: " + this.id + "\n" +
                "Nombre: " + this.nombre + "\n" +
                "Apellido Paterno: " + this.apellido1 + "\n" +
                "Apellido Materno: " + this.apellido2 + "\n" +
                "Edad: " + edad(this.fechaNac) + " años" + "\n" +
                "Fecha de Nacimiento: " + this.fechaNac;
    }
}
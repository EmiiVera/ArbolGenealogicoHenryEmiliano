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
    Persona[] hijos;
    Solicitud solicitud = null;

    public Persona() {
    }

    public Persona(int id, String nombre, String apellido1, String apellido2, String fechaNac, boolean esFallecido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
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
        if(tienePadre()) {
            System.out.println("Ya tiene un padre.");
            return;
        }
        padres[0] = padre;
    }

    public void agregarMadre(Persona madre) {
        if(tieneMadre()) {
            System.out.println("Ya tiene un madre.");
            return;
        }
        padres[1] = madre;
    }

    public boolean tienePadre() {
        return padres[0] != null;
    }

    public boolean tieneMadre() {
        return padres[1] != null;
    }

    public void agregar(Persona[] lista, Persona hijo) {
        Persona[] nuevaLista;
        if(lista == null) {
            nuevaLista = new Persona[1];
            nuevaLista[0] = hijo;
            this.hijos = nuevaLista;
            return;
        }

        nuevaLista = new Persona[lista.length + 1];

        for (int i = 0; i < lista.length; i++) {
            nuevaLista[i] = lista[i];
        }
        nuevaLista[nuevaLista.length - 1 ] = hijo;
        this.hijos = nuevaLista;
    }

    public Persona[] ordenarPorEdad(Persona[] listaHijos) {
        if(listaHijos.length == 0) {
            return new Persona[0];
        }

        if (listaHijos.length == 1) {
            return listaHijos;
        }
        Persona medio = listaHijos[listaHijos.length/2];
        Persona[] arr1 = new Persona[0];
        Persona[] arr2 = new Persona[0];
        for (int i = 0; i < listaHijos.length; i++) {
            if (listaHijos[i].edad(fechaNac) < medio.edad(fechaNac)) {
                agregar(arr1, listaHijos[i]);
            } else if (listaHijos[i].edad(fechaNac) > medio.edad(fechaNac)) {
                agregar(arr2, listaHijos[i]);
            }
        }
        Persona[] resultado1 = ordenarPorEdad(arr1);
        Persona[] resultado2 = ordenarPorEdad(arr2);
        Persona[] delMedio = new Persona[1];
        delMedio[0] = medio;

        Persona[] nuevaLista = new Persona[resultado1.length + resultado2.length + delMedio.length];
        for (int i = 0; i < resultado1.length; i++) {
            nuevaLista[i] = resultado1[i];
        }

        nuevaLista[resultado1.length] = medio;

        for (int i = resultado1.length + 1; i < resultado2.length; i++) {
            nuevaLista[i] = resultado2[i];
        }

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
        if (!tio.equals(this.padres[0]) && !tio.equals(this.padres[1]) && tio.hijos != null) { // Excluir a los padres
            for (Persona primo : tio.hijos) {
                if (!lista.contains(primo)) { // Evitar duplicados
                    lista.add(primo);
                }
            }
        }
        obtenerPrimosRecursivo(lista, hermanos, index + 1); // Llamada recursiva al siguiente hermano del padre
    }

    public List<Persona> obtenerPrimos() {
        List<Persona> primos = new ArrayList<>();
        for (Persona padre : padres) {
            if (padre != null && padre.padres != null) {
                for (Persona abuelo : padre.padres) {
                    if (abuelo != null && abuelo.hijos != null) {
                        obtenerPrimosRecursivo(primos, abuelo.hijos, 0); // Llamada inicial
                    }
                }
            }
        }
        return primos;
    }

    public void nuevaSolicitud(Solicitud solicitud) {
        if (!tieneMensaje()) {
            this.solicitud = solicitud;
            return;
        }
        if (!solicitud.tieneNext()) {
            this.solicitud.setNext(solicitud);
        } else {
            Solicitud siguiente = solicitud.getNext();
            while (siguiente.tieneNext()) {
                siguiente = siguiente.getNext();
            }
        }
    }

    public boolean tieneMensaje() {
        return this.solicitud!= null;
    }

}

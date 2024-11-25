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

    public void agregarHijo(Persona[] lista, Persona hijo) {
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

    public Persona[] ordenarHijosPorEdad(Persona[] listaHijos) {
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
                agregarHijo(arr1, listaHijos[i]);
            } else if (listaHijos[i].edad(fechaNac) > medio.edad(fechaNac)) {
                agregarHijo(arr2, listaHijos[i]);
            }
        }
        Persona[] resultado1 = ordenarHijosPorEdad(arr1);
        Persona[] resultado2 = ordenarHijosPorEdad(arr2);
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

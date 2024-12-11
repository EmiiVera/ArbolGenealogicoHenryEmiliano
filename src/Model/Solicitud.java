package Model;

import java.util.Random;
import java.util.Scanner;

public class Solicitud {
    private int emisorId;
    private int receptorId;
    private boolean confirmado;
    private String codigoConfirmacion;
    private Solicitud next;

    public Solicitud(int emisorId, int receptorId) {
        this.emisorId = emisorId;
        this.receptorId = receptorId;
        this.confirmado = false;
        this.codigoConfirmacion = generarCodigoConfirmacion();
    }

    public Solicitud() {
        this.codigoConfirmacion = generarCodigoConfirmacion();
    }

    private String generarCodigoConfirmacion() {
        return Integer.toString((int)(Math.random() * 1000));
    }

    public String getCodigoConfirmacion() {
        return codigoConfirmacion;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void confirmar(int codigoIngresado) {
        if (codigoConfirmacion.equals(Integer.toString(codigoIngresado))) {
            this.confirmado = true;
        }
    }

    public Solicitud getNext() {
        return next;
    }

    public void setNext(Solicitud next) {
        this.next = next;
    }

    public boolean tieneNext() {
        return next != null;
    }
}


package Model;

public class Solicitud {
    private int emisorId;
    private int receptorId;
    private String texto;
    private String estado;
    private Solicitud next = null;

    public Solicitud() {
    }

    public Solicitud( int emisorId, int receptorId, String texto, String estado) {

        this.emisorId = emisorId;
        this.receptorId = receptorId;
        this.texto = texto;
        this.estado = estado;
    }

    public boolean tieneNext() {
        return next!= null;
    }

    public int getEmisorId() {
        return emisorId;
    }

    public void setEmisorId(int emisorId) {
        this.emisorId = emisorId;
    }

    public int getReceptorId() {
        return receptorId;
    }

    public void setReceptorId(int receptorId) {
        this.receptorId = receptorId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        texto = "Confirmacion pendiente.";
        this.texto = texto;
    }

    public Solicitud getNext() {
        return next;
    }

    public void setNext(Solicitud next) {
        this.next = next;
    }
}

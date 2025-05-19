public class Nodo {
    int dato;
    Nodo izquierdo, derecho;

    public Nodo(int dato) {
        this.dato = dato;
        this.izquierdo = this.derecho = null;
    }
}
// Clase ArbolBinario (ArbolBinario.java)
public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    // Agregar Nodo
    public void agregar(int dato) {
        raiz = agregarRecursivo(raiz, dato);
    }

    private Nodo agregarRecursivo(Nodo actual, int dato) {
        if (actual == null) return new Nodo(dato);

        if (dato < actual.dato) actual.izquierdo = agregarRecursivo(actual.izquierdo, dato);
        else if (dato > actual.dato) actual.derecho = agregarRecursivo(actual.derecho, dato);

        return actual;
    }

    // Recorrido PreOrden
    public void preOrden() {
        preOrdenRecursivo(raiz);
        System.out.println();
    }

    private void preOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            preOrdenRecursivo(nodo.izquierdo);
            preOrdenRecursivo(nodo.derecho);
        }
    }

    // Recorrido InOrden
    public void inOrden() {
        inOrdenRecursivo(raiz);
        System.out.println();
    }

    private void inOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            inOrdenRecursivo(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            inOrdenRecursivo(nodo.derecho);
        }
    }

    // Recorrido PostOrden
    public void postOrden() {
        postOrdenRecursivo(raiz);
        System.out.println();
    }

    private void postOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            postOrdenRecursivo(nodo.izquierdo);
            postOrdenRecursivo(nodo.derecho);
            System.out.print(nodo.dato + " ");
        }
    }

    // Buscar Nodo
    public boolean buscar(int dato) {
        return buscarRecursivo(raiz, dato);
    }

    private boolean buscarRecursivo(Nodo nodo, int dato) {
        if (nodo == null) return false;
        if (nodo.dato == dato) return true;

        return dato < nodo.dato ? buscarRecursivo(nodo.izquierdo, dato) : buscarRecursivo(nodo.derecho, dato);
    }

    // Altura del Árbol
    public int altura() {
        return alturaRecursiva(raiz);
    }

    private int alturaRecursiva(Nodo nodo) {
        if (nodo == null) return -1;

        int alturaIzquierda = alturaRecursiva(nodo.izquierdo);
        int alturaDerecha = alturaRecursiva(nodo.derecho);

        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    // Contar Nodos Hojas
    public int contarHojas() {
        return contarHojasRecursivo(raiz);
    }

    private int contarHojasRecursivo(Nodo nodo) {
        if (nodo == null) return 0;
        if (nodo.izquierdo == null && nodo.derecho == null) return 1;

        return contarHojasRecursivo(nodo.izquierdo) + contarHojasRecursivo(nodo.derecho);
    }

    // Contar todos los nodos del árbol
    public int contarNodos() {
        return contarNodosRecursivo(raiz);
    }

    private int contarNodosRecursivo(Nodo nodo) {
        if (nodo == null) return 0;
        return 1 + contarNodosRecursivo(nodo.izquierdo) + contarNodosRecursivo(nodo.derecho);
    }

    // Borrar Nodo
    public void borrar(int dato) {
        raiz = borrarRecursivo(raiz, dato);
    }

    // Borrar Nodo (optimización)
    private Nodo borrarRecursivo(Nodo nodo, int dato) {
        if (nodo == null) return null;

        if (dato < nodo.dato) {
            nodo.izquierdo = borrarRecursivo(nodo.izquierdo, dato);
        } else if (dato > nodo.dato) {
            nodo.derecho = borrarRecursivo(nodo.derecho, dato);
        } else {
            // Nodo encontrado
            if (nodo.izquierdo == null) return nodo.derecho;
            if (nodo.derecho == null) return nodo.izquierdo;

            // Nodo con dos hijos: obtener el menor en el subárbol derecho
            nodo.dato = obtenerMinimo(nodo.derecho);
            nodo.derecho = borrarRecursivo(nodo.derecho, nodo.dato);
        }
        return nodo;
    }

    private int obtenerMinimo(Nodo nodo) {
        int min = nodo.dato;
        while (nodo.izquierdo != null) {
            min = nodo.izquierdo.dato;
            nodo = nodo.izquierdo;
        }
        return min;
    }

    // Vaciar Árbol
    public void vaciar() {
        raiz = null;
    }

    // Método para verificar si el árbol está vacío
    public boolean estaVacio() {
        return raiz == null;
    }

    // Método para obtener la raíz del árbol
    public Nodo getRaiz() {
        return raiz;
    }

    
}
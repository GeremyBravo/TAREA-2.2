import java.util.LinkedList;
import java.util.Queue;

class nodo2 {
    int dato;
    nodo2 izquierda;
    nodo2 derecha;

    public nodo2(int dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }
}

public class ejercicio2 {

    public static nodo2 insertar(nodo2 raiz, int valor) {
        if (raiz == null) return new nodo2(valor);
        if (valor < raiz.dato)
            raiz.izquierda = insertar(raiz.izquierda, valor);
        else
            raiz.derecha = insertar(raiz.derecha, valor);
        return raiz;
    }

    public static void preorden(nodo2 raiz) {
        if (raiz == null) return;
        System.out.print(raiz.dato + " ");
        preorden(raiz.izquierda);
        preorden(raiz.derecha);
    }

    public static void inorden(nodo2 raiz) {
        if (raiz == null) return;
        inorden(raiz.izquierda);
        System.out.print(raiz.dato + " ");
        inorden(raiz.derecha);
    }

    public static void postorden(nodo2 raiz) {
        if (raiz == null) return;
        postorden(raiz.izquierda);
        postorden(raiz.derecha);
        System.out.print(raiz.dato + " ");
    }

    public static void bfs(nodo2 raiz) {
        if (raiz == null) return;
        Queue<nodo2> cola = new LinkedList<>();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            nodo2 actual = cola.poll();
            System.out.print(actual.dato + " ");
            if (actual.izquierda != null) cola.add(actual.izquierda);
            if (actual.derecha != null) cola.add(actual.derecha);
        }
    }

    public static void main(String[] args) {
        nodo2 raiz = new nodo2(10);
        raiz.izquierda = new nodo2(5);
        raiz.derecha = new nodo2(15);
        raiz.izquierda.izquierda = new nodo2(2);
        raiz.izquierda.derecha = new nodo2(7);
        raiz.derecha.izquierda = new nodo2(12);
        raiz.derecha.derecha = new nodo2(20);

        raiz = insertar(raiz, 1);
        raiz = insertar(raiz, 3);
        raiz = insertar(raiz, 18);
        raiz = insertar(raiz, 25);

        System.out.print("preorden: ");
        preorden(raiz);
        System.out.println();

        System.out.print("inorden: ");
        inorden(raiz);
        System.out.println();

        System.out.print("postorden: ");
        postorden(raiz);
        System.out.println();

        System.out.print("bfs: ");
        bfs(raiz);
        System.out.println();
    }
}

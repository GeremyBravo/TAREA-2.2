class nodo4 {
    int dato;
    nodo4 izquierda;
    nodo4 derecha;

    public nodo4(int dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }
}

public class ejercicio4 {

    public static nodo4 insertar(nodo4 raiz, int valor) {
        if (raiz == null) return new nodo4(valor);
        if (valor < raiz.dato)
            raiz.izquierda = insertar(raiz.izquierda, valor);
        else
            raiz.derecha = insertar(raiz.derecha, valor);
        return raiz;
    }

    public static int contarhojas(nodo4 raiz) {
        if (raiz == null) return 0;
        if (raiz.izquierda == null && raiz.derecha == null) return 1;
        return contarhojas(raiz.izquierda) + contarhojas(raiz.derecha);
    }

    public static int contarnodos(nodo4 raiz) {
        if (raiz == null) return 0;
        return 1 + contarnodos(raiz.izquierda) + contarnodos(raiz.derecha);
    }

    public static void inorden(nodo4 raiz) {
        if (raiz == null) return;
        inorden(raiz.izquierda);
        System.out.print(raiz.dato + " ");
        inorden(raiz.derecha);
    }

    public static void main(String[] args) {
        nodo4 raiz = new nodo4(10);
        raiz.izquierda = new nodo4(5);
        raiz.derecha = new nodo4(15);
        raiz.izquierda.izquierda = new nodo4(2);
        raiz.izquierda.derecha = new nodo4(7);
        raiz.derecha.izquierda = new nodo4(12);
        raiz.derecha.derecha = new nodo4(20);

        raiz = insertar(raiz, 1);
        raiz = insertar(raiz, 3);
        raiz = insertar(raiz, 18);
        raiz = insertar(raiz, 25);

        System.out.print("inorden: ");
        inorden(raiz);
        System.out.println();

        System.out.println("total de nodos: " + contarnodos(raiz));
        System.out.println("total de hojas: " + contarhojas(raiz));
    }
}

class nodo3 {
    int dato;
    nodo3 izquierda;
    nodo3 derecha;

    public nodo3(int dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }
}

public class ejercicio3 {

    public static nodo3 insertar(nodo3 raiz, int valor) {
        if (raiz == null) return new nodo3(valor);
        if (valor < raiz.dato)
            raiz.izquierda = insertar(raiz.izquierda, valor);
        else
            raiz.derecha = insertar(raiz.derecha, valor);
        return raiz;
    }

    public static int contarnodos(nodo3 raiz) {
        if (raiz == null) return 0;
        return 1 + contarnodos(raiz.izquierda) + contarnodos(raiz.derecha);
    }

    public static void inorden(nodo3 raiz) {
        if (raiz == null) return;
        inorden(raiz.izquierda);
        System.out.print(raiz.dato + " ");
        inorden(raiz.derecha);
    }

    public static void main(String[] args) {
        nodo3 raiz = new nodo3(10);
        raiz.izquierda = new nodo3(5);
        raiz.derecha = new nodo3(15);
        raiz.izquierda.izquierda = new nodo3(2);
        raiz.izquierda.derecha = new nodo3(7);
        raiz.derecha.izquierda = new nodo3(12);
        raiz.derecha.derecha = new nodo3(20);

        raiz = insertar(raiz, 1);
        raiz = insertar(raiz, 3);
        raiz = insertar(raiz, 18);
        raiz = insertar(raiz, 25);

        System.out.print("inorden: ");
        inorden(raiz);
        System.out.println();

        int total = contarnodos(raiz);
        System.out.println("total de nodos: " + total);
    }
}

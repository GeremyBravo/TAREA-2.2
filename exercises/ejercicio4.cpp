#include <iostream>
#include <queue>
using namespace std;

struct nodo {
    int dato;
    nodo* izquierda;
    nodo* derecha;
    nodo(int valor) {
        dato = valor;
        izquierda = nullptr;
        derecha = nullptr;
    }
};

nodo* insertar(nodo* raiz, int valor) {
    if (raiz == nullptr) return new nodo(valor);
    if (valor < raiz->dato)
        raiz->izquierda = insertar(raiz->izquierda, valor);
    else
        raiz->derecha = insertar(raiz->derecha, valor);
    return raiz;
}

int contarhojas(nodo* raiz) {
    if (raiz == nullptr) return 0;
    if (raiz->izquierda == nullptr && raiz->derecha == nullptr) return 1;
    return contarhojas(raiz->izquierda) + contarhojas(raiz->derecha);
}

int contarnodos(nodo* raiz) {
    if (raiz == nullptr) return 0;
    return 1 + contarnodos(raiz->izquierda) + contarnodos(raiz->derecha);
}

void inorden(nodo* raiz) {
    if (raiz == nullptr) return;
    inorden(raiz->izquierda);
    cout << raiz->dato << " ";
    inorden(raiz->derecha);
}

int main() {
    nodo* raiz = new nodo(10);
    raiz->izquierda = new nodo(5);
    raiz->derecha = new nodo(15);
    raiz->izquierda->izquierda = new nodo(2);
    raiz->izquierda->derecha = new nodo(7);
    raiz->derecha->izquierda = new nodo(12);
    raiz->derecha->derecha = new nodo(20);

    raiz = insertar(raiz, 1);
    raiz = insertar(raiz, 3);
    raiz = insertar(raiz, 18);
    raiz = insertar(raiz, 25);

    cout << "inorden: ";
    inorden(raiz);
    cout << endl;

    cout << "total de nodos: " << contarnodos(raiz) << endl;
    cout << "total de hojas: " << contarhojas(raiz) << endl;

    return 0;
}

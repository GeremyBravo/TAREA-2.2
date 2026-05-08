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

void preorden(nodo* raiz) {
    if (raiz == nullptr) return;
    cout << raiz->dato << " ";
    preorden(raiz->izquierda);
    preorden(raiz->derecha);
}

void inorden(nodo* raiz) {
    if (raiz == nullptr) return;
    inorden(raiz->izquierda);
    cout << raiz->dato << " ";
    inorden(raiz->derecha);
}

void postorden(nodo* raiz) {
    if (raiz == nullptr) return;
    postorden(raiz->izquierda);
    postorden(raiz->derecha);
    cout << raiz->dato << " ";
}

void bfs(nodo* raiz) {
    if (raiz == nullptr) return;
    queue<nodo*> cola;
    cola.push(raiz);
    while (!cola.empty()) {
        nodo* actual = cola.front();
        cola.pop();
        cout << actual->dato << " ";
        if (actual->izquierda != nullptr) cola.push(actual->izquierda);
        if (actual->derecha != nullptr) cola.push(actual->derecha);
    }
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

    cout << "preorden: ";
    preorden(raiz);
    cout << endl;

    cout << "inorden: ";
    inorden(raiz);
    cout << endl;

    cout << "postorden: ";
    postorden(raiz);
    cout << endl;

    cout << "bfs: ";
    bfs(raiz);
    cout << endl;

    return 0;
}

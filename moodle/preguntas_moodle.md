# banco de preguntas moodle - recorridos de arboles binarios

## preguntas tipo opcion multiple

### pregunta 1
cual es el orden del recorrido inorden?

- a. raiz, izquierda, derecha
- b. izquierda, raiz, derecha  <-- RESPUESTA CORRECTA
- c. izquierda, derecha, raiz
- d. nivel por nivel

respuesta: b
explicacion: el recorrido inorden sigue el orden izquierda -> raiz -> derecha.
esto permite obtener los elementos de un arbol binario de busqueda en orden ascendente.

---

### pregunta 2
que estructura utiliza bfs?

- a. pila
- b. lista circular
- c. cola  <-- RESPUESTA CORRECTA
- d. arbol avl

respuesta: c
explicacion: bfs (breadth first search) utiliza una cola (fifo) para recorrer el arbol
nivel por nivel. el primer nodo que entra a la cola es el primero en salir.

---

### pregunta 3
cual recorrido visita primero la raiz?

- a. inorden
- b. preorden  <-- RESPUESTA CORRECTA
- c. postorden
- d. bfs unicamente

respuesta: b
explicacion: el recorrido preorden sigue el orden raiz -> izquierda -> derecha,
por lo tanto la raiz es el primer nodo en ser visitado.

---

### pregunta 4
cual recorrido procesa la raiz al final?

- a. preorden
- b. inorden
- c. postorden  <-- RESPUESTA CORRECTA
- d. nivel por nivel

respuesta: c
explicacion: el recorrido postorden sigue el orden izquierda -> derecha -> raiz,
por lo tanto la raiz es el ultimo nodo en ser procesado.
este recorrido es util cuando se necesita procesar los hijos antes que el nodo padre.

---

### pregunta 5
en un bst, el recorrido inorden permite obtener:

- a. elementos desordenados
- b. elementos por niveles
- c. elementos en orden ascendente  <-- RESPUESTA CORRECTA
- d. solo hojas

respuesta: c
explicacion: en un arbol binario de busqueda (bst), el recorrido inorden visita
primero el subarbol izquierdo (valores menores), luego la raiz y luego el subarbol
derecho (valores mayores). esto produce los elementos en orden ascendente.

---

## pregunta practica

complete el codigo c++ del recorrido inorden:

```
void inorden(nodo* raiz) {
    if (raiz == nullptr) return;
    _____________(raiz->izquierda);
    cout << raiz->dato << " ";
    _____________(raiz->derecha);
}
```

respuesta esperada: inorden

explicacion: la funcion se llama a si misma de forma recursiva. primero se llama con
el hijo izquierdo, luego imprime el dato actual, y finalmente se llama con el hijo
derecho. esto implementa el patron izquierda -> raiz -> derecha del recorrido inorden.

codigo correcto:

```
void inorden(nodo* raiz) {
    if (raiz == nullptr) return;
    inorden(raiz->izquierda);
    cout << raiz->dato << " ";
    inorden(raiz->derecha);
}
```

package domain;

public interface VectorList {
    int size(); // devuelve el número de elementos en el vector

    void clear(); //remueve todos los elementos del vector
    boolean isEmpty(); // true si el vector está vacío
    boolean contains(Object element); //true si el elemento existe
    void add (Object element); // inserta un elemento al final
    void add(int index, Object element); //inserta un elemento en la posición indicada
    boolean remove(Object element); //true si el elemento es suprimido
    Object remove(int index); //suprime y retorna el elemento
    void sort(); //ordena el vector
    int indexOf(Object element); //devuelve la posición del elemento (primera ocurrencia)
    Object get(int index); //devuelve el elemento en la posición indicada
}

package domain;

public class SinglyLinkedList implements List {
    private Node first; //apunta al inicio de la lista

    public SinglyLinkedList() {
        this.first = null;
    }

    @Override
    public int size() throws ListException {
        if(isEmpty()){
            throw new ListException("Singly Linked List is empty");
        }
        Node aux = first;
        int count = 0;
        while(aux!=null){
            count++;
            aux = aux.next; //muevo aux al sgte nodo
        }
        return count;
    }

    @Override
    public void clear() {
        first = null;    }

    @Override
    public boolean isEmpty() {
        return first==null;
    }

    @Override
    public boolean contains(Object element) throws ListException {
        if(isEmpty()){
            throw new ListException("Singly Linked List is empty");
        }
        Node aux = first;
        while(aux!=null){
            if(util.Utility.compare(aux.data, element)==0) return true;
            aux = aux.next; //muevo aux al sgte nodo
        }
        return false; //si llego aqui, el elemento no existe
    }

    @Override
    public void add(Object element) {
        Node newNode = new Node(element);
        if(isEmpty()){
            first = newNode;
        }else{
            Node aux = first; //apunta al primer nodo de la lista
            //necesito moverme por la lista hasta el final
            while(aux.next!=null){
                aux = aux.next;
            }
            //se sale del while cuando aux.next == null
            aux.next = newNode;
        }

    }

    @Override
    public void addFirst(Object element) {

    }

    @Override
    public void addLast(Object element) {
        add(element);
    }

    @Override
    public void addInSortedList(Object element) {

    }

    @Override
    public void remove(Object element) throws ListException {
        if(isEmpty()){
            throw new ListException("Singly Linked List is empty");
        }
        //Caso 1. El elemento a suprimir es el primero de la lista
        if(util.Utility.compare(first.data, element)==0){
            first = first.next;
        }else {
            //Caso 2. El elemento puede estar en cualquier parte
            Node prev = first;
            Node aux = first.next;
            while(aux!=null && !(util.Utility.compare(aux.data, element)==0)){
                prev = aux;
                aux = aux.next;
            }
            //se sale cuando alcanza nulo o cuando encuentra el elemento
            if(aux!=null&&util.Utility.compare(aux.data, element)==0){
                //desenlaza el nodo con el elemento a eliminar
                prev.next = aux.next;
            }
        }
    }

    @Override
    public Object removeFirst() throws ListException {
        if(isEmpty()){
            throw new ListException("Singly Linked List is empty");
        }

        return null;
    }

    @Override
    public Object removeLast() throws ListException {
        if(isEmpty()){
            throw new ListException("Singly Linked List is empty");
        }
        return null;
    }

    @Override
    public void sort() throws ListException {

    }

    @Override
    public int indexOf(Object element) throws ListException {
        if(isEmpty()){
            throw new ListException("Singly Linked List is empty");
        }
        Node aux = first;
        int index = 1;
        while(aux!=null){
            if(util.Utility.compare(aux.data, element)==0) return index;
            index++;
            aux = aux.next; //lo movemos al sgte nodo
        }
        return -1; //significa que el elemento no existe
    }

    @Override
    public Object getFirst() throws ListException {
        if(isEmpty()){
            throw new ListException("Singly Linked List is empty");
        }
        return null;
    }

    @Override
    public Object getLast() throws ListException {
        if(isEmpty()){
            throw new ListException("Singly Linked List is empty");
        }
        return null;
    }

    @Override
    public Object getPrev(Object element) throws ListException {
        if(isEmpty()){
            throw new ListException("Singly Linked List is empty");
        }
        return null;
    }

    @Override
    public Object getNext(Object element) throws ListException {
        if(isEmpty()){
            throw new ListException("Singly Linked List is empty");
        }
        return null;
    }

    @Override
    public Node getNode(int index) throws ListException {
        if(isEmpty()){
            throw new ListException("Singly Linked List is empty");
        }
        Node aux = first;
        int i = 1;
        while(aux!=null){
            if(util.Utility.compare(i, index)==0) return aux;
            i++;
            aux = aux.next; //muevo aux al sgte nodo
        }
        return null; //si llega aqui, no encontro el nodo
    }

    @Override
    public String toString() {
        String result="Singly Linked List Content\n";
        Node aux = first;
        while(aux!=null){
            result+=aux.data+" ";
            aux = aux.next; //muevo aux al sgte nodo
        }
        return result;
    }
}

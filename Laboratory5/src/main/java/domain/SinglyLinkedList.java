package domain;

public class SinglyLinkedList implements List {
    private Node first; //apunta al inicio de la lista

    public SinglyLinkedList() {
        this.first = null;
    }

    @Override
    public int size() throws ListException {
        if (isEmpty()) {
            throw new ListException("Singly Linked List is empty");
        }
        Node aux = first;
        int count = 0;
        while (aux != null) {
            count++;
            aux = aux.next; //muevo aux al sgte nodo
        }
        return count;
    }

    @Override
    public void clear() {
        first = null;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean contains(Object element) throws ListException {
        if (isEmpty()) {
            throw new ListException("Singly Linked List is empty");
        }
        Node aux = first;
        while (aux != null) {
            if (util.Utility.compare(aux.data, element) == 0) return true;
            aux = aux.next; //muevo aux al sgte nodo
        }
        return false; //si llego aqui, el elemento no existe
    }

    @Override
    public void add(Object element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node aux = first; //apunta al primer nodo de la lista
            //necesito moverme por la lista hasta el final
            while (aux.next != null) {
                aux = aux.next;
            }
            //se sale del while cuando aux.next == null
            aux.next = newNode;
        }

    }

    @Override
    public void addFirst(Object element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
    }

    @Override
    public void addLast(Object element) {
        add(element);
    }

    @Override
    public void addInSortedList(Object element) {

        Node newNode = new Node(element);
        if(isEmpty()){
            first = newNode;
        }else{
            //Cuando first.data es mayor que element
            if(util.Utility.compare(first.data, element)>0){
                newNode.next = first;
                first = newNode;
            }else{
                Node prev = first; //rastro o marca
                Node aux = first.next;
                boolean added=false;
                while(aux!=null&&!added){
                    if(util.Utility.compare(aux.data, element)>0){
                        prev.next = newNode;
                        newNode.next = aux;
                        added = true;
                    }
                    prev = aux;
                    aux = aux.next;
                }
                //enlazamos el nodo al final de la lista
                if(!added) {
                    prev.next = newNode;
                }
            }
        }
    }

    @Override
    public void remove(Object element) throws ListException {
        if (isEmpty()) {
            throw new ListException("Singly Linked List is empty");
        }
        //Caso 1. El elemento a suprimir es el primero de la lista
        if (util.Utility.compare(first.data, element) == 0) {
            first = first.next;
        } else {
            //Caso 2. El elemento puede estar en cualquier parte
            Node prev = first;
            Node aux = first.next;
            while (aux != null && !(util.Utility.compare(aux.data, element) == 0)) {
                prev = aux;
                aux = aux.next;
            }
            //se sale cuando alcanza nulo o cuando encuentra el elemento
            if (aux != null && util.Utility.compare(aux.data, element) == 0) {
                //desenlaza el nodo con el elemento a eliminar
                prev.next = aux.next;
            }
        }
    }

    @Override
    public Object removeFirst() throws ListException {
        if (isEmpty()) {
            throw new ListException("Singly Linked List is empty");
        }
        Object element = first.data;
        first = first.next;
        return element;
    }

    @Override
    public Object removeLast() throws ListException {
        if (isEmpty()) {
            throw new ListException("Singly Linked List is empty");
        }
        remove(getLast());

        return getLast();
    }

    @Override
    public void sort() throws ListException {
        if (isEmpty())
            throw new ListException("Singly Linked List is empty");
        for (int i = 1; i <= size(); i++) {
            for (int j = i + 1; j < size(); j++) {
                if (util.Utility.compare(getNode(j).data, getNode(i).data) < 0) {
                    //if(util.Utility.lessT(getNode(j).data, getNode(i).data)){
                    Object aux = getNode(i).data;
                    getNode(i).data = getNode(j).data;
                    getNode(j).data = aux;
                }//if
            }//for j
        }//for i
    }

    @Override
    public int indexOf(Object element) throws ListException {
        if (isEmpty()) {
            throw new ListException("Singly Linked List is empty");
        }
        Node aux = first;
        int index = 1;
        while (aux != null) {
            if (util.Utility.compare(aux.data, element) == 0) return index;
            index++;
            aux = aux.next; //lo movemos al sgte nodo
        }
        return -1; //significa que el elemento no existe
    }

    @Override
    public Object getFirst() throws ListException {
        if (isEmpty()) {
            throw new ListException("Singly Linked List is empty");
        }
        return first.data;
    }

    @Override
    public Object getLast() throws ListException {
        if (isEmpty()) {
            throw new ListException("Singly Linked List is empty");
        }
        Node aux = first;
        while (aux.next != null) {
            aux = aux.next;
        }
        // al salir del while esta en el ultimo nodo
        return aux.data;
    }

    @Override
    public Object getPrev(Object element) throws ListException {
        if(isEmpty()){
            throw new ListException("Singly Linked List is empty");
        }
        if(util.Utility.compare(first.data, element)==0){
            return "It's the first, it has no prev";
        }
        Node aux = first;
        while(aux.next!=null){
            if(util.Utility.compare(aux.next.data, element)==0){
                return aux.data;
            }
            aux = aux.next; //muevo aux al sgte nodo
        }
        return "Does not exist in Single Linked List";
    }

    @Override
    public Object getNext(Object element) throws ListException {
        if (isEmpty()) {
            throw new ListException("Singly Linked List is empty");
        }
        Node aux = first;

        if (util.Utility.compare(getLast(), element) == 0) {
            return " This element is the last in the list, don't have next.";
        } else {

            while (aux.next != null) {

                if (util.Utility.compare(aux, element) == 0) {
                    return aux.next.data;
                }
                aux = aux.next;

            }
            return "This element don't exist in the list.";
        }
    }

    @Override
    public Node getNode(int index) throws ListException {
        if (isEmpty()) {
            throw new ListException("Singly Linked List is empty");
        }
        Node aux = first;
        int i = 1;
        while (aux != null) {
            if (util.Utility.compare(i, index) == 0) return aux;
            i++;
            aux = aux.next; //muevo aux al sgte nodo
        }
        return null; //si llega aqui, no encontro el nodo
    }

    @Override
    public String toString() {
        String result = "Singly Linked List Content\n";
        Node aux = first;
        while (aux != null) {
            result += aux.data + "\n ";
            aux = aux.next; //muevo aux al sgte nodo
        }
        return result;
    }
}

package domain;

public class DoublyLinkedList implements List {
    private Node first; //apunta al inicio de la lista

    public DoublyLinkedList() {
        this.first = null;
    }

    @Override
    public int size() throws ListException {
        if(isEmpty()){
            throw new ListException("Doubly Linked List is empty");
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
    public boolean isEmpty() {return first==null;}

    @Override
    public boolean contains(Object element) throws ListException {
        if(isEmpty()){
            throw new ListException("Doubly Linked List is empty");
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
            //hago el doble enlace
            newNode.prev = aux;
        }

    }

    @Override
    public void addFirst(Object element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.next = first;
            first.prev=newNode;
            first = newNode;

        }
    }

    @Override
    public void addLast(Object element) {
        add(element);
    }

    @Override
    public void addInSortedList(Object element) {
        try {
            add(element);
            sort();
        } catch (ListException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(Object element) throws ListException {
        if(isEmpty()){
            throw new ListException("Singly Linked List is empty");
        }
        //Caso 1. El elemento a suprimir es el primero de la lista
        if(util.Utility.compare(first.data, element)==0){

            if(first.next==null){
                first=null;
            }else{
                first = first.next;
                first.prev = null; //pq el anterior del 1er nodo quede apuntado a nulo
            }

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
                //mantengo el doble enlace
                if(aux.next!=null)
                    aux.next.prev = prev;
            }
        }
    }

    @Override
    public Object removeFirst() throws ListException {
        if(isEmpty()){
            throw new ListException("Singly Linked List is empty");
        }else {
            first = first.next;
            first.prev = null; //pq el anterior del 1er nodo quede apuntado a nulo
        }
        return null;
    }

    @Override
    public Object removeLast() throws ListException {
        if(isEmpty()){
            throw new ListException("Singly Linked List is empty");
        }
        remove(getLast());

        return getLast();
    }

    @Override

        public void sort() throws ListException {
            if(isEmpty())
                throw new ListException("Doubly Linked List is empty");
            for(int i=1;i<=size();i++){
                for(int j=i+1;j<size();j++){
                    if(util.Utility.compare(getNode(j).data, getNode(i).data)<0){
                        //if(util.Utility.lessT(getNode(j).data, getNode(i).data)){
                        Object aux=getNode(i).data;
                        getNode(i).data=getNode(j).data;
                        getNode(j).data=aux;
                    }//if
                }//for j
            }//for i
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
            throw new ListException("Doubly Linked List is empty");
        }
        return first.data;
    }

    @Override
    public Object getLast() throws ListException {
        if(isEmpty()){
            throw new ListException("Doubly Linked List is empty");
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
        Node newNode = new Node(element);
        if(isEmpty()){
            throw new ListException("Singly Linked List is empty");
        }else {
            newNode=newNode.prev;
        }
        return newNode;
    }

    @Override
    public Object getNext(Object element) throws ListException {
        if(isEmpty()){
            throw new ListException("Doubly Linked List is empty");
        }
        Node aux = first;

        if (util.Utility.compare(getLast(), element)==0) {
            return " This element is the last in the list, don't have next.";
        } else {

            while (aux.next != null) {

                if (util.Utility.compare(aux, element)==0) {
                    return aux.next.data;
                }
                aux = aux.next;

            }
            return "This element don't exist in the list.";
        }
    }

    @Override
    public Node getNode(int index) throws ListException {
        if(isEmpty()){
            throw new ListException("Doubly Linked List is empty");
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
        String result="Doubly Linked List Content\n";
        Node aux = first;
        while(aux!=null){
            result+=aux.data+" ";
            aux = aux.next; //muevo aux al sgte nodo
        }
        return result;
    }
}

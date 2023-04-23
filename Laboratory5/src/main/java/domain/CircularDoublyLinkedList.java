/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 * Lista circular doblemente enlazada
 * @author Profesor Lic. Gilberth Chaves A.
 */
public class CircularDoublyLinkedList implements List {
    private Node first; //apunta al inicio de la lista
    private Node last; //apunta al final de la lista
    
   //Constructor
    public CircularDoublyLinkedList(){
        this.first = this.last = null;
    }

    @Override
    public int size() throws ListException {
        if(isEmpty()){
            throw new ListException("Circular Doubly Linked List is empty");
        }
        Node aux = first;
        int count=0;
        while(aux!=last){
            count++;
            aux = aux.next; //lo movemos al sgte nodo
        }
        return count+1; //+1 para que cuente el ultimo
    }

    @Override
    public void clear() {
        first = last = null;
    }

    @Override
    public boolean isEmpty() {
        return first==null;
    }

    @Override
    public boolean contains(Object element) throws ListException {
        if(isEmpty()){
            throw new ListException("Circular Doubly Linked List is empty");
        }
        Node aux = first;
        while(aux!=last){
            if(util.Utility.compare(aux.data, element)==0){
                return true;
            }
            aux = aux.next; //lo movemos al sgte nodo
        }
        //se sale cuando aux==last
        //solo nos queda verificar si el elemento a buscar esta en el ultimo nodo
        return util.Utility.compare(aux.data, element)==0;
    }

    @Override
    public void add(Object element) {
        Node newNode = new Node(element);
        if(isEmpty()){
            first = last = newNode;
        }
        else{
            last.next = newNode;
            //hago el doble enlace
            newNode.prev = last;
            last = newNode;
            
            //hago el enlace circular
            last.next = first;
            //hago el doble enlace
            first.prev = last;
        }
    }

    @Override
    public void addFirst(Object element) {
        Node newNode = new Node(element);
        if(isEmpty()){
            first = newNode;
        }else{
            newNode.next = first;
            //hago el doble enlace
            first.prev = newNode;
            first = newNode;
        }
        //hago el enlace circular y doble
        last.next = first;
        first.prev = last;
    }

    @Override
    public void addLast(Object element) {
        add(element);
    }

    @Override
    public void addInSortedList(Object element) {
        Node newNode = new Node(element);
        //caso1. La lista esta vacia
        if(isEmpty()){
            first = last = newNode;
        }
        else{
            //caso2. inicio.sgte sea nulo
            //o incio.sgte no sea nulo
            //y el elemento a insertar es menor al del inicio
            if(util.Utility.compare(first.data, element)>0){
            //if(Utility.greaterT(first.data, element)){
               newNode.next = first;
               //hago el doble enlace
               first.prev = newNode;
               first = newNode;
            }
            //para todos los otros casos
            else{
                Node prev = first;
                Node aux = first.next;
                boolean inserted=false;
                while(aux!=last&&!inserted){
                    if(util.Utility.compare(element, aux.data)<0){
                        prev.next = newNode;
                        //hago el doble enlace
                        newNode.prev = prev;
                        newNode.next = aux;
                        //hago el doble enlace
                        aux.prev = newNode;
                        inserted=true;
                    }
                    prev=aux;
                    aux=aux.next;
                }
                //se enlaza cuando aux=last
                if(util.Utility.compare(element, aux.data)<0 &&!inserted){
                //if(Utility.lessT(element, aux.data)&&!inserted){
                    prev.next = newNode;
                    //hago el doble enlace
                    newNode.prev = prev;
                    newNode.next = aux;
                    //hago el doble enlace
                    aux.prev = newNode;
                }//if
                else //enlaza al final
                    if(!inserted){
                        aux.next = newNode;
                        //hago el doble enlace
                        newNode.prev = aux;
                        //muevo last al ultimo nodo
                        last = newNode;
                    }//if
            }//else
        }//else
        //hago el enlace circular
        last.next = first;
    }

    @Override
    public void remove(Object element) throws ListException {
        if(isEmpty()){
            throw new ListException("Circular Doubly Linked List is empty");
        }
        //caso1. El elemento a suprimir es el primero
        if(util.Utility.compare(first.data, element)==0){
            first = first.next;
        }
        //caso2. Elemento puede estar en medio o al final
        else{
            Node prev = first; //anterior
            Node aux = first.next;
            while(aux!=last&&!(util.Utility.compare(aux.data, element)==0)){
                prev = aux;
                aux = aux.next;
            }
            //se sale cuando alcanza aux=last
            //o cuando encuentra el elemento a suprimir
            if(util.Utility.compare(aux.data, element)==0){
                //desenlanza el nodo
                prev.next = aux.next;
                //mantengo el doble enlace
                aux.next.prev = prev;
                        
            }
            //debo asegurarme q last apunte al ultimo nodo
            if(aux==last){ //estamos en el ultimo nodo
                last=prev;
            }
        }//else
        //mantengo el enlace circular y doble
        last.next = first;
        first.prev = last;
        //q pasa si solo queda un nodo
        //y es el q quiero eliminar
        if(first==last&&util.Utility.compare(first.data, element)==0){
            clear(); //anulo la lista
        }
    }

    @Override
    public Object removeFirst() throws ListException {
        if(isEmpty()){
            throw new ListException("Circular Doubly Linked List is empty");
        }
        Object element = first.data;
        first = first.next; //muevo el apuntador al sgte nodo
        //hago el enlace circular y doble
        last.next = first;
        first.prev = last;
        return element;
    }

    @Override
    public Object removeLast() throws ListException {
        if(isEmpty()){
            throw new ListException("Circular Doubly Linked List is empty");
        }
        Object element = last.data;
        Node prev = last.prev;
        last = prev;
        //mantengo el enlace circular y doble
        last.next = first;
        first.prev = last;
        return element;
    }

    @Override
    public void sort() throws ListException {
        if(isEmpty())
            throw new ListException("Singly Linked List is empty");
        for(int i=1;i<=size();i++){
            for(int j=i+1;j<size();j++){
                if(util.Utility.compare(getNode(j).data, getNode(i).data)<0){
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
            throw new ListException("Circular Doubly Linked List is empty");
        }
        Node aux = first;
        int index=1;
        while(aux!=last){
            if(util.Utility.compare(aux.data, element)==0){
                return index;
            }
            index++;
            aux = aux.next; //lo movemos al sgte nodo
        }
        //se sale cuando aux apunta a last (al ultimo nodo)
        if(util.Utility.compare(aux.data, element)==0){
            return index;
        }
        return -1; //indica q el elemento no existe
    }
    
    @Override
    public Object getFirst() throws ListException {
        if(isEmpty()){
            throw new ListException("Circular Doubly Linked List is empty");
        }
        return first.data;
    }

    @Override
    public Object getLast() throws ListException {
        if(isEmpty()){
            throw new ListException("Circular Doubly Linked List is empty");
        }
        return last.data; //es el ultimo en la lista
    }    

    @Override
    public Object getPrev(Object element) throws ListException {
        if(isEmpty()){
            throw new ListException("Circular Doubly Linked List is empty");
        }
        if(util.Utility.compare(first.data, element)==0){
            return last.data;
        }
        Node aux = first;
        while(aux.next!=last){
            //if(aux.next.data.equals(element)){
            if(util.Utility.compare(aux.next.data, element)==0){
                return aux.data;
            }
            aux = aux.next;
        }
        //se sale cuando aux.next apunta a last (al ultimo nodo)
        if(util.Utility.compare(aux.next.data, element)==0){
            return aux.data;
        }
        return "Does not exist in circular doubly linked list";
    }

    @Override
    public Object getNext(Object element) throws ListException {
        if(isEmpty()){
            throw new ListException("Circular Doubly Linked List is empty");
        }
        Node aux = first; //dejar un rastro
        while(aux!=last){
            if(util.Utility.compare(aux.data, element)==0){
                return aux.next.data; //el elemento posterior
            }
            aux = aux.next; //lo movemos al sgte nodo
        }
        //se sale cuando aux==last
        if(util.Utility.compare(aux.data, element)==0){
            return aux.next.data; //el elemento anterior
        }
        return "Does not exist in circular doubly linked list";
    }

    @Override
    public Node getNode(int index) throws ListException {
        if(isEmpty()){
            throw new ListException("Circular Doubly Linked List is empty");
        }
        Node aux = first;
        int i = 1; //posicion del primer nodo
        while(aux!=last){
            if(util.Utility.compare(i, index)==0){
                return aux;
            }
            i++;
            aux = aux.next; //lo movemos al sgte nodo
        }
        //se sale cuando aux==last
        if(util.Utility.compare(i, index)==0){
            return aux;
        }
        return null; //si llega aqui no encontro el nodo
    }    
    
    @Override
    public String toString() {
        String result = "\nCircular Doubly Linked List Content\n";
        Node aux = first;
        while(aux!=last){
            result+=aux.data+" ";
            aux = aux.next; //lo movemos al sgte nodo
        }
        //se sale cuando aux==last
        //agregamos la info del ultimo nodo
        return result+" "+aux.data;
    }

}

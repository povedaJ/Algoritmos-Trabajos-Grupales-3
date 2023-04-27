package domain;

public class LinkedStack implements Stack {
    private Node top; //es un apuntador al tope de la pila enlazada
    private int counter; //contador de elementos apilados

    public LinkedStack() {
        this.top = null;
        this.counter = 0;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public void clear() {
        this.top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public Object peek() throws StackException {
        if (isEmpty())
            throw new StackException("Linked Stack is empty");
        return this.top.data;
    }

    @Override
    public Object top() throws StackException {
        if (isEmpty())
            throw new StackException("Linked Stack is empty");
        return this.top.data;
    }

    @Override
    public void push(Object element) throws StackException {
        Node newNode = new Node(element);
        if (isEmpty()) {
            // creamos un nuevo nodo
            this.top = newNode;

        } else {
            newNode.next = top;//hacemos el enlace entre nodos
            top = newNode;
        }
        //incremento el contador de elementos apilados
        this.counter++;
    }

    @Override
    public Object pop() throws StackException {
        if (isEmpty())
            throw new StackException("Linked Stack is empty");
        Object element = top.data;
        top = top.next;//movemos top al siguente nodo
        this.counter--;//decremento el contador
        return element;
    }

    @Override
    public String toString() {
        String result = "Linked Stack content\n";
        LinkedStack aux = new LinkedStack();
        try {
            while (!isEmpty()) {
                result += peek() + ", ";
                aux.push(pop());
            }

            //requiero volver a llenar la pila original
            while (!aux.isEmpty()) {
                push(aux.pop());
            }
        } catch (StackException ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

}

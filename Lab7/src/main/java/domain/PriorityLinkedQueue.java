package domain;

public class PriorityLinkedQueue implements Queue {

    private Node front;//apuntador al anterior
    private Node rear;//apuntador al posterior
    private int count;// control de elementos encolados

    public PriorityLinkedQueue() {
        this.front = this.rear = null;
        this.count = 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void clear() {
        this.front = this.rear = null;
        this.count = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
        //count==0
    }

    @Override
    public int indexOf(Object element) throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Priority Linked queue is empty");
        }
        PriorityLinkedQueue aux = new PriorityLinkedQueue();
        int i = 1;//iniciamos en el indice 1
        int j = -1;//si es -1 no existe el elemento en la cola
        while (!isEmpty()) {
            if (util.Utility.compare(front(), element) == 0) {// son iguales
                j = i;
            }
            aux.enQueue(deQueue());
            i++;
        }
        //al final dejamos la cola en su estado original
        while (!aux.isEmpty()) {
            enQueue(aux.deQueue());
        }
        return j;
    }

    @Override
    public void enQueue(Object element) throws QueueException {
        Node newNode = new Node(element);
        if (isEmpty()) {//si la cola esta vacia
            rear = newNode;
            //garantizamos que anterior quede apuntando al primer nodo
            front = rear;
        } else {//quiere decir que la cola existe
            rear.next = newNode;
            rear = newNode;
        }
        count++;//actualizamos el contador de elementos
    }
    public void enQueue(Object element,Integer priority) throws QueueException {
        Node newNode = new Node(element,priority);
        if (isEmpty()) {//si la cola esta vacia
            rear = newNode;
            //garantizamos que anterior quede apuntando al primer nodo
            front = rear;
        } else {//quiere decir que la cola existe
            Node aux =front;
            Node prev = front;
            while(aux!=null&&aux.priority>priority){
                prev= aux;//dejamos un rastro en el nodo anterior
                aux=aux.next;//movemos aux al siguiente nodo

            }
            //se sale del while cuando alcanza nulo o la prioridad del nuevo elemeto es mas alta

            if(aux==front){//el nuevo elemento tiene prioridad mas alta
                newNode.next=front;
                front=newNode;
            }else if(aux==null){//prev esta en el ultimo nodo
                prev.next=newNode;
                rear=newNode;
            }else{
                prev.next=newNode;
                newNode.next=aux;
            }
        }
        count++;//actualizamos el contador de elementos
    }

    @Override
    public Object deQueue() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Priority Linked queue is empty");
        }
        Object element = front.data;
        //caso 1: cuando solo hay un elemento
        if (front == rear) {
            clear();//elimino la cola
        } else {//caso 2: tiene varios elementos
            front = front.next;
            count--;//actualizo el contador de elementos
        }
        return element;

    }

    @Override
    public boolean contains(Object element) throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Priority Linked queue is empty");
        }

        PriorityLinkedQueue aux = new PriorityLinkedQueue();
        boolean finded = false;
        while (!isEmpty()) {
            if (util.Utility.compare(front(), element) == 0) {// son iguales
                finded = true;
            }
            aux.enQueue(deQueue());
        }
        //al final dejamos la cola en su estado original
        while (!aux.isEmpty()) {
            enQueue(aux.deQueue());
        }

        return finded;
    }

    @Override
    public Object peek() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Priority Linked queue is empty");
        }

        return front.data;
    }

    @Override
    public Object front() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Priority Linked queue is empty");
        }

        return front.data;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "Priority LinkedQueue is Empty";
        String result = "Priority LinkedQueue content\n";
        try {
            PriorityLinkedQueue aux = new PriorityLinkedQueue();
            while (!isEmpty()) {
                result += front() + ", ";
                Integer priority= front.priority;
                aux.enQueue(deQueue(),priority);
            }
            //al final dejamos las cola en su estado original
            while (!aux.isEmpty()) {
                Integer priority= aux.front.priority;
                enQueue(aux.deQueue(),priority);
            }

        } catch (QueueException ex) {
            throw new RuntimeException(ex);

        }
        return result;
    }
}

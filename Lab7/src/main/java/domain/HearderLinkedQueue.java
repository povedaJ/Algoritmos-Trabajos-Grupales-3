package domain;

public class HearderLinkedQueue implements Queue {

    private Node front;//apuntador al anterior
    private Node rear;//apuntador al posterior
    private int count;// control de elementos encolados

    public HearderLinkedQueue() {
        this.front = this.rear = new Node();//node en null
        this.count = 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void clear() {
        this.front = this.rear = new Node();
        this.count = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
        //count==0
    }

    @Override
    public int indexOf(Object element) throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Linked queue is empty");
        }
        HearderLinkedQueue aux = new HearderLinkedQueue();
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
            rear.next = newNode;
            rear= newNode;
        count++;//actualizamos el contador de elementos
    }

    @Override
    public Object deQueue() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Header Linked queue is empty");
        }
        Object element = front.next.data;
        //caso 1: cuando solo hay un elemento
        if (front.next == rear) {
            clear();//elimino la cola
        } else {//caso 2: tiene varios elementos
            front.next = front.next.next;
            count--;//actualizo el contador de elementos
        }
        return element;

    }

    @Override
    public boolean contains(Object element) throws QueueException {
        if (isEmpty()) {
            throw new QueueException("HeaderLinked queue is empty");
        }

        HearderLinkedQueue aux = new HearderLinkedQueue();
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
            throw new QueueException("HeaderLinked queue is empty");
        }

        return front.next.data;
    }

    @Override
    public Object front() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("HeaderLinked queue is empty");
        }

        return front.next.data;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "HeaderLinked is Empty";
        String result = "HeaderLinked content\n";
        try {
            HearderLinkedQueue aux = new HearderLinkedQueue();
            while (!isEmpty()) {
                result += front() + ", ";
                aux.enQueue(deQueue());
            }
            //al final dejamos las cola en su estado original
            while (!aux.isEmpty()) {
                enQueue(aux.deQueue());
            }

        } catch (QueueException ex) {
            throw new RuntimeException(ex);

        }
        return result;
    }
}

package domain;

import org.junit.jupiter.api.Test;
import util.Utility;

class LinkedQueueTest {
    @Test
    void test1() {
        LinkedQueue queue= new LinkedQueue();
        SinglyLinkedList singly = new SinglyLinkedList();
        singly.add("Ana");

        for (int i = 0; i < 30; i++) {
            singly.add(Utility.getPlace()); //30 nombres de lugares
        }
        ArrayQueue aQueue = new ArrayQueue(20);
        ArrayStack aStack = new ArrayStack(30);
        try {
            for (int i = 0; i < 20; i++) {
                aQueue.enQueue(new Person(Utility.getPerson(), Utility.getMood()));
            }
            for (int i = 0; i < 30; i++) {
                aStack.push(Utility.getObject());
            }
            queue.enQueue(singly);

            queue.enQueue(aQueue);
            queue.enQueue(aStack);
            System.out.println(queue.toString());
            //
            System.out.println("\nDesencole los objetos tipo ArrayStack\n");
            remove(queue, aStack);
            System.out.println(queue.toString());
        } catch (QueueException e) {
            throw new RuntimeException(e);
        } catch (StackException e) {
            throw new RuntimeException(e);
        }
    }
    private void remove(LinkedQueue list, ArrayStack element) throws QueueException { //la lista no puede estar vacia
        LinkedQueue aux = new LinkedQueue();
        while (!list.isEmpty()) {
            if (Utility.compare(list.front(), element) == 0) {
                list.deQueue();
            } else {
                aux.enQueue(list.deQueue());
            }
        }
        while (!aux.isEmpty()) {
            list.enQueue(aux.deQueue());
        }
    }

    @Test
    void test() {//

        //enQueue: 10, 20,5,7,2,1
        LinkedQueue queue= new LinkedQueue();
//en el ultimo nivel(ya va a imprimir algo) se usa try cath
        try {
            queue.enQueue(10);
            queue.enQueue(20);
            queue.enQueue(5);
            queue.enQueue(7);
            queue.enQueue(2);
            queue.enQueue(1);
            System.out.println(queue);
            System.out.println("Index of 5: "+ queue.indexOf(5));
            System.out.println("Index of 2: "+ queue.indexOf(2));
            System.out.println("Index of 1: "+ queue.indexOf(1));
            System.out.println("Contains 15 : "+ queue.contains(15));
            System.out.println( queue.contains(15)?"El 15 si fue enconlado":"El 15 no fue encolado");
            System.out.println( queue.contains(2)?"El 2 si fue enconlado":"El 2 no fue encolado");// operadores ternarios

        } catch (QueueException e) {
            throw new RuntimeException(e);
        }

    }
}
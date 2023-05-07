package domain;

import org.junit.jupiter.api.Test;
import util.Utility;

class LinkedQueueTest {
    @Test
    void test1() {
        LinkedQueue queue= new LinkedQueue();
        SinglyLinkedList singly = new SinglyLinkedList();
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


}
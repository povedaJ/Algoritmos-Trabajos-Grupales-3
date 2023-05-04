package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HearderLinkedQueueTest {

    @Test
    void test() {

        //enQueue: 10, 20,5,7,2,1
        HearderLinkedQueue queue= new HearderLinkedQueue();
//en el ultimo nivel(ya va a imprimir algo) se usa try cath
        try {
            queue.enQueue(10);
            queue.enQueue(20);
            queue.enQueue(5);
            queue.enQueue(7);
            queue.enQueue(2);
            queue.enQueue(1);
            System.out.println(queue);
            System.out.println("Size "+ queue.size());
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
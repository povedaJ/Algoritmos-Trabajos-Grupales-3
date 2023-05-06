package domain;

import org.junit.jupiter.api.Test;
import util.Utility;

class ArrayQueueTest {

    @Test
    void test() {
        ArrayQueue queue = new ArrayQueue(20);
        try {

            int j = 0;
            for (int i = 0; i < 19; i++) {

                //name y mood viene de forma random desde utility
                queue.enQueue(new Person(Utility.getPerson(), Utility.getMood()));
                if (j == 12) {
                    j = 0;
                } else {
                    j++;
                }
            }
            queue.enQueue(new Person("Valeria", "Cheerful"));
//            queue.enQueue(new Person("Laura", "Cheerful"));
//            queue.enQueue(new Person("Laura", "Sadness"));

            System.out.println(queue.toString());
            System.out.println("Size " + queue.size());
            System.out.println(queue.contains(new Person("Valeria", "Cheerful")) ? "Valeria  Cheerful si fue enconlado" : "Valeria Calm no fue encolado");
            System.out.println(queue.contains(new Person("Mateo", "Anger")) ? "Mateo Anger si fue enconlado" : "Mateo Anger  no fue encolado");
            System.out.println("Index of Laura Sadness: " + queue.indexOf(new Person("Laura", "Sadness")));
            System.out.println("Index of Valeria Cheerful: " + queue.indexOf(new Person("Valeria", "Cheerful")));

            System.out.println("Desencole todas las personas con Cheerful");
            remove(queue, "Cheerful");
            System.out.println("Size " + queue.size());
            System.out.println(queue.toString());

        } catch (QueueException e) {
            throw new RuntimeException(e);
        }
    }

    private void remove(ArrayQueue list, String mood) throws QueueException { //la lista no puede estar vacia
        ArrayQueue aux = new ArrayQueue(list.size());
        while (!list.isEmpty()) {
            if (Utility.compare(list.front(), mood) == 0) {
                list.deQueue();
            } else {
                aux.enQueue(list.deQueue());
            }
        }
        while (!aux.isEmpty()) {
            list.enQueue(aux.deQueue());
        }
    }

}//fin
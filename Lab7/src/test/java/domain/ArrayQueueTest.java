package domain;

import org.junit.jupiter.api.Test;
import util.Utility;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

    @Test
    void test() {
        ArrayQueue queue = new ArrayQueue(20);
        try {

            int j =0;
            for (int i = 0; i < 20; i++) {
                //queue.enQueue(new Person(nombre[i], mood[j]));
                queue.enQueue(new Person(util.Utility.getPerson(i), util.Utility.getMood(j)));
                if(j==12){
                    j=0;
                }else{
                    j++;
                }
            }
            System.out.println(queue.toString());
            System.out.println("Size "+ queue.size());
            System.out.println(queue.contains(new Person("Valeria","Cheerful"))?"Valeria si fue enconlado" :"Valeria Calm no fue encolado");
            System.out.println(queue.contains(new Person("Hugo","Anger"))?"Hugo Hopeful si fue enconlado":"Hugo Hopeful no fue encolado");
            System.out.println("Index of Laura: "+ queue.indexOf(new Person("Laura","Sadness")));
            System.out.println("Index of Valeria: "+ queue.indexOf(new Person("Valeria", "Cheerful")));

            //Desencole todas las personas con Cheerful
            remove(queue,"Cheerful");
            System.out.println(queue.toString());
        } catch (QueueException e) {
            throw new RuntimeException(e);
        }
    }

    private void remove(ArrayQueue list, String mood) throws QueueException { //la lista no puede estar vacia
        ArrayQueue aux = new ArrayQueue(list.size());
        while (!list.isEmpty()){
            if (Utility.compare(list.front(), mood) ==0) {
                list.deQueue();
            } else {
                aux.enQueue(list.deQueue());
            }
        }
        while (!aux.isEmpty()){
            list.enQueue(aux.deQueue());
        }
    }

}//fin
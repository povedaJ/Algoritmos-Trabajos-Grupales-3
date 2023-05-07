package domain;

import jdk.jshell.execution.Util;
import org.junit.jupiter.api.Test;
import util.Utility;

import static org.junit.jupiter.api.Assertions.*;

class HearderLinkedQueueTest {

    @Test

        void test1() {
            HearderLinkedQueue hlq1 = new HearderLinkedQueue();
            HearderLinkedQueue hlq2 = new HearderLinkedQueue();
            HearderLinkedQueue hlq3 = new HearderLinkedQueue();
            try {
                for (int i = 0; i < 20; i++) {
                    hlq1.enQueue(new Climate(new Place(Utility.getPlace()), new Weather(Utility.getWeather())));
                }
                System.out.println(hlq1.toString());
                //Desencole los objetos con “sunny” y “foggy” de hlq1
                System.out.println("Desencole los objetos con “sunny” y “foggy”");
                remove(hlq1, "sunny", hlq2);
                remove(hlq1, "foggy",hlq2);

                System.out.print("hlq1");
                System.out.println(hlq1.toString());
                System.out.print("hlq2");
                System.out.println(hlq2.toString());

                //Desencole los objetos con “Paraíso” y “Liberia” de hlq1
                System.out.println("Desencole los objetos con “Paraiso” y “Liberia”");
                remove(hlq1, "Paraiso", hlq3);
                remove(hlq1, "Liberia",hlq3);

                System.out.print("hlq1");
                System.out.println(hlq1.toString());
                System.out.print("hlq3");
                System.out.println(hlq3.toString());

                //h. Desencole los objetos con “thunderstorm” y “cloudy”
                System.out.println("Desencole los objetos con “thunderstorm” y “cloudy”");
                remove(hlq1, "thunderstorm", hlq2);
                remove(hlq1, "cloudy",hlq3);

                System.out.print("hlq1");
                System.out.println(hlq1.toString());
                System.out.print("hlq2");
                System.out.println(hlq2.toString());
                System.out.print("hlq3");
                System.out.println(hlq3.toString());
            } catch (QueueException e) {
                throw new RuntimeException(e);
            }
        }
        private HearderLinkedQueue remove(HearderLinkedQueue list, String elemt, HearderLinkedQueue aux2) throws QueueException { //la lista no puede estar vacia
            HearderLinkedQueue aux = new HearderLinkedQueue();
            while (!list.isEmpty()) {
                if (Utility.compare(list.front(), elemt) == 0) {
                    //list.deQueue();
                    aux2.enQueue(list.deQueue());
                } else {
                    aux.enQueue(list.deQueue());
                }
            }
            while (!aux.isEmpty()) {
                list.enQueue(aux.deQueue());
            }
            return aux2;
        }

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
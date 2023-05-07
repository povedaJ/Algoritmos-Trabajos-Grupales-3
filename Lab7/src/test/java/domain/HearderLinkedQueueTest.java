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
                System.out.println("Desencole los objetos con “Sunny” y “Foggy”");
                remove(hlq1, "Sunny", hlq2);
                remove(hlq1, "Foggy",hlq2);

                System.out.print("hlq1");
                System.out.println(hlq1.toString());
                System.out.print("hlq2");
                System.out.println(hlq2.toString());

                //Desencole los objetos con “Paraíso” y “Liberia” de hlq1
                System.out.println("Desencole los objetos con “Paraíso” y “Liberia”");
                remove(hlq1, "Paraíso", hlq3);
                remove(hlq1, "Liberia",hlq3);
                System.out.print("hlq1");
                System.out.println(hlq1.toString());
                System.out.print("hlq3");
                System.out.println(hlq3.toString());

                //h. Desencole los objetos con “thunderstorm” y “cloudy”
                System.out.println("Desencole los objetos con “Thunderstorm” y “Cloudy”");

                HearderLinkedQueue aux = new HearderLinkedQueue();
                duplicar(hlq1,aux);
                remove(hlq1, "Thunderstorm", hlq2); remove(hlq1, "Cloudy",hlq2);
                remove(aux, "Thunderstorm", hlq3); remove(aux, "Cloudy",hlq3);

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
        private void remove(HearderLinkedQueue list, String elemt, HearderLinkedQueue aux2) throws QueueException { //la lista no puede estar vacia
            HearderLinkedQueue aux = new HearderLinkedQueue();
            while (!list.isEmpty()) {
                if (Utility.compare(list.front(), elemt) == 0) {
                    aux2.enQueue(list.deQueue());
                } else {
                    aux.enQueue(list.deQueue());
                }
            }
            while (!aux.isEmpty()) {
                list.enQueue(aux.deQueue());
            }
        }
    private void duplicar(HearderLinkedQueue list, HearderLinkedQueue aux2) throws QueueException { //la lista no puede estar vacia
        HearderLinkedQueue aux = new HearderLinkedQueue();
        while (!list.isEmpty()) {
            aux2.enQueue(list.front());
            aux.enQueue(list.deQueue());
        }
        while (!aux.isEmpty()) {
            list.enQueue(aux.deQueue());
        }
    }

    }
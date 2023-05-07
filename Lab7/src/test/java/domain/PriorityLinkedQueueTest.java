package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityLinkedQueueTest {

    @Test
    void test() {
        try {
        PriorityLinkedQueue q = new PriorityLinkedQueue();
//        q.enQueue("Carlos",1);
//        q.enQueue("Maria",3);
//        q.enQueue("Raul",2);
//        q.enQueue("Valeria",3);
//        q.enQueue("Pedro",2);
//
            q.enQueue(new Person("Carlos","Sadness"),1);
            System.out.println(q.toString());
            q.enQueue(new Person("duhiusj","Sadness"),3);
            System.out.println(q.toString());
            q.enQueue(new Person("Vicic","Sadness"),2);
            System.out.println(q.toString());
            System.out.println(q.contains(new Person("Carlos","Sadness")));



            System.out.println(q);
        }catch (QueueException ex){
            throw new RuntimeException(ex);
        }

    }
}
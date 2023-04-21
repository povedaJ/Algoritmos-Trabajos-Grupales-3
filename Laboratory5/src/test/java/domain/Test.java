package domain;

import java.util.Calendar;

public class Test {

    @org.testng.annotations.Test
    public void testEmployee() {
        CircularLinkedList list = new CircularLinkedList();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2003,4,19);
        list.add(new Employee(1,"Poveda","Viviana","Informatica",
                calendar.getTime()));
        calendar.set(2001,7,19);
        list.add(new Employee(2,"Alvarado","Sebastian","Administracion",
                calendar.getTime()));
        System.out.println(list.toString());

    }
    @org.testng.annotations.Test
    public void testJobPositions() {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        list.add(new JobPosition("Informatica",200));
        System.out.println(list.toString());
    }
}
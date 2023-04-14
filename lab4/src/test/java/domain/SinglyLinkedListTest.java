package domain;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SinglyLinkedListTest {

    @Test
    public void test1(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(new Student("1","Maria", 20, "Cartago"));
        System.out.println(list.toString());
    }
    @Test
    public void test2() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(20);
        list.add(10);
        list.add(15);
        list.add(3);
        list.add(17);
        System.out.println(list.toString());
        try {
            System.out.println("List size: "+list.size());
            System.out.println(list.contains(50)?"El 50 existe"
                    :"El 50 no existe");
            System.out.println(list.contains(3)?"El 3 existe"
                    :"El 3 no existe");

            System.out.println("Deleting 20...");
            list.remove(20);
            System.out.println("Deleting 3...");
            list.remove(3);
            for (int i = 0; i < 10; i++) {
                list.add(util.Utility.random(50));
            }
            System.out.println(list.toString());
            for (int i = 0; i < 10; i++) {
                int value = util.Utility.random(50);
                System.out.println(list.contains(value)
                        ?"Element "+value+" exists at pos: "+list.indexOf(value)
                        :"Element "+value+" does not exist in list"
                );
            }
            int n = list.size();
            for (int i = 1; i <= n; i++) {
                System.out.println("Element at position: "+i+": "
                        +list.getNode(i).data);
            }

        } catch (ListException e) {
            throw new RuntimeException(e);
        }
    }


}
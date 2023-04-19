package domain;

import org.testng.annotations.Test;

public class Tarea2 {

    DoublyLinkedList list2 = new DoublyLinkedList();
    SinglyLinkedList list1 = new SinglyLinkedList();
    CircularLinkedList list3=new CircularLinkedList();
    CircularDoublyLinkedList list4= new CircularDoublyLinkedList();

    @Test
    public void test1() throws ListException {
        Node newNode=new Node("");

        list1.add(new Student("1","Maria", 20, "Cartago"));
        list1.add(new Student("2","Gabriel", 20, "Cartago"));
        list1.add(new Student("3","Diego", 20, "Cartago"));
        list1.add(new Student("4","Juan", 20, "Cartago"));
        list1.add(new Student("5","Jesus", 20, "Cartago"));

        list2.add(new Course("IF-3000","PROGA 2",4));
        list2.add(new Course("IF-3001","PROGA 3",4));
        list2.add(new Course("IF-3002","PROGA 4",4));
        list2.add(new Course("IF-3003","PROGA 5",4));
        list2.add(new Course("IF-3004","PROGA 6",4));

        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(4);
        list3.add(5);

        list4.add("a");
        list4.add("b");
        list4.add("c");
        list4.add("d");
        list4.add("e");

        newNode.next=list1.getNode(1);
        list1.getNode(5).next=list2.getNode(1);
        list2.getNode(5).next=list3.getNode(1);
        list3.getNode(5).next=list4.getNode(1);
        list4.getNode(5).next=null;

        show(newNode);
        System.out.println("Reverse ");
        reverse(newNode);
    }

    public void show(Node newNode){
        while(newNode!=null){
            System.out.println(newNode.data);
            if (newNode.next!=null) {
                newNode.data = newNode.next.data;
            }
            System.out.println(newNode.data);
            newNode = newNode.next;
        }

    }

    public void reverse(Node node){
        if (node == null){
            return;
        }
        reverse(node.next);
        System.out.println(node.data+" ");
    }


}//fin
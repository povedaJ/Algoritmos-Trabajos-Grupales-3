package domain;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DoublyLinkedListTest {
    @Test
    public void test1() throws ListException {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(new Course("IF-3001","Algoritmos",4));
        list.add(new Course("IF-4001","Sistemas Operativos",4));
        list.add(new Course("IF-2000","Programacion",4));
        list.add(new Course("IF-3000","Programacion 2",4));
        list.add(new Course("IF-4000","Arquitectura",3));
        list.add(new Course("IF-5000","Redes",3));
        list.add(new Course("IF-5100","Bases de datos",4));
        list.add(new Course("IF-4101","Lenguajes app Comerciales",4));
        list.add(new Course("IF-3100","Sistemas de informacion",3));
        /*list.contains();*/
        for (int i = 1; i <= list.size(); i++) {
            System.out.println("El elemento en la posicion " +i+" es: "+list.getNode(i).toString());
        }

       // list.indexOf()


    }


}